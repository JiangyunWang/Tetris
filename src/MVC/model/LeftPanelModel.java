package MVC.model;

import java.awt.Graphics;
import javax.swing.SwingUtilities;

public class LeftPanelModel {
	private static final int size = 25;
	private static final int ysize = 0;
	private static int xmax = size * 12;
	private static int ymax = size * 24;
	public static int[][] MAP;
	
	public LeftPanelModel (){
		MAP = new int[xmax/size][ysize/size];
		 for(int i = 0; i < xmax/size; ++i) {
			 for (int j = 0; j < ysize/size; ++j) {
				 MAP[i][j] = 0;
			 }
		 }
		
	 }
	
	
}