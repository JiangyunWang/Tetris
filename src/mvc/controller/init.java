package MVC.Controller;

import MVC.View.GameFrame;
import MVC.View.setFrame;
import MVC.model.LeftPanelModel;
import MVC.model.RightPanelModel;

public class init {
	private boolean running;//should be in model
	// total model
	
	public void init() {
		running = true;
	}
	
	public static void main(String[] args) {
		init i = new init();
		//initialize
		GameFrame GameFrame = new GameFrame(/*total model*/);
	    GameFrame.setVisible(true);
		i.go();
	}
	
	
    /*public static void setShape(int shapeInt) { to be modify!!!
    	if(shapeInt < 15) {
    		block = new Ashape();// parameter
    	}
    	else if (shapeInt < 30) {
    		block = new Ashape();//
    	}
    	else if(shapeInt < 45) {
    		block = new Ashape();//
    	}
    	else if(shapeInt < 60) {
    		block = new Ashape();//
    	}
    	else if (shapeInt < 75) {
    		block = new Ashape();//
    	}
    	else if(shapeInt < 90) {
    		block = new Ashape();//
    	}
    	else if(shapeInt < 105) {
    		block = new Ashape();
    	}
    	lpm.setBlock(shapeInt);
    }*/
	public void go() {
		while(true) {
			if(running == false) {
				break;
			}
			//int nextBlock = (int) (Math.random()*105);
			
		}
		// show game over
	}
	  
}
