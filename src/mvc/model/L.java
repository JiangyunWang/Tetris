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
 		
    	/* 
		 *  1
		 *  1
		 *  0 1
		 */
		if(rotation == 0) {  
			currLook[0][0] = -2;
			currLook[0][1] = 0;
			currLook[1][0] = -1;
			currLook[1][1] = 0;
			//center
			currLook[2][0] = 0;
			currLook[2][1] = 0;
			currLook[3][0] = 0;
			currLook[3][1] = -1;
		}
		/*
		 * 0 1 1
		 * 1
		 */
		else if (rotation == 1) {
			//center
			currLook[0][0] = 0;
			currLook[0][1] = 0;
			
			currLook[1][0] = 0;
			currLook[1][1] = 1;
			currLook[2][0] = 0;
			currLook[2][1] = 2;
			currLook[3][0] = 1;
			currLook[3][1] = 0;
		}
		/*
		 * 1 0
		 *   1
		 *   1
		 */
		else if (rotation == 2) {
			currLook[0][0] = 0;
			currLook[0][1] = -1;
			//center
			currLook[1][0] = 0;
			currLook[1][1] = 0;
			currLook[2][0] = 1;
			currLook[2][1] = 0;
			currLook[3][0] = 2;
			currLook[3][1] = 0;
		}
		/*
		 * 	   1
		 * 1 1 0
		 */
		else {
			currLook[0][0] = -1;
			currLook[0][1] = 0;
			currLook[1][0] = 0;
			currLook[1][1] = -2;
			currLook[2][0] = 0;
			currLook[2][1] = -1;
			//center
			currLook[3][0] = 0;
			currLook[3][1] = 0;
		}
		return currLook;
    }
    
    
}
