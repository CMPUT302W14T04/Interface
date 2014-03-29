package wiiusej.values;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.event.EventListenerList;

import wiiusej.WiiUseApi;
import wiiusej.WiiUseApiManager;
import wiiusej.Wiimote;
import wiiusej.test.WiiuseJGuiTest;
import wiiusej.utils.IRCombined;
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
	private float[] center = new float[2];
	
	boolean useOffset = false;
	public float minX;
	public float minY;
	public float offX;
	public float offY;
	private static int X1;
	private static int X2;
	private static int Y1;
	private static int Y2;
	
	public float XCF = 1;
	public float YCF = 1;
	
	private int defaultFloor;
	
	private static int flip = 1;
	public boolean leftSide = true;
	
	public float width = 8.5f;
	public float height = 5.5f;
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
		int[] offAdjust = offSetFunction(sideAdjust[0], sideAdjust[1]);
		
		return stretchFunction(offAdjust[0], offAdjust[1]);
		
	} else {
		return sideAdjust;
	}
	
}

public int[] stretchFunction(int x, int y){
	int oldX = x;
	int oldY = y;
	x = (int) (x - offX);
	y = (int) (y - offY);
	
	int[] out = new int[2];
	out[0] = x;
	out[1] = y;
	return out;
	
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
	int oldX = x;
	int oldY = y;
	float[] ulF = new float[2];
	float[] urF = new float[2];
	float[] llF = new float[2];
	float[] lrF = new float[2];
	
	float shiftX = 0;
	float shiftY = 0;
			
	ulF[0] = ul[0] - ul[0];
	ulF[1] = ul[1] - ul[1];

	llF[0] = ll[0] - ll[0];
	llF[1] = ll[1] - ul[1];

	urF[0] = ur[0] - ul[0];
	urF[1] = ur[1] - ur[1];

	lrF[0] = lr[0] - ll[0];
	lrF[1] = lr[1] - ur[1];
	
	if(y > 511){
		//Top
		float myX = oldX - ul[0]; 
		
		shiftY = (myX / urF[0]); 
		if (shiftY > 1){
			shiftY = 1;
		}
		if (shiftY < 0){
			shiftY = 0;
		}
		//y = (int) (y + (Math.abs(ul[1] - ur[1])) * shiftY) ;
		y = (int) (oldY +  (ur[1] - 512) / (ul[1] - 512) * shiftY * (oldY - 512) / YCF  );       //(Math.abs(ul[1] - ur[1]))    );
	} else {
		//Bottom
		float myX = oldX - ll[0];
		shiftY = (myX / lrF[0]);
		if (shiftY > 1){
			shiftY = 1;
		}
		if (shiftY < 0){
			shiftY = 0;
		}
		//y = (int) (y - (Math.abs(ll[1] - lr[1])) * shiftY) ;
		y = (int) (oldY -  (512 - lr[1]) / (512 - ll[1]) * shiftY * (512 - oldY) / YCF  );// (Math.abs(ll[1] - lr[1])));
	}
	
	if(x > 511){
		//Right
		float myY = (1024 - oldY) - ul[1]; 
		shiftX = (myY / llF[1]);
		if (shiftX > 1){
			shiftX = 1;
		}
		if (shiftX < 0){
			shiftX = 0;
		}
		//x = (int) (x + (Math.abs(ul[0] - ll[0])) * shiftX);
		x = (int) (oldX + (ll[0] + 512) / (ul[0] + 512) * shiftX * (oldX - 512) / XCF   ); //(Math.abs(ul[0] - ll[0])));
	} else {
		//Left
		float myY = (1024 - oldY) - ur[1];
		shiftX = (myY / lrF[1]);
		if (shiftX > 1){
			shiftX = 1;
		}
		if (shiftX < 0){
			shiftX = 0;
		}
		//x = (int) (x - (Math.abs(ur[0] - lr[0])) * shiftX);
		x = (int) (oldX - (512 - lr[0]) / (512 - ur[0]) * shiftX * (512 - oldX) / XCF  ); //(Math.abs(ur[0] - lr[0])));
	}
	
	
	int[] out = new int[2];
	out[0] = x;
	out[1] = y;
	
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
	
	if(leftSide == true){
		lr[0] = calibMatrix[0][0];
		lr[1] = 1024 - calibMatrix[0][1];
		ll[0] = calibMatrix[1][0];
		ll[1] = 1024 - calibMatrix[1][1];
		ul[0] = calibMatrix[2][0];
		ul[1] = 1024 - calibMatrix[2][1];
		ur[0] = calibMatrix[3][0];
		ur[1] = 1024 - calibMatrix[3][1];
		//center[0] = calibMatrix[4][0];
		//center[1] = 1024 - calibMatrix[4][1];
	} else { 
		lr[0] = 1024 - calibMatrix[0][0];
		lr[1] = 1024 - calibMatrix[0][1];
		ll[0] = 1024 - calibMatrix[1][0];
		ll[1] = 1024 - calibMatrix[1][1];
		ul[0] = 1024 - calibMatrix[2][0];
		ul[1] = 1024 - calibMatrix[2][1];
		ur[0] = 1024 - calibMatrix[3][0];
		ur[1] = 1024 - calibMatrix[3][1];
		//center[0] = 1024 - calibMatrix[4][0];
		//center[1] = 1024 - calibMatrix[4][1];
	}
	
	System.out.print("UL " + ul[0] +"," + ul[1] + "\n");
	System.out.print("UR " + ur[0] +"," + ur[1] + "\n");
	System.out.print("LL " + ll[0] +"," + ll[1] + "\n");
	System.out.print("LR " + lr[0] +"," + lr[1] + "\n");
	useOffset = true;
}

public void setF(float w, float h) {
	if(w > h){
		XCF =  1;
	} else if (h > w){
		YCF =  1;
	}
	
}

public void calculateShift(int[][] offSet) {
	
	
	if(offSet[1][0] < offSet[2][0]){
		minX = offSet[1][0];
	} else {
		minX = offSet[2][0];
	}
	if(offSet[1][1] < offSet[0][1]){
		minY = offSet[1][1];
	} else {
		minY = offSet[0][1];
	}
	
	
	
}

public int[][] getOffsets(){
	int[][] offSet = new int[4][2];
	int[] offSet3 = calculateOffsets((int) ul[0],(int) ul[1]);
	int[] offSet4 = calculateOffsets((int) ur[0],(int) ur[1]);
	int[] offSet1 = calculateOffsets((int) lr[0],(int) lr[1]);
	int[] offSet2 = calculateOffsets((int) ll[0],(int) ll[1]);
	offSet[0] = offSet1;
	offSet[1] = offSet2;
	offSet[2] = offSet3;
	offSet[3] = offSet4;
	return offSet;
}

	

}
