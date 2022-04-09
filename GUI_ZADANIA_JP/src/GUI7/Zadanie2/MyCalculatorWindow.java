package GUI7.Zadanie2;

import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyCalculatorWindow extends JFrame implements ActionListener {
    JTextField jTextField;
    JButton liczba0, liczba1, liczba2, liczba3, liczba4, liczba5, liczba6, liczba7, liczba8, liczba9, mnozenie, dzielenie, dodawanie, odejmowanie, kropka, wynik, wyczysc;
    JPanel panelLiczb, panelOperacji;
    double wynikDzialan = 0;
    double wartosc1 = 0;
    double wartosc2 = 0;
    String operacja;
    public MyCalculatorWindow() {
        jTextField = new JTextField("");
        jTextField.setEditable(false);
        liczba0 = new JButton("0");
        liczba1 = new JButton("1");
        liczba2 = new JButton("2");
        liczba3 = new JButton("3");
        liczba4 = new JButton("4");
        liczba5 = new JButton("5");
        liczba6 = new JButton("6");
        liczba7 = new JButton("7");
        liczba8 = new JButton("8");
        liczba9 = new JButton("9");
        kropka = new JButton(".");
        mnozenie = new JButton("*");
        dzielenie = new JButton("/");
        dodawanie = new JButton("+");
        odejmowanie = new JButton("-");
        wyczysc = new JButton("C");
        wynik = new JButton("=");
        liczba0.addActionListener(this::actionPerformed);
        liczba1.addActionListener(this::actionPerformed);
        liczba2.addActionListener(this::actionPerformed);
        liczba3.addActionListener(this::actionPerformed);
        liczba4.addActionListener(this::actionPerformed);
        liczba5.addActionListener(this::actionPerformed);
        liczba6.addActionListener(this::actionPerformed);
        liczba7.addActionListener(this::actionPerformed);
        liczba8.addActionListener(this::actionPerformed);
        liczba9.addActionListener(this::actionPerformed);
        kropka.addActionListener(this::actionPerformed);
        odejmowanie.addActionListener(this::actionPerformed);
        dodawanie.addActionListener(this::actionPerformed);
        mnozenie.addActionListener(this::actionPerformed);
        dzielenie.addActionListener(this::actionPerformed);
        wyczysc.addActionListener(this::actionPerformed);
        wynik.addActionListener(this::actionPerformed);
        panelLiczb = new JPanel(new GridLayout(4, 3));
        panelOperacji = new JPanel(new GridLayout());
        panelLiczb.add(liczba0);
        panelLiczb.add(liczba1);
        panelLiczb.add(liczba2);
        panelLiczb.add(liczba3);
        panelLiczb.add(liczba4);
        panelLiczb.add(liczba5);
        panelLiczb.add(liczba6);
        panelLiczb.add(liczba7);
        panelLiczb.add(liczba8);
        panelLiczb.add(liczba9);
        panelLiczb.add(kropka);
        panelOperacji.add(dodawanie);
        panelOperacji.add(odejmowanie);
        panelOperacji.add(mnozenie);
        panelOperacji.add(dzielenie);
        panelOperacji.add(wyczysc);
        panelOperacji.add(wynik);
        this.add(panelLiczb, BorderLayout.CENTER);
        this.add(panelOperacji, BorderLayout.EAST);
        this.add(jTextField, BorderLayout.NORTH);
        //-----------------------------------------------------------
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(650, 650);
        this.setLocationRelativeTo(null);
        this.setTitle("Zadanie2_Kalkulator");
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String liczbaoprator = e.getActionCommand();

        if (liczbaoprator.equals("1")) {
            jTextField.setText(jTextField.getText() + "1");
        } else if (liczbaoprator.equals("2")) {
            jTextField.setText(jTextField.getText() + "2");
        } else if (liczbaoprator.equals("3")) {
            jTextField.setText(jTextField.getText() + "3");
        } else if (liczbaoprator.equals("4")) {
            jTextField.setText(jTextField.getText() + "4");
        } else if (liczbaoprator.equals("5")) {
            jTextField.setText(jTextField.getText() + "5");
        } else if (liczbaoprator.equals("6")) {
            jTextField.setText(jTextField.getText() + "6");
        } else if (liczbaoprator.equals("7")) {
            jTextField.setText(jTextField.getText() + "7");
        } else if (liczbaoprator.equals("8")) {
            jTextField.setText(jTextField.getText() + "8");
        } else if (liczbaoprator.equals("9")) {
            jTextField.setText(jTextField.getText() + "9");
        } else if (liczbaoprator.equals("0")) {
            jTextField.setText(jTextField.getText() + "0");
        } else if (liczbaoprator.equals("+")) {
            wartosc1 = Double.parseDouble(jTextField.getText());
            this.operacja = liczbaoprator;
            jTextField.setText("");
        } else if (liczbaoprator.equals(".")) {
            jTextField.setText(jTextField.getText() + ".");
        } else if (liczbaoprator.equals("-")) {
            wartosc1 = Double.parseDouble(jTextField.getText());
            this.operacja = liczbaoprator;
            jTextField.setText("");
        } else if (liczbaoprator.equals("*")) {
            wartosc1 = Double.parseDouble(jTextField.getText());
            this.operacja = liczbaoprator;
            jTextField.setText("");
        } else if (liczbaoprator.equals("/")) {
            wartosc1 = Double.parseDouble(jTextField.getText());
            this.operacja = liczbaoprator;
            jTextField.setText("");
        } else if (liczbaoprator.equals("=")) {
           try {
               wartosc2 = Double.parseDouble(jTextField.getText());
               switch (operacja) {
                   case "+":
                       wynikDzialan = wartosc1 + wartosc2;
                       break;
                   case "-":
                       wynikDzialan = wartosc1 - wartosc2;
                       break;
                   case "/":
                       wynikDzialan = wartosc1 / wartosc2;
                       if(wartosc2 == 0){
                           JOptionPane.showMessageDialog(this,wynikDzialan,"DZIELENIE PRZEZ ZERO",JOptionPane.WARNING_MESSAGE,null);
                           jTextField.setText("");
                       }
                       break;
                   case "*":
                       wynikDzialan = wartosc1 * wartosc2;
                       break;
               }
               if(wartosc2 != 0)
                   jTextField.setText(Double.toString(wynikDzialan));
           }catch (NumberFormatException ex){
               System.err.println("Pusty kalkulator!");
           }
        } else if (liczbaoprator.equals("C")) {
            wartosc1 = 0;
            wartosc2 = 0;
            jTextField.setText("");
        }
    }
}
