package mvc.model;

import java.awt.Color;
import java.util.List;
import java.util.Random;

public class RightPanelModel {
	//private int line; 
	private String name = "anonymity";
	private int score;
	private IShape block;
	private IShape nextBlock;
	private Random rnd;

	public RightPanelModel() {
		//this.line = 0;
		//this.name = "anonymity";
		this.score = 0;

		rnd = new Random(); 
		generateShape();
		setCurr();
		
	}

	/*public RightPanelModel(String name, int score) {
		this.line = 0;
		this.name = name;
		this.score = score;
		generateShape();
		setCurr();
	}*/

	public void generateShape() {
		int shapeInt = (int) (Math.random() * 105);
		if(shapeInt < 15) {
			nextBlock = new S(Color.pink);
		}
		else if (shapeInt < 30) {
			nextBlock = new Z(Color.blue);
		}
		else if(shapeInt <45) {
			nextBlock = new T(Color.black);
		}
		else if(shapeInt < 60) {
			nextBlock = new J(Color.gray);
		}
		else if(shapeInt < 75) {
			nextBlock = new L(Color.magenta);
		}
		else if(shapeInt < 90) {
			nextBlock = new Line(Color.green);
		}
		else {
			nextBlock = new Square(Color.red);
		}
		//***************
		int y = nextBlock.getCenter()[1];
		
			nextBlock.setY(y+4);
		
		/*int shapeInt = rnd.nextInt(7);
		switch (shapeInt) {
			case 0:
				block = new S();
			case 1:
				block = new Z();
			case 2:
				block = new T();
			case 3:
				block = new J();
			case 4:
				block = new L();
			case 5:
				block = new Line();
			case 6:
				block = new Square();
			default:
				throw new IllegalStateException("Invalid shape int");
		}*/
	
	}
	public void setCurr() {
		block = nextBlock;
		generateShape();
	}
	/*public int getLine() {
		return line;
	}*/
	  
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	//Block getter setter
	/*public void setLineNoStatic(int line) {
		this.line = line;
	}*/
	
	public void setName(String name) {
		this.name = name;
	}
	public void setScore(int score) {
		this.score += score;
	}
	public IShape getBlock() {
		return block;
	}
	public IShape getNextBlock() {
		return nextBlock;
	}

}
