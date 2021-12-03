package MVC.View;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MVC.model.RightPanelModel;
import MVC.model.ShapeType;

public class RightPanel extends JPanel {
	private static JLabel score;
	private static JLabel nextBlock;
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
		creatPanel() ;
		//this.add(nextBlock,BorderLayout.NORTH);
		this.add(downPanel,BorderLayout.CENTER);
		
	}

	
	public void creatScoreLabel() {
		score = new JLabel ("Score: ");
		final int FIELD_WIDTH = 10;
		scoreField = new JTextField(FIELD_WIDTH);
		scoreField.setText(String.valueOf(model.getScore()));
	}
	public void creatNextLabel() {
		nextBlock = new JLabel("Next: ");
		//draw next next block

	}
	public void creatUserNameLabel() {
		UserName = new JLabel("Name: ");
		final int FIELD_WIDTH = 10;
		nameField = new JTextField(FIELD_WIDTH);
		nameField.setText(model.getName());//!!!!!model
	}
	public void eraseLineLabel() {
		erasedLine = new JLabel("erased line: ");
		final int FIELD_WIDTH = 10;
		erasedField = new JTextField(FIELD_WIDTH);
		erasedField.setText(String.valueOf(model.getLine()));//model!!
	}
	public void creatPanel() {
		creatScoreLabel();
		creatUserNameLabel();
		eraseLineLabel();
		downPanel.add(UserName,BorderLayout.NORTH);
		downPanel.add(erasedLine,BorderLayout.CENTER);
		downPanel.add(score,BorderLayout.SOUTH);
	}
	public void refresh(){
		scoreField.setText(String.valueOf(model.getScore()));
		nameField.setText(model.getName());
		erasedField.setText(String.valueOf(model.getLine()));
		//missing next block;
	}
}
