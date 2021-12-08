package mvc.model;

import java.awt.*;

public class Line extends AShape{
    public Line(Color color, int[] pos, int rotate) {
        super(ShapeType.LINE, color, pos, rotate);
    }
    public Line() {
        super(ShapeType.LINE);
        initCenter();
    }
    @Override
    public void initCenter() {
        /*         11011


 */
        int[] temp = new int[2];
        temp[0] = 0;
        temp[1] = 2;
        this.center = temp;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.LINE;
    }
    
    public int[][] currLook(){
   	 int[][] currLook = new int[5][2];
   	 int rotation = this.getRotation();
	    int[] center = this.getCenter();
		
		/*
		 * 11011
		 */
		if(rotation == 0 || rotation == 2) {
			currLook[0][0] = 0;
			currLook[0][1] = -2;
			currLook[1][0] = 0;
			currLook[1][1] = -1;
			//center
			currLook[2][0] = 0;
			currLook[2][1] = 0;
			currLook[3][0] = 0;
			currLook[3][1] = 1;
			currLook[4][0] = 0;
			currLook[4][1] = 2;
		}
		/*
		 * 1
		 * 1
		 * 0
		 * 1
		 * 1
		 */
		else { //if (rotation == 1 || rotation == 3) 
			currLook[0][0] = -2;
			currLook[0][1] = 0;
			currLook[1][0] = -1;
			currLook[1][1] = 0;
			//center
			currLook[2][0] = 0;
			currLook[2][1] = 0;
			currLook[3][0] = 1;
			currLook[3][1] = 0;
			currLook[4][0] = 2;
			currLook[4][1] = 0;
		}
		
		
		return currLook;
    }
}
