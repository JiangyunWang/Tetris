package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class s implements Runnable{
    private int port;
    private ServerSocket socket;
    private boolean running = false;

    public s(int port) {
        this.port = port;
        try {
            socket = new ServerSocket(port);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void start() {
        new Thread(this).start();
    }
    @Override
    public void run() {
        running = true;
//        while (running){
//            try {
//                Socket s = socket.accept();
//                initSocket(s);
//            }catch (IOException  e) {
//                e.printStackTrace();
//            }
//        }
//        shut
    }
}
