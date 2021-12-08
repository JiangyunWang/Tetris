package mvc.model;

import java.util.List;
import java.util.Random;

public class RightPanelModel {
	private int line = 0; 
	private String name = "anonymity";
	private int score = 0;
	private IShape block;
	private Random rnd;

	public RightPanelModel() {
		this.line = 0;
		this.name = "anonymity";
		this.score = 0;

		rnd = new Random(); // YIHan for TESTING****************************
		this.block  = generateShape();
	}

	public RightPanelModel(String name, int score) {
		this.line = 0;
		this.name = name;
		this.score = score;
		this.block  = generateShape();
	}

	public IShape generateShape() {
		int shapeInt = rnd.nextInt(7);
		switch (shapeInt) {
			case 0:
				return new S();
			case 1:
				return new Z();
			case 2:
				return new T();
			case 3:
				return new J();
			case 4:
				return new L();
			case 5:
				return new Line();
			case 6:
				return new Square();
			default:
				throw new IllegalStateException("Invalid shape int");
		}
	}

	public int getLine() {
		return line;}
	  
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	//Block getter setter
	public void setLine(int line) {
		this.line = line;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public IShape getBlock() {
		return block;
	}
	

}
