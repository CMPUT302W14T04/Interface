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

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

import wiiusej.WiiUseApiManager;
import wiiusej.Wiimote;
import wiiusej.utils.AccelerationPanel;
import wiiusej.utils.AccelerationWiimoteEventPanel;
import wiiusej.utils.ButtonsEventPanel;
import wiiusej.utils.GForcePanel;
import wiiusej.utils.IRPanel;
import wiiusej.utils.IRCombined;
import wiiusej.utils.OrientationPanel;
import wiiusej.utils.OrientationWiimoteEventPanel;
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
	private Wiimote wiimote3;
	private Wiimote wiimote4;
	private Robot robot = null;
	private boolean statusMotionRequested = false;
	private boolean statusIRRequested = false;
	private JFrame expansionFrame = null;
	private boolean isFirstStatusGot = false;
	private static Calibrations cal = new Calibrations();
	
	
	
	
	private WindowListener buttonSetter = new WindowListener(){
		
		

		public void windowOpened(WindowEvent e) {
			// nothing
		}

		public void windowClosing(WindowEvent e) {
			// nothing
		}

		public void windowClosed(WindowEvent e) {
			// nothing
		}

		public void windowIconified(WindowEvent e) {
			// nothing
		}

		public void windowDeiconified(WindowEvent e) {
			// nothing
		}

		public void windowActivated(WindowEvent e) {
			showExpansionWiimoteButton.setEnabled(false);
                        if (expansionFrame instanceof NunchukGuiTest){
                            showExpansionWiimoteButton.setText("Hide Nunchuk");
                        }else if(expansionFrame instanceof GuitarHero3GuiTest){
                            showExpansionWiimoteButton.setText("Hide Guitar");
                        }else if(expansionFrame instanceof ClassicControllerGuiTest){
                            showExpansionWiimoteButton.setText("Hide Classic Controller");
                        }			
		}

		public void windowDeactivated(WindowEvent e) {
			showExpansionWiimoteButton.setEnabled(true);			
                        if (expansionFrame instanceof NunchukGuiTest){
                            showExpansionWiimoteButton.setText("Show Nunchuk");
                        }else if(expansionFrame instanceof GuitarHero3GuiTest){
                            showExpansionWiimoteButton.setText("Show Guitar");
                        }else if(expansionFrame instanceof ClassicControllerGuiTest){
                            showExpansionWiimoteButton.setText("Show Classic controller");
                        }
		}
	};
	


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
		if (wiimote != null) {
			if(wiimote2 != null){
				
				this.wiimote = wiimote;
				this.wiimote2 = wiimote2;				
				registerListeners();
				initWiimote();
				isFirstStatusGot = false;
				getStatusButtonMousePressed(null);
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
		
//		((ButtonsEventPanel) buttonsPanel).clearView();
//		((OrientationPanel) motionSensingPanel).clearView();
//		((GForcePanel) gForcePanel).clearView();
//		((AccelerationPanel) accelerationPanel).clearView();
	}

	/**
	 * Unregister all listeners.
	 */
	private void unregisterListeners() {
		wiimote.removeWiiMoteEventListeners((IRPanel) irViewPanel1);
		wiimote2.removeWiiMoteEventListeners((IRPanel) irViewPanel2);
		
		wiimote.removeWiiMoteEventListeners((ButtonsEventPanel) buttonsPanel);
		wiimote.removeWiiMoteEventListeners((OrientationPanel) motionSensingPanel);
		wiimote.removeWiiMoteEventListeners((GForcePanel) gForcePanel);
		wiimote.removeWiiMoteEventListeners((AccelerationPanel) accelerationPanel);
		wiimote.removeWiiMoteEventListeners(this);
	}

	private void initWiimote() {
		wiimote.deactivateContinuous();
		wiimote.deactivateSmoothing();
		wiimote.setScreenAspectRatio169();
		wiimote.setSensorBarBelowScreen();
	}

	/**
	 * Register all listeners
	 */
	private void registerListeners() {
		wiimote.addWiiMoteEventListeners((IRPanel) irViewPanel1);
		wiimote2.addWiiMoteEventListeners((IRPanel) irViewPanel2);
		
		wiimote.addWiiMoteEventListeners((ButtonsEventPanel) buttonsPanel);
		wiimote.addWiiMoteEventListeners((OrientationPanel) motionSensingPanel);
		wiimote.addWiiMoteEventListeners((GForcePanel) gForcePanel);
		wiimote.addWiiMoteEventListeners((AccelerationPanel) accelerationPanel);
		wiimote.addWiiMoteEventListeners(this);

	}

	public void onButtonsEvent(WiimoteButtonsEvent arg0) {
		
		if (robot != null) {
			if (arg0.isButtonAPressed()) {
				robot.mousePress(InputEvent.BUTTON1_MASK);
			}
			if (arg0.isButtonBPressed()) {
				robot.mousePress(InputEvent.BUTTON2_MASK);

			}
			if (arg0.isButtonOnePressed()) {
				robot.mousePress(InputEvent.BUTTON3_MASK);

			}
			if (arg0.isButtonAJustReleased()) {
				robot.mouseRelease(InputEvent.BUTTON1_MASK);

			}
			if (arg0.isButtonBJustReleased()) {
				robot.mouseRelease(InputEvent.BUTTON2_MASK);

			}
			if (arg0.isButtonOneJustReleased()) {
				robot.mouseRelease(InputEvent.BUTTON3_MASK);

			}
			if (arg0.isButtonUpPressed()) {// mouse wheel up
				robot.mouseWheel(-1);
			}
			if (arg0.isButtonDownPressed()) {// mouse wheel down
				robot.mouseWheel(1);
			}

			if (arg0.isButtonTwoPressed()) {// stop mouse control
				mouseIRControlButtonMousePressed(null);
			}
		}
	}

	public void onIrEvent(IREvent arg0) {
		if (robot != null) {// if mouse control activated
			robot.mouseMove(arg0.getX(), arg0.getY());
		}
		if (statusIRRequested) {
			xResolutionTextField.setText("" + arg0.getXVRes());
			yResolutionTextField.setText("" + arg0.getYVRes());
			statusIRRequested = false;
		}
	}

	public void onMotionSensingEvent(MotionSensingEvent arg0) {
		if (statusMotionRequested) {// Status requested
			accelerationThresholdTextField.setText(""
					+ arg0.getAccelerationThreshold());
			orientationThresholdTextField.setText(""
					+ arg0.getOrientationThreshold());
			alphaSmoothingTextField.setText("" + arg0.getAlphaSmoothing());
			statusMotionRequested = false;
		}
	}

	public void onExpansionEvent(ExpansionEvent e) {
		// nothing yet
	}

	public void onStatusEvent(StatusEvent arg0) {
		if (!isFirstStatusGot) {
			if (arg0.isNunchukConnected()) {
				showExpansionWiimoteButton.setEnabled(true);
				showExpansionWiimoteButton.setText("Show Nunchuk");
				expansionFrame = new NunchukGuiTest(wiimote);
				expansionFrame
						.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				expansionFrame.addWindowListener(buttonSetter);
				isFirstStatusGot = true;
			}else if(arg0.isClassicControllerConnected()){
                                showExpansionWiimoteButton.setEnabled(true);
				showExpansionWiimoteButton.setText("Show Classic Controller");
				expansionFrame = new ClassicControllerGuiTest(wiimote);
				expansionFrame
						.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				expansionFrame.addWindowListener(buttonSetter);
				isFirstStatusGot = true;
                        }
                        else if(arg0.isGuitarHeroConnected()){
                                showExpansionWiimoteButton.setEnabled(true);
				showExpansionWiimoteButton.setText("Show Guitar Hero 3 Controller");
				expansionFrame = new GuitarHero3GuiTest(wiimote);
				expansionFrame
						.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				expansionFrame.addWindowListener(buttonSetter);
				isFirstStatusGot = true;
                        }
		}
		messageText.setText("Status received !");
		batteryLevelText.setText(arg0.getBatteryLevel() + " %");
		led1Button.setEnabled(arg0.isLed1Set());
		led2Button.setEnabled(arg0.isLed2Set());
		calibButton.setEnabled(arg0.isLed3Set());
		LRButton.setEnabled(arg0.isLed4Set());
		if (arg0.isNunchukConnected()) {
                    ((NunchukGuiTest) expansionFrame).requestThresholdsUpdate();
		}
		// attachments
		int eventType = arg0.getEventType();
		if (eventType == StatusEvent.WIIUSE_CLASSIC_CTRL_INSERTED) {
			expansionText.setText("Classic control connected.");
		} else if (eventType == StatusEvent.WIIUSE_CLASSIC_CTRL_REMOVED) {
			expansionText.setText("Classic control removed.");
		} else if (eventType == StatusEvent.WIIUSE_NUNCHUK_INSERTED) {
			expansionText.setText("Nunchuk connected.");
		} else if (eventType == StatusEvent.WIIUSE_NUNCHUK_REMOVED) {
			expansionText.setText("Nunchuk removed.");
		} else if (eventType == StatusEvent.WIIUSE_GUITAR_HERO_3_CTRL_INSERTED) {
			expansionText.setText("Guitar Hero 3 control connected.");
		} else if (eventType == StatusEvent.WIIUSE_GUITAR_HERO_3_CTRL_REMOVED) {
			expansionText.setText("Guitar Hero 3 control removed.");
		}
	}

	public void onDisconnectionEvent(DisconnectionEvent arg0) {
		messageText.setText("Wiimote Disconnected !");
		unregisterListeners();
		clearViews();
		isFirstStatusGot = false;
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        leftPanel = new javax.swing.JPanel();
        irViewPanel1 = new IRPanel();
        irViewPanel2 = new IRPanel();
        irCombined = new IRCombined();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        accelerationPanel = new AccelerationWiimoteEventPanel();
        motionSensingPanel = new OrientationWiimoteEventPanel();
        gForcePanel = new wiiusej.utils.GForceWiimoteEventPanel();
        rightPanel = new javax.swing.JPanel();
        buttonsPanel = new ButtonsEventPanel();
        controlsPanel = new javax.swing.JPanel();
        activateRumbleIRPanel = new javax.swing.JPanel();

        toggleIRTrackingButton = new javax.swing.JButton();



        setLedsPanel = new javax.swing.JPanel();
        led1Button = new javax.swing.JButton();
        led2Button = new javax.swing.JButton();
        calibButton = new javax.swing.JButton();
        LRButton = new javax.swing.JButton();
        setLedsButton = new javax.swing.JButton();
        
        alphaSmoothingTextField = new javax.swing.JTextField();
        
        orientationThresholdTextField = new javax.swing.JTextField();
        
        accelerationThresholdTextField = new javax.swing.JTextField();
        

        getStatusButton = new javax.swing.JButton();
        
        batteryLevelText = new javax.swing.JLabel();
        setIrSensitivyPanel = new javax.swing.JPanel();
        setIrSensitivySpinner = new javax.swing.JSpinner();
        setIrSensitivyButton = new javax.swing.JButton();



        
        setIRConfPanel = new javax.swing.JPanel();
        toggleSensorBarPositionButton = new javax.swing.JButton();
        toggleScreenAspectRatioButton = new javax.swing.JButton();

        xResolutionTextField = new javax.swing.JTextField();

        yResolutionTextField = new javax.swing.JTextField();
  
        
        mouseIRControlButton = new javax.swing.JButton();
        
        expansionText = new javax.swing.JLabel();
        
        showExpansionWiimoteButton = new javax.swing.JButton();
        showExpansionWiimoteButton.setEnabled(false);

        messageText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IR Paint");
        setName("IR Paint"); // NOI18N

        leftPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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


        accelerationPanel.setToolTipText("MotionSensingEvent");

        javax.swing.GroupLayout accelerationPanelLayout = new javax.swing.GroupLayout(accelerationPanel);
        accelerationPanel.setLayout(accelerationPanelLayout);
        accelerationPanelLayout.setHorizontalGroup(
            accelerationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );
        accelerationPanelLayout.setVerticalGroup(
            accelerationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );

        //jTabbedPane1.addTab("Acceleration", accelerationPanel);

        javax.swing.GroupLayout motionSensingPanelLayout = new javax.swing.GroupLayout(motionSensingPanel);
        motionSensingPanel.setLayout(motionSensingPanelLayout);
        motionSensingPanelLayout.setHorizontalGroup(
            motionSensingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );
        motionSensingPanelLayout.setVerticalGroup(
            motionSensingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );

       // jTabbedPane1.addTab("Orientation", motionSensingPanel);

        javax.swing.GroupLayout gForcePanelLayout = new javax.swing.GroupLayout(gForcePanel);
        gForcePanel.setLayout(gForcePanelLayout);
        gForcePanelLayout.setHorizontalGroup(
            gForcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );
        gForcePanelLayout.setVerticalGroup(
            gForcePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 213, Short.MAX_VALUE)
        );

        //jTabbedPane1.addTab("GForce", gForcePanel);

       

        jTabbedPane1.getAccessibleContext().setAccessibleName("Orientation");
        
        
        rightPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        rightPanel.setLayout(new javax.swing.BoxLayout(rightPanel, javax.swing.BoxLayout.LINE_AXIS));

        

        controlsPanel.setMinimumSize(new java.awt.Dimension(100, 264));
        controlsPanel.setPreferredSize(new java.awt.Dimension(190, 264));
        controlsPanel.setLayout(new java.awt.GridLayout(16, 1));

       

        toggleIRTrackingButton.setText("Clear");
        toggleIRTrackingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                toggleIRTrackingButtonMousePressed(evt);
            }
        });
        activateRumbleIRPanel.add(toggleIRTrackingButton);

        //controlsPanel.add(activateRumbleIRPanel);

        


        led1Button.setText("Led1");
        led1Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                led1ButtonMousePressed(evt);
            }
        });
        setLedsPanel.add(led1Button);

        led2Button.setText("Led2");
        led2Button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                led2ButtonMousePressed(evt);
            }
        });
        setLedsPanel.add(led2Button);

        calibButton.setText("Capture");
        calibButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                calibButtonMousePressed(evt);
            }
        });
        activateRumbleIRPanel.add(calibButton);

        LRButton.setText("Left");
        LRButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LRButtonMousePressed(evt);
            }
        });
        
        activateRumbleIRPanel.add(LRButton);

        setLedsButton.setText("Set leds");
        setLedsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                setLedsButtonMousePressed(evt);
            }
        });
        setLedsPanel.add(setLedsButton);

        //controlsPanel.add(setLedsPanel);


        
      

        

        setIrSensitivyPanel.add(getStatusButton);

        setIrSensitivySpinner.setPreferredSize(new java.awt.Dimension(50, 18));
        setIrSensitivySpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                setIrSensitivySpinnerStateChanged(evt);
            }
        });
        setIrSensitivyPanel.add(setIrSensitivySpinner);

        setIrSensitivyButton.setText("Set IR Sensivity");
        setIrSensitivyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                setIrSensitivyButtonMousePressed(evt);
            }
        });
        setIrSensitivyPanel.add(setIrSensitivyButton);

       

        //controlsPanel.add(setIrSensitivyPanel);

       

        toggleSensorBarPositionButton.setText("Set sensor bar above");
        toggleSensorBarPositionButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                toggleSensorBarPositionButtonMousePressed(evt);
            }
        });
        setIRConfPanel.add(toggleSensorBarPositionButton);

        toggleScreenAspectRatioButton.setText("Set screen aspect ratio 4/3");
        toggleScreenAspectRatioButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                toggleScreenAspectRatioButtonMousePressed(evt);
            }
        });
        setIRConfPanel.add(toggleScreenAspectRatioButton);

        
        
        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(irViewPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(irViewPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(activateRumbleIRPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftPanelLayout.createSequentialGroup()
            	.addComponent(activateRumbleIRPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(irViewPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(irViewPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                
                
                )
        );
        
        
        //controlsPanel.add(jTabbedPane1);
        //rightPanel.add(controlsPanel);
        rightPanel.add(irCombined);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)                
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                //.addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                )
                
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
            .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
            //.addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-800)/2, (screenSize.height-600)/2, 800, 600);
    }// </editor-fold>//GEN-END:initComponents

	private void toggleIRTrackingButtonMousePressed(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_toggleIRTrackingButtonMousePressed
		if (toggleIRTrackingButton.isEnabled()) {
			clearViews();
		} else {
			wiimote.deactivateIRTRacking();
			wiimote2.deactivateIRTRacking();
			toggleIRTrackingButton.setEnabled(true);
			toggleIRTrackingButton.setText("Activate IR Tracking");
			((IRPanel) irViewPanel1).onDisconnectionEvent(null);
			((IRPanel) irViewPanel2).onDisconnectionEvent(null);
			messageText.setText("IR Tracking deactivated");
		}
	}// GEN-LAST:event_toggleIRTrackingButtonMousePressed

	

	private void led1ButtonMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_led1ButtonMousePressed
		if (led1Button.isEnabled()) {
			led1Button.setEnabled(false);
		} else {
			led1Button.setEnabled(true);
		}
	}// GEN-LAST:event_led1ButtonMousePressed

	private void led2ButtonMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_led2ButtonMousePressed
		if (led2Button.isEnabled()) {
			led2Button.setEnabled(false);
		} else {
			led2Button.setEnabled(true);
		}
	}// GEN-LAST:event_led2ButtonMousePressed

	private void calibButtonMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_calibButtonMousePressed
		if (calibButton.isEnabled()) {
			calibButton.setEnabled(false);
			calibButton.setText("Locked");
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

	private void setLedsButtonMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_setLedsButtonMousePressed
		wiimote.setLeds(led1Button.isEnabled(), led2Button.isEnabled(),
				calibButton.isEnabled(), LRButton.isEnabled());
		messageText.setText("Leds set");
	}// GEN-LAST:event_setLedsButtonMousePressed

	private void getStatusButtonMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_getStatusButtonMousePressed
		wiimote.getStatus();
		statusMotionRequested = true;
		statusIRRequested = true;
		if (expansionFrame instanceof NunchukGuiTest) {
			((NunchukGuiTest) expansionFrame).requestThresholdsUpdate();
		}
	}// GEN-LAST:event_getStatusButtonMousePressed

	private void toggleSensorBarPositionButtonMousePressed(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_toggleSensorBarPositionButtonMousePressed
		if (toggleSensorBarPositionButton.isEnabled()) {
			wiimote.setSensorBarBelowScreen();
			toggleSensorBarPositionButton.setEnabled(false);
			toggleSensorBarPositionButton.setText("Set sensor bar below");
			messageText.setText("Sensor bar set above");
		} else {
			wiimote.setSensorBarAboveScreen();
			toggleSensorBarPositionButton.setEnabled(true);
			toggleSensorBarPositionButton.setText("Set sensor bar above");
			messageText.setText("Sensor bar set below");
		}
	}// GEN-LAST:event_toggleSensorBarPositionButtonMousePressed

	private void toggleScreenAspectRatioButtonMousePressed(
			java.awt.event.MouseEvent evt) {// GEN-FIRST:event_toggleScreenAspectRatioButtonMousePressed
		if (toggleScreenAspectRatioButton.isEnabled()) {
			wiimote.setScreenAspectRatio43();
			toggleScreenAspectRatioButton.setEnabled(false);
			toggleScreenAspectRatioButton
					.setText("Set screen aspect ratio 16/9");
			messageText.setText("creen aspect ratio to 4/3");
		} else {
			wiimote.setScreenAspectRatio169();
			toggleScreenAspectRatioButton.setEnabled(true);
			toggleScreenAspectRatioButton
					.setText("Set screen aspect ratio 4/3");
			messageText.setText("Screen aspect ratio to 16/9");
		}
	}// GEN-LAST:event_toggleScreenAspectRatioButtonMousePressed

	

	private void mouseIRControlButtonMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_mouseIRControlButtonMousePressed
		if (mouseIRControlButton.isEnabled()) {
			try {
				mouseIRControlButton.setEnabled(false);
				mouseIRControlButton.setText("Stop infrared mouse control");
				robot = new Robot();
				messageText.setText("Infrared mouse control started");
			} catch (AWTException ex) {
				Logger.getLogger(WiiuseJGuiTest.class.getName()).log(
						Level.SEVERE, null, ex);
			}
		} else {
			mouseIRControlButton.setEnabled(true);
			mouseIRControlButton.setText("Start infrared mouse control");
			robot = null;
			messageText.setText("Infrared mouse control stopped");
		}
	}// GEN-LAST:event_mouseIRControlButtonMousePressed

	
	private void setIrSensitivySpinnerStateChanged(
			javax.swing.event.ChangeEvent evt) {// GEN-FIRST:event_setIrSensitivySpinnerStateChanged
		String value = setIrSensitivySpinner.getValue().toString();
		boolean isInt = true;
		int valueInt = 0;
		try {
			valueInt = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			isInt = false;
			messageText.setText("Wrong value for IR senstivity.");
		}
		if (isInt) {
			if (valueInt > 5) {
				setIrSensitivySpinner.setValue("1000");
			} else if (valueInt < 0) {
				setIrSensitivySpinner.setValue("0");
			}
		}
	}// GEN-LAST:event_setIrSensitivySpinnerStateChanged

	
	private void setIrSensitivyButtonMousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_setIrSensitivyButtonMousePressed
		String value = setIrSensitivySpinner.getValue().toString();
		boolean isInt = true;
		int valueInt = 0;
		try {
			valueInt = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			isInt = false;
			messageText
					.setText("Wrong value for IR sensitivity. It must be an int !");
		}
		if (isInt) {
			if (valueInt >= 1 && valueInt <= 5) {
				wiimote.setIrSensitivity(valueInt);
				messageText.setText("IR senstivity set to: " + valueInt + ".");
			} else {
				messageText
						.setText("Wrong value for IR senstivity. It muset be between 1 and 5 !");
			}
		}
	}// GEN-LAST:event_setIrSensitivyButtonMousePressed

	

	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel accelerationPanel;
    
    private javax.swing.JTextField accelerationThresholdTextField;

    private javax.swing.JPanel activateRumbleIRPanel;
    
    private javax.swing.JTextField alphaSmoothingTextField;
    private javax.swing.JLabel batteryLevelText;
    
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JPanel controlsPanel;
    

   
    private javax.swing.JLabel expansionText;
    private javax.swing.JPanel gForcePanel;
    private javax.swing.JButton getStatusButton;

    private static javax.swing.JPanel irViewPanel1;
    private static javax.swing.JPanel irViewPanel2;
    private static javax.swing.JPanel irCombined;    
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton led1Button;
    private javax.swing.JButton led2Button;
    private static javax.swing.JButton calibButton;
    private javax.swing.JButton LRButton;
    private javax.swing.JPanel leftPanel;

    private javax.swing.JLabel messageText;

    private javax.swing.JPanel motionSensingPanel;
    private javax.swing.JButton mouseIRControlButton;


    private javax.swing.JTextField orientationThresholdTextField;
    private javax.swing.JPanel rightPanel;
    
    private javax.swing.JPanel setIRConfPanel;
    private javax.swing.JButton setIrSensitivyButton;
    private javax.swing.JPanel setIrSensitivyPanel;
    private javax.swing.JSpinner setIrSensitivySpinner;
    private javax.swing.JButton setLedsButton;
    private javax.swing.JPanel setLedsPanel;  
    private javax.swing.JButton showExpansionWiimoteButton;
    private javax.swing.JButton toggleIRTrackingButton;

    private javax.swing.JButton toggleScreenAspectRatioButton;
    private javax.swing.JButton toggleSensorBarPositionButton;
    private javax.swing.JTextField xResolutionTextField;
    private javax.swing.JTextField yResolutionTextField;
    // End of variables declaration//GEN-END:variables

	public static void drawCombine(int x, int y, int lastX, int lastY){	
		int[] adjust = cal.calculateOffsets(x,y);
		int[] adjustLast = cal.calculateOffsets(lastX,lastY);
		
		((IRCombined) irCombined).onIrEvent(adjust[0], adjust[1],adjustLast[0],adjustLast[1]);
		
		
		
	}
	
	public static void calibrate(){
		int[][] calibMatrix = new int[8][2];
		int[][] coords = cal.eventFilter(2);
		cal.setF(8f, 5.5f);		
		cal.setDefaultFloor((coords[0][1] + coords[1][1])/2);
		cal.spatializeWiiMotes2x(coords[0][0], coords[1][0], wiimote, wiimote2);
		clearViews();
		calibMatrix[0] = cal.calculateOffsets(coords[0][0], coords[1][0]);
		calibButton.setEnabled(true);
		calibButton.setText("Capture");
		((IRCombined) irCombined).drawCalib(calibMatrix[0]);
		for(int i = 2; i < 9; i++){
			while(calibButton.isEnabled() == true){
				System.out.print("SP: " + i + "");
			}
			int[][] temp = cal.getCalibPoints(calibButton);
			calibMatrix[i - 1] = cal.calculateOffsets(temp[0][0], temp[1][0]);
			
			((IRCombined) irCombined).drawCalib(calibMatrix[i - 1]);
		}
		
		calibButton.setEnabled(false);
		calibButton.setText("DONE");
		
		
		
		cal.generateBoundaries(calibMatrix);
		clearViews();
	
	}
	
	
		
}
