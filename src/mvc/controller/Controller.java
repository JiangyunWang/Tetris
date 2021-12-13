package mvc.controller;

import mvc.model.*;
import mvc.view.GameFrame;
import mvc.view.LeftPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;



public class Controller {
    private GameFrame gf;
    private LeftPanelModel lpm;
    private RightPanelModel rpm;
    private IShape nexShape;
    private IShape  currShape;
    private int[][] map;
    private int player;


    public Controller() {
       
        this.rpm = new RightPanelModel();
        this.lpm = new LeftPanelModel(rpm, this);
        this.gf = new GameFrame(rpm,lpm);
        this.map = lpm.getMap();
        gf.setVisible(true);
        this.currShape = lpm.getBlock();
        this.gf.addKeyListener(new MyListener());

    }
      class MyListener implements KeyListener{

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {

                int dir = e.getKeyCode();
                if (player == 0) {
                    switch (dir) {
                        case KeyEvent.VK_LEFT:
                            lpm.moveLeft();
                            break;
                        case KeyEvent.VK_RIGHT:
                            lpm.moveRight();
                            break;
                        case KeyEvent.VK_DOWN:
                            lpm.goDown();
                            lpm.speedUp();
                            break;
                        case KeyEvent.VK_SPACE:
                            lpm.setRotate();
                            break;

                    }
                } else {
                    switch (dir) {
                        case KeyEvent.VK_A:
                            lpm.moveLeft();
                            break;
                        case KeyEvent.VK_D:
                            lpm.moveRight();
                            break;
                        case KeyEvent.VK_S:
                            lpm.goDown();
                            lpm.speedUp();
                            break;
                        case KeyEvent.VK_W:
                            lpm.setRotate();
                            break;
                    }
                }
                gf.refresh();
            }

          @Override
          public void keyReleased(KeyEvent e) {
              int dir =  e.getKeyCode();
              if (player == 0) {
                  if (dir==KeyEvent.VK_DOWN)  {
                      gf.getlPanel().speedBack();
                  }
              }  else {
                  if (dir==KeyEvent.VK_S)  {
                      gf.getlPanel().speedBack();
                  }
              }

          }
        	
        }


    public LeftPanelModel getLpm() {
        return lpm;
    }

    public RightPanelModel getRpm() {
        return rpm;
    }

    public void move() {
    	System.out.println("before loop");//*******************
    	
    	Timer timer1 = new Timer();

    	timer1.schedule(new TimerTask()
    		{
    			@Override
    			public void run()
    			{
                    System.out.println("timer is： "+timer1.toString());
    				lpm.goDown();
    				gf.refresh();
    				if(lpm.getGameOver()) {
    					timer1.cancel();
    					System.out.println("over!!!");
    				}
    			}
    		}, 1000, 1000);
    }
    
    public void refreshRight() {
    	gf.refresh();
    }

    public int getPlayer() {
        return player;
    }
    public void setPlayer(int num) {
        this.player = num;
    }
    
    
   /* public void start(int[][] map, IShape shape) {
        for (int i=0; i<map.length; i++) {
            for(int j=0; j<map[0].length; j++) {
            }
        }
    }*/

}