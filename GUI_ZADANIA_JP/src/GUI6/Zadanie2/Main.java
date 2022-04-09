package GUI6.Zadanie2;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MySecondWindow mySecondWindow = new MySecondWindow();
            mySecondWindow.setVisible(true);
        });
    }
}
