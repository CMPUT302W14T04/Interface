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
package wiiusej.test;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import wiiusej.Wiimote;
import wiiusej.test.CState.calibrationState;
import wiiusej.utils.IRCombined;
import wiiusej.utils.IRPanel;
import wiiusej.values.Calibrations;
import wiiusej.wiiusejevents.physicalevents.ExpansionEvent;
import wiiusej.wiiusejevents.physicalevents.IREvent;
import wiiusej.wiiusejevents.physicalevents.MotionSensingEvent;
import wiiusej.wiiusejevents.physicalevents.WiimoteButtonsEvent;
import wiiusej.wiiusejevents.utils.WiimoteListener;
import wiiusej.wiiusejevents.wiiuseapievents.DisconnectionEvent;
import wiiusej.wiiusejevents.wiiuseapievents.StatusEvent;


public class WiiuseJGuiTest extends JFrame implements WiimoteListener {

	// declaration of variables
	private static final long serialVersionUID = 1L;
	
	private static Wiimote wiimote;
	private static Wiimote wiimote2;
	private static Calibrations cal = new Calibrations();
	private static int[][] calibMatrix = new int[9][2];

	// GUI-related constants
	static String title = "IR Paint";
	static final Color black = Color.black;
	static final Color red = Color.red;
	static final Color bluegreen = new Color(0, 153, 153);
	
	static final Font TitleTahoma = new Font("Tahoma",0,16);
	static final Font Tahoma = new Font("Tahoma",0,12);
	static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	// GUI: container panels
	private JPanel buttonPanel;
	private JPanel mapDrawPanel;
	private JPanel irCombinedPanel;
	private JPanel calibTextPanel;
	private JPanel dimensionPanel;
	
	// GUI: text display and text inputs
	private JTextField lengthInput;
	private JTextField widthInput;
	private static JTextArea directionTextArea;
	private JLabel dimensionLabel;
	private JLabel xLabel;

	// GUI: draw panels
	private static JPanel irViewPanel1;
	private static JPanel irViewPanel2;
	private static JPanel mapDraw;

	// GUI: buttons
	private static JButton calibButton;
	private JButton LRButton;
	private JButton clearDrawingButton;
	
	private static CState cState;

	/**
	 * default constructor if no wiimotes are present
	 */
	public WiiuseJGuiTest() {
		initComponents();
		this.addWindowListener(new CloseGuiTestCleanly());
	}

	/**
	 * Creates new form WiiuseJGuiTest
	 */
	public WiiuseJGuiTest(Wiimote wiimote, Wiimote wiimote2) {
		
		// initial calibration state ready to start calibrating
		cState = new CState();
		
		initComponents();
		this.addWindowListener(new CloseGuiTestCleanly());

		// checks for wiimote connection and setups the wiimote
		if (wiimote != null) {
			if (wiimote2 != null) {

				WiiuseJGuiTest.wiimote = wiimote;
				WiiuseJGuiTest.wiimote2 = wiimote2;
				registerListeners();
				initWiimote();
				wiimote.activateIRTRacking();
				wiimote2.activateIRTRacking();
				calibButton.setEnabled(false);
				calibButton.setText("Locked- No Wiimotes detected");

			}
		}
	}

	/**
	 * Function to clear all views
	 */
	private static void clearViews() {
			((IRPanel) irViewPanel1).clearView();
			((IRPanel) irViewPanel2).clearView();
			((IRCombined) mapDraw).clearView();
	}

	private void unregisterListeners() {
		wiimote.removeWiiMoteEventListeners((IRPanel) irViewPanel1);
		wiimote2.removeWiiMoteEventListeners((IRPanel) irViewPanel2);
		wiimote.removeWiiMoteEventListeners(this);
	}

	private void initWiimote() {
		wiimote.deactivateContinuous();
		wiimote.deactivateSmoothing();
		wiimote.setScreenAspectRatio169();
		wiimote.setSensorBarBelowScreen();
	}

	private void registerListeners() {
		wiimote.addWiiMoteEventListeners((IRPanel) irViewPanel1);
		wiimote2.addWiiMoteEventListeners((IRPanel) irViewPanel2);
		wiimote.addWiiMoteEventListeners(this);

	}

	/**
	 * Required function due to inheritance
	 */
	public void onButtonsEvent(WiimoteButtonsEvent arg0) {
		// nothing
	}

	/**
	 * Required function due to inheritance Note: this is NOT the same onIrEvent
	 * used in IRCombine to draw later on
	 */
	public void onIrEvent(IREvent arg0) {
		// nothing
	}

	/**
	 * Required function due to inheritance
	 */
	public void onMotionSensingEvent(MotionSensingEvent arg0) {
		// nothing
	}

