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
import java.util.Date;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
<<<<<<< HEAD
import javax.sound.sampled.LineUnavailableException;
=======
>>>>>>> theoretically most updated so far
import javax.sound.sampled.TargetDataLine;

public class SessionController extends Thread {

	static SessionModel model;
	static TabbedPanelView view;

	static SimpleDateFormat timeFormat;
<<<<<<< HEAD
	static boolean recordState;	
	public TargetDataLine targetDataLine;
	AudioFileFormat.Type fileType = null;
	File audioFile = null;
	
=======
	static boolean recordState;
	TargetDataLine targetDataLine;

>>>>>>> theoretically most updated so far
	public SessionController() {
		model = new SessionModel();
		view = new TabbedPanelView(model.getPanelWidth(),
				model.getPanelHeight(), model.getProgramName());
		addViewListeners();
		recordState = true;

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
	
	public void start()
	{
		targetDataLine.start();
		super.start();
	}
	

	public void run()
	{
		
		AudioInputStream stream = new AudioInputStream(targetDataLine);
	    try
	    {
			AudioSystem.write(stream,fileType, audioFile);
	    }
	    catch (IOException e)
	    {
		   e.printStackTrace();
	    }
		
	}
	
	private void recordingButtonPressed(MouseEvent evt) {
		// TODO Auto-generated method stub

<<<<<<< HEAD
		if (recordState) {
			model.setRecordStartTime();
			view.getRecordingButton().setText("Stop Recording Session");

			try {

				AudioFormat af = new AudioFormat(44100, 16, 2, true, false);
				DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, af);
				targetDataLine = (TargetDataLine) AudioSystem.getLine(dataLineInfo);
				targetDataLine.open(af);
				fileType = AudioFileFormat.Type.WAVE;
				audioFile = new File("testcam.wav");		
             
				//start recording
				this.start();				
				System.out.println("we are recording here");
				
			}
		catch (Exception ex) {
				System.out.println(ex);
		}
			recordState = false;
		} else {
			view.getRecordingButton().setText("Start Recording Session");
			targetDataLine.stop();
			targetDataLine.close();
			recordState = true;
			
		}
=======
//		if (recordState) {
//			model.setRecordStartTime();
//			view.getRecordingButton().setText("Stop Recording Session");
//
//			try {
//
//				AudioFormat af = new AudioFormat(44100, 16, 2, true, false);
//				DataLine.Info dataLineInfo = new DataLine.Info(
//						TargetDataLine.class, af);
//				targetDataLine = (TargetDataLine) AudioSystem
//						.getLine(dataLineInfo);
//				targetDataLine.open(af);
//				targetDataLine.start();
//				AudioFileFormat.Type fileType = null;
//				File audioFile = null;
//
//				fileType = AudioFileFormat.Type.WAVE;
//				audioFile = new File("testcam.wav");
//				
//				AudioInputStream stream = new AudioInputStream(targetDataLine);
//
//				AudioSystem.write(stream,fileType, audioFile);
//				targetDataLine.stop();
//				targetDataLine.close();
//				System.out.println("we got here");
//			}
//			catch (Exception ex) {
//				System.out.println(ex);
//			}
//			recordState = false;
//		} else {
//			view.getRecordingButton().setText("Start Recording Session");
//			targetDataLine.stop();
//			targetDataLine.close();
//			recordState = true;
//			
//		}
>>>>>>> theoretically most updated so far

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

			File file = new File(fileName + ".txt");

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
