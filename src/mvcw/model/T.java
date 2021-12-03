package mvcw.model;

import java.awt.*;

public class T extends AShape{
    public T(Color color, int[] pos, int rotate) {
        super(ShapeType.T, color, pos, rotate);
    }
    public T() {
        super(ShapeType.T);
        initCenter();
    }

    @Override
    public void initCenter() {
        /*   101
              1


 */
        int[] temp = new int[2];
        temp[0] = 0;
        temp[1] = 1;
        this.center = temp;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.T;
    }
}
