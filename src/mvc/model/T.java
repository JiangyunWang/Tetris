package mvc.model;

import java.awt.*;

public class T extends AShape{
    public T(Color color, int[] pos, int rotate) {
        super(ShapeType.T, color, rotate);
    }
    public T() {
        super(ShapeType.T);
        initCenter();
    }

    @Override
    public void initCenter() {
        /*   101
              1


 */
        int[] temp = new int[2];
        temp[0] = 0;
        temp[1] = 1;
        this.center = temp;
    }
/*getshape(){
	
}*/
    @Override
    public ShapeType getType() {
        return ShapeType.T;
    }
    
    public int[][] currLook(){
      	 int[][] currLook = new int[4][2];
   	    int rotation = this.getRotation();
   	 
  
   		
   		/*
   		 *  1 0 1
   		 *    1
   		 */
   		if(rotation == 0) {
   			currLook[0][0] = 0;
			currLook[0][1] = -1;
			
			currLook[1][0] = 0;
			currLook[1][1] = 0;
			
			currLook[2][0] = 0;
			currLook[2][1] = 1;
			
			currLook[3][0] = 1;
			currLook[3][1] = 0;
			
		}
   		/*
   		 *    1
   		 *  1 0
   		 *    1
   		 */
		else if (rotation == 1) {
			currLook[0][0] = -1;
			currLook[0][1] = 0;
			
			currLook[1][0] = 0;
			currLook[1][1] = -1;
			
			currLook[2][0] = 0;
			currLook[2][1] = 0;
			
			currLook[3][0] = 1;
			currLook[3][1] = 0;
		}
   		/* 
   		 *    1
   		 *  1 0 1
   		 */
		else if (rotation == 2) {
			currLook[0][0] = -1;
			currLook[0][1] = 0;
			
			currLook[1][0] = 0;
			currLook[1][1] = -1;
			
			currLook[2][0] = 0;
			currLook[2][1] = 0;
			
			currLook[3][0] = 0;
			currLook[3][1] = 1;
		}
   		
   		/*
   		 *   1
   		 *   0 1
   		 *   1
   		 */
		else {
			currLook[0][0] = -1;
			currLook[0][1] = 0;
			
			currLook[1][0] = 0;
			currLook[1][1] = 0;
			
			currLook[2][0] = 0;
			currLook[2][1] = 1;
			
			currLook[3][0] = 1;
			currLook[3][1] = 0;
		}
   		return currLook;
       }
    
    
}
