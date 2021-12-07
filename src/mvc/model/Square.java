package mvc.model;

import java.awt.*;

public class Square extends AShape{
    public Square(Color color, int[] pos, int rotate) {
        super(ShapeType.SQUARE, color, pos, rotate);
    }
    public Square() {
        super(ShapeType.SQUARE);
        initCenter();
    }
    @Override
    public void initCenter() {
        /*01
          11

 */
        int[] temp = new int[2];
        temp[0] = 0;
        temp[1] = 0;
        this.center = temp;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.SQUARE;
    }
    public int[][] currLook(){
      	 int[][] currLook = new int[2][2];
   	    int rotation = this.getRotation();
   	    int[] center = this.getCenter();
   		int x = 0;
   		int y = 0;
   		
   		/*
   		 * 0 1
   		 * 1 1
   		 */
   		if(rotation == 0) {
			currLook[x][y] = 1; 
			currLook[x+1][y] = 1; 
			currLook[x+1][y] = 1; 
			currLook[x+1][y+1] = 1; 
		}
   		/*
   		 * 1 0
   		 * 1 1
   		 */
		else if (rotation == 1) {
			currLook[x][y] = 1; 
			currLook[x][y-1] = 1; 
			currLook[x+1][y+1] = 1; 
			currLook[x+1][y] = 1; 
		}
   		/* 
   		 * 1 1 
   		 * 1 0
   		 */
		else if (rotation == 2) {
			currLook[x][y] = 1; 
			currLook[x-1][y] = 1; 
			currLook[x-1][y-1] = 1; 
			currLook[x][y-1] = 1; 
		}
   		/*
   		 * 1 1
   		 * 0 1
   		 */
		else {
			currLook[x][y] = 1; 
			currLook[x][y+1] = 1; 
			currLook[x-1][y] = 1; 
			currLook[x-1][y] = 1; 
		}
   		return currLook;
       }
}
