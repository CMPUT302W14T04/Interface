package wiiusej.test;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;

public class SessionController {

	static SessionModel model;
	static TabbedPanelView view;

	static SimpleDateFormat timeFormat;

	public SessionController() {
		model = new SessionModel();
		view = new TabbedPanelView(model.getPanelWidth(),
				model.getPanelHeight(), model.getProgramName());
		addViewListeners();

		timeFormat = new SimpleDateFormat("HH:mm:ss");
	}

	public String formatTime(Date time) {
		DateFormat format = new SimpleDateFormat("HH:mm:ss");
		return format.format(time);
	}

	/**
	 * Registers all listeners for all components of the view
	 */
	public void addViewListeners() {

		view.getLoadMapButton().addMouseListener(
				new java.awt.event.MouseAdapter() {
					public void mousePressed(java.awt.event.MouseEvent evt) {
						loadMapButtonPressed(evt);
					}
				});

		view.getCalibrateButton().addMouseListener(
				new java.awt.event.MouseAdapter() {
					public void mousePressed(java.awt.event.MouseEvent evt) {
						calibrateButtonPressed(evt);
					}
				});

		view.getRecordingButton().addMouseListener(
				new java.awt.event.MouseAdapter() {
					public void mousePressed(java.awt.event.MouseEvent evt) {
						recordingButtonPressed(evt);
					}
				});

		view.getSaveButton().addMouseListener(
				new java.awt.event.MouseAdapter() {
					public void mousePressed(java.awt.event.MouseEvent evt) {
						saveButtonPressed(evt);
					}
				});

	}

	/**
	 * Not fully complete!
	 * 
	 * Upon press of button, the map panels update their background image
	 * 
	 * @param evt
	 */
	private void loadMapButtonPressed(MouseEvent evt) {
		BufferedImage mapImage = null;
		try {
			mapImage = ImageIO.read(new File("src/wiiusej/test/testmap.png"));
			model.setMapImage(mapImage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		view.getMapImagePanel().loadBackgroundImage(mapImage);
		// TODO: how to tell the IRCombined to paint the new background?
		// view.getIRMapRecordingPanel().loadBackgroundImage(mapImage);
	}

	private void calibrateButtonPressed(MouseEvent evt) {
		// TODO Auto-generated method stub

	}

	private void recordingButtonPressed(MouseEvent evt) {
		// TODO Auto-generated method stub

		model.setRecordStartTime();

	}

	private void saveButtonPressed(MouseEvent evt) {
		// TODO Auto-generated method stub
		
		// fetch info for model from the view
		model.setSessionName(view.getSessionName());
		model.setMapName(view.getMapName());
		model.setMapCode(view.getMapCode());
		model.setLocationText(view.getLocationText());
		model.setInterviewDate(view.getDate());
		model.setInterviewer(view.getInterviewer());
		model.setInterviewee(view.getInterviewee());
		model.setComments(view.getComments());
		model.compileSessionInfo();

		try {
			
			String fileName = model.getSessionName();

			File file = new File(fileName+".txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			
			ArrayList<String> content;
			content = model.getSessionRecord();

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			
			for (String line : content) {
				bw.write(line);
				bw.newLine();
			}

			bw.close();

			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {

		SessionController controller = new SessionController();
		view.setResizable(false);
		view.setVisible(true);
	}

}
