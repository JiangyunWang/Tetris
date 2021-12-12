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
	private static JPanel upperPanel;
	private JLabel UserName;
	private JLabel erasedLine;
	private JTextField scoreField;
	private JTextField nameField;
	private JTextField erasedField;
	private RightPanelModel model;
	private NextClass nextB;
	private JPanel downPanel;

	public RightPanel(BorderLayout layout, RightPanelModel model) {
		super(layout);
		this.model = model;
		downPanel = new JPanel(new BorderLayout());
		downPanel.setSize(300,300);

		nextB = new NextClass(model.getNextBlock(),new BorderLayout());
		nextB.setSize(600,600);
		creatPanel() ;

		this.add(nextB,BorderLayout.CENTER);
		this.add(downPanel,BorderLayout.NORTH);
		
	}
	

	public void creatScoreLabel() {
		score = new JLabel ("Score: "+ model.getScore());
		final int FIELD_WIDTH = 10;
		scoreField = new JTextField(FIELD_WIDTH);
		scoreField.setText("Score: "+ model.getScore());
	}
	
	public void creatUserNameLabel() {
		UserName = new JLabel("Name: " +model.getName());
		
		final int FIELD_WIDTH = 10;
		nameField = new JTextField(FIELD_WIDTH);
		nameField.setText("Name: "+ model.getName());
	}
	public void eraseLineLabel() {
		erasedLine = new JLabel("erased line: " + model.getLine());
		final int FIELD_WIDTH = 10;
		erasedField = new JTextField(FIELD_WIDTH);
		//erasedField.setText("erased line: " + model.getLine());//model!!
	}
	public void creatPanel() {
		creatScoreLabel();
		creatUserNameLabel();
		eraseLineLabel();
		downPanel.add(UserName,BorderLayout.NORTH);
		downPanel.add(erasedLine,BorderLayout.CENTER);
		downPanel.add(score,BorderLayout.SOUTH);
		
	}
	
	public void refreBlock() {
		nextB.setBlock(model.getBlock());
	}
	
	public void refresh(){
		
		scoreField.setText(String.valueOf(model.getScore()));
		nameField.setText(model.getName());
		erasedField.setText(String.valueOf(model.getLine()));
		scoreField.repaint();
		nameField.repaint();
		erasedField.repaint();
		this.repaint();
		nextB.setBlock(model.getNextBlock()); 
	}


}
