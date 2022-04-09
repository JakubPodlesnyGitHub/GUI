package GUI7.Zadanie1;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MySumWindow sumWindow = new MySumWindow();
            sumWindow.setVisible(true);
        });

    }
}
