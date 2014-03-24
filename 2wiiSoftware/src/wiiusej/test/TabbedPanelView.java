/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package wiiusej.test;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import wiiusej.utils.IRCombined;

/**
 * 
 * @author Eddie
 */
public class TabbedPanelView extends JFrame {

	private static final long serialVersionUID = 1L;
	// GUI Constants
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double screenHeight = screenSize.getHeight();
	double screenWidth = screenSize.getWidth();

	private Font fontTahoma = new Font("Tahoma", 0, 12);

	// Variables declaration - do not modify
	private CalibrationPanel calibrationPanel;
	private NLPPanel nlpPanel;
	private SessionInfoPanel sessionInfoPanel;
	private RecordPanel recordPanel;
	private JTabbedPane tabbedPane;

	public TabbedPanelView(int width, int height, String name) {
		initComponents(width, height, name);
		this.addWindowListener(new CloseGuiTestCleanly());
	}


	private void initComponents(int width, int height, String name) {

		tabbedPane = new JTabbedPane();

		sessionInfoPanel = new SessionInfoPanel(width,height);
		calibrationPanel = new CalibrationPanel(width,height);
		nlpPanel = new NLPPanel(width,height);
		recordPanel = new RecordPanel(width,height);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		tabbedPane.setFont(fontTahoma); // NOI18N

		tabbedPane.addTab("Session Info", sessionInfoPanel);
		tabbedPane.addTab("Calibration", calibrationPanel);
		tabbedPane.addTab("NLP Codes", nlpPanel);
		tabbedPane.addTab("Record", recordPanel);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(tabbedPane,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
				Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(tabbedPane,
				GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
				Short.MAX_VALUE));
		
		setBounds( (int) Math.round((screenWidth - 800) / 2), (int) Math.round((screenHeight - 600) / 2),
				width, height);
		
		setName(name);
		setTitle(name);

		pack();

	}
	
	//getters and setters from the 4 panels
	
	public double getMapLength() {
		return calibrationPanel.getMapLength();
	}
	
	public double getMapWidth() {
		return calibrationPanel.getMapWidth();
	}
	
	public double getMapTLXCoord() {
		return calibrationPanel.getMapTLXCoord();
	}
	
	public double getMapTLYCoord() {
		return calibrationPanel.getMapTLYCoord();
	}
	
	public double getMapBRXCoord() {
		return calibrationPanel.getMapBRXCoord();
	}
	
	public double getMapBRYCoord() {
		return calibrationPanel.getMapBRYCoord();
	}
	
	public void setInstruction(String instruction) {
		calibrationPanel.setInstruction(instruction);
	}
	
	public void setVertWiimoteDistance(Double dist) {
		calibrationPanel.setVertWiimoteDistance(dist);
	}
	
	public void setHorWiimoteDistance(Double dist) {
		calibrationPanel.setHorWiimoteDistance(dist);
	}
	
	public void setVertMapDistance(Double dist) {
		calibrationPanel.setVertMapDistance(dist);
	}
	
	public void setHorMapDistance(Double dist) {
		calibrationPanel.setHorMapDistance(dist);
	}
	
	public JButton getCalibrateButton() {
		return calibrationPanel.getCalibrateButton();
	}
	
	public ImagePanel getMapImagePanel() {
		return calibrationPanel.getMapImagePanel();
	}
	
	public void setSystemStatus(String status) {
		recordPanel.setSystemStatus(status);
	}
	
	public JButton getRecordingButton() {
		return recordPanel.getRecordingButton();
	}
	
	public JButton getSaveButton() {
		return recordPanel.getSaveButton();
	}
	
	public IRCombined getIRMapRecordingPanel() {
		return recordPanel.getIRCombinedPanel();
	}
	
	public String getSessionName() {
		return sessionInfoPanel.getSessionName();
	}
	
	public String getMapName() {
		return sessionInfoPanel.getMapName();
	}
	
	public String getMapCode() {
		return sessionInfoPanel.getMapCode();
	}
	
	// getLocation() is a superclass method, so naming convention here is changed
	public String getLocationText() {
		return sessionInfoPanel.getLocationText();
	}
	
	public String getDate() {
		return sessionInfoPanel.getDate();
	}
	
	public String getInterviewer() {
		return sessionInfoPanel.getInterviewer();
	}
	
	public String getInterviewee() {
		return sessionInfoPanel.getInterviewee();
	}
	
	public String getComments() {
		return sessionInfoPanel.getComments();
	}
	
	public Image getMapImage() {
		return sessionInfoPanel.getMapImage();
	}
	
	public JButton getLoadMapButton() {
		return sessionInfoPanel.getLoadMapButton();
	}
}
