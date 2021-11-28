package MVC.View;

import java.awt.GridLayout;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class GameFrame extends JFrame {

    private static final int game_x = 26;
    private static final int game_y = 12;
    JTextArea[][] text;


    public GameFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tetris Battle");
        this.setSize(500, 300);
        this.setVisible(true);
        this.setResizable(false);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(creatMenus());
    }

    private JMenu creatMenus() {
        JMenu menu = new JMenu("File");

		/*class OpenActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				OpenFileListener myFileListener = new OpenFileListener();
				myFileListener.actionPerformed(e);
			}
		}
		OpenActionListener listener = new OpenActionListener();*/

        menu.add(creatAboutMenu());
        menu.add(creatFileExitItem());
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

	/*public void initGamePanel() {
		JPanel game_main = new JPanel();
		game_main.setLayout(new GridLayout(game_x, game_y, hgap:1, vgap:1));

	}*/


    public static void main(String[] args) {
        GameFrame GameFrame = new GameFrame();
        GameFrame.setVisible(true);
    }
}