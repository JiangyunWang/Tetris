package mvc.model;

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
    
    
/*public void godown() {
		
	}
	public void moveLeft() {
		int[] center = currBlock.getCenter();
		boolean canMove = false;
		// need to know its current shape!!
		if(currBlock instanceof L) {
			if(center[1] > 0) {
				canMove = true;
			}
		}
		else if (currBlock instanceof S) {
			if(center[1] >1) {
				canMove = true;
			}
		}
		else if(currBlock instanceof Line) {
			//if(center[1] > )
			// we need shape?? 
		}
		else if(currBlock instanceof T) {
			
		}
		else if (currBlock instanceof Square) {
			
		}
		else if (currBlock instanceof Z) {
			
		}
		else if (currBlock instanceof J) {
			
		}
		if(MAP[center[1]-1][center[0]] == 0) {
			currBlock.setPosY(center[1]-1);
		}
		
		
	}
	public void moveRight() {
		int[] center = currBlock.getCenter();
		if(currBlock instanceof L) {
			if(center[1] > 1) {
				if(MAP[center[1]-1][center[0]] == 0) {
					currBlock.setPosY(center[1]-1);
				}
			}
		}
		else if (currBlock instanceof S) {
			
		}
		else if(currBlock instanceof Line) {
			
		}
		else if(currBlock instanceof T) {
			
		}
		else if (currBlock instanceof Square) {
			
		}
		else if (currBlock instanceof Z) {
			
		}
		else if (currBlock instanceof J) {
			
		}
	}
	
	public void earseLine() { // i = row, j = column 
		boolean isFull = true;
		int count = 0;
		for(int i = xunit-1; i >=0; --i) {
			for(int j = yunit-1; j >= 0; --j) {
				if(MAP[i][j] == 0) {
					isFull = false;
				}
			}
			if(isFull) {
				++count;
			}
		}
		// to be check whether the logic is correct
		for(int i = xunit-1; i-count >=0; --i) {
			for(int j = yunit-1; j >= 0; --j) {
				MAP[i][j] = MAP[i-count][j];
			}
		}
	}
	public int[][] getMap(){
		return MAP;
	}
	
	public void rotate() { // rotate // 
		
	}*/

}
