package MVC.View;

import javax.swing.JLabel;
import javax.swing.JDialog;
import java.awt.*;
    public class About extends JDialog {
        private int width;
        private int height;
        public About(){
            setLayout(null);
            setBackground(Color.red);
            width = Toolkit.getDefaultToolkit().getScreenSize().width;
            height = Toolkit.getDefaultToolkit().getScreenSize().height;
            setBounds((width - 300)/ 2, (height - 300) / 2,300,300);
            add();
            this.setVisible(true); 
        }

        private void add() {
            JLabel jLabel=new JLabel("Game Name: Tetris");
            jLabel.setBounds(60, 40, 180, 60);
            add(jLabel);

            jLabel=new JLabel("Version: 1.0 ");
            jLabel.setBounds(60, 90, 180, 60);

            add(jLabel);

            jLabel=new JLabel("By Jiangyun W"
            		+ " & Yihan W");
            jLabel.setBounds(60,140, 180, 60);
            add(jLabel);
        }



    }

