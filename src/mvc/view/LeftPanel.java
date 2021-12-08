package mvc.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import mvc.model.IShape;
import mvc.model.LeftPanelModel;
import mvc.model.RightPanelModel;

public class LeftPanel extends JPanel implements ActionListener {
	private LeftPanelModel model;
	private Timer time;
	private int counter;
	private int speed;
//	private int[][] map;
//	private IShape shape;
	private int width;
	private int height;

	public LeftPanel(LeftPanelModel model) {
		setSize(100,800);
		this.model = model;
		this.speed = 1;
		this.time= new Timer(1000/speed, this);
//		this.counter = 0;
//		this.map = model.
//		this.shape = shape;
		this.width = model.getMap()[0].length;
		this.height = model.getMap().length;
	}

//	public void setMap(int[][] map) {
//		this.map = map;
//
//	}
//
//	public void setShape(IShape shape) {
//		this.shape = shape;
//	}

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



//	------- wjy --------
	public void speedUp() {
	this.speed+=5;
}

	public void speedBack() {
		this.speed=1;
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		model.goDown();
		this.repaint();
//		counter++;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		int[][] map = model.getMap();
		for (int i =0; i<height; i++) {
			for (int j=0;j<width;  j++) {
				if (map[i][j]==1)  {
					g2d.setPaint(Color.gray);
					g2d.drawRect(i*25,j*25,25,25);
				} else {
					g2d.setPaint(Color.white);
					g2d.drawRect(i*25,j*25,25,25);
				}
			}
		}

		IShape shape = model.getShape();
		g2d.setPaint(shape.getColor());
		int[][] shapeIdx = shape.currLook();
		int x = shape.getPos()[0], y = shape.getPos()[1];
		for (int[] pair: shapeIdx) {
			pair[0]+=x;
			pair[1]+=y;
			g2d.drawRect(pair[0]*25,pair[1]*25,25,25);
		}

	}



}

