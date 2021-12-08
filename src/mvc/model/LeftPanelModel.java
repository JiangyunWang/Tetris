package mvc.model;

import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

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
	private Timer timer2;
	
	public Timer getTimer2() {
		return timer2;
	}


	public void setTimer2(Timer timer2) {
		this.timer2 = timer2;
	}

	//private static int[][] inmoveMap;
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
	
	public void eraseLine() { // i = row, j = column 
		int[][] temp = new int[xunit][yunit];
		int cnt = xunit -1;
		//!!!!!!!!!! !!!!!!somehow get score 
		int score = 0;
		for(int i = xunit-1; i >=0; --i) {
			for(int j = 0; j < yunit; ++j) {
				if(map[i][j] == 0) {
					temp[cnt] = map[i];
					cnt--;
					
					/*
					 * ++score
					 */
				}
			}
			if(score < 2) {
				
			}
			else if(score < 6) {
				score *= 2;
			}
			else {
				score *=3;
			}
			// somehow add score back to right panel
		
		}
		map = temp;
		
	}
	
	public void setBlock(IShape block) {
		this.block = block;
	}
	public IShape getBlock() {
		return block;
	}
	// block become a part of map
	public void updateMap() {
		int[][] currLook = block.currLook();
		int[] currPos = block.getPos();

		boolean shouldChangeToMap = false;
		for(int i =0; i < currLook.length;++i) {
			for (int j =0; j < currLook[i].length;++j) {
				if(currLook[i][j] == 1) {
					
					if(i+currPos[1] == xunit-1) {
						shouldChangeToMap = true;
						break;
					}
					else if(map[i+1+currPos[0]][j] == 1) {
						shouldChangeToMap = true;
						break;
					}
				}
			}
			if(shouldChangeToMap) {
				break;
			}
		}
		if(shouldChangeToMap) {
			for(int i =0; i < currLook.length;++i) {
				for (int j =0; j < currLook[i].length;++j) {
					if(currLook[i][j] == 1) {
						map[i][j] = 1;
					}
				}
			}
			//!!!!!!!!!!!!
			//this.block = rpm.getBlock();// need get next block in right panel model
			// !!!!!!!!!!!!!!need timer here???
		}
		this.eraseLine(); // do we need check here?
		//gameOver(); //do we need to check here??
	}

	public boolean gameOver() {
		
		for(int i = 0; i < yunit; ++i) {
			if(map[0][i] == 1) {
				gameOver = true;
				//gameJpanel.setOverFlag(true);
			}
		}
		// need to call gameover 
		return gameOver;
	}
	
	// map will grow after few second
	public void autoUp(){
		timer2 = new Timer();

		timer2.schedule(new TimerTask()
		{
			@Override
			public void run()
			{
				
				growSelf();
				
			}
		}, 0, 16000);
	}
	private void growSelf() {
		int k= (int) (Math.random() % yunit)+1;
		for (int i = 0; i<xunit-1; i++) {
			for (int j = 0; j < yunit; j++) {
				map[i][j]=map[i+1][j];
			}
		}
		for(int i = 0; i < yunit; ++i) {
			map[xunit-1][i] = 1;
		}
		map[xunit-1][k] = 0;
		eraseLine();
	}
}