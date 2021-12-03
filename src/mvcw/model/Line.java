package mvcw.model;

import java.awt.*;

public class Line extends AShape{
    public Line(Color color, int[] pos, int rotate) {
        super(ShapeType.LINE, color, pos, rotate);
    }
    public Line() {
        super(ShapeType.LINE);
        initCenter();
    }
    @Override
    public void initCenter() {
        /*         11011


 */
        int[] temp = new int[2];
        temp[0] = 0;
        temp[1] = 2;
        this.center = temp;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.LINE;
    }
}
