package mvc.model;

import java.awt.*;

public class S extends AShape{
    public S(Color color, int[] pos, int rotate) {
        super(ShapeType.S, color, pos, rotate);
    }
    public S() {
        super(ShapeType.S);
        initCenter();
    }
    @Override
    public void initCenter() {
        /*        11
                 10

 */
        int[] temp = new int[2];
        temp[0] = 1;
        temp[1] = 1;
        this.center = temp;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.S;
    }
    
    public int[][] currLook(){
      	 int[][] currLook = null;
   	    int rotation = this.getRotation();
   	    int[] center = this.getCenter();
   		int x = center[0];
   		int y = center[1];
   		
   		
   		/*    1 1
		 *  1 0
		 */
		if(rotation == 0) {
			currLook = new int[2][3];
			currLook[x][y] = 1;
			currLook[x][y-1] =1;
			currLook[x-1][y] = 1;
			currLook[x-1][y+1] = 1;
		}
		/*
		 * 	1
		 *  0 1
		 *    1
		 */
		else if(rotation == 1){
			currLook = new int [3][2];
			currLook[x][y] = 1;
			currLook[x-1][y] = 1;
			currLook[x][y+1] = 1;
			currLook[x-1][y+1] = 1;
		} 
		/*
		 * 	   0 1
		 * 	 1 1
		 */
		else if(rotation == 2) {
			currLook = new int [2][3];
			currLook[x][y] = 1;
			currLook[x+1][y] = 1;
			currLook[x][y+1] = 1;
			currLook[x+1][y-1] = 1;
		}
		/*
		 *   1
		 *   1 0
		 *     1
		 */
		else { //rotation == 3
			currLook = new int [3][2];
			currLook[x][y] = 1;
			currLook[x-1][y] = 1;
			currLook[x][y-1] = 1;
			currLook[x-1][y-1] = 1;
		}
   		return currLook;
       }
}
