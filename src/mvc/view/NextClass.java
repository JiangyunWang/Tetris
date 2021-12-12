package mvc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import mvc.model.IShape;
import mvc.model.ShapeType;

public class NextClass extends JPanel {
	IShape shape;
	public NextClass(IShape block,BorderLayout layout) {
		super(layout);
		this.shape = block;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		for (int i =0; i<3; i++) {
			for (int j=0;j<5;  j++) {
				
					g2d.setPaint(Color.white);
					g2d.drawRect(j*25,i*25,25,25);
				}
		}
		
		g2d.setPaint(shape.getColor());
		int[][] shapeIdx = shape.currLook();
		int x = 0, y = 0;
		
		x = 1;
		y = 2;
		
			
		for (int[] pair: shapeIdx) {
			pair[0]+=x;
			pair[1]+=y;
			g2d.fillRect(pair[1]*25,pair[0]*25,25,25);
		}
	}
	
	public void setBlock(IShape block) {
		shape = block;
	}
}
