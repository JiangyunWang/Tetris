package mvc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mvc.model.IShape;
import mvc.model.RightPanelModel;
import mvc.model.ShapeType;

public class RightPanel extends JPanel {
	private static JLabel score;
	private static JPanel nextBlock;
	private JLabel UserName;
	private JLabel erasedLine;
	private JTextField scoreField;
	private JTextField nameField;
	private JTextField erasedField;
	private RightPanelModel model;
	
	private JPanel downPanel;
	public RightPanel(BorderLayout layout, RightPanelModel model) {
		super(layout);
		setSize(100,800);
		this.model = model;
		downPanel = new JPanel(new BorderLayout());
		//downPanel.setSize(100,100);
		nextBlock = new JPanel();
		creatPanel() ;
		creatNextPanel();
		
		this.add(nextBlock,BorderLayout.NORTH);
		this.add(downPanel,BorderLayout.CENTER);
		
	}
	
	
	public void creatScoreLabel() {
		score = new JLabel ("Score: "+ model.getScore());
		final int FIELD_WIDTH = 10;
		scoreField = new JTextField(FIELD_WIDTH);
		scoreField.setText(String.valueOf(model.getScore()));
	}
	
	public void creatUserNameLabel() {
		UserName = new JLabel("Name: " +model.getName());
		
		final int FIELD_WIDTH = 10;
		nameField = new JTextField(FIELD_WIDTH);
		//nameField.setText("Name: "+ model.getName());//!!!!!model
	}
	public void eraseLineLabel() {
		erasedLine = new JLabel("erased line: " + model.getLine());
		final int FIELD_WIDTH = 10;
		erasedField = new JTextField(FIELD_WIDTH);
		//erasedField.setText(String.valueOf(model.getLine()));//model!!
	}
	public void creatPanel() {
		creatScoreLabel();
		creatUserNameLabel();
		eraseLineLabel();
		downPanel.add(UserName,BorderLayout.NORTH);
		downPanel.add(erasedLine,BorderLayout.CENTER);
		downPanel.add(score,BorderLayout.SOUTH);
	}
	public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			IShape shape = model.getBlock();
			g2d.setPaint(shape.getColor());
			int[][] shapeIdx = shape.currLook();
			int x = shape.getCenter()[0], y = shape.getCenter()[1];
			for (int[] pair: shapeIdx) {
				pair[0]+=x;
				pair[1]+=y;
				g2d.fillRect(pair[0]*25,pair[1]*25,25,25);
			}
	}
	
public void creatNextPanel() {
		
		//draw next next block
	
	/*public void paint(Graphics g) {
	super.paint(g);
	g.setColor(Color.gray);
	drawCoordinates(g);
}


private void drawCoordinates(Graphics g) {

	for (int i = 0; i < 12*25; i += 25) {
		g.drawLine(i, 0, i, 23*25);
	}
	for (int j = 0; j < 24*25; j += 25) {
		g.drawLine(0, j, 11*25, j);
	}
}*/

	}
	public void refresh(){
		scoreField.setText(String.valueOf(model.getScore()));
		nameField.setText(model.getName());
		erasedField.setText(String.valueOf(model.getLine()));
		//missing next block;
	}



}
