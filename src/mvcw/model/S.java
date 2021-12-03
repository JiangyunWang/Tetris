package mvcw.model;

import java.awt.*;

public class S extends AShape{
    public S(Color color, int[] pos, int rotate) {
        super(ShapeType.S, color, pos, rotate);
    }
    public S() {
        super(ShapeType.S);
        initCenter();
    }
    @Override
    public void initCenter() {
        /*        11
                  0
                 11

 */
        int[] temp = new int[2];
        temp[0] = 1;
        temp[1] = 1;
        this.center = temp;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.S;
    }
}
