package wiiusej.test;



/**
 * Class that reflects what stage of calibration the user is on, used as a state
 * machine such that other functions may act appropriately depending on the
 * calibration state, such as displaying instructions, or turning on/off certain
 * buttons.
 * 
 * @author Eddie
 *
 */
public class CState {

	/**
	 * possible states for which point we are calibrating and where the wiimotes
	 * are
	 */
	protected enum calibrationState {
		
		// complete, ready to use statae
		DONE(null, false, false, null),

		// wiimote on right position
		RIGHTBMF("Calibration for this point is complete. Please press the " +
					"\"Capture Next Point\" button to begin calibration for the next point.", false, false, DONE),
		RIGHTBMT("Activate the IR pen over the midpoint on the bottom edge of the map and lightly swivel at that location", true, false, RIGHTBMF), 
		RIGHTBRF("Calibration for this point is complete. Please press the " +
					"\"Capture Next Point\" button to begin calibration for the next point.", false, false, RIGHTBMT), 
		RIGHTBRT("Activate the IR pen over the bottom right of the corner of the map and lightly swivel at that location", true, false, RIGHTBRF), 
		RIGHTMRF("Calibration for this point is complete. Please press the " +
					"\"Capture Next Point\" button to begin calibration for the next point.", false, false, RIGHTBRT), 
		RIGHTMRT("Activate the IR pen over the midpoint on the right edge of the map and lightly swivel at that location", true, false, RIGHTMRF), 
		RIGHTTRF("Calibration for this point is complete. Please press the " +
					"\"Capture Next Point\" button to begin calibration for the next point.", false, false, RIGHTMRT), 
		RIGHTTRT("Activate the IR pen over the top right corner of the map and lightly swivel at that location", true, false, RIGHTTRF), 
		RIGHTTMF("Calibration for this point is complete. Please press the " +
					"\"Capture Next Point\" button to begin calibration for the next point.", false, false, RIGHTTRT),
		RIGHTTMT("Activate the IR pen over the midpoint on the top edge of the map and lightly swivel at that location", true, false, RIGHTTMF),
		RIGHTTLF("Calibration for this point is complete. Please press the " +
					"\"Capture Next Point\" button to begin calibration for the next point.", false, false, RIGHTTMT), 
		RIGHTTLT("Activate the IR pen over the top left corner of the map and lightly swivel at that location", true, false, RIGHTTLF), 
		RIGHTMLF("Calibration for this point is complete. Please press the " +
					"\"Capture Next Point\" button to begin calibration for the next point.", false, false, RIGHTTLT),
		RIGHTMLT("Activate the IR pen over the midpoint of the left edge of the map and lightly swivel at that location", true, false, RIGHTMLF), 
		RIGHTBLF("Calibration for this point is complete. Please press the " +
					"\"Capture Next Point\" button to begin calibration for the next point.", false, false, RIGHTMLT),
		RIGHTBLT("Activate the IR pen over the bottom left corner of the map and lightly swivel at that location", true, false,  RIGHTBLF),

		// wiimote on left position
		LEFTMRT("Calibration for this point is complete. Please press the " +
					"\"Capture Next Point\" button to begin calibration for the next point.", true, false, DONE), 
		LEFTMRF("Activate the IR pen over the midpoint of the right edge of the map and lightly swivel at that location", false, false, LEFTMRT), 
		LEFTTRF("Calibration for this point is complete. Please press the " +
					"\"Capture Next Point\" button to begin calibration for the next point.", false, false,  LEFTMRF), 
		LEFTTRT("Activate the IR pen over the top right corner of the map and lightly swivel at that location", true, false,  LEFTTRF), 
		LEFTTMF("Calibration for this point is complete. Please press the " +
					"\"Capture Next Point\" button to begin calibration for the next point.", false, false,  LEFTTRT),
		LEFTTMT("Activate the IR pen over the midpoint of the top edge of the map and lightly swivel at that location", true, false,  LEFTTMF), 
		LEFTTLF("Calibration for this point is complete. Please press the " +
					"\"Capture Next Point\" button to begin calibration for the next point.", false,  false, LEFTTMT),
		LEFTTLT("Activate the IR pen over the top left corner of the map and lightly swivel at that location", true,  false, LEFTTLF), 
		LEFTMLF("Calibration for this point is complete. Please press the " +
					"\"Capture Next Point\" button to begin calibration for the next point.", false,  false, LEFTTLT), 
		LEFTMLT("Activate the IR pen over the midpoint of the left edge of the map and lightly swivel at that location", true,  false, LEFTMLF), 
		LEFTBLF("Calibration for this point is complete. Please press the " +
					"\"Capture Next Point\" button to begin calibration for the next point.", false,  false, LEFTMLT), 
		LEFTBLT("Activate the IR pen over the bottom left corner of the map and lightly swivel at that location", true,  false, LEFTBLF), 
		LEFTBMF("Calibration for this point is complete. Please press the " +
					"\"Capture Next Point\" button to begin calibration for the next point.", false,  false, LEFTBLT), 
		LEFTBMT("Activate the IR pen over the midpoint of the bottom edge of the map and lightly swivel at that location", true,  false, LEFTBMF), 
		LEFTBRF("Calibration for this point is complete. Please press the " +
					"\"Capture Next Point\" button to begin calibration for the next point.", false,  false, LEFTBMT),
		LEFTBRT("Activate the IR pen over the bottom right corner of the map and lightly swivel at that location", true,  false, LEFTBRF),
		
		// setting up wiimote distance
		
		// next state cannot be pre-determined due to left right config
		WII2("setup of wiimote 2", false,  false, null),
		WII1("setup of wiimote 1", false, false, WII2),
		BEGIN("begin", false, true, WII1),
		
		// wiimote disconnected, must recalibrate
		DISCONN(null, false, true, BEGIN),
		// state for asking confirmation before carrying out an action
		RECALICONFIRM(null, false, false, BEGIN),
		CLEARCONFIRM(null, false, false, BEGIN);

		String description;
		boolean pollState;
		boolean lrAllow;
		calibrationState nextPosition;
		
		/*
		 * Format of states:
		 * descriptive text, pollstate, next point
		 * 
		 * Description Text: text description to be displayed at that state by the program
		 * pollState: are we polling right now waiting for IR signal?
		 * lrAlow: do we allow L/R orientation switch of remotes? if yes, then true
		 * Next point: which is the next point to be calibrated
		 */

		calibrationState(String t, boolean s, boolean b, calibrationState next) {
			description = t; 
			pollState = s;
			lrAllow = b;
			nextPosition = next; 
		}

		calibrationState getNext() {
			return nextPosition;
		}
		
		String getDescription() {
			return description;
		}
		
		boolean getPollState() {
			return pollState;
		}
		
		boolean getLRAllow() {
			return lrAllow;
		}
	}
	
	private calibrationState calibrationState;
	
	public CState() {
		calibrationState = calibrationState.BEGIN;
	}
	
	// getters and setters
	public calibrationState getCState() {
		return this.calibrationState;
	}
	
	public void setCState(calibrationState state) {
		this.calibrationState = state;
	}
	
	public calibrationState getNext() {
		return calibrationState.getNext();
	}
	
	public String getDescription() {
		return calibrationState.getDescription();
	}
	
	public boolean getPollState() {
		return calibrationState.getPollState();
	}
	
	public boolean getLRAllow() {
		return calibrationState.getLRAllow();
	}
	
}

