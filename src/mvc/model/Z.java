package mvc.model;

import java.awt.*;

public class Z extends AShape{
    public Z(Color color) {
        super(ShapeType.Z, color);
        initCenter();
    }
    public Z() {
        super(ShapeType.Z);
        initCenter();
    }
    @Override
    public void initCenter() {
        /*       11
                  01

 */
        int[] temp = new int[2];
        temp[0] = 1;
        temp[1] = 1;
        this.center = temp;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.Z;
    }
    
    
    public int[][] currLook(){
      	 int[][] currLook = new int[4][2];
   	    int rotation = this.getRotation();
   	  
   		
   		/*
   		 * 1 1 
   		 *   0 1
   		 */
   		if(rotation == 0 || rotation == 2) {
   			currLook[0][0] = -1;
			currLook[0][1] = -1;
			
			currLook[1][0] = -1;
			currLook[1][1] = 0;
			
			currLook[2][0] = 0;
			currLook[2][1] = 0;
			
			currLook[3][0] = 0;
			currLook[3][1] = 1;
		}
   		/*
   		 *    1
   		 *  0 1
   		 *  1
   		 */
		else if (rotation == 1 || rotation == 3) {
			currLook[0][0] = -1;
			currLook[0][1] = 1;
			
			currLook[1][0] = 0;
			currLook[1][1] = 0;
			
			currLook[2][0] = 0;
			currLook[2][1] = 1;
			
			currLook[3][0] = 1;
			currLook[3][1] = 0;
		}
   		/*
   		 *  1 0
   		 *    1 1
   		 */
		/* else if (rotation == 2) {
			currLook[0][0] = 0;
			currLook[0][1] = -1;
			
			currLook[1][0] = 0;
			currLook[1][1] = 0;
			
			currLook[2][0] = 1;
			currLook[2][1] = 0;
			
			currLook[3][0] = 1;
			currLook[3][1] = 1; 
		}
   		/*
   		 *    1
   		 *  1 0
   		 *  1
   		 
		else {
			currLook[0][0] = -1;
			currLook[0][1] = 0;
			
			currLook[1][0] = 0;
			currLook[1][1] = -1;
			
			currLook[2][0] = 0;
			currLook[2][1] = 0;
			
			currLook[3][0] = 1;
			currLook[3][1] = -1;
		}*/
   		return currLook;
       }
}
