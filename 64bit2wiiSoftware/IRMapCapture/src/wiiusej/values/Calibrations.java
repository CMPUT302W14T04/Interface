package wiiusej.values;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.event.EventListenerList;

import wiiusej.WiiUseApi;
import wiiusej.WiiUseApiManager;
import wiiusej.Wiimote;
import wiiusej.test.WiiuseJGuiTest;
import wiiusej.wiiusejevents.utils.EventsGatherer;
import wiiusej.wiiusejevents.utils.WiiUseApiListener;
import wiiusej.wiiusejevents.wiiuseapievents.WiiUseApiEvent;

public class Calibrations {
	
	private static Calibrations instanceCal = new Calibrations();
	
	private WiiUseApi wiiuse = WiiUseApi.getInstance();
	private final EventListenerList listeners = new EventListenerList();
	private AtomicBoolean running = new AtomicBoolean(false);
	
	private float[] ul = new float[]{-1, 1024};
	private float[] ur = new float[]{-1, -1};
	private float[] ll = new float[]{1024, 1024};
	private float[] lr = new float[]{1024, -1};
	
	boolean useOffset = false;
	
	private static int X1;
	private static int X2;
	private static int Y1;
	private static int Y2;
	
	private int defaultFloor;
	
	private static int flip = 1;
	public boolean leftSide = true;
	
	
	public int[][] eventFilter(int numWii){
		int[][] coords = new int[numWii][2];
		
		boolean stepSwitch = false;
		if (stepSwitch == false && numWii > 0) {
			running.set(true);
			EventsGatherer gather = new EventsGatherer(numWii);

			// Start polling and tell the observers when there are Wiimote
			// events
			while (stepSwitch == false && numWii > 0) {
				setCurrentArea(-1,-1,1);
				setCurrentArea(-1,-1,2);
				/* Polling */
				wiiuse.specialPoll(gather);

				/* deal with events gathered in Wiiuse API */
				for (WiiUseApiEvent evt : gather.getEvents()) {
					if (evt.getWiimoteId() != -1) {// event filled
						// there is an event notify observers
						notifyWiiUseApiListener(evt);
						stepSwitch = true;
					} else {
						System.out
								.println("There is an event with id == -1 ??? there is a problem !!! : "
										+ evt);
					}
				}
				if(getX1() == -1 || getX2() == -1){
					stepSwitch = false;					
				}
				if(getX1() == 1023 || getX2() == 1023){
					stepSwitch = false;					
				}
				gather.clearEvents();
			}
		}
		
		coords[0][0] = getX1();
		coords[0][1] = getY1();
		coords[1][0] = getX2();
		coords[1][1] = getY1();
		return coords;		
	}
	
	/**
	 * Notify WiiUseApiListeners that an event occured.
	 * 
	 * @param evt
	 *            GenericEvent occured
	 */
	private void notifyWiiUseApiListener(WiiUseApiEvent evt) {
		for (WiiUseApiListener listener : getWiiUseApiListeners()) {
			listener.onWiiUseApiEvent(evt);
		}
	}
	
	/**
	 * Get the list of WiiUseApiListeners.
	 * 
	 * @return the list of WiiUseApiListeners.
	 */
	protected WiiUseApiListener[] getWiiUseApiListeners() {
		return listeners.getListeners(WiiUseApiListener.class);
	}
	
	public static int getX1() {
		return X1;
	}

	public static int getX2() {
		return X2;
	}

	public static int getY1() {
		return Y1;
	}

	public static int getY2() {
		return Y2;
	}
	
	public static void setCurrentArea(int x, int y, int id) {
		if(id == 1){
			X1 = x;
			Y1 = y;
		}
		else if(id == 2){
			X2 = x;
			Y2 = y;
		}
		
	}

	public int getDefaultFloor() {
		return defaultFloor;
	}

	public void setDefaultFloor(int defaultFloor) {
		this.defaultFloor = defaultFloor;
	}
	
public void spatializeWiiMotes2x(int x1, int x2, Wiimote wiimote, Wiimote wiimote2){		
		
		
		if(x1 < x2){	
			wiimote.setLeds(true, false, false, false);	
			wiimote2.setLeds(true, true, false, false);	
			flip = 2;
			
		} else if(x1 > x2) {			
			wiimote.setLeds(true, true, false, false);
			wiimote2.setLeds(true, false, false, false);
     		wiimote.setId(2);			
			wiimote2.setId(1);
			flip = 1;
		}
		
	}

public int[] calculateOffsets(int x, int y){
	int[] flipped = flipFunction(x,y);
	int[] sideAdjust = sideFunction(flipped[0],flipped[1]);
	if(useOffset == true){
		return offSetFunction(sideAdjust[0], sideAdjust[1]);
	} else {
		return sideAdjust;
	}
	
}
public int[] flipFunction(int x, int y){
	if(flip == 2){
		int t = x;
		x = y;
		y = t;
	} else {}
	
	int[] out = new int[2];
	out[0] = x;
	out[1] = y;
	return out;
}

public int[] sideFunction(int x, int y){
	if(leftSide == false){
		int t = x;
		x = y;
		y = 1023 - t;
		
	}
	int[] out = new int[2];
	out[0] = x;
	out[1] = y;
	return out;
	
}

public int[] offSetFunction(int x, int y){
//	x = 512;
//	float lower = ((x - (lr[0] - 512))/((ll[0] - 512) - (lr[0] - 512))) * ((ll[1] - 512) - (lr[1] - 512)); 
//	float upper = ((x - (512 - ur[0]))/((512 - ul[0]) - (512 - ur[0]))) * ((512 - ul[1]) - (512 - ur[1]));
//    float left = x;
//	float right = x;
//	if(x > 512){
//		x = (int) right;
//	} else {
//		x = (int) left;
//	}
//	if(y > 512){
//		y = (int) lower;
//	} else {
//		y = (int) upper;
//	}
	int[] out = new int[2];
//	out[0] = x;
//	out[1] = y;
//	System.out.print(x + "," + y + "\n");
	return out;
	
}

public int[][] getCalibPoints(javax.swing.JButton state) {
	int[][] coords;
	coords = eventFilter(2);
	state.setEnabled(true);
	state.setText("Capture");
	return coords;
}

public void generateBoundaries(int[][] calibMatrix) {
	
	for(int i = 0; i < 8; i++){
		if(calibMatrix[i][0] > ul[0] && calibMatrix[i][1] < ul[1]){
			ul[0] = calibMatrix[i][0];
			ul[1] = calibMatrix[i][1];
		}
		if(calibMatrix[i][0] > ur[0] && calibMatrix[i][1] > ur[1]){
			ur[0] = calibMatrix[i][0];
			ur[1] = calibMatrix[i][1];
		}
		if(calibMatrix[i][0] < ll[0] && calibMatrix[i][1] < ll[1]){
			ll[0] = calibMatrix[i][0];
			ll[1] = calibMatrix[i][1];
		}
		if(calibMatrix[i][0] < lr[0] && calibMatrix[i][1] > lr[1]){
			lr[0] = calibMatrix[i][0];
			lr[1] = calibMatrix[i][1];
		}
	}
	System.out.print("UL " + ul[0] +"," + ul[1] + "\n");
	System.out.print("UR " + ur[0] +"," + ur[1] + "\n");
	System.out.print("LL " + ll[0] +"," + ll[1] + "\n");
	System.out.print("LR " + lr[0] +"," + lr[1] + "\n");
	useOffset = true;
}

	

}
