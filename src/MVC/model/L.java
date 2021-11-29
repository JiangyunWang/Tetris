package MVC.model;

import java.awt.*;

public class L extends AShape{
    public L(Color color, int[] pos, int rotate) {
        super(ShapeType.L, color, pos, rotate);
    }
    public L() {
        super(ShapeType.L);
        initCenter();
    }

    @Override
    public void initCenter() {
        /*        1
                  1
                  0 1

 */
        int[] temp = new int[2];
        temp[0] = 0;
        temp[1] = 3;
        this.center = temp;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.L;
    }
    
    
}
