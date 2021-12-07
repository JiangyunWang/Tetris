package mvc.model;

import java.awt.*;

public class Z extends AShape{
    public Z(Color color, int[] pos, int rotate) {
        super(ShapeType.Z, color, pos, rotate);
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
      	 int[][] currLook = new int[3][2];
   	    int rotation = this.getRotation();
   	    int[] center = this.getCenter();
   		int x = 1;
   		int y = 1;
   		
   		/*
   		 * 1 1 
   		 *   0 1
   		 */
   		if(rotation == 0) {
   			currLook[x][y] = 1; 
			currLook[x][y+1] = 1; 
			currLook[x-1][y] = 1; 
			currLook[x-1][y-1] = 1; 
		}
   		/*
   		 *    1
   		 *  0 1
   		 *  1
   		 */
		else if (rotation == 1) {
			currLook[x][y] = 1; 
			currLook[x][y+1] = 1; 
			currLook[x+1][y] = 1; 
			currLook[x-1][y+1] = 1; 
		}
   		/*
   		 *  1 0
   		 *    1 1
   		 */
		else if (rotation == 2) {
			currLook[x][y] = 1; 
			currLook[x][y-1] = 1; 
			currLook[x-1][y] = 1; 
			currLook[x-1][y+1] = 1; 
		}
   		/*
   		 *    1
   		 *  1 0
   		 *  1
   		 */
		else {
			currLook[x][y] = 1; 
			currLook[x][y-1] = 1; 
			currLook[x+1][y-1] = 1; 
			currLook[x-1][y] = 1; 
		}
   		return currLook;
       }
}
