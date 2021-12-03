package mvcw.model;

import java.awt.*;

public class Z extends AShape{
    public Z(Color color, int[] pos, int rotate) {
        super(ShapeType.Z, color, pos, rotate);
    }
    public Z() {
        super(ShapeType.Z);
        initCenter();
    }
    @Override
    public void initCenter() {
        /*       11
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
        return ShapeType.Z;
    }
}