	/**
	 * Required function due to inheritance
	 */
	public void onExpansionEvent(ExpansionEvent e) {
		// nothing yet
	}

	/**
	 * Required function due to inheritance
	 */
	public void onStatusEvent(StatusEvent arg0) {
		// nothing yet
	}

	/**
	 * What happens when wiimote disconnects
	 */
	public void onDisconnectionEvent(DisconnectionEvent arg0) {
		unregisterListeners();
		clearViews();
		// change calibration status to reflect need of calibration
		CState.setCState(calibrationState.DISCONN);
		setDirection();
	}

	/**
	 * Constructs the GUI
	 */
	private void initComponents() {

		// declaration of variables
		mapDrawPanel = new JPanel();
		calibTextPanel = new JPanel();
		dimensionPanel = new JPanel();
		cState = new CState();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle(title);
		setName(title);

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(mapDrawPanel,
								GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(calibTextPanel, GroupLayout.PREFERRED_SIZE,
								238, GroupLayout.PREFERRED_SIZE)
						)
				);
		layout.setVerticalGroup(layout
				.createParallelGroup(Alignment.LEADING)
				.addComponent(calibTextPanel, GroupLayout.DEFAULT_SIZE, 573,
						Short.MAX_VALUE)
				.addComponent(mapDrawPanel, GroupLayout.DEFAULT_SIZE, 573,
						Short.MAX_VALUE));
		
		setupMapDrawPanel(mapDrawPanel);
		setupCalibTextPanel(calibTextPanel);

