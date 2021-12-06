package mvc.model;

import java.awt.Graphics;
import javax.swing.SwingUtilities;

public class LeftPanelModel {
	private static final int size = 25;
	private static int xunit = 12;
	private static int yunit = 24;
	private static int xmax = size * 12;
	private static int ymax = size * 24;
	Boolean gameOver;
	private IShape block;
	private static int[][] map;
	
	
	public LeftPanelModel (IShape block){
		map = new int[xunit][yunit];
		/* for(int i = 0; i < xunit; ++i) {
			 for (int j = 0; j < yunit; ++j) {
				 map[i][j] = 0;
			 }
		 }*/
		gameOver = false;
		this.block = block;
	 }
	
	// need to check gameover
	
	public void earseLine() { // i = row, j = column 
		boolean isFull = true;
		int[][] temp = new int[xunit][yunit];
		int cnt = xunit -1;
		for(int i = xunit-1; i >=0; --i) {
			for(int j = 0; j < yunit; ++j) {
				if(map[i][j] == 0) {
					temp[cnt] = map[i];
					cnt--;
				}
			}
		
		}
		map = temp;
		
	}
	
	public void drawBlock() {
		int[] center = block.getCenter();
		int rotation = block.getRotation();
		ShapeType type = block.getType();
		int x = center[0];
		int y = center[y];
		switch (type){
		case L:
			/* 
			 *  1
			 *  1
			 *  0 1
			 */
			if(rotation == 0) {  
				map[x][y] = 1;
				map[x-1][y]= 1;
				map[x-2][y] = 1;
				map[x][y+1] = 1;
			}
			/*
			 * 0 1 1
			 * 1
			 */
			else if (rotation == 1) {
				map[x][y] = 1;
				map[x][y+1] = 1;
				map[x][y+2] = 1;
				map[x+1][y] = 1;
			}
			/*
			 * 1 0
			 *   1
			 *   1
			 */
			else if (rotation == 2) {
				map[x][y] = 1;
				map[x+1][y] = 1;
				map[x+2][y] = 1;
				map[x][y-1] = 1;
			}
			/*
			 * 	   1
			 * 1 1 0
			 */
			else {
				map[x][y] = 1;
				map[x-1][y] = 1;
				map[x][y-1] = 1;
				map[x][y-2] =1;
			}
			break;
			
		case J:
			/*
			 * 	 1
			 * 	 1
			 * 1 0
			 */
			if(rotation == 0) {
				map[x][y] = 1;
				map[x][y-1] = 1;
				map[x-1][y] = 1;
				map[x-2][y] = 1;
			}
			/*
			 * 1
			 * 0 1 1 
			 */
			else if (rotation == 1) {
				map[x][y] = 1;
				map[x-1][y] = 1;
				map[x][y +1] = 1;
				map[x][y+2] = 1;
				
			}
			/*
			 * 0 1
			 * 1
			 * 1
			 */
			else if (rotation == 2) {
				map[x][y] = 1;
				map[x][y+1] = 1;
				map[x+1][y] = 1;
				map[x+2][y] =1;
			}
			
			
			/*
			 * 1 1 0 
			 * 	   1
			 */
			else {
				map[x][y] = 1;
				map[x][y-1] = 1;
				map[x][y-2] = 1;
				map[x+1][y] =1;
			}
			break;
		case LINE:
			/*
			 * 11011
			 */
			if(rotation == 0) {
				map[x][y] = 1;
				map[x][y-1] =1;
				map[x][y-2] = 1;
				map[x][y+1] = 1;
				map[x][y+2] = 1;
			}
			/*
			 * 1
			 * 1
			 * 0
			 * 1
			 * 1
			 */
			else if (rotation == 1) {
				map[x][y] = 1;
				map[x-1][y] =1;
				map[x-2][y] =1;
				map[x+1][y] = 1;
				map[x+2][y] = 1;
			}
			else if (rotation == 2) {
				map[x][y] = 1;
				map[x][y-1] =1;
				map[x][y-2] = 1;
				map[x][y+1] = 1;
				map[x][y+2] = 1;

			}
			else {
				map[x][y] = 1;
				map[x-1][y] =1;
				map[x-2][y] =1;
				map[x+1][y] = 1;
				map[x+2][y] = 1;
			}
			break;
		case S:
			/*    1 1
			 *  1 0
			 */
			if(rotation == 0) {
				map[x][y] = 1;
				map[x][y-1] =1;
				map[x-1][y] = 1;
				map[x-1][y+1] = 1;
			}
			/*
			 * 	1
			 *  0 1
			 *    1
			 */
			else if (rotation == 1) {
				
			}
			else if (rotation == 2) {
				
			}
			else {
				
			}
			break;
		case T:
			if(rotation == 0) {
				
			}
			else if (rotation == 1) {
				
			}
			else if (rotation == 2) {
				
			}
			else {
				
			}
			break;
		case Z:
			/*
			 * 11
			 *  01
			 */
			if(rotation == 0) {
				
			}
			else if (rotation == 1) {
				
			}
			else if (rotation == 2) {
				
			}
			else {
				
			}
			break;
		case SQUARE:
			if(rotation == 0) {
			
			}
			else if (rotation == 1) {
				
			}
			else if (rotation == 2) {
				
			}
			else {
				
			}
			break;
	
		}
		
	}
	/*public checkBlockPosition() {
		
	}*/
	public void setBlock(IShape block) {
		this.block = block;
	}
	public IShape getBlock() {
		return block;
	}
	public void updateMap() {
		
	}
	
}