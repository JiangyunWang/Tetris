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
	private Ishape block;
	private static int[][] map;
	
	
	public LeftPanelModel (){
		map = new int[xunit][yunit];
		 for(int i = 0; i < xunit; ++i) {
			 for (int j = 0; j < yunit; ++j) {
				 map[i][j] = 0;
			 }
		 }
		gameOver = false;
	 }
	
	// need to check gameover
	
	public void earseLine() { // i = row, j = column 
		boolean isFull = true;
		int count = 0;
		int[][] temp = new int[xunit][yunit];
		for(int i = xunit-1; i >=0; --i) {
			for(int j = yunit-1; j >= 0; --j) {
				if(map[i][j] == 0) {
					isFull = false;
					break;
				}
			}
			if(!isFull) {
				for(int k = 0;  k < yunit;++k) {
				      temp[j][k] = map[i+1];
				 }
			    ++j;
			}
		}
		map = temp;
		
	}
	/*public void setGameOver() {
		gameOver = !gameOver;
	}
	public Boolean getGameOver() {
		return gameOver;
	}*/
	
	//thread // real time // server mor info
	
}