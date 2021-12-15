package mvc.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mvc.model.IShape;
import mvc.model.J;
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
	private JPanel instruction;

	public RightPanel(BorderLayout layout, RightPanelModel model) {
		super(layout);
		this.model = model;
		//this.setSize(300,300);
		downPanel = new JPanel(new BorderLayout());

		//downPanel.setSize(100,100);
		instruction =new JPanel(new GridLayout(3,1));
		JLabel a = new JLabel("See the Tile of the board:");
		JLabel b = new JLabel("Player 1 uses: ^,v,<,>");
		JLabel c = new JLabel("Player 2 uses: w,s,a,d");
		instruction.add(a);
		instruction.add(b);
		instruction.add(c);
		nextB = new NextClass(model.getNextBlock(),new BorderLayout());
		//nextB.setSize(200,200);
		creatPanel() ;

		this.add(nextB,BorderLayout.CENTER);
		this.add(downPanel,BorderLayout.NORTH);
		this.add(instruction, BorderLayout.SOUTH);
		
	}
	
	
	public void creatLabel() {
		score = new JLabel ("    Current  Score:       " +String.valueOf(model.getScore()));
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
		
		score.setText("    Current  Score:       " +String.valueOf(model.getScore()));
		//UserName.setText("          Name:     " +model.getName());
		//erasedLine.setText("          erased line:     " + String.valueOf(model.getLine()));
		score.repaint();
		//erasedLine.repaint();
		this.repaint();
		nextB.setBlock(model.getNextBlock()); 
	}


}
