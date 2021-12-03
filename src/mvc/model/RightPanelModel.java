package mvc.model;

public class RightPanelModel {
	private int line = 0; 
	private String name = "anonymity";
	private int score = 0;
	private AShape block;
	public RightPanelModel() {
	}
	public int getLine() {return line;}
	
	
	  
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

}
