package server;

import mvc.controller.Controller;

import java.io.*;
import java.net.Socket;
import java.util.Map;

public class ClientMulti {
    DataOutputStream toServer;
    DataInputStream fromServer;
    Socket socket = null;
    Controller player;
    int id = -1;

    public ClientMulti() {
        player = new Controller();
        run();
    }


    public void run() {
        while (!player.getGf().connected) {
            System.out.println("Wait for starting game!");
        }
        try {
            socket = new Socket("localhost", 8000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            id = in.readInt();
            player.getGf().setPlayer(id);



            player.move();

        } catch (IOException e) {
            e.printStackTrace();
        }


        while (true) {
            try {
                fromServer = new DataInputStream(socket.getInputStream());
                boolean isWin = fromServer.readBoolean();
                if (isWin) {
                    player.setWin();
                    player.getLpm().setGameOver(true);

                }

                    toServer = new DataOutputStream(socket.getOutputStream());
                    toServer.writeBoolean(player.getLpm().getGameOver());
                    toServer.flush();



            }
            catch(IOException ex){
                System.err.println(ex);
            }
        }
    }


    public static void main(String[] args) {
        ClientMulti c = new ClientMulti();
    }
}