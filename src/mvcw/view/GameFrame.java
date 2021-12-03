package MVC.View;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import MVC.model.LeftPanelModel;
import MVC.model.RightPanelModel;

public class GameFrame extends JFrame {

    private static final int game_x = 26;
    private static final int game_y = 12;
    JTextArea[][] text;
    private RightPanel RPanel;
    private LeftPanel LPanel;
    RightPanelModel rpm;
    LeftPanelModel lpm;
    
    public GameFrame() {
    	
    	rpm = new RightPanelModel();
    	lpm = new LeftPanelModel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tetris Battle");
        this.setSize(600, 800);
        this.setVisible(true);
        this.setResizable(false);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(creatMenus());
        RPanel = new RightPanel(new BorderLayout(), rpm);
        LPanel = new LeftPanel(lpm);
        this.add(LPanel,BorderLayout.CENTER);
        this.add(RPanel,BorderLayout.EAST);
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

}