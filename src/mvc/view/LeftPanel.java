package mvc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import mvc.model.LeftPanelModel;
import mvc.model.RightPanelModel;

public class LeftPanel extends JPanel{
	private LeftPanelModel model;

	public LeftPanel(LeftPanelModel model) {
		setSize(100,800);
		this.model = model;


	}

	public void paint(Graphics g) {
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
	}
	
//	private void DrawBlockes() {
//
//		for(int i = )
//	}
}
