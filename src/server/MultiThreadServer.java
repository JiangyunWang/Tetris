package server;


import mvc.controller.Controller;

import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class MultiThreadServer extends JFrame implements Runnable {
    // Text area for displaying contents
    private JTextArea ta;

    // Number a client
    private int clientNo = -1;
    Map<Integer, PlayerInfo> players;

    public MultiThreadServer() {
        ta = new JTextArea(10,10);
        JScrollPane sp = new JScrollPane(ta);
        this.add(sp);
        this.setTitle("MultiThreadServer");
        this.setSize(400,200);
        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(8000);
            ta.append("MultiThreadServer started at "
                    + new Date() + '\n');

            while (true) {
                // Listen for a new connection request
                Socket socket = serverSocket.accept();

                // Increment clientNo
                clientNo++;

                ta.append("Starting thread for client " + clientNo +
                        " at " + new Date() + '\n');

                // Find the client's host name, and IP address
                InetAddress inetAddress = socket.getInetAddress();
                ta.append("Client " + clientNo + "'s host name is "
                        + inetAddress.getHostName() + "\n");
                ta.append("Client " + clientNo + "'s IP Address is "
                        + inetAddress.getHostAddress() + "\n");

                // Create and start a new thread for the connection
                new Thread(new HandleAClient(socket, clientNo)).start();
            }
        }
        catch(IOException ex) {
            System.err.println(ex);
        }

    }



    // Define the thread class for handling new connection
    class HandleAClient implements Runnable {
        private Socket socket; // A connected socket
        private int clientNum;
        private Controller player;

        /** Construct a thread */
        public HandleAClient(Socket socket, int clientNum) {
            this.socket = socket;
            this.clientNum = clientNum;
            if (!players.containsKey(clientNum)) {
                players.put(clientNum, new PlayerInfo());
            }
            this.player  = new Controller();
            player.setPlayer(clientNum);
            player.move();

        }

        /** Run a thread */
        public void run() {
            try {
                // Create data input and output streams
//                DataInputStream inputFromClient = new DataInputStream(
//                        socket.getInputStream());
//                DataOutputStream outputToClient = new DataOutputStream(
//                        socket.getOutputStream());
                ObjectInputStream fromClient = new ObjectInputStream(socket.getInputStream());

                // Create an output stream to send data to the server
                ObjectOutputStream toClient = new ObjectOutputStream(socket.getOutputStream());

                // Continuously serve the client
                while (true) {
                    // Receive radius from the client
                    // Read from input
                    try {
                        Object object = fromClient.readObject();

                        // Write to the file
                        PlayerInfo info = (PlayerInfo) object;
                        if (object!=null)  {
                            players.put(clientNum, info);
                        }

                        toClient.writeObject(players);
                        toClient.flush();
                    } catch (IOException ie) {
                        ie.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                }

            }
            catch(IOException ex) {
                ex.printStackTrace();
            }
        }
    }



    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        MultiThreadServer mts = new MultiThreadServer();
        mts.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mts.setVisible(true);
    }
}

