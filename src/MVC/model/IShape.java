package mvc.model;

import java.awt.*;

public interface IShape {
	
	public LeftPanelModel lpm = new LeftPanelModel();
	public RightPanelModel rpm = new RightPanelModel();
	public AShape block;
	
	
    public void setColor(Color color);
    public void initCenter();
    public void setPosX(int x);
    public void setPosY(int y);
    public void setRotate();
    public Color getColor();
    public int[] getCenter();
    public int getRotation();
    public ShapeType getType();

    
    public static void setShape(int shapeInt) { // why static
    	/*if(shapeInt < 15) {
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
    	}*/
    	lpm.setBlock(shapeInt);
    }
    public static void moveLeft() { // why static
    	lpm.moveLeft();
    }
    public static void moveRight() {
    	lpm.moveRight();
    }
    public void moveDown() {
    	lpm.godown();
    }
}