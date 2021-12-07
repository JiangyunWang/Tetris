package mvc.view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import mvc.model.IShape;
import mvc.model.LeftPanelModel;
import mvc.model.RightPanelModel;


public class GameFrame extends JFrame {

    private static final int game_x = 26;
    private static final int game_y = 12;
    JTextArea[][] text;
    private RightPanel rPanel;
    private LeftPanel lPanel;
    private int[][] board;
    private IShape block;
//    RightPanelModel rpm;
//    LeftPanelModel lpm;
    
    public GameFrame() {
    	
//    	rpm = new RightPanelModel();
//    	lpm = new LeftPanelModel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tetris Battle");
        this.setSize(600, 800);
        this.setVisible(true);
        this.setResizable(false);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(creatMenus());
//        Panel = new RightPanel(new BorderLayout(), rpm);
//        lPanel = new LeftPanel(lpm);
//        this.add(lPanel,BorderLayout.CENTER);
//        this.add(Panel,BorderLayout.EAST);
        setJMenuBar(menuBar);
    }

    private JMenu creatAboutMenus() {
    	 JMenu menu = new JMenu("About");
    	 menu.add(creatAboutMenu());
    	 return null;
	}

	private JMenu creatMenus() {
        JMenu menu = new JMenu("File");
        menu.add(creatFileExitItem());
        menu.add(creatAboutMenu());
        return menu;
    }
    public JMenuItem creatAboutMenu() {
        JMenuItem item = new JMenuItem("About");
        item.addActionListener((n)->new About());
        return item;
    }


    public JMenuItem creatFileExitItem() {
        JMenuItem item = new JMenuItem("Exit");
        item.addActionListener((n)->System.exit(0));
        return item;
    }
//how to add gameover
    public JLabel gameOver() {
    	JLabel l = new JLabel();
    	l.setText("GameOver!");
    	return l;
    }

//    *******WJY*******
    public void setBoard(int[][] map) {
        this.board = map;
    }

    public void setBlock(IShape s) {
        this.block  = s;
    }

    public void keyMovement(IShape s) {
        lPanel.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        int dir = e.getKeyCode();
                        switch (dir) {
                            case KeyEvent.VK_LEFT:
                                s.moveLeft();
                            case KeyEvent.VK_RIGHT:
                                s.moveRight();
                            case KeyEvent.VK_DOWN:
                                lPanel.speedUp();
                            case KeyEvent.VK_SPACE:
                                s.setRotate();

                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                        int dir =  e.getKeyCode();
                        if (dir==KeyEvent.VK_DOWN)  {
                            lPanel.speedBack();
                        }
                    }
                }
        );
    }

    private void leftMovement() {
        //1. reach the bound of the board
        //2.  left most has block
        IShape curr = s.
        if ()
    }

}