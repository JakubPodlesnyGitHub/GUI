package GUI7.Zadanie3;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            MyProgramingCalculator myProgramingCalculator = new MyProgramingCalculator();
            myProgramingCalculator.setVisible(true);
        });
    }
}
