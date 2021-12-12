package server;

import mvc.controller.Controller;

import java.io.*;
import java.net.Socket;

public class Client extends Thread{
    /*
    protected Socket socket;
    int playerNum;
    Controller player;
    int competitorScore;

    public Client(Socket s, int cnt){
        this.socket = s;
        this.playerNum = cnt;
        player = new Controller(cnt);
    }

    public void run() {
        InputStream inp = null;
        BufferedReader brinp = null;
        DataOutputStream out = null;
        try {
            inp = socket.getInputStream();
            brinp = new BufferedReader(new InputStreamReader(inp));
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            return;
        }
        String line;
        while (true) {
            try {
                line = brinp.readLine();
                if ((line == null) || line.equalsIgnoreCase("QUIT")) {
                    socket.close();
                    return;
                } else {
                    out.writeBytes(line + "\n\r");
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
    }

*/
}
