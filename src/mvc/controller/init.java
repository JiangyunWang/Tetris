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
