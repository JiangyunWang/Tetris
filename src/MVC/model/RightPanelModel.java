package MVC.model;

public class RightPanelModel {
	private int line = 0; 
	private String name = "anonymity";
	private int score = 0;
	private ShapeType block;
	public RightPanelModel() {  
	}
	public int getLine() {return line;}
	  
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	public ShapeType getBlock() {
		return block;
	}
	public void setBlock(ShapeType block) {
		this.block = block;
	}
	public void setLine(int line) {
		this.line = line;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setScore(int score) {
		this.score = score;
	}

}
