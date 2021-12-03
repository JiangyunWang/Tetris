package mvcw.model;

public class Block {
    private AShape shape;
    private int[] movement;
    public Block(ShapeType type, int[] movement) {
        switch (type) {
            case J -> shape=new J();
            case L -> shape = new L();
            case S -> shape = new S();
            case T -> shape = new T();
            case Z -> shape = new Z();
            case LINE -> shape = new Line();
            case SQUARE -> shape = new Square();
            default -> throw new IllegalStateException("Invalid shape type");
        }
        shape.setPosX(movement[0]);
        shape.setPosY(movement[1]);
    }

    public AShape getShape() {
        return shape;
    }

    public int[] getMovement() {
        return movement;
    }
     public void setMovement(int x, int y) {
        movement[0]=x;
        movement[1]=y;
        shape.setPosX(movement[0]);
        shape.setPosY(movement[1]);
     }
}
