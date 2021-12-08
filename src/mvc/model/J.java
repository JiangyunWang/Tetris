package mvc.model;

import java.awt.*;

public class J extends AShape{
    public J(Color color, int[] pos, int rotate) {
        super(ShapeType.J, color, pos, rotate);
    }
    public J() {
        super(ShapeType.J);
        initCenter();
    }

    @Override
    public void initCenter() {
/*        1
          1
         10

 */
        int[] temp = new int[2];
            temp[0] = 2;
            temp[1] = 1;
        this.center = temp;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.J;
    }

    public int[][] currLook(){
    	/* this is the relative position of currShape, cneter is 0,0, and 0 is X 1 is Y
    	for currlook: first array is the size of points that current block has
    	the position are set from left to right, up to down
    	*/
	    int[][] currLook = new int[4][2];
	    int rotation = this.getRotation();
	    int[] center = this.getCenter();
	    /*
		 * 	 1
		 * 	 1
		 * 1 0
		 */
		if(rotation == 0) {
			currLook[0][0] = -2;
			currLook[0][1] = 0;
			currLook[1][0] = -1;
			currLook[1][1] = 0;
			currLook[2][0] = 0;
			currLook[2][1] = -1;
			//center
			currLook[3][0] = 0;
			currLook[3][1] = 0;
		}
		/*
		 * 1
		 * 0 1 1 
		 */
		else if (rotation == 1) {
			currLook[0][0] = -1;
			currLook[0][1] = 0;
			//center
			currLook[1][0] = 0;
			currLook[1][1] = 0;
			
			currLook[2][0] = 0;
			currLook[2][1] = 1;
			currLook[3][0] = 0;
			currLook[3][1] = 2;
			
		}
		/*
		 * 0 1
		 * 1
		 * 1
		 */
		else if (rotation == 2) {
			//center
			currLook[0][0] = 0;
			currLook[0][1] = 0;
			
			currLook[1][0] = 0;
			currLook[1][1] = 1;
			currLook[2][0] = 1;
			currLook[2][1] = 0;
			currLook[3][0] = 2;
			currLook[3][1] = 0;
		}
		
		
		/*
		 * 1 1 0 
		 * 	   1
		 */
		else {
			currLook[0][0] = 0;
			currLook[0][1] = -2;
			currLook[1][0] = 0;
			currLook[1][1] = -1;
			//center
			currLook[2][0] = 0;
			currLook[2][1] = 0;
			currLook[3][0] = 1;
			currLook[3][1] = 0;
		}
		return currLook;
    }
    
}
