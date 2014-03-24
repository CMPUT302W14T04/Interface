package wiiusej.test;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;

/**
 * JPanel with a background image, auto-sized
 * 
 * Modified from Stackoverflow:
 * http://stackoverflow.com/questions/15479820/set-background-image-for
 * -jpanel-in-java-breakout-game
 * 
 * @author Java42
 * 
 */
public class ImagePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image imageOrg = null;
	private Image backgroundImage = null;
	{
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(final ComponentEvent e) {
				rescaleImage();
			}
		});
	}
	
	public ImagePanel() {
		
	}

	public ImagePanel(final Image i) {
		imageOrg = i;
		backgroundImage = i;
	}
	
	/**
	 * Change the image of the ImagePanel
	 * @param i Image to be painted in the panel
	 */
	public void loadBackgroundImage (Image i) {
		imageOrg = i;
		backgroundImage = i;
		rescaleImage();
	}
	
	/**
	 * Rescale the image so that the image is maximized  to 
	 * fit the entire panel. background image's own aspect ratio is not maintained.
	 */
	public void rescaleImage() {
		if (backgroundImage != null) {
			final int w = ImagePanel.this.getWidth();
			final int h = ImagePanel.this.getHeight();
			backgroundImage = w > 0 && h > 0 ? imageOrg.getScaledInstance(w, h,
					Image.SCALE_SMOOTH) : imageOrg;
			ImagePanel.this.repaint();
		}
	}

	@Override
	public void paintComponent(final Graphics g) {
		super.paintComponent(g);
		if (backgroundImage != null)
			g.drawImage(backgroundImage, 0, 0, null);
	}
}