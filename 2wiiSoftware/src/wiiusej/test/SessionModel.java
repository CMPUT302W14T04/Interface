package wiiusej.test;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SessionModel {
	
	// General program info
	private final String programName;
	private final int panelHeight;
	private final int panelWidth;
	private ArrayList<String> sessionRecord;
	
	// Session info panel model info
	private Image mapImage;
	private String sessionName;
	private String mapName;
	private String mapCode;
	private String location;
	private String interviewDate;
	private String interviewer;
	private String interviewee;
	private String comments;
	
	// Calibration panel model info
	private double mapSizeHeight;
	private double mapSizeWidth;
	private double mapTLCoordx;
	private double mapTLCoordy;
	private double mapBRCoordx;
	private double mapBRCoordy;
	private double horMapDistance;
	private double vertMapDistance;
	private double horWiimoteDistance;
	private double vertWiimoteDistance;
	private String calibrationInstruction;
	private boolean leftOrientation;
	
	// NLP Codes panel model info, need getters/setters for these
	private List<String> suggestedNLPCodes;
	private List<String> currentNLPCodes;
	
	// Record panel model info
	private String systemStatus;
	private Date recordStartTime;
	
	
	

	public SessionModel() {
		// General program info
		programName = "IR Capture Pen and Paper";
		panelHeight = 600;
		panelWidth = 800;
		sessionRecord = new ArrayList<String>();
		
		// Session info panel model info
		mapImage = null;
		sessionName = "NewSession001";
		mapName = null;
		mapCode = null;
		location = null;
		interviewDate = null;
		interviewer = null;
		interviewee = null;
		comments = null;
		
		// Calibration panel model info
		mapSizeHeight = 0;
		mapSizeWidth = 0;
		horMapDistance = 0;
		vertMapDistance = 0;
		horWiimoteDistance = 0;
		vertWiimoteDistance = 0;
		mapTLCoordx = 0;
		mapTLCoordy = 0;
		mapBRCoordx = 0;
		mapBRCoordy = 0;
		calibrationInstruction = "filler information";
		leftOrientation = true;
		
		// NLP Codes panel model info
		suggestedNLPCodes = new ArrayList<String>();
		currentNLPCodes = new ArrayList<String>();
		
		// Record panel model info
		systemStatus = "filler information";
		recordStartTime = null;
	}
	
	// Getters and setters for each variable
	
	// Session info panel model info
	
	public String getProgramName() {
		return programName;
	}
	
	public int getPanelHeight() {
		return panelHeight;
	}
	
	public int getPanelWidth() {
		return panelWidth;
	}
	
	public Image getMapImage() {
		return mapImage;
	}
	
	public void setMapImage(Image image) {
		mapImage = image;
	}
	
	public String getSessionName() {
		return sessionName;
	}
	
	public void setSessionName(String name) {
		sessionName = name;
	}
	
	public String getMapName() {
		return mapName;
	}
	
	public void setMapName(String name) {
		mapName = name;
	}
	
	public String getMapCode() {
		return mapCode;
	}
	
	public void setMapCode(String code) {
		mapCode = code;
	}
	
	public String getLocationText() {
		return location;
	}
	
	public void setLocationText(String place) {
		location = place;
	}
	
	public String getInterviewDate() {
		return interviewDate;
	}
	
	public void setInterviewDate(String time) {
		interviewDate = time;
	}
	
	public String getInterviewer() {
		return interviewer;
	}
	
	public void setInterviewer(String name) {
		interviewer = name;
	}
	
	public String getInterviewee() {
		return interviewee;
	}
	
	public void setInterviewee(String name) {
		interviewee = name;
	}
	
	public String getComments() {
		return comments;
	}
	
	public void setComments(String text) {
		comments = text;
	}
	
	// Calibration panel model info
	public double getMapSizeHeight() {
		return mapSizeHeight;
	}
	
	public void setMapSizeHeight(double height) {
		mapSizeHeight = height;
	}
	
	public double getMapSizeWidth() {
		return mapSizeWidth;
	}
	
	public void setMapSizeWidth(double width) {
		mapSizeWidth = width;
	}
	
	public double getHorMapDistance() {
		return horMapDistance;
	}
	
	public void setHorMapDistance(double distance) {
		horMapDistance = distance;
	}

	public double getVertMapDistance() {
		return vertMapDistance;
	}
	
	public void setVertMapDistance(double distance) {
		vertMapDistance = distance;
	}

	public double getHorWiimoteDistance() {
		return horWiimoteDistance;
	}
	
	public void setHorWiimoteDistance(double distance) {
		horWiimoteDistance = distance;
	}
	
	public double getVertWiimoteDistance() {
		return vertWiimoteDistance;
	}
	
	public void setVertWiimoteDistance(double distance ) {
		vertWiimoteDistance = distance;
	}
	
	public double getMapTLCoordx() {
		return mapTLCoordx;
	}
	
	public void setMapTLCoordx(double coord) {
		mapTLCoordx = coord;
	}
	
	public double getMapTLCoordy() {
		return mapTLCoordy;
	}
	
	public void setMapTLCoordy(double coord) {
		mapTLCoordy = coord;
	}
	
	public double getMapBRCoordx() {
		return mapBRCoordx;
	}
	
	public void setMapBRCoordx(double coord) {
		mapBRCoordx = coord;
	}
	
	public double getMapBRCoordy() {
		return mapBRCoordy;
	}
	
	public void setMapBRCoordy(double coord) {
		mapBRCoordy = coord;
	}

	public String getCalibrationInstruction() {
		return calibrationInstruction;
	}
	
	public void setCalibrationInstruction(String instruction) {
		calibrationInstruction = instruction;
	}

	public boolean getLeftOrientation() {
		return leftOrientation;
	}
	
	public void setLeftOrientation(boolean state) {
		leftOrientation = state;
	}
	
	// NLP Codes panel model info
	// TODO: NLP Codes getter/setter/adder/remover
	
	// Record panel model info
	public String getSystemStatus() {
		return systemStatus;
	}
	
	public void setSystemStatus(String status) {
		systemStatus = status;
	}
	
	public Date getRecordStartTime() {
		return recordStartTime;
	}
	
	/**
	 * sets the recordStartTime as the current time on the machine
	 */
	public void setRecordStartTime() {
		recordStartTime = new Date();
	}
	
	public ArrayList<String> getSessionRecord() {
		return sessionRecord;
	}
	
	public void compileSessionInfo() {
		String s = null;
		s = "Session Name: "+getSessionName();
		addRecord(s);
		s = "Map Name: "+getMapName();
		addRecord(s);
		s = "Map Code: "+getMapCode();
		addRecord(s);
		s = "Location: "+getLocationText();
		addRecord(s);
		s = "Date: "+getInterviewDate();
		addRecord(s);
		s = "Interviewer: "+getInterviewer();
		addRecord(s);
		s = "Interviewee: "+getInterviewee();
		addRecord(s);
		s = "Comments: "+getComments();
		addRecord(s);
		s = "Record Start Time: "+getRecordStartTime();
		addRecord(s);
	}
	
	public void addRecord(String s) {
		sessionRecord.add(s);
	}

}
