package mvc.controller;

import mvc.model.*;
import mvc.view.GameFrame;
import mvc.view.LeftPanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import database.Database;

public class Controller {
    private GameFrame gf;
    private LeftPanelModel lpm;
    private RightPanelModel rpm;
    private IShape nexShape;
    private IShape currShape;
    private int[][] map;
    public int playerId;

    public Controller() {

        this.rpm = new RightPanelModel();
        this.lpm = new LeftPanelModel(rpm, this);
        this.gf = new GameFrame(rpm, lpm, playerId);
        this.map = lpm.getMap();
        gf.setVisible(true);
        this.currShape = lpm.getBlock();
        // this.gf.addKeyListener(new MyListener());

    }

    public LeftPanelModel getLpm() {
        return lpm;
    }

    public RightPanelModel getRpm() {
        return rpm;
    }

    public void move() {
//        System.out.println("before loop");// *******************

        Timer timer1 = new Timer();

        timer1.schedule(new TimerTask() {
            @Override
            public void run() {

                lpm.goDown();
                gf.refresh();
                if (lpm.getGameOver()) {
                    timer1.cancel();
                   try {
					gameOverFlag();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                }
            }
        }, 1000, 1000);
    }


    public void gameOverFlag() throws SQLException {
	 JFrame jFrame = new JFrame();
	 
	 JOptionPane.showMessageDialog(jFrame, "Game Over! Your score is: " + rpm.getScore());
	Database db = new Database();
	ResultSet rset  = db.findTopThree();
	 JOptionPane.showMessageDialog(jFrame, "Game Over! Your score is: " + rpm.getScore());//!!!!!!!!!!
	while (rset.next() ) {
		
        String  score= rset.getString("score");
        String userName = rset.getString("userName");
        System.out.println(userName+ " " + score + " ");
	}
	 String getMessage = JOptionPane.showInputDialog(jFrame, "Enter your user name");
	 JOptionPane.showMessageDialog(jFrame, "Your message: "+getMessage);
	 
    }


    public int getPlayer() {
        return playerId;
    }

    public void setPlayer(int num) {
        this.playerId = num;
    }

    public GameFrame getGf(){
        return this.gf;
    }

    public void executeCommand(List<String> commands) {
        for (String s: commands) {
            switch (s) {
                case "l":
                    lpm.moveLeft();
                    break;
                case "r":
                    lpm.moveRight();
                    break;
                case "d":
                    lpm.goDown();
                    lpm.speedUp();
                    break;
                case "rotate":
                    lpm.setRotate();
                    break;
            }
            getGf().refresh();
        }

    }

}