package MVC.model;

import java.awt.*;

public class J extends AShape{
    public J(Color color, int[] pos, int rotate) {
        super(ShapeType.J, color, pos, rotate);
    }
    public J() {
        super(ShapeType.J);
        initCenter();
    }

    @Override
    public void initCenter() {
/*        1
          1
         10

 */
        int[] temp = new int[2];
            temp[0] = 1;
            temp[1] = 3;
        this.center = temp;
    }

    @Override
    public ShapeType getType() {
        return ShapeType.J;
    }

}
