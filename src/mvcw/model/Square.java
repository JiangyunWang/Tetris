package mvcw.model;

import java.awt.*;

public class Square extends AShape{
    public Square(Color color, int[] pos, int rotate) {
        super(ShapeType.SQUARE, color, pos, rotate);
    }
    public Square() {
        super(ShapeType.SQUARE);
        initCenter();
    }
    @Override
    public void initCenter() {
        /*01
          11

 */
        int[] temp = new int[2];
        temp[0] = 0;
        temp[1] = 0;
        this.center = temp;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.SQUARE;
    }
}
