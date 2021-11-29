package MVC.model;

import java.awt.*;

public abstract class AShape implements IShape{
    protected ShapeType type;
    protected Color color;
    protected int[] center;
    protected int rotate;

    public AShape(ShapeType type, Color color, int[] pos, int rotate)  {
        if (type==null || color == null || pos==null) {
            throw new IllegalStateException("Invalid shape parameter");
        } else if (pos[0]<0 || pos[1]<0 || rotate<0) {
            throw new IllegalStateException("parameter can't be negative");
        }
        this.type = type;
        this.color = color;
        this.center = pos;
        this.rotate = rotate;
    }

    public AShape(ShapeType type)  {
        this.type = type;
        this.color = Color.black;
        this.rotate = 0;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

//    @Override
//    public void setCenter(int[] pos) {
//        this.center = pos;
//    }

    @Override
    public void setPosX(int x) {
        this.center[0] +=x;
    }

    @Override
    public void setPosY(int y) {
        this.center[1] += y;
    }

    @Override
    public void setRotate() {
        this.rotate+=1;
    }

    @Override
    public Color getColor() {
//        deep copy
        return new Color(this.color.getRGB());
    }

    @Override
    public int[] getCenter() {
        int[] temp  = new int[2];
        temp[0] = this.center[0];
        temp[1] = this.center[1];
        return temp;
    }

    @Override
    public int getRotation() {
        return this.rotate;
    }

}
