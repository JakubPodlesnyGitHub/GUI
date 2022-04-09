package GUI6.Zadanie3;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Flow;

public class MyThirdWindow extends JFrame {
    JPanel jPanel;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton b5;

    public MyThirdWindow(int wybor) {
        jPanel = new JPanel();
        b1 = new JButton("Przycisk1");
        b2 = new JButton("Przycisk2");
        b3 = new JButton("Przycisk3");
        b4 = new JButton("Przycisk4");
        b5 = new JButton("Przycisk5");
        if (wybor == 1) {
            jPanel.setLayout(new BorderLayout());
            jPanel.add(b1, BorderLayout.NORTH);
            jPanel.add(b2, BorderLayout.SOUTH);
            jPanel.add(b3, BorderLayout.CENTER);
            jPanel.add(b4, BorderLayout.WEST);
            jPanel.add(b5, BorderLayout.EAST);
        } else {
            switch (wybor) {
                case 2:
                    jPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                    break;
                case 3:
                    jPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

                    break;
                case 4:
                    jPanel.setLayout(new FlowLayout());

                    break;
                case 5:
                    jPanel.setLayout(new GridLayout(1, 0));

                    break;
                case 6:
                    jPanel.setLayout(new GridLayout(0, 1));

                    break;
                case 7:
                    jPanel.setLayout(new GridLayout(2, 3));

                    break;
            }
            jPanel.add(b1);
            jPanel.add(b2);
            jPanel.add(b3);
            jPanel.add(b4);
            jPanel.add(b5);
        }

        this.add(jPanel);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Zadanie3");
    }
}
