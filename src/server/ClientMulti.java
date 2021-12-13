package server;

import mvc.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.util.Map;

public class ClientMulti extends JFrame{
    ObjectOutputStream toServer = null;
    ObjectInputStream fromServer = null;
    Socket socket = null;
    JButton openButton;
    Controller player;

    public ClientMulti() {
        super("Client");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //**********yihan
        this.setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();

        openButton = new JButton("start Game");

        controlPanel.add(openButton);

        this.add(controlPanel);
        openButton.addActionListener(new OpenConnectionListener());
        setSize(400, 200);
        this.setVisible(true); //**********yihan
    }

    class OpenConnectionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            try {
                socket = new Socket("localhost", 8000);
                player = new Controller();
                DataInputStream in = new DataInputStream(socket.getInputStream());
                int id = in.readInt();
                System.out.println("The id of player is： "+id);
                player.setPlayer(id);
                player.move();
                run();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }

    }


    public void run() {
        try {
            fromServer = new ObjectInputStream(socket.getInputStream());

            toServer = new ObjectOutputStream(socket.getOutputStream());
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        PlayerInfo p = new PlayerInfo();
        while (true) {
        try {
            // Get the radius from the text field
            p.setScore(player.getRpm().getScore());
            p.setWin(player.getLpm().getGameOver());

            // Send the radius to the server
            toServer.writeObject(p);
            toServer.flush();

                // Read from input
            Object object = fromServer.readObject();

                // Write to the file
            Map<Integer,PlayerInfo> map = (Map)object;
            PlayerInfo self = map.get(player.getPlayer());
            PlayerInfo compe = null;
            for (Integer i: map.keySet()) {
                if (i!=player.getPlayer()) {
                    compe = map.get(i);
                }
            }

            if (compe!=null &&compe.isLose()) {
                player.getLpm().gameOver();
//                rpm shows win or lose
            }

            if (compe!=null &&compe.isWin()) {
                player.getLpm().gameOver();
//                rpm shows win or lose
            }


            }
        catch(IOException ex){
                System.err.println(ex);
            }
        catch (ClassNotFoundException ce) {
            System.err.println(ce);
        }
        }
    }


    public static void main(String[] args) {
        ClientMulti c = new ClientMulti();
        c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        c.setVisible(true);
    }
}
