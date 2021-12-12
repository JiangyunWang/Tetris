package server;

import mvc.controller.Controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class Server {
    /*
    private ObjectOutputStream outputToFile;
    private ObjectInputStream inputFromClient;
    Map<Integer, Controller> players;
    int cnt = -1;

    public static void main(String[] args) {
        new Server();

    }

    public Server() {
        players = new HashMap<>();
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started ");

            // Create an object ouput stream
//            outputToFile = new ObjectOutputStream(
//                    new FileOutputStream("student.dat", true));
//            for (int i: player) {
//                   outputToFile = new ObjectOutputStream(
//                    new FileOutputStream("student.dat", true));
//            }

            while (true) {
                // Listen for a new connection request
                Socket socket = serverSocket.accept();

                // Create an input stream from the socket
                inputFromClient =
                        new ObjectInputStream(socket.getInputStream());

                // Read from input
                Object object = inputFromClient.readObject();

                // Write to the file
                Controller player = (Controller) object;
                int p = player.getPlayer();
                if (p>cnt) {
                    cnt++;
                    players.put(cnt, new Controller(cnt));
                    new Client(socket, cnt).start();
                }
                System.out.println("got object " + player.getPlayer());
                outputToFile.writeObject(object);
                outputToFile.flush();
                System.out.println("A new student object is stored");
            }
        }
        catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
        finally {
            try {
                inputFromClient.close();
                outputToFile.close();
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

     */
}
