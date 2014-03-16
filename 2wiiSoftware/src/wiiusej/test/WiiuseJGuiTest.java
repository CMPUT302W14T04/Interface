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
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import wiiusej.Wiimote;
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
	private static boolean isCalibrating = false;
	private static int[][] calibMatrix = new int[9][2];

	// GUI-related variables
	static String title = "IR Paint";
	static final Color black = Color.black;
	static final Color red = Color.red;
	static final Color bluegreen = new Color(0, 153, 153);
	
	static final Font Tahoma = new Font("Tahoma",0,16);
	static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

	// GUI: container panels
	private JPanel buttonPanel;
	private JPanel irCombinedPanel;
	private JPanel irPadPanel;

	// GUI: draw panels
	private static JPanel irViewPanel1;
	private static JPanel irViewPanel2;
	private static JPanel irCombined;

	// GUI: buttons
	private static JButton calibButton;
	private JButton LRButton;
	private JButton clearDrawingButton;

	/**
	 * possible states for which point we are calibrating and where the wiimotes
	 * are
	 */
	protected enum cState {

		RIGHTBM(7, "midpoint on the bottom edge", null), 
		RIGHTBR(6, "bottom right", RIGHTBM), 
		RIGHTMR(5, "midpoint on the right edge", RIGHTBR), 
		RIGHTTR(4, "top right", RIGHTMR), 
		RIGHTTM(3, "midpoint on the top edge", RIGHTTR), 
		RIGHTTL(2, "top left", RIGHTTM), 
		RIGHTML(1, "midpoint of the left edge", RIGHTTL), 
		RIGHTBL(0, "bottom left", RIGHTML),

		LEFTMR(7, "midpoint of the right edge", null), 
		LEFTTR(6, "top right", LEFTMR), 
		LEFTTM(5, "midpoint of the top edge", LEFTTR), 
		LEFTTL(4, "top left", LEFTTM), 
		LEFTML(3, "midpoint of the left edge",LEFTTL), 
		LEFTBL(2, "bottom left", LEFTML), 
		LEFTBM(1, "midpoint of the bottom edge", LEFTBL), 
		LEFTBR(0, "bottom right", LEFTBM);

		int order;
		String position;
		cState nextPosition;
		
		/*
		 * Format of states:
		 * Order, descriptive text, next point
		 * 
		 * Order: numerical order for which step we are on in calibration
		 * Descriptive Text: text prepared for when we insert directions
		 * Next point: which is the next point to be calibrated
		 */

		cState(int i, String p, cState next) {
			order = i; 
			position = p; 
			nextPosition = next; 
		}

		cState getNext() {
			return nextPosition;
		}


		/**
		 * Calibrate function that is called when calibration button is pressed
		 * Function changes depending on state of which point is to be calibrated
		 * and where the wiimotes are (left vs right)
		 */
		void calibrate() {
			isCalibrating = true;

			if (order == '0') {
				// enable this following block for real usage
				// int[][] coords = cal.eventFilter(2);

				// for development purposes only; disable this block for real
				// usage
				int[][] coords = cal.getFakeCalibPoints(calibButton, 1);

				cal.setF(8f, 5.5f);
				cal.setDefaultFloor((coords[0][1] + coords[1][1]) / 2);
				cal.spatializeWiiMotes2x(coords[0][0], coords[1][0], wiimote,
						wiimote2);

				// what does this clearView do?
				clearViews();

				calibMatrix[0] = cal.calculateOffsets(coords[0][0],
						coords[1][0]);

				calibButton.setEnabled(true);
				calibButton.setText("Capture Next Point");
				((IRCombined) irCombined).drawCalib(calibMatrix[0]);

			}

			else {

				// insert calibration instruction here based on Order/Position

				// draw the source of the received IR

				// enable this following block for real usage
				// int[][] temp = cal.getCalibPoints(calibButton);

				// for development purposes only; disable this block for real
				// usage
				int[][] temp = cal.getFakeCalibPoints(calibButton, order);

				calibMatrix[order] = cal.calculateOffsets(temp[0][0],
						temp[1][0]);

				((IRCombined) irCombined).drawCalib(calibMatrix[order]);

				// when we finish calibration
				if (order == 7) {
					calibButton.setEnabled(true);
					calibButton.setText("Re-Calibrate");
					isCalibrating = false;

					cal.generateBoundaries(calibMatrix);
					// remove drawn calibration points
					clearViews();
					printCaliState();
				}

			}
		}

	}

	// default state assumes that wiimotes are on the left
	private static cState state = cState.LEFTBR;

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
				calibButton.setText("Locked");

			}
		}
	}

	private static void clearViews() {
		((IRPanel) irViewPanel1).clearView();
		((IRPanel) irViewPanel2).clearView();
		((IRCombined) irCombined).clearView();
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
	}

	/**
	 * Constructs the GUI
	 */
	private void initComponents() {

		// IR dot panel to show what an individual wiimote picks up
		irViewPanel1 = new IRPanel();
		irViewPanel2 = new IRPanel();
		// draw the combined coordinates; the "real picture"
		irCombined = new IRCombined();

		// this is the panel containing irCombined, formerly leftpanel
		irCombinedPanel = new JPanel();
		// this is the panel containing individual, formerly rightpanel
		irPadPanel = new JPanel();
		// this is the panel containing the 3 buttons
		buttonPanel = new JPanel();

		clearDrawingButton = new JButton();
		calibButton = new JButton();
		LRButton = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle(title);
		setName(title); // NOI18N

		irPadPanel.setBorder(BorderFactory.createEtchedBorder());

		irViewPanel1.setBackground(black);
		irViewPanel1.setBorder(BorderFactory.createTitledBorder(new LineBorder(
				bluegreen, 2, true), "IR: Remote #1",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, Tahoma, red));
		irViewPanel1.setToolTipText("IREvent - Remote 1");
		GroupLayout irViewPanelLayout1 = new GroupLayout(irViewPanel1);
		irViewPanel1.setLayout(irViewPanelLayout1);

		irViewPanel2.setBackground(black);
		irViewPanel2.setBorder(BorderFactory.createTitledBorder(new LineBorder(
				bluegreen, 2, true), "IR: Remote #2",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, Tahoma, red));
		irViewPanel2.setToolTipText("IREvent - Remote 2");
		GroupLayout irViewPanelLayout2 = new GroupLayout(irViewPanel2);
		irViewPanel2.setLayout(irViewPanelLayout2);

		irCombined.setBackground(black);
		irCombined.setBorder(BorderFactory.createTitledBorder(new LineBorder(
				black, 2, true), "IR: Combined",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, Tahoma, black));
		irCombined.setToolTipText("IREvent - Combined View");
		GroupLayout irCombinedLayout = new GroupLayout(irCombined);
		irCombined.setLayout(irCombinedLayout);
		
        irViewPanelLayout1.setHorizontalGroup(
                irViewPanelLayout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 272, Short.MAX_VALUE)
            );
            irViewPanelLayout1.setVerticalGroup(
                irViewPanelLayout1.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 299, Short.MAX_VALUE)
            );
            
       irViewPanelLayout2.setHorizontalGroup(
            irViewPanelLayout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
            );
            irViewPanelLayout2.setVerticalGroup(
            irViewPanelLayout2.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
            );

		irCombinedLayout.setHorizontalGroup(irCombinedLayout
				.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0,
						272, Short.MAX_VALUE));
		irCombinedLayout.setVerticalGroup(irCombinedLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGap(0, 299, Short.MAX_VALUE));

		irCombinedPanel.setBorder(BorderFactory.createEtchedBorder());
		irCombinedPanel.setLayout(new BoxLayout(irCombinedPanel,
				BoxLayout.LINE_AXIS));

		clearDrawingButton.setText("Clear");
		clearDrawingButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				clearDrawingButtonMousePressed(evt);
			}
		});
		buttonPanel.add(clearDrawingButton);

		calibButton.setText("Start Calibration");
		calibButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				calibButtonMousePressed(evt);
			}
		});
		buttonPanel.add(calibButton);

		LRButton.setText("Left");
		LRButton.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				LRButtonMousePressed(evt);
			}
		});
		buttonPanel.add(LRButton);

		GroupLayout irPadPanelLayout = new GroupLayout(irPadPanel);
		irPadPanel.setLayout(irPadPanelLayout);
		irPadPanelLayout.setHorizontalGroup(
				irPadPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(irViewPanel1, GroupLayout.Alignment.TRAILING,
						GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(irViewPanel2, GroupLayout.Alignment.TRAILING,
						GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE)
				.addComponent(buttonPanel, GroupLayout.Alignment.TRAILING,
						GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
						Short.MAX_VALUE));
		irPadPanelLayout.setVerticalGroup(irPadPanelLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				irPadPanelLayout
						.createSequentialGroup()
						.addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(irViewPanel1, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(irViewPanel2, GroupLayout.DEFAULT_SIZE,
								GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

		));

		irCombinedPanel.add(irCombined);
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup()
						.addComponent(irPadPanel, GroupLayout.PREFERRED_SIZE,
								238, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(irCombinedPanel,
								GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE))

		);
		layout.setVerticalGroup(layout
				.createParallelGroup(Alignment.LEADING)
				.addComponent(irPadPanel, GroupLayout.DEFAULT_SIZE, 573,
						Short.MAX_VALUE)
				.addComponent(irCombinedPanel, GroupLayout.DEFAULT_SIZE, 573,
						Short.MAX_VALUE));

		setBounds((screenSize.width - 800) / 2, (screenSize.height - 600) / 2,
				800, 600);

	}// </editor-fold>//GEN-END:initComponents

	private void clearDrawingButtonMousePressed(MouseEvent evt) {// GEN-FIRST:event_clearDrawingButtonMousePressed
		if (clearDrawingButton.isEnabled()) {
			clearViews();
		}
	}// GEN-LAST:event_clearDrawingButtonMousePressed

	private void calibButtonMousePressed(MouseEvent evt) {// GEN-FIRST:event_calibButtonMousePressed
		if (calibButton.isEnabled()) {
			// debug statement block
			System.out.println("Button got pressed!");
			printCaliState();
			calibButton.setEnabled(false);
			calibButton.setText("Locked");
			state.calibrate();
			setState(state.getNext());
		}
	}// GEN-LAST:event_calibButtonMousePressed

	private void LRButtonMousePressed(MouseEvent evt) {// GEN-FIRST:event_LRButtonMousePressed
		// only allow changing of left and right if we are not in the middle of
		// a calibration
		// changes initial starting state as well
		if (!isCalibrating) {
			if (LRButton.isEnabled()) {
				LRButton.setEnabled(false);
				LRButton.setText("Right");
				cal.leftSide = false;
				setState(cState.RIGHTBL);
			} else {
				LRButton.setEnabled(true);
				LRButton.setText("Left");
				cal.leftSide = true;
				setState(cState.LEFTBR);
			}
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

		((IRCombined) irCombined).onIrEvent(adjust[0], adjust[1],
				adjustLast[0], adjustLast[1]);
	}

	/**
	 * Sets state of calibration ready for any re-calibrating,
	 * based on where the wiimotes are
	 * @param s
	 */
	private void setState(cState s) {
		state = s;

		if (state == null) {
			if (cal.leftSide == true) {
				setState(cState.LEFTBR);
			} else {
				setState(cState.RIGHTBL);
			}
		}
	}

	/**
	 * Debug function; should be removed from final product
	 */
	public static void printCaliState() {
		System.out.println("isCalibrating state: " + isCalibrating);
		System.out.println("CaliButton state: " + calibButton.isEnabled());
		System.out.println("Order: " + state.order);
		System.out.println("");
	}

}
