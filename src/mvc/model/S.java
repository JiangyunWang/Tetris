package mvc.model;

import java.awt.*;

public class S extends AShape{
    public S(Color color) {
        super(ShapeType.S, color);
        initCenter();
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
      	 int[][] currLook = new int[4][2];
   	    int rotation = this.getRotation();

   		/*    1 1
		 *  1 0
		 */
		if(rotation == 0 || rotation == 2) {
			currLook[0][0] = -1;
			currLook[0][1] = 0;
			currLook[1][0] = -1;
			currLook[1][1] = 1;
			
			currLook[2][0] = 0;
			currLook[2][1] = -1;
			//center
			currLook[3][0] = 0;
			currLook[3][1] = 0;
		}
		/*
		 * 	1
		 *  1 0
		 *    1
		 */
		else if(rotation == 1 || rotation == 3){
			currLook[0][0] = -1;
			currLook[0][1] = -1;
			//center
			currLook[1][0] = 0;
			currLook[1][1] = -1;
			
			currLook[2][0] = 0;
			currLook[2][1] = 0;
			
			currLook[3][0] = 1;
			currLook[3][1] = 0;
		} 
		/*
		 * 	   0 1
		 * 	 1 1
		 */
		/*else if(rotation == 2) {
			//center
			currLook[0][0] = 0;
			currLook[0][1] = 0;
			
			currLook[1][0] = 0;
			currLook[1][1] = 1;
			
			currLook[2][0] = 1;
			currLook[2][1] = -1;
			
			currLook[3][0] = 1;
			currLook[3][1] = 0;
		}
		/*
		 *   1
		 *   1 0
		 *     1
		 
		else { //rotation == 3
			currLook[0][0] = -1;
			currLook[0][1] = -1;
			
			currLook[1][0] = 0;
			currLook[1][1] = -1;
			//center
			currLook[2][0] = 0;
			currLook[2][1] = 0;
			
			currLook[3][0] = 1;
			currLook[3][1] = 0;
		}*/
   		return currLook;
       }
}