		setBounds((screenSize.width - 800) / 2, (screenSize.height - 600) / 2,
				800, 600);

	}// </editor-fold>//GEN-END:initComponents
	
	/**
	 * Setups the panel to show what the user is drawing in the 3rd tab
	 * 
	 * @param mapDrawPanel the JPanel to hold the content
	 */
	private void setupMapDrawPanel(JPanel mapDrawPanel) {
		
		mapDraw = new IRCombined();
		
		mapDraw.setBorder(BorderFactory.createTitledBorder(new LineBorder(
				black, 2, true), "IR: Combined",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, TitleTahoma, black));
		mapDraw.setToolTipText("IREvent - Combined View");
		GroupLayout mapDrawLayout = new GroupLayout(mapDraw);
		mapDraw.setLayout(mapDrawLayout);
		
		mapDrawLayout.setHorizontalGroup(mapDrawLayout
				.createParallelGroup(Alignment.LEADING).addGap(0,
						272, Short.MAX_VALUE));
		mapDrawLayout.setVerticalGroup(mapDrawLayout.createParallelGroup(
				Alignment.LEADING).addGap(0, 299, Short.MAX_VALUE));

		mapDrawPanel.setBorder(BorderFactory.createEtchedBorder());
		mapDrawPanel.setLayout(new BoxLayout(mapDrawPanel,
				BoxLayout.LINE_AXIS));

		mapDrawPanel.add(mapDraw);
	}
	
	/**
	 * setup the text message display box and the calibration buttons
	 * for the 2nd tab in the main GUI
	 */
	private void setupCalibTextPanel(JPanel calibTextPanel) {
		
		// declaration of variables
		buttonPanel = new JPanel();
		irCombinedPanel = new JPanel();
		directionTextArea = new JTextArea();

		setupIRViewPanel(irCombinedPanel);
		setupButtonPanel(buttonPanel);
		
		directionTextArea.setBorder(BorderFactory.createTitledBorder(new LineBorder(
				black, 2, true), "Status",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, TitleTahoma, black));
		directionTextArea.setFont(Tahoma);
		directionTextArea.setLineWrap(true);
		directionTextArea.setWrapStyleWord(true);
		directionTextArea.setEditable(false);
		
		// initial instructions
		setDirection();
		
		calibTextPanel.setBorder(BorderFactory.createEtchedBorder());
		
		GroupLayout calibTextPanelLayout = new GroupLayout(calibTextPanel);
		calibTextPanel.setLayout(calibTextPanelLayout);
		calibTextPanelLayout.setHorizontalGroup(
				calibTextPanelLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(directionTextArea, Alignment.TRAILING,
						GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
// 				Uncomment this block to see each individual wiimote's pickup
//				.addComponent(irCombinedPanel, Alignment.TRAILING,
//						GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
//						Short.MAX_VALUE)
				.addComponent(buttonPanel, Alignment.TRAILING,
						GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));
		calibTextPanelLayout.setVerticalGroup(calibTextPanelLayout.createParallelGroup(
				Alignment.LEADING).addGroup(
				Alignment.TRAILING,
				calibTextPanelLayout
						.createSequentialGroup()
						.addComponent(directionTextArea,
								GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
// 						Uncomment this block to see each individual wiimote's pickup
//						.addComponent(irCombinedPanel, GroupLayout.DEFAULT_SIZE,
//								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(buttonPanel)

		));
		
	}
	

	
	/**
	 * Creates the content of the Button Panel, including its layout
	 * 
	 * @param buttonPanel the panel to hold the content
	 */
	private void setupButtonPanel(JPanel buttonPanel) {
		
		clearDrawingButton = new JButton();
		calibButton = new JButton();
		LRButton = new JButton();
		
		// button to clear all drawings shown on the panel
		clearDrawingButton.setText("Clear DrawPad");
		clearDrawingButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				clearDrawingButtonMousePressed(evt);
			}
		});

		// button to start the calibration process
		calibButton.setText("Start Calibration");
		calibButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				calibButtonMousePressed(evt);
			}
		});

		// button to switch configuration of where wiimotes are placed
		LRButton.setText("Change Wiimote Orientation");
		LRButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				LRButtonMousePressed(evt);
			}
		});
		
		// setups the layout
		GroupLayout buttonPanelLayout = new GroupLayout(buttonPanel);
		buttonPanel.setLayout(buttonPanelLayout);
		buttonPanelLayout.setHorizontalGroup(
				buttonPanelLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(clearDrawingButton, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(calibButton, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(LRButton, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		buttonPanelLayout.setVerticalGroup(
				buttonPanelLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING,
							buttonPanelLayout.createSequentialGroup()
								.addComponent(clearDrawingButton)
								.addComponent(calibButton)
								.addComponent(LRButton)
		));
	}

	private void clearDrawingButtonMousePressed(MouseEvent evt) {// GEN-FIRST:event_clearDrawingButtonMousePressed
		if (clearDrawingButton.isEnabled()) {
			clearViews();
		}
	}// GEN-LAST:event_clearDrawingButtonMousePressed

	private void calibButtonMousePressed(MouseEvent evt) {// GEN-FIRST:event_calibButtonMousePressed
		//TODO
		
		// disable other buttons once calibration starts
		LRButton.setEnabled(false);
		LRButton.setText(" ");
		clearDrawingButton.setEnabled(false);
		clearDrawingButton.setText(" ");
		
		if (calibButton.isEnabled()) {
			
			// calibration is required
			if (CState.getCalib()) {
				
				// insert calibration instruction here based on Order/Position
				setDirection();
				calibButton.setText("Waiting for IR Signal");
				calibButton.setEnabled(false);
				
				calibrate();
				
				// move on to the next state after this step of calibration
				calibrationState next = cState.getNext();
				CState.setCState(next);
			}
			
			// pressing calibration button when we are not calibrating the 8 points of the map
			else {
				
				calibButton.setText("Next Step");
				
				// determine the starting point of calibration depending on left/right
				if (cState.getCState() == calibrationState.LEFTWII2) {
					CState.setCState(calibrationState.LEFTBRT);
				}
				else if (cState.getCState() == calibrationState.RIGHTWII2) {
					CState.setCState(calibrationState.RIGHTBLT);
				}
				
				else {
					// move on to the next state after this step of calibration
					calibrationState next = cState.getNext();
					CState.setCState(next);
				}
				
				setDirection();
			}
		}
	}// GEN-LAST:event_calibButtonMousePressed

	private void LRButtonMousePressed(MouseEvent evt) {// GEN-FIRST:event_LRButtonMousePressed
		// only allow changing of left and right if we are not in the middle of
		// a calibration
		// changes initial starting state as well
		
		if (LRButton.isEnabled()) {
			if (cal.leftSide) {
				cal.leftSide = false;
				CState.setCState(calibrationState.BEGINRIGHT);
			} 
			else {
				cal.leftSide = true;
				CState.setCState(calibrationState.BEGINLEFT);
			}
			setDirection();
		}

	}// GEN-LAST:event_LRButtonMousePressed

	/**
	 * Draws on the map panel based on calibrated results
	 * 
	 * @param x
	 * @param y
	 * @param lastX
	 * @param lastY
	 */
	public static void drawCombine(int x, int y, int lastX, int lastY) {
		int[] adjust = cal.calculateOffsets(x, y);
		int[] adjustLast = cal.calculateOffsets(lastX, lastY);

		((IRCombined) mapDraw).onIrEvent(adjust[0], adjust[1],
				adjustLast[0], adjustLast[1]);
	}
	
	/**
	 * Function to quickly set the text display of the directionTextArea
	 * @param text
	 */
	private static void setDirection() {
		String text = CState.getDescription();
		directionTextArea.setText(text);
	}
	
	/**
	 * The panel to hold the 2 individual IR panels that shows what each wiimote
	 * can pickup. Used only for debugging to show what a wiimote can see.
	 * 
	 * @param irCombinedPanel the panel to hold the content
	 */
	private void setupIRViewPanel(JPanel irCombinedPanel) {
		
		// IR dot panel to show what an individual wiimote picks up
		irViewPanel1 = new IRPanel();
		irViewPanel2 = new IRPanel();
		
		// creates first IR dot panel
		irViewPanel1.setBackground(black);
		irViewPanel1.setBorder(BorderFactory.createTitledBorder(new LineBorder(
				bluegreen, 2, true), "IR: Remote #1",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, TitleTahoma, red));
		irViewPanel1.setToolTipText("IREvent - Remote 1");
		GroupLayout irViewPanelLayout1 = new GroupLayout(irViewPanel1);
		irViewPanel1.setLayout(irViewPanelLayout1);

		// creates second IR dot panel
		irViewPanel2.setBackground(black);
		irViewPanel2.setBorder(BorderFactory.createTitledBorder(new LineBorder(
				bluegreen, 2, true), "IR: Remote #2",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, TitleTahoma, red));
		irViewPanel2.setToolTipText("IREvent - Remote 2");
		GroupLayout irViewPanelLayout2 = new GroupLayout(irViewPanel2);
		irViewPanel2.setLayout(irViewPanelLayout2);

		// setups the layout
		GroupLayout irCombinedPanelLayout = new GroupLayout(irCombinedPanel);
		irCombinedPanel.setLayout(irCombinedPanelLayout);
		irCombinedPanelLayout.setHorizontalGroup(
				irCombinedPanelLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(irViewPanel1, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(irViewPanel2, GroupLayout.DEFAULT_SIZE,
						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		irCombinedPanelLayout.setVerticalGroup(
				irCombinedPanelLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING,
							irCombinedPanelLayout.createSequentialGroup()
								.addComponent(irViewPanel1, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(irViewPanel2, GroupLayout.DEFAULT_SIZE,
										GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		));
	}

	/**
	 * Debug function; should not be visible in final product
	 */
	public static void printCaliState() {
		System.out.println("Calibration state: " + cState.getCState());
		System.out.println("CaliButton state: " + calibButton.isEnabled());
		System.out.println("Order: " + cState.getNext().toString());
		System.out.println("");
	}
	
	/**
	 * Calibrate function that is called when calibration button is pressed
	 * Function changes depending on state of which point is to be calibrated
	 * and where the wiimotes are (left vs right) 
	 */
	void calibrate() {
		
		//TODO
		
		int i = CState.getCalibMatrixPos();

		// special procedures for beginning of calibration
		if (cState.getCState() == calibrationState.LEFTBRT || cState.getCState() == calibrationState.RIGHTBLT) {
			
			clearViews();
			// enable this following block for real usage
			// int[][] coords = cal.eventFilter(2);

			// for development purposes only; final program should not be in try catch block
			int[][] coords; //delete this line for real
			try { //delete this line for real
				
				coords = cal.getFakeCalibPoints(i); //delete this line for real
				cal.setF(8f, 5.5f);
				cal.setDefaultFloor((coords[0][1] + coords[1][1]) / 2);
				cal.spatializeWiiMotes2x(coords[0][0], coords[1][0], wiimote,
						wiimote2);

				calibMatrix[i] = cal.calculateOffsets(coords[0][0],
						coords[1][0]);

				setDirection();
				calibButton.setEnabled(true);
				calibButton.setText("Capture Next Point");
				((IRCombined) mapDraw).drawCalib(calibMatrix[0]);
			} catch (InterruptedException e) { //delete this line for real
				e.printStackTrace(); //delete this line for real
			}

		}
		
		else {
			// draw the source of the received IR

			// enable this following block for real usage
			// int[][] temp = cal.getCalibPoints(calibButton);

			// for development purposes only; disable this block for real usage
			int[][] temp; //delete this line for real
			try { //delete this line for real
				temp = cal.getFakeCalibPoints(5); //delete this line for real
				
				calibMatrix[i] = cal.calculateOffsets(temp[0][0],
						temp[1][0]);

				((IRCombined) mapDraw).drawCalib(calibMatrix[5]);
				
				// insert calibration instruction here based on Order/Position
				setDirection();
				calibButton.setEnabled(true);
				calibButton.setText("Capture Next Point");
				
				// when we finish calibration
				if (cState.getCState() == calibrationState.LEFTMRF || cState.getCState() == calibrationState.RIGHTMRF) {
					calibButton.setText("Re-Calibrate");
					CState.setCState(calibrationState.DONE);
					
					// re-enable clearDrawingButtons
					clearDrawingButton.setText("Clear DrawPad");
					clearDrawingButton.setEnabled(true);

					cal.generateBoundaries(calibMatrix);
					// remove drawn calibration points
					clearViews();
					
			}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


				
				} 

			}

}
