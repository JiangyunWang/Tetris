package mvc.model;

import java.awt.Graphics;
import javax.swing.SwingUtilities;

public class LeftPanelModel {
	private static final int size = 25;
	private static int yunit = 12;
	private static int xunit = 24;
	private static int ymax = size * 12;
	private static int xmax = size * 24;
	Boolean gameOver;
	private IShape block;
	private static int[][] map;
	private static int[][] inmoveMap;
	public static int getXunit() {
		return xunit;
	}

	public static void setXunit(int xunit) {
		LeftPanelModel.xunit = xunit;
	}

	public static int getYunit() {
		return yunit;
	}

	/*public static void setYunit(int yunit) {
		LeftPanelModel.yunit = yunit;
	}*/

	public static int getXmax() {
		return xmax;
	}

	/*public static void setXmax(int xmax) {
		LeftPanelModel.xmax = xmax;
	}*/

	public static int getYmax() {
		return ymax;
	}

	/*public static void setYmax(int ymax) {
		LeftPanelModel.ymax = ymax;
	}*/

	public Boolean getGameOver() {
		return gameOver;
	}

	public void setGameOver(Boolean gameOver) {
		this.gameOver = gameOver;
	}

	public static int[][] getMap() {
		return map;
	}

	public static void setMap(int[][] map) {
		LeftPanelModel.map = map;
	}
	
	
	
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
		// to be modify ,MAYBE
		int[][] currLook = block.currLook();
		for(int i = 0; i < currLook.length; ++i) {
			for (int j = 0; j < currLook.length; ++j){
				map[i][j] = currLook[i][j];
			}
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
		int[][] currLook = block.currLook();
		for(int i =0; i < currLook.length;++i) {
			for (int j =0; j < currLook[i].length;++j) {
				if(currLook[i][j] == 1) {
					if(i == xunit-1) {
						
					}
				}
			}
		}
	}
	
	
}