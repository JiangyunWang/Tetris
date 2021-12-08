package mvc.model;

import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.SwingUtilities;

public class LeftPanelModel {
	// leftPanel should have next block in the beginning
	private static final int size = 25;
	private static int yunit = 12;
	private static int xunit = 24;
	private static int ymax = size * 12;
	private static int xmax = size * 24;
	
	Boolean gameOver;
	private IShape block;
	private static int[][] map;
	private Timer timer2;
	private Timer timer1;
	int score = 0; // add or set
	
	
	boolean needNewBlock;
	
	/* yihan for testing ***************
		*/
	//**************有图行了, 开始往下掉*****
	
	int speed = 1;
	public void speedUp() {
		this.speed+=5;
	}

	public void speedBack() {
		this.speed=1;
	}
	
	// ****************end of testing
	

	
	
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
	
	public int getScore() {
		return score;
	}
	public Timer getTimer2() {
		return timer2;
	}


	public void setTimer2(Timer timer2) {
		this.timer2 = timer2;
	}

	//private static int[][] inmoveMap;
	public int getXunit() {
		return xunit;
	}

	public void setXunit(int xunit) {
		LeftPanelModel.xunit = xunit;
	}

	public int getYunit() {
		return yunit;
	}

	/*public static void setYunit(int yunit) {
		LeftPanelModel.yunit = yunit;
	}*/

	public int getXmax() {
		return xmax;
	}

	/*public static void setXmax(int xmax) {
		LeftPanelModel.xmax = xmax;
	}*/

	public int getYmax() {
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

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		LeftPanelModel.map = map;
	}
	
	public boolean getNeedNewBlock() {
		return needNewBlock;
	}

	// need to check gameover
	
	public void eraseLine() { // i = row, j = column 
		int[][] temp = new int[xunit][yunit];
		int cnt = xunit -1;
		
		for(int i = xunit-1; i >=0; --i) {
			for(int j = 0; j < yunit; ++j) {
				if(map[i][j] == 0) {
					temp[cnt] = map[i];
					cnt--;
					++score;
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
		
		}
		//**********controller.setsoreS
		//communicate with rpm
		//to be check!!!!!!!!!!!!!!!!!!!!
		map = temp;
		
	}
	
	public void setBlock(IShape block) {
		this.block = block;
		speedBack();// **************test***********
	}
	public IShape getBlock() {
		return block;
	}
	// block become a part of map
	//********************need update*********************************
	
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
			this.needNewBlock = true;
			//!!!!!!!!!!!!
			//this.block = rpm.getBlock();// need get next block in right panel model
			// !!!!!!!!!!!!!!need timer here???
		}
		this.eraseLine(); 
		//*******shape = controller******************************************
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
	// need check how this works!!!!!!!!!!!!!!!!!!!!!!!*****************
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
	
	public void moveRight() {
		
		
		/*	for (int i = 0; i < actPoints.length; i++) {
				int newX=actPoints[i].x+moveX;
				int newY=actPoints[i].y+moveY;
				if (isOver(newX, newY,blockShow)) {
					return false;
				}
			}
			for(int i=0;i<actPoints.length;i++){
				actPoints[i].x+=moveX;
				actPoints[i].y+=moveY;
			}
			return true;*/
		block.moveRight(); // we can just use set center in model???!!!!!!!!!!S
		
	}
	public void moveLeft() {
		block.moveLeft(); // we can jusr use set center in model!!!S
	}
	public void isValid() {
		
	}
	//!!!!!!!
	public void autoDown() {
		timer1 = new Timer();

		timer1.schedule(new TimerTask()
		{
			@Override
			public void run()
			{
				
				block.goDown();;
				
			}
		}, 0, 3000);
	}
	
	
	public void goDown() {
		boolean canGoDown = true;
	
		
	}
	
	
	
}