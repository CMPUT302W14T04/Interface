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

import java.awt.Robot;

import javax.swing.JFrame;

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

/**
 * Gui class to test WiiuseJ.
 * 
 * @author guiguito
 * @param <cState>
 */

public class WiiuseJGuiTest extends javax.swing.JFrame implements
		WiimoteListener {

	// declaration of variables
	private static final long serialVersionUID = 1L;
	private static Wiimote wiimote;
	private static Wiimote wiimote2;
	private static Calibrations cal = new Calibrations();
	private static boolean isCalibrating = false;
	private static int[][] calibMatrix = new int[9][2];

	// GUI-related declarations

	// GUI: container panels
	private javax.swing.JPanel buttonPanel;
	private javax.swing.JPanel irCombinedPanel;
	private javax.swing.JPanel irPadPanel;

	// GUI: draw panels
	private static javax.swing.JPanel irViewPanel1;
	private static javax.swing.JPanel irViewPanel2;
	private static javax.swing.JPanel irCombined;

	// GUI: buttons
	private static javax.swing.JButton calibButton;
	private javax.swing.JButton LRButton;
	private javax.swing.JButton clearDrawingButton;

	// possible states for which point we are calibrating and where the wiimotes
	// are
	protected enum cState {

		RIGHTBM(7, "midpoint on the bottom edge", null), RIGHTBR(6,
				"bottom right", RIGHTBM), RIGHTMR(5,
				"midpoint on the right edge", RIGHTBR), RIGHTTR(4, "top right",
				RIGHTMR), RIGHTTM(3, "midpoint on the top edge", RIGHTTR), RIGHTTL(
				2, "top left", RIGHTTM), RIGHTML(1,
				"midpoint of the left edge", RIGHTTL), RIGHTBL(0,
				"bottom left", RIGHTML),

		LEFTMR(7, "midpoint of the right edge", null), LEFTTR(6, "top right",
				LEFTMR), LEFTTM(5, "midpoint of the top edge", LEFTTR), LEFTTL(
				4, "top left", LEFTTM), LEFTML(3, "midpoint of the left edge",
				LEFTTL), LEFTBL(2, "bottom left", LEFTML), LEFTBM(1,
				"midpoint of the bottom edge", LEFTBL), LEFTBR(0,
				"bottom right", LEFTBM);

		int order;
		String position;
		cState nextPosition;

		cState(int i, String p, cState next) {
			order = i; // order of calibration
			position = p; // position relative to the map
			nextPosition = next; // next point to calibrate
		}
		
		cState getNext() {
			return nextPosition;
		}

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
				if (order == '7') {
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

	/**
	 * Clear all views
	 */
	private static void clearViews() {
		((IRPanel) irViewPanel1).clearView();
		((IRPanel) irViewPanel2).clearView();
		((IRCombined) irCombined).clearView();
	}

	/**
	 * Unregister all listeners.
	 */
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
		// IR panel to draw the combined coordinates from the individual
		// irViewPanel
		irCombined = new IRCombined();

		// this is the panel containing irCombined, formerly leftpanel
		irCombinedPanel = new javax.swing.JPanel();

		// this is the panel containing individual, formerly rightpanel
		irPadPanel = new javax.swing.JPanel();

		// this is the panel containing the 3 buttons, formerly buttonPanel
		buttonPanel = new javax.swing.JPanel();

		clearDrawingButton = new javax.swing.JButton();
		calibButton = new javax.swing.JButton();
		LRButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("IR Paint");
		setName("IR Paint"); // NOI18N

		irPadPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		irViewPanel1.setBackground(new java.awt.Color(0, 0, 0));
		irViewPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 153,
						153), 2, true), "IR: Remote #1",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(255, 0,
						51)));
		irViewPanel1.setToolTipText("IREvent - Remote 1");
		javax.swing.GroupLayout irViewPanelLayout1 = new javax.swing.GroupLayout(
				irViewPanel1);
		irViewPanel1.setLayout(irViewPanelLayout1);

		irViewPanel2.setBackground(new java.awt.Color(0, 0, 0));
		irViewPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(
				new javax.swing.border.LineBorder(new java.awt.Color(0, 153,
						153), 2, true), "IR: Remote #2",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(255, 0,
						51)));
		irViewPanel2.setToolTipText("IREvent - Remote 2");
		javax.swing.GroupLayout irViewPanelLayout2 = new javax.swing.GroupLayout(
				irViewPanel2);
		irViewPanel2.setLayout(irViewPanelLayout2);

		irCombined.setBackground(new java.awt.Color(0, 0, 0));
		irCombined.setBorder(javax.swing.BorderFactory
				.createTitledBorder(new javax.swing.border.LineBorder(
						new java.awt.Color(0, 0, 0), 2, true), "IR: Combined",
						javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
						javax.swing.border.TitledBorder.DEFAULT_POSITION,
						new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(
								0, 0, 0)));
		irCombined.setToolTipText("IREvent - Combined View");
		javax.swing.GroupLayout irCombinedLayout = new javax.swing.GroupLayout(
				irCombined);
		irCombined.setLayout(irCombinedLayout);

		irViewPanelLayout1.setHorizontalGroup(irViewPanelLayout1
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 272, Short.MAX_VALUE));
		irViewPanelLayout1.setVerticalGroup(irViewPanelLayout1
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 299, Short.MAX_VALUE));

		irViewPanelLayout2.setHorizontalGroup(irViewPanelLayout2
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 272, Short.MAX_VALUE));
		irViewPanelLayout2.setVerticalGroup(irViewPanelLayout2
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 299, Short.MAX_VALUE));

		irCombinedLayout.setHorizontalGroup(irCombinedLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 272, Short.MAX_VALUE));
		irCombinedLayout.setVerticalGroup(irCombinedLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 299,
				Short.MAX_VALUE));

		irCombinedPanel.setBorder(javax.swing.BorderFactory
				.createEtchedBorder());
		irCombinedPanel.setLayout(new javax.swing.BoxLayout(irCombinedPanel,
				javax.swing.BoxLayout.LINE_AXIS));

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

		javax.swing.GroupLayout irPadPanelLayout = new javax.swing.GroupLayout(
				irPadPanel);
		irPadPanel.setLayout(irPadPanelLayout);
		irPadPanelLayout.setHorizontalGroup(irPadPanelLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(irViewPanel1,
						javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(irViewPanel2,
						javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(buttonPanel,
						javax.swing.GroupLayout.Alignment.TRAILING,
						javax.swing.GroupLayout.DEFAULT_SIZE,
						javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		irPadPanelLayout.setVerticalGroup(irPadPanelLayout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				irPadPanelLayout
						.createSequentialGroup()
						.addComponent(buttonPanel,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(irViewPanel1,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(irViewPanel2,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)

		));

		irCombinedPanel.add(irCombined);
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(irPadPanel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										238,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(irCombinedPanel,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										498, Short.MAX_VALUE)

				)

		);
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(irPadPanel, javax.swing.GroupLayout.DEFAULT_SIZE,
						573, Short.MAX_VALUE)
				.addComponent(irCombinedPanel,
						javax.swing.GroupLayout.DEFAULT_SIZE, 573,
						Short.MAX_VALUE));

		java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit()
				.getScreenSize();
		setBounds((screenSize.width - 800) / 2, (screenSize.height - 600) / 2,
				800, 600);

	}// </editor-fold>//GEN-END:initComponents

	private void clearDrawingButtonMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_clearDrawingButtonMousePressed
		if (clearDrawingButton.isEnabled()) {
			clearViews();
		}
	}// GEN-LAST:event_clearDrawingButtonMousePressed

	private void calibButtonMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_calibButtonMousePressed
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

	private void LRButtonMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_LRButtonMousePressed
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

	public static void drawCombine(int x, int y, int lastX, int lastY) {
		int[] adjust = cal.calculateOffsets(x, y);
		int[] adjustLast = cal.calculateOffsets(lastX, lastY);

		((IRCombined) irCombined).onIrEvent(adjust[0], adjust[1],
				adjustLast[0], adjustLast[1]);
	}

	private void setState(cState s) {
		state = s;
		
		// sets state properly if this is the last calibration based on LR preferences
		if(state == null) {
			if(cal.leftSide == true) {
				setState(cState.LEFTBR);
			}
			else {
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
		System.out.println("");
	}

}
