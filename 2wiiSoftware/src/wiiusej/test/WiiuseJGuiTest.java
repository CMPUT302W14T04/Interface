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
 */

public class WiiuseJGuiTest extends javax.swing.JFrame implements
		WiimoteListener {

	private static final long serialVersionUID = 1L;
	private static Wiimote wiimote;
	private static Wiimote wiimote2;
	private static Calibrations cal = new Calibrations();
	private static boolean isCalibrating = false;
	
	/**
	 * default constructor
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
			if(wiimote2 != null){
				
				this.wiimote = wiimote;
				this.wiimote2 = wiimote2;				
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
		//nothing
	}

	/**
	 * Required function due to inheritance
	 * Note: this is NOT the same onIrEvent used in IRCombine to draw later on
	 */
	public void onIrEvent(IREvent arg0) {
		//nothing
	}

	/**
	 * Required function due to inheritance
	 */
	public void onMotionSensingEvent(MotionSensingEvent arg0) {
		//nothing
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
		//nothing yet
	}

	/**
	 * What happens when wiimote disconnects
	 */
	public void onDisconnectionEvent(DisconnectionEvent arg0) {
		unregisterListeners();
		clearViews();
	}


    private void initComponents() {
        
        // IR dot panel to show what an individual wiimote picks up
        irViewPanel1 = new IRPanel();
        irViewPanel2 = new IRPanel();
        // IR panel to draw the combined coordinates from the individual irViewPanel
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
        
        showExpansionWiimoteButton = new javax.swing.JButton();
        showExpansionWiimoteButton.setEnabled(false);

        messageText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IR Paint");
        setName("IR Paint"); // NOI18N

        irPadPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        irViewPanel1.setBackground(new java.awt.Color(0, 0, 0));
        irViewPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 2, true), "IR: Remote #1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(255, 0, 51)));
        irViewPanel1.setToolTipText("IREvent - Remote 1");
        javax.swing.GroupLayout irViewPanelLayout1 = new javax.swing.GroupLayout(irViewPanel1);
        irViewPanel1.setLayout(irViewPanelLayout1);
        
        irViewPanel2.setBackground(new java.awt.Color(0, 0, 0));
        irViewPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 2, true), "IR: Remote #2", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(255, 0, 51)));
        irViewPanel2.setToolTipText("IREvent - Remote 2");
        javax.swing.GroupLayout irViewPanelLayout2 = new javax.swing.GroupLayout(irViewPanel2);
        irViewPanel2.setLayout(irViewPanelLayout2);
        
        irCombined.setBackground(new java.awt.Color(0, 0, 0));
        irCombined.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), "IR: Combined", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16), new java.awt.Color(0, 0, 0)));
        irCombined.setToolTipText("IREvent - Combined View");
        javax.swing.GroupLayout irCombinedLayout = new javax.swing.GroupLayout(irCombined);
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
        
        irCombinedLayout.setHorizontalGroup(
        		irCombinedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		.addGap(0, 272, Short.MAX_VALUE)
        		);
        irCombinedLayout.setVerticalGroup(
        		irCombinedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        		.addGap(0, 299, Short.MAX_VALUE)
        		);

        
        
        irCombinedPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        irCombinedPanel.setLayout(new javax.swing.BoxLayout(irCombinedPanel, javax.swing.BoxLayout.LINE_AXIS));

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

        javax.swing.GroupLayout irPadPanelLayout = new javax.swing.GroupLayout(irPadPanel);
        irPadPanel.setLayout(irPadPanelLayout);
        irPadPanelLayout.setHorizontalGroup(
            irPadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(irViewPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(irViewPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        irPadPanelLayout.setVerticalGroup(
            irPadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, irPadPanelLayout.createSequentialGroup()
            	.addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(irViewPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(irViewPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                
                
                )
        );
        
        irCombinedPanel.add(irCombined);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(irPadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)                
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(irCombinedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
               
                )
                
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(irPadPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
            .addComponent(irCombinedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-800)/2, (screenSize.height-600)/2, 800, 600);
        
    }// </editor-fold>//GEN-END:initComponents

	private void clearDrawingButtonMousePressed(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_clearDrawingButtonMousePressed
		if (clearDrawingButton.isEnabled()) {
			clearViews();
		}
	}// GEN-LAST:event_clearDrawingButtonMousePressed

	private void calibButtonMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_calibButtonMousePressed
		if (calibButton.isEnabled()) {
			System.out.println("Button got pressed!");
			printCaliState();
			if (isCalibrating) {
				calibButton.setEnabled(false);
				calibButton.setText("Locked");
			}
			else {
				calibrate();
			}
		} 
	}// GEN-LAST:event_calibButtonMousePressed

	private void LRButtonMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_LRButtonMousePressed
		if (LRButton.isEnabled()) {
			LRButton.setEnabled(false);
			LRButton.setText("Right");
			cal.leftSide = false;
		} else {
			LRButton.setEnabled(true);
			LRButton.setText("Left");
			cal.leftSide = true;
		}
	}// GEN-LAST:event_LRButtonMousePressed

	// Variables declaration - do not modify//GEN-BEGIN:variables

    private javax.swing.JPanel buttonPanel;

    private static javax.swing.JPanel irViewPanel1;
    private static javax.swing.JPanel irViewPanel2;
    private static javax.swing.JPanel irCombined;    

    private static javax.swing.JButton calibButton;
    private javax.swing.JButton LRButton;
    private javax.swing.JPanel irPadPanel;

    private javax.swing.JLabel messageText;

    private javax.swing.JPanel irCombinedPanel;
     
    private javax.swing.JButton showExpansionWiimoteButton;
    private javax.swing.JButton clearDrawingButton;

	public static void drawCombine(int x, int y, int lastX, int lastY){	
		int[] adjust = cal.calculateOffsets(x,y);
		int[] adjustLast = cal.calculateOffsets(lastX,lastY);
		
		((IRCombined) irCombined).onIrEvent(adjust[0], adjust[1],adjustLast[0],adjustLast[1]);
	}
	
	// James's calibration routine
	public static void calibrate(){
		isCalibrating = true;
		int[][] calibMatrix = new int[9][2];
		
		//calibration for the first points
		
		//enable this following block for real usage
		//int[][] coords = cal.eventFilter(2);
		
		//for development purposes only; disable this block for real usage
		int[][] coords = cal.getFakeCalibPoints(calibButton, 1);
		
		printCaliState();
		cal.setF(8f, 5.5f);		
		cal.setDefaultFloor((coords[0][1] + coords[1][1])/2);
		cal.spatializeWiiMotes2x(coords[0][0], coords[1][0], wiimote, wiimote2);
		
		// clears what's drawn so far if calibration is required
		clearViews();
		calibMatrix[0] = cal.calculateOffsets(coords[0][0], coords[1][0]);
		calibButton.setEnabled(true);
		calibButton.setText("Capture Next Point");
		((IRCombined) irCombined).drawCalib(calibMatrix[0]);
		
		// calibration routine for points 2 to 8, the rest of the points
		for(int i = 2; i < 9; i++){
			
			// draw the source of the received IR
			
			//enable this following block for real usage
			//int[][] temp = cal.getCalibPoints(calibButton);
			//calibMatrix[i - 1] = cal.calculateOffsets(temp[0][0], temp[1][0]);
			
			//for development purposes only; disable this block for real usage
			printCaliState();
			int[][] temp = cal.getFakeCalibPoints(calibButton, i-1);
			printCaliState();
			
			((IRCombined) irCombined).drawCalib(calibMatrix[i - 1]);
		}
		
		calibButton.setEnabled(true);
		calibButton.setText("Re-Calibrate");
		isCalibrating = false;
		
		cal.generateBoundaries(calibMatrix);
		// remove drawn calibration points
		printCaliState();
	
	}
	
	public static void printCaliState() {
		System.out.println("isCalibrating state: "+isCalibrating);
		System.out.println("CaliButton state: "+calibButton.isEnabled());
		System.out.println("");
	}
	
	
		
}
