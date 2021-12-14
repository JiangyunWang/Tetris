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
	private RightPanelModel model;
	private NextClass nextB;
	private JPanel downPanel;

	public RightPanel(BorderLayout layout, RightPanelModel model) {
		super(layout);
		this.model = model;
		//this.setSize(300,300);
		downPanel = new JPanel(new BorderLayout());

		//downPanel.setSize(100,100);
		
		nextB = new NextClass(model.getNextBlock(),new BorderLayout());
		//nextB.setSize(200,200);
		creatPanel() ;

		this.add(nextB,BorderLayout.CENTER);
		this.add(downPanel,BorderLayout.NORTH);
		
	}
	
	
	public void creatLabel() {
		score = new JLabel ("          Score:     "+ model.getScore());
		//UserName = new JLabel("          Name:     " +model.getName());
		//erasedLine = new JLabel("          erased line:     " + model.getLine());

	}
	
	
	public void creatPanel() {
		creatLabel();
		
		//downPanel.add(UserName,BorderLayout.NORTH);
		//downPanel.add(erasedLine,BorderLayout.CENTER);
		downPanel.add(score,BorderLayout.SOUTH);
		
	}
	
	public void refreBlock() {
		nextB.setBlock(model.getBlock());
	}
	
	public void refresh(){
		
		score.setText("         Current  Score:       " +String.valueOf(model.getScore()));
		//UserName.setText("          Name:     " +model.getName());
		//erasedLine.setText("          erased line:     " + String.valueOf(model.getLine()));
		score.repaint();
		//erasedLine.repaint();
		this.repaint();
		nextB.setBlock(model.getNextBlock()); 
	}


}
