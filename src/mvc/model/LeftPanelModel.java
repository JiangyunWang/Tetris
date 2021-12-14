package mvc.model;

import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.SwingUtilities;

import mvc.controller.Controller;

public class LeftPanelModel {
	private static final int size = 25;
	private static int yunit = 12;
	private static int xunit = 24;
	private static int ymax = size * 12;
	private static int xmax = size * 24;

	private Controller c;
	Boolean gameOver;
	private IShape block;
	private int[][] map;
	private Timer timer2;
	private Timer timer1;
	private boolean isChanged;

	boolean isAttacked;
	// int score = 0; // add or set

	/*
	 * yihan for testing ***************
	 */

	private RightPanelModel rpm;
	int speed = 1;

	public void speedUp() {
		this.speed += 5;
	}

	public void speedBack() {
		this.speed = 1;
	}

	// ****************end of testing

	public LeftPanelModel(RightPanelModel rpm, Controller c) {
		this.rpm = rpm;
		map = new int[xunit][yunit];
		block = rpm.getBlock();

		gameOver = false;
		isAttacked = false;
		this.c = c;
		this.isChanged = false;

	}

	public boolean getIsChanged() {
		if (isChanged) {
			isChanged = false;
			return true;
		}
		return isChanged;
	}

	public void setattack(boolean isAttacked) {

	}

	public void setBlock(IShape block) {
		this.block = block;
		speedBack();// **************test***********
	}

	public IShape getBlock() {
		return block;
	}

	/*
	 * public static void setYmax(int ymax) {
	 * LeftPanelModel.ymax = ymax;
	 * }
	 */

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
		this.map = map;
	}

	public void eraseLine() { // i = row, j = column S
		int[][] temp = new int[xunit][yunit];
		int cnt = xunit - 1;
		int score = 0;

		for (int i = xunit - 1; i >= 0; --i) {
			boolean getScore = true;
			for (int j = 0; j < yunit; ++j) {
				if (map[i][j] == 0) {
					temp[cnt] = map[i];
					cnt--;
					getScore = false;
					break;
				}

			}
			if (getScore) {
				++score;
				isChanged = true;
			}

		}

		if (score < 2) {

		} else if (score < 6) {
			score *= 2;
		} else {
			score *= 3;
		}

		rpm.setScore(score);
		this.map = temp;
		gameOver();

		//System.out.println("score:" + score);
		

	}

	public void gameOver() {

		for (int i = 0; i < yunit; ++i) {
			if (map[0][i] == 1) {
				gameOver = true;
				// gameJpanel.setOverFlag(true);
			}
		}
	}

	// map will grow after few second
	public void autoUp() {
		timer2 = new Timer();

		timer2.schedule(new TimerTask() {
			@Override
			public void run() {

				growSelf();

			}
		}, 0, 16000);
	}

	private void growSelf() {
		int k = (int) (Math.random() % yunit) + 1;
		for (int i = 0; i < xunit - 1; i++) {
			for (int j = 0; j < yunit; j++) {
				map[i][j] = map[i + 1][j];
			}
		}
		for (int i = 0; i < yunit; ++i) {
			map[xunit - 1][i] = 1;
		}
		map[xunit - 1][k] = 0;
		eraseLine();
	}

	public void moveRight() {
		if (gameOver) {
			return;
		}
		int[][] currLook = block.currLook();
		int[] center = block.getCenter();
		boolean isValid = true;

		for (int i = 0; i < currLook.length; ++i) {
			int currX = currLook[i][0] + center[0];
			int currY = currLook[i][1] + center[1];
			if (currY + 1 >= yunit) {
				isValid = false;
				break;
			} else if (map[currX][currY + 1] == 1) {
				isValid = false;
				break;
			}
		}
		if (isValid) {
			block.setY(center[1] + 1);
		}

	}

	public void moveLeft() {
		if (gameOver) {
			return;
		}
		int[][] currLook = block.currLook();
		int[] center = block.getCenter();
		boolean isValid = true;
		// have to initialize

		for (int i = 0; i < currLook.length; ++i) {
			int currX = currLook[i][0] + center[0];
			int currY = currLook[i][1] + center[1];
			if (currY - 1 < 0) {
				isValid = false;
				break;
			} else if (map[currX][currY - 1] == 1) {
				isValid = false;
				break;
			}
		}
		if (isValid) {
			block.setY(center[1] - 1);
		}

	}

	// !!!!!!!
	public void autoDown() {
		timer1 = new Timer();

		timer1.schedule(new TimerTask() {
			@Override
			public void run() {

				goDown();
				;

			}
		}, 0, 3000);
	}

	// block become a part of map
	public void goDown() {
		if (gameOver) {
			return;
		}
		// System.out.println("*** go down");
		int[][] currLook = block.currLook();
		int[] center = block.getCenter();
		boolean shouldChangeToMap = false;

		for (int i = 0; i < currLook.length; ++i) {
			int currX = currLook[i][0] + center[0];
			int currY = currLook[i][1] + center[1];

			if (currX + 1 == xunit) {
				shouldChangeToMap = true;

				break;
			} else if (map[currX + 1][currY] == 1) {
				shouldChangeToMap = true;
				break;
			}

		}

		// System.out.println("center is" + center[0] + "center Y is" + center[1]);

		if (shouldChangeToMap) {
			changetoMap();
		} else {
			block.setX(center[0] + 1);

		}

		// *********************
		/*
		 * System.out.println("shouldchage: ");
		 * System.out.println(shouldChangeToMap);
		 * center = block.getCenter();
		 * for(int i =0; i < currLook.length;++i) {
		 * int currX= currLook[i][0] + center[0];
		 * int currY = currLook[i][1] + center[1];
		 * System.out.println("x is" + currX + " Y is" + currY);
		 * }
		 */
	}

	public void changetoMap() {
		int[] center = block.getCenter();
		int[][] currLook = block.currLook();
		for (int[] pair : currLook) {
			map[pair[0] + center[0]][pair[1] + center[1]] = 1;
		}
		rpm.setCurr();
		this.block = rpm.getBlock();

		this.eraseLine();

		if (gameOver) {
			gameOver = true;
		}

	}

	public void setRotate() {
		boolean success = true;
		block.setRotate();
		int[][] idx = block.currLook();
		int x = block.getCenter()[0], y = block.getCenter()[1];

		for (int[] pair : idx) {
			if (x + pair[0] >= 0 && x + pair[0] <= xunit - 1 && y + pair[1] >= 0 && y + pair[1] <= yunit - 1) {
				if (map[x + pair[0]][y + pair[1]] == 1) {
					success = false;
					break;
				}
			} else {
				success = false;
			}

		}
		if (!success) {
			block.reRotate();
		}
	}

}