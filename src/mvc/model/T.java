package mvc.model;

import java.awt.*;

public class T extends AShape{
    public T(Color color, int[] pos, int rotate) {
        super(ShapeType.T, color, pos, rotate);
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
    
    public int[][] drawShape(){
      	 int[][] currLook = new int[3][2];
   	    int rotation = this.getRotation();
   	    int[] center = this.getCenter();
   		int x = center[0];
   		int y = center[1];
   		
   		/*
   		 *  1 0 1
   		 *    1
   		 */
   		if(rotation == 0) {
   			currLook[x][y] = 1; 
			currLook[x][y-1] = 1; 
			currLook[x][y+1] = 1; 
			currLook[x+1][y] = 1; 
		}
   		/*
   		 *    1
   		 *  1 0
   		 *    1
   		 */
		else if (rotation == 1) {
			currLook[x][y] = 1; 
			currLook[x][y-1] = 1; 
			currLook[x+1][y] = 1; 
			currLook[x-1][y] = 1; 
		}
   		/* 
   		 *    1
   		 *  1 0 1
   		 */
		else if (rotation == 2) {
			currLook[x][y] = 1; 
			currLook[x-1][y] = 1; 
			currLook[x][y-1] = 1; 
			currLook[x][y+1] = 1; 
		}
   		
   		/*
   		 *   1
   		 *   0 1
   		 *   1
   		 */
		else {
			currLook[x][y] = 1; 
			currLook[x-1][y] = 1; 
			currLook[x+1][y] = 1; 
			currLook[x][y+1] = 1; 
		}
   		return currLook;
       }
    
    
}
