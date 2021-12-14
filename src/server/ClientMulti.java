package server;

import mvc.controller.Controller;

import java.io.*;
import java.net.Socket;
import java.util.Map;

public class ClientMulti {
    ObjectOutputStream toServer = null;
    ObjectInputStream fromServer = null;
    Socket socket = null;
    Controller player;
    int id = -1;

    public ClientMulti() {
        player = new Controller();
        run();

    }


    public void run() {
//        player.getGf().connected = true;
        while (!player.getGf().connected) {
                System.out.println("Wait for starting game!");

        }
//        player.getGf().openButton.setFocusable(false);
        try {
            socket = new Socket("localhost", 8000);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            id = in.readInt();
            player.getGf().setPlayer(id);
            System.out.println("received from server: "+id);
            System.out.println("player id："+player.playerId);
            player.move();
            fromServer = new ObjectInputStream(socket.getInputStream());
            toServer = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
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
    }
}
