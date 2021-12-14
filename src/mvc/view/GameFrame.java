package mvc.view;

//import java.awt.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import mvc.model.IShape;
import mvc.model.LeftPanelModel;
import mvc.model.RightPanelModel;
import server.ClientMulti;

public class GameFrame extends JFrame {

    private RightPanel rPanel;
    private LeftPanel lPanel;
    public JButton openButton;
    JPanel controlPanel;
    public boolean connected;
    private int playerId;
    private List<String> command;

    // RightPanelModel rpm;
    // LeftPanelModel lpm;

    public GameFrame(RightPanelModel rpm, LeftPanelModel lpm, int id) {
        this.playerId = id;
        this.command = new ArrayList<>();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tetris Battle");
        this.setSize(600, 800);

        this.setResizable(false);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(creatMenus());

        controlPanel = new JPanel();

        rPanel = new RightPanel(new BorderLayout(), rpm);
        lPanel = new LeftPanel(lpm);
        this.add(lPanel, BorderLayout.CENTER);
        this.add(rPanel, BorderLayout.EAST);
        this.add(controlPanel, BorderLayout.NORTH);
        this.setVisible(true);
        setJMenuBar(menuBar);
        connected = false;
        this.addKeyListener(new MyListener());
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
        item.addActionListener((n) -> new About());
        return item;
    }

    public JMenuItem creatFileExitItem() {
        JMenuItem item = new JMenuItem("Exit");
        item.addActionListener((n) -> System.exit(0));
        return item;
    }
    // how to add gameover

    // *******WJY*******

    public LeftPanel getlPanel() {
        return this.lPanel;
    }

    /*
     * public void setBoard(int[][] map) {
     * this.board = map;
     * }
     * 
     * public void setBlock(IShape s) {
     * this.block = s;
     * }
     * 
     * //*******for testing
     * public void keyMovement(IShape s) {
     * lPanel.addKeyListener(
     * new KeyListener() {
     * 
     * @Override
     * public void keyTyped(KeyEvent e) {
     * 
     * }
     * 
     * @Override
     * public void keyPressed(KeyEvent e) {
     * int dir = e.getKeyCode();
     * switch (dir) {
     * case KeyEvent.VK_LEFT:
     * s.moveLeft();
     * case KeyEvent.VK_RIGHT:
     * s.moveRight();
     * case KeyEvent.VK_DOWN:
     * lPanel.speedUp();
     * case KeyEvent.VK_SPACE:
     * s.setRotate();
     * 
     * }
     * }
     * 
     * @Override
     * public void keyReleased(KeyEvent e) {
     * int dir = e.getKeyCode();
     * if (dir==KeyEvent.VK_DOWN) {
     * lPanel.speedBack();
     * }
     * }
     * }
     * );
     * }
     * 
     */

    public void refresh() {

        lPanel.repaint();
        rPanel.refresh();
    }

    class OpenConnectionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            connected = true;
        }

    }

    class MyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyPressed(KeyEvent e) {
            // System.out.println("key pressed: user id"+playerId);
            int dir = e.getKeyCode();
            if (playerId == 0) {
                switch (dir) {
                    case KeyEvent.VK_LEFT:
                        lPanel.getModel().moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT:
                        lPanel.getModel().moveRight();
                        break;
                    case KeyEvent.VK_DOWN:
                        lPanel.getModel().goDown();
                        lPanel.getModel().speedUp();
                        break;
                    case KeyEvent.VK_UP:
                        lPanel.getModel().setRotate();
                        break;
                    case KeyEvent.VK_SPACE:
                        connected = true;

                    case KeyEvent.VK_A:
                        command.add("l");
                        break;
                    case KeyEvent.VK_D:
                        lPanel.getModel().moveRight();
                        command.add("r");
                        break;
                    case KeyEvent.VK_S:
                        command.add("d");
                        break;
                    case KeyEvent.VK_W:
                        command.add("rotate");
                        break;

                }
            } else {
                switch (dir) {
                    case KeyEvent.VK_A:
                        lPanel.getModel().moveLeft();
                        break;
                    case KeyEvent.VK_D:
                        lPanel.getModel().moveRight();
                        break;
                    case KeyEvent.VK_S:
                        lPanel.getModel().goDown();
                        lPanel.getModel().speedUp();
                        break;
                    case KeyEvent.VK_W:
                        lPanel.getModel().setRotate();
                        break;
                    case KeyEvent.VK_SPACE:
                        connected = true;

                    case KeyEvent.VK_LEFT:
                        command.add("l");
                        break;
                    case KeyEvent.VK_RIGHT:
                        command.add("r");
                        break;
                    case KeyEvent.VK_DOWN:
                        command.add("d");
                        break;
                    case KeyEvent.VK_UP:
                        command.add("rotate");
                        break;
                }
            }
            refresh();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int dir = e.getKeyCode();
            if (playerId == 0) {
                if (dir == KeyEvent.VK_DOWN) {
                    lPanel.getModel().speedBack();
                }
            } else {
                if (dir == KeyEvent.VK_S) {
                    lPanel.getModel().speedBack();
                }
            }

        }

    }

    public void setPlayer(int num) {
        this.playerId = num;
        if (num == 0) {
            setTitle("Tetris Battle:player 1");
        } else {
            setTitle("Tetris Battle:player 2");
        }

    }

    public List<String> getCommand() {
        List<String> temp = this.command;
        command = new ArrayList<>();
        return temp;
    }
}