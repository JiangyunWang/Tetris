package mvc.controller;

import mvc.model.*;
import mvc.view.GameFrame;
import mvc.view.LeftPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Controller {
    private GameFrame gf;
    private LeftPanelModel lpm;
    private RightPanelModel rpm;
    private IShape nexShape;
    private int[][] map;


    public Controller() {


        this.gf = new GameFrame();
        this.rpm = new RightPanelModel();
        this.nexShape = rpm.getBlock();
        this.lpm = new LeftPanelModel(nexShape);
        this.map = lpm.getMap();
        this.gf = new GameFrame();
        gf.setBoard(map);
        gf.setBlock(nexShape); // YIHAN correct error************
        
        // ******* yihan ****************
      /*  class MyListener implements KeyListener{

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
	
			    int dir = e.getKeyCode();
                        switch (dir) {
                            case KeyEvent.VK_LEFT:
                                lpm.moveLeft();
                            case KeyEvent.VK_RIGHT:
                                lpm.moveRight();
                            case KeyEvent.VK_DOWN:
                               lpm.speedUp();
                            case KeyEvent.VK_SPACE:
                                nexShape.setRotate();//***for test

                        }
			    // repaint
			    

				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
        	
        }
        this.gf.addKeyListener(new MyListener());*/
        // ****************************
    }

    public void move() {
    	// ***********yihan***************
        // how to begin timer.........
    	lpm.autoDown(); //************************
    	
        	
        	//if need new block
        if(lpm.getNeedNewBlock()) {
        	lpm.setBlock(nexShape);
        }
        
    }

    
    

}
