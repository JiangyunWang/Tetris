package server;

public class PlayerInfo {
        int score;
        boolean win;
        boolean lose;


        public PlayerInfo(int score, boolean win, boolean lose){
            this.score = score;
            this.win = win;
            this.lose =  lose;
        }

        public PlayerInfo(){
            this.score = 0;
            this.win = false;
            this.lose = false;
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


}
