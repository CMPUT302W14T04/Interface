/**
 * This file is part of WiiuseJ.
 *
 *  WiiuseJ is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  WiiuseJ is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with WiiuseJ.  If not, see <http://www.gnu.org/licenses/>.
 */
package wiiusej.utils;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import wiiusej.WiiUseApiManager;
import wiiusej.values.Calibrations;
import wiiusej.wiiusejevents.physicalevents.WiimoteButtonsEvent;
import wiiusej.wiiusejevents.wiiuseapievents.DisconnectionEvent;


/**
 * This panel is used to see what the IR camera of the wiimote sees.
 * 
 * @author guiguito
 */
public class IRCombined extends javax.swing.JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int MAX_NB_POINTS = 4;
	private Color color = Color.BLACK;
	private Color backgroundColor = Color.WHITE;
	private Color borderColor = Color.BLACK;
	private Shape shape;
	private Image mImage;// image for double buffering
	private int[] xCoordinates;
	private int[] yCoordinates;
	private int id;
	private int nbPoints = -1;

	/**
	 * Default constructor for IR Panel. Background color : black. IR sources
	 * color : yellow. Border color of IR sources : blue. Shape of the IR
	 * sources : circle with a diameter of 10.
	 */
	public IRCombined() {
		shape = new java.awt.geom.Ellipse2D.Double(0, 0, 1, 1);
		initArrays();
		initComponents();
	}

	/**
	 * Constructor used to parameterize the IR panel.
	 * 
	 * @param bgColor
	 *            color.
	 * @param ptColor
	 *            IR sources color.
	 * @param bdColor
	 *            border color of IR sources.
	 * @param sh
	 *            Shape of the IR sources.
	 */
	public IRCombined(Color bgColor, Color ptColor, Color bdColor, Shape sh) {
		backgroundColor = bgColor;
		color = ptColor;
		borderColor = bdColor;
		shape = sh;
		initArrays();
		initComponents();
	}

	private void initArrays() {
		xCoordinates = new int[MAX_NB_POINTS];
		yCoordinates = new int[MAX_NB_POINTS];
		for (int i = 0; i < MAX_NB_POINTS; i++) {
			xCoordinates[i] = -1;
			yCoordinates[i] = -1;
		}
	}
	
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension d = getSize();
		checkOffScreenImage();
		Graphics offG = mImage.getGraphics();
		offG.setColor(backgroundColor);
		//offG.fillRect(0, 0, d.width, d.height);
		Graphics2D g2 = (Graphics2D) mImage.getGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

	
		
		
		double x = xCoordinates[0];
		double y = yCoordinates[0];
		double lx = xCoordinates[1];
		double ly = yCoordinates[1];
		int compX = xCoordinates[1];
		int compY = yCoordinates[1];
		long xx = getWidth() - Math.round((double) getWidth() * x  / 1024.0);
		long yy = getHeight() - Math.round((double) getHeight() * y / 1024.0);
		
		long xx2 = getWidth() - Math.round((double) getWidth() *  lx/ 1024.0);
		long yy2 = getHeight()- Math.round((double) getHeight() * ly/ 1024.0);
		
		
		
		g2.translate(xx, yy);
		g2.setPaint(borderColor);
		if(compX != -1){
			
			if(compY != -1){			
				
				if ((xx - xx2) < 1000){
					if((yy-yy2) < 1000){
						g2.setStroke(new BasicStroke(1));
						g2.setPaint(Color.BLACK);
						g2.draw(new Line2D.Double(xx2 - xx,yy2 - yy,0 ,0));				
					}
				}
				
			}
			else{
				g2.draw(shape);
				g2.setPaint(color);
				g2.fill(shape);
				
			}

		}
		else{
			g2.draw(shape);
			g2.setPaint(color);
			g2.fill(shape);
		}
		
		

		g2.setTransform(new AffineTransform());
		// put offscreen image on the screen
		g.drawImage(mImage, 0, 0, null);
	}

	/**
	 * check if the mImage variable has been initialized. If it's not the case
	 * it initializes it with the dimensions of the panel. mImage is for double
	 * buffering.
	 */
	private void checkOffScreenImage() {
		Dimension d = getSize();
		if (mImage == null || mImage.getWidth(null) != d.width
				|| mImage.getHeight(null) != d.height) {
			mImage = createImage(d.width, d.height);
		}
	}

	

	public void onIrEvent(int x, int y, int lastX, int lastY) {	
		xCoordinates[0] = 1023 - x;
		xCoordinates[1] = 1023 - lastX;
		yCoordinates[0] = y;
		yCoordinates[1] = lastY;
		
		
		// redraw panel
		repaint();
	}

	

	

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public Color getColor() {
		return color;
	}

	public Shape getShape() {
		return shape;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public void clearView() {
		initArrays();
		Dimension d = getSize();
		checkOffScreenImage();
		Graphics offG = mImage.getGraphics();
		offG.setColor(backgroundColor);
		offG.fillRect(0, 0, d.width, d.height);
		Image image = null;
		try {
			image = ImageIO.read(new File("C:\\giraffe.jpg"));
			int height = 100 * image.getHeight(this);
			int width = 100 * image.getWidth(this);
			
			image = image.getScaledInstance(485,460, 0);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		offG.drawImage(image,0,0, this);
		
		repaint();
	}
	
	public void drawCalib(int[] calibMatrix, Color colour){
		Shape marker = new java.awt.geom.Ellipse2D.Double(-5, -5, 10, 10);
		
		Graphics2D g2 = (Graphics2D) mImage.getGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		long xx = getWidth() - Math.round((double) getWidth() *  (1023 - calibMatrix[0]) / 1024.0);
		long yy = getHeight() - Math.round((double) getHeight() * calibMatrix[1] / 1024.0);

		g2.translate(xx, yy);
		g2.setPaint(colour);
		g2.draw(marker);
		g2.setPaint(colour);
		g2.fill(marker);
			
		
		
		
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300,
				Short.MAX_VALUE));
	}// </editor-fold>//GEN-END:initComponents
	// Variables declaration - do not modify//GEN-BEGIN:variables
	// End of variables declaration//GEN-END:variables

	
}
