package MVC.Model;

import java.awt.*;

public class Block {
    BlockType type;
    Color color;
    int[] pos;
    int direction;
    public Block(BlockType type, Color color) {
        this.type = type;
        this.color = color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPos(int[] pos){
        this.pos = pos;
    }

    public void setPosX(int x)  {
        // check boundary
        this.pos[0] = x;
    }

    public void setPosY(int y)  {
        // check boundary
        this.pos[1] = y;
    }


}
