package mvc.model;

import java.awt.*;

public interface IShape {
	
    public void setColor(Color color);
    public void initCenter();
    public void setPosX(int x);
    public void setPosY(int y);
    public void setRotate();
    public Color getColor();
    public int[] getCenter();
    public int getRotation();
    public ShapeType getType();
    public void moveLeft();
    public void moveRight();
    public void goDown();
    public int[][] currLook();
    

}