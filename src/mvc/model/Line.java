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
   	 int[][] currLook = null;
   	 int rotation = this.getRotation();
	    int[] center = this.getCenter();
		int x = center[0];
		int y = center[1];
		
		
		/*
		 * 11011
		 */
		if(rotation == 0 || rotation == 2) {
			currLook = new int[1][5];
			currLook[x][y] = 1;
			currLook[x][y-1] =1;
			currLook[x][y-2] = 1;
			currLook[x][y+1] = 1;
			currLook[x][y+2] = 1;
		}
		/*
		 * 1
		 * 1
		 * 0
		 * 1
		 * 1
		 */
		else { //if (rotation == 1 || rotation == 3) 
			currLook = new int[5][1];
			currLook[x][y] = 1;
			currLook[x-1][y] =1;
			currLook[x-2][y] =1;
			currLook[x+1][y] = 1;
			currLook[x+2][y] = 1;
		}
		
		
		return currLook;
    }
}
