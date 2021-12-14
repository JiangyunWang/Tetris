package server;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerInfo {
        int score;
        boolean win;
        boolean lose;
        List<String> command;
        boolean start;


        public PlayerInfo(int score, boolean win, boolean lose, List<String> command){
            this.score = score;
            this.win = win;
            this.lose =  lose;
            this.command = command;
        }

        public PlayerInfo(){
            this.score = 0;
            this.win = false;
            this.lose = false;
            this.command = new ArrayList<>();
            this.start =  false;
        }

        public int getScore() {
            return score;
        }

        public boolean isWin() {
            return win;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public void setWin(boolean win) {
            this.win = win;
        }

    public void setLose(boolean lose) {
        this.lose = lose;
    }
    public boolean isLose() {
        return lose;
    }

    public List<String> getCommand() {
            return command;
    }

    public void setCommand(List<String> c) {
            this.command = c;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public boolean isStart() {
            return start;
    }
}

