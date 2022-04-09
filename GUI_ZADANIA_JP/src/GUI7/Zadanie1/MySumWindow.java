package GUI7.Zadanie1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

public class MySumWindow extends JFrame {
    JTextField jTextField1;
    JTextField jTextField2;
    JButton jButton;
    JPanel jPanel;

    public MySumWindow() {
        jTextField1 = new JTextField("0");
        jTextField1.setPreferredSize(new Dimension(100, 20));
        jTextField2 = new JTextField("0");
        jTextField2.setPreferredSize(new Dimension(100, 20));

        jButton = new JButton("a+b");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double wynik = Double.parseDouble(jTextField1.getText()) + Double.parseDouble(jTextField2.getText());
                showMessageDialog(null, wynik, "Wynik dodawania", JOptionPane.INFORMATION_MESSAGE, null);
            }
        });
        jPanel = new JPanel(new FlowLayout());
        jPanel.add(jTextField1);
        jPanel.add(jTextField2);
        jPanel.add(jButton);
        this.add(jPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 100);
        this.setLocationRelativeTo(null);
        this.setTitle("Zadanie1_SUMATOR");

    }
}
