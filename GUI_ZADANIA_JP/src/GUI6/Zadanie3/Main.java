package GUI6.Zadanie3;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            dipslayLayout();
            Scanner scanner = new Scanner(System.in);
            int wyborLayout = scanner.nextInt();
            MyThirdWindow myThirdWindow = new MyThirdWindow(wyborLayout);
            myThirdWindow.setVisible(true);
        });
    }
    public static void dipslayLayout(){
        System.out.println("1.Układ BorderLayout");
        System.out.println("2.Układ FlowLayout z wyrównaniem do lewej");
        System.out.println("3.Układ FlowLayout z wyrównaniem do prawej");
        System.out.println("4.Układ FlowLayout");
        System.out.println("5.Układ GridLayout – jako jeden wiersz");
        System.out.println("6.Układ GridLayout – jako jedna kolumna");
        System.out.println("7.Układ GridLayout – jako tabela 2 wiersze, 3 kolumny");
    }
}
