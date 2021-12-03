package MVC.model;

import java.awt.Graphics;
import javax.swing.SwingUtilities;

public class LeftPanelModel {
	private static final int size = 25;
	private static final int ysize = 0;
	private static int xunit = 12;
	private static int yunit = 24;
	private static int xmax = size * 12;
	private static int ymax = size * 24;
	Boolean gameOver;
	
	private static int[][] MAP;
	// private AShape currBlock;// is it Ashape?? 
	
	public LeftPanelModel (){
		MAP = new int[xmax/size][ysize/size];
		 for(int i = 0; i < xmax/size; ++i) {
			 for (int j = 0; j < ysize/size; ++j) {
				 MAP[i][j] = 0;
			 }
		 }
		gameOver = false;
	 }
	
	public void godown() {
		
	}
	public void moveLeft() {
		int[] center = currBlock.getCenter();
		boolean canMove = false;
		// need to know its current shape!!
		if(currBlock instanceof L) {
			if(center[1] > 0) {
				canMove = true;
			}
		}
		else if (currBlock instanceof S) {
			if(center[1] >1) {
				canMove = true;
			}
		}
		else if(currBlock instanceof Line) {
			//if(center[1] > )
			// we need shape?? 
		}
		else if(currBlock instanceof T) {
			
		}
		else if (currBlock instanceof Square) {
			
		}
		else if (currBlock instanceof Z) {
			
		}
		else if (currBlock instanceof J) {
			
		}
		if(MAP[center[1]-1][center[0]] == 0) {
			currBlock.setPosY(center[1]-1);
		}
		
		
	}
	public void moveRight() {
		int[] center = currBlock.getCenter();
		if(currBlock instanceof L) {
			if(center[1] > 1) {
				if(MAP[center[1]-1][center[0]] == 0) {
					currBlock.setPosY(center[1]-1);
				}
			}
		}
		else if (currBlock instanceof S) {
			
		}
		else if(currBlock instanceof Line) {
			
		}
		else if(currBlock instanceof T) {
			
		}
		else if (currBlock instanceof Square) {
			
		}
		else if (currBlock instanceof Z) {
			
		}
		else if (currBlock instanceof J) {
			
		}
	}
	
	public void earseLine() { // i = row, j = column 
		boolean isFull = true;
		int count = 0;
		for(int i = xunit-1; i >=0; --i) {
			for(int j = yunit-1; j >= 0; --j) {
				if(MAP[i][j] == 0) {
					isFull = false;
				}
			}
			if(isFull) {
				++count;
			}
		}
		// to be check whether the logic is correct
		for(int i = xunit-1; i-count >=0; --i) {
			for(int j = yunit-1; j >= 0; --j) {
				MAP[i][j] = MAP[i-count][j];
			}
		}
	}
	public int[][] getMap(){
		return MAP;
	}
	
	public void rotate() { // rotate // 
		
	}
	public AShape getcurrBlock() {
		return currBlock;
	}
	public void setBlock(int blockInt) {
		currBlock = block;
	}
	/*public void setGameOver() {
		gameOver = !gameOver;
	}
	public Boolean getGameOver() {
		return gameOver;
	}*/
	
	//thread // real time // server mor info
	
}