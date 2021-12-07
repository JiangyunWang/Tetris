package mvc.model;

import java.awt.*;

public class L extends AShape{
    public L(Color color, int[] pos, int rotate) {
        super(ShapeType.L, color, pos, rotate);
    }
    public L() {
        super(ShapeType.L);
        initCenter();
    }

    @Override
    public void initCenter() {
        /*        1
                  1
                  0 1

 */
        int[] temp = new int[2];
        temp[0] = 2;
        temp[1] = 0;
        this.center = temp;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.L;
    }
    
    public int[][] currLook(){
    	 int[][] currLook = new int[3][2];
 	    int rotation = this.getRotation();
 	    int[] center = this.getCenter();
 		int x = 2;
 		int y = 0;
    	/* 
		 *  1
		 *  1
		 *  0 1
		 */
		if(rotation == 0) {  
			currLook[x][y] = 1;
			currLook[x-1][y]= 1;
			currLook[x-2][y] = 1;
			currLook[x][y+1] = 1;
		}
		/*
		 * 0 1 1
		 * 1
		 */
		else if (rotation == 1) {
			currLook[x][y] = 1;
			currLook[x][y+1] = 1;
			currLook[x][y+2] = 1;
			currLook[x+1][y] = 1;
		}
		/*
		 * 1 0
		 *   1
		 *   1
		 */
		else if (rotation == 2) {
			currLook[x][y] = 1;
			currLook[x+1][y] = 1;
			currLook[x+2][y] = 1;
			currLook[x][y-1] = 1;
		}
		/*
		 * 	   1
		 * 1 1 0
		 */
		else {
			currLook[x][y] = 1;
			currLook[x-1][y] = 1;
			currLook[x][y-1] = 1;
			currLook[x][y-2] =1;
		}
		return currLook;
    }
}
