package GUI7.Zadanie2;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() ->{
            MyCalculatorWindow myCalculatorWindow = new MyCalculatorWindow();
            myCalculatorWindow.setVisible(true);
        });
    }
}
