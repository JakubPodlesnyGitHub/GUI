package GUI6.Zadanie1;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
           Window1 window1 = new Window1();
           window1.setVisible(true);
        });
        }
    }