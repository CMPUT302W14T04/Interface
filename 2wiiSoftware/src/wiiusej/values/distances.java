package wiiusej.values;

public class distances {

	//Measure using Inches
	//value output[x][0] is always the measurement away from the map, to the tip of the wiimote
	//value output[x][1] is always the value along the edge, to the midpoint of the wiimotes tip
	//Assume that the remotes are perpendicular, with the filter facing the map
	@SuppressWarnings("null")
	public float[][] calculateDistance(float height, float width, int numWii) {
		
		float[][] output = null;		
		if(numWii == 2){
			
			output[0][0] = (float) ((height * 1.5) + 1);
			output[0][1] = height/2;
			
			output[1][0] = (float) ((width * 1.5) + 1);
			output[1][1] = width/2;
			
		} else if(numWii == 4){
			
			output[0][0] = (float) ((height * 1.5) + 1);
			output[1][0] = (float) ((height * 1.5) + 1);
			
			output[0][1] = height/4;
			output[1][1] = 3*height/4;
			
			output[2][0] = (float) ((width * 1.5) + 1);
			output[3][0] = (float) ((width * 1.5) + 1);
			
			output[2][1] = width/4;
			output[3][1] = 3*width/4;
			
		}
		return output;
	
	}
}