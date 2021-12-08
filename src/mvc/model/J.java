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
    	// this is the relative position of currShape
	    int[][] currLook = new int[4][2];
	    int rotation = this.getRotation();
	    int[] center = this.getCenter();
		int x = 2;
		int y = 1;
	    /*
		 * 	 1
		 * 	 1
		 * 1 0
		 */
		if(rotation == 0) {
			currLook[x][y] = 1;
			currLook[x][y-1] = 1;
			currLook[x-1][y] = 1;
			currLook[x-2][y] = 1;
		}
		/*
		 * 1
		 * 0 1 1 
		 */
		else if (rotation == 1) {
			currLook[x][y] = 1;
			currLook[x-1][y] = 1;
			currLook[x][y +1] = 1;
			currLook[x][y+2] = 1;
			
		}
		/*
		 * 0 1
		 * 1
		 * 1
		 */
		else if (rotation == 2) {
			currLook[x][y] = 1;
			currLook[x][y+1] = 1;
			currLook[x+1][y] = 1;
			currLook[x+2][y] =1;
		}
		
		
		/*
		 * 1 1 0 
		 * 	   1
		 */
		else {
			currLook[x][y] = 1;
			currLook[x][y-1] = 1;
			currLook[x][y-2] = 1;
			currLook[x+1][y] =1;
		}
		return currLook;
    }
    
}
