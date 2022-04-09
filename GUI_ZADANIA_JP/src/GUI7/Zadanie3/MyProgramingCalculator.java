package GUI7.Zadanie3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyProgramingCalculator extends JFrame implements ActionListener {
    JButton liczba1, liczba2, liczba3, liczba4, liczba5, liczba6, liczba7, liczba8, liczba9, liczba0, liczbaA, liczbaB, liczbaC, liczbaD, liczbaE, liczbaF, ce, minus, plus, wynik;
    JRadioButton szesnastkowy, dziesietny, binarny;
    JLabel system;
    JPanel paneloperacyjny, systemliczbowy;
    ButtonGroup buttonGroup;
    JTextField pole;
    int wynikDzialan = 0, wartosc1 = 0, wartosc2 = 0;
    String operacja;
    JSplitPane jSplitPane;

    public MyProgramingCalculator() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setTitle("Zadanie3_Kalkulator_Systemowy");
        ////////////////////////////////////
        system = new JLabel("System Liczbowy");
        paneloperacyjny = new JPanel(new GridLayout(5, 4));
        systemliczbowy = new JPanel();
        buttonGroup = new ButtonGroup();
        pole = new JTextField();
        pole.setEnabled(false);
        //-------------------------------
        liczba1 = new JButton("1");
        liczba2 = new JButton("2");
        liczba3 = new JButton("3");
        liczba4 = new JButton("4");
        liczba5 = new JButton("5");
        liczba6 = new JButton("6");
        liczba7 = new JButton("7");
        liczba8 = new JButton("8");
        liczba9 = new JButton("9");
        liczba0 = new JButton("0");
        liczbaA = new JButton("A");
        liczbaB = new JButton("B");
        liczbaC = new JButton("C");
        liczbaD = new JButton("D");
        liczbaE = new JButton("E");
        liczbaF = new JButton("F");
        ce = new JButton("CE");
        minus = new JButton("-");
        plus = new JButton("+");
        wynik = new JButton("=");
        //---------------------------
        paneloperacyjny.add(liczba1);
        paneloperacyjny.add(liczba2);
        paneloperacyjny.add(liczba3);
        paneloperacyjny.add(liczba4);
        paneloperacyjny.add(liczba4);
        paneloperacyjny.add(liczba5);
        paneloperacyjny.add(liczba6);
        paneloperacyjny.add(liczba7);
        paneloperacyjny.add(liczba8);
        paneloperacyjny.add(liczba9);
        paneloperacyjny.add(liczba0);
        paneloperacyjny.add(liczbaA);
        paneloperacyjny.add(liczbaB);
        paneloperacyjny.add(liczbaC);
        paneloperacyjny.add(liczbaD);
        paneloperacyjny.add(liczbaE);
        paneloperacyjny.add(liczbaF);
        paneloperacyjny.add(ce);
        paneloperacyjny.add(minus);
        paneloperacyjny.add(plus);
        paneloperacyjny.add(wynik);
        liczba0.setEnabled(true);
        liczba1.setEnabled(true);
        liczba2.setEnabled(true);
        liczba3.setEnabled(true);
        liczba4.setEnabled(true);
        liczba5.setEnabled(true);
        liczba6.setEnabled(true);
        liczba7.setEnabled(true);
        liczba8.setEnabled(true);
        liczba9.setEnabled(false);
        liczbaA.setEnabled(false);
        liczbaB.setEnabled(false);
        liczbaC.setEnabled(false);
        liczbaD.setEnabled(false);
        liczbaE.setEnabled(false);
        liczbaF.setEnabled(false);
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
        liczbaA.addActionListener(this::actionPerformed);
        liczbaB.addActionListener(this::actionPerformed);
        liczbaC.addActionListener(this::actionPerformed);
        liczbaD.addActionListener(this::actionPerformed);
        liczbaE.addActionListener(this::actionPerformed);
        liczbaF.addActionListener(this::actionPerformed);
        minus.addActionListener(this::actionPerformed);
        ce.addActionListener(this::actionPerformed);
        wynik.addActionListener(this::actionPerformed);
        plus.addActionListener(this::actionPerformed);
        szesnastkowy = new JRadioButton("szesnastkowy");
        dziesietny = new JRadioButton("dziesietny");
        binarny = new JRadioButton("binarny");
        buttonGroup.add(szesnastkowy);
        buttonGroup.add(dziesietny);
        buttonGroup.add(binarny);
        systemliczbowy.add(szesnastkowy);
        systemliczbowy.add(dziesietny);
        systemliczbowy.add(binarny);
        //----------------------------------
//        this.add(paneloperacyjny, BorderLayout.SOUTH);
//        this.add(systemliczbowy, BorderLayout.CENTER);
        this.add(pole, BorderLayout.NORTH);
        jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, systemliczbowy, paneloperacyjny);
        this.add(jSplitPane);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String operator = e.getActionCommand();
        String liczba = e.getActionCommand();

        //Przyciski panelu operacyjnego
        if (liczba.equals("0")) {
            pole.setText(pole.getText() + "0");
        } else if (liczba.equals("1")) {
            pole.setText(pole.getText() + "1");
        } else if (liczba.equals("2")) {
            pole.setText(pole.getText() + "2");
        } else if (liczba.equals("3")) {
            pole.setText(pole.getText() + "3");
        } else if (liczba.equals("4")) {
            pole.setText(pole.getText() + "4");
        } else if (liczba.equals("5")) {
            pole.setText(pole.getText() + "5");
        } else if (liczba.equals("6")) {
            pole.setText(pole.getText() + "6");
        } else if (liczba.equals("7")) {
            pole.setText(pole.getText() + "7");
        } else if (liczba.equals("8")) {
            pole.setText(pole.getText() + "8");
        } else if (liczba.equals("9")) {
            pole.setText(pole.getText() + "9");
        } else if (liczba.equals("A")) {
            pole.setText(pole.getText() + "A");
        } else if (liczba.equals("B")) {
            pole.setText(pole.getText() + "B");
        } else if (liczba.equals("C")) {
            pole.setText(pole.getText() + "C");
        } else if (liczba.equals("D")) {
            pole.setText(pole.getText() + "D");
        } else if (liczba.equals("E")) {
            pole.setText(pole.getText() + "E");
        } else if (liczba.equals("F")) {
            pole.setText(pole.getText() + "F");
        }

        //DZIESIETNY
        if (dziesietny.isSelected()) {
            if (operator.equals("+")) {
                wartosc1 = Integer.parseInt(pole.getText());
                this.operacja = operator;
                pole.setText("");
            } else if (operator.equals("-")) {
                wartosc1 = Integer.parseInt(pole.getText());
                this.operacja = operator;
                pole.setText("");
            } else if (operator.equals("=")) {
                try {
                    wartosc2 = Integer.parseInt(pole.getText());
                    switch (operacja) {
                        case "+":
                            wynikDzialan = wartosc1 + wartosc2;
                            break;
                        case "-":
                            wynikDzialan = wartosc1 - wartosc2;
                            break;
                    }
                    pole.setText(Integer.toString(wynikDzialan));
                } catch (NumberFormatException ex) {
                    System.err.println("Pusty kalkulator!");
                }
            }
        }
        //BINARNY
        if (binarny.isSelected()) {
            liczba2.setEnabled(false);
            liczba3.setEnabled(false);
            liczba4.setEnabled(false);
            liczba5.setEnabled(false);
            liczba6.setEnabled(false);
            liczba7.setEnabled(false);
            liczba8.setEnabled(false);
            liczba9.setEnabled(false);
            if (operator.equals("+")) {
                wartosc1 = Integer.parseInt(pole.getText(),2);
                this.operacja = operator;
                pole.setText("");
            } else if (operator.equals("-")) {
                wartosc1 = Integer.parseInt(pole.getText(),2);
                this.operacja = operator;
                pole.setText("");
            } else if (operator.equals("=")) {
                try {
                    wartosc2 = Integer.parseInt(pole.getText(),2);
                    switch (operacja) {
                        case "+":
                            wynikDzialan = wartosc1 + wartosc2;
                            break;
                        case "-":
                            wynikDzialan = wartosc1 - wartosc2;
                            break;
                    }
                    pole.setText(Integer.toString(wynikDzialan,2));
                } catch (NumberFormatException ex) {
                    System.err.println("Pusty kalkulator!");
                }
            }
        }
        //SZESNASTKOWY
        if (szesnastkowy.isSelected()) {
            liczbaA.setEnabled(true);
            liczbaB.setEnabled(true);
            liczbaC.setEnabled(true);
            liczbaD.setEnabled(true);
            liczbaE.setEnabled(true);
            liczbaF.setEnabled(true);
            liczba0.setEnabled(true);
            liczba1.setEnabled(true);
            liczba2.setEnabled(true);
            liczba3.setEnabled(true);
            liczba4.setEnabled(true);
            liczba5.setEnabled(true);
            liczba6.setEnabled(true);
            liczba7.setEnabled(true);
            liczba8.setEnabled(true);
            if (operator.equals("+")) {
                wartosc1 = Integer.parseInt(pole.getText(),16);
                this.operacja = operator;
                pole.setText("");
            } else if (operator.equals("-")) {
                wartosc1 = Integer.parseInt(pole.getText(),16);
                this.operacja = operator;
                pole.setText("");
            } else if (operator.equals("=")) {
                try {
                    wartosc2 = Integer.parseInt(pole.getText(),16);
                    switch (operacja) {
                        case "+":
                            wynikDzialan = wartosc1 + wartosc2;
                            break;
                        case "-":
                            wynikDzialan = wartosc1 - wartosc2;
                            break;
                    }
                    pole.setText(Integer.toString(wynikDzialan,16));
                } catch (NumberFormatException ex) {
                    System.err.println("Pusty kalkulator!");
                }
            }
        }
        if (operator.equals("CE")) {
            wynikDzialan = 0;
            wartosc1 = 0;
            wartosc2 = 0;
            pole.setText("");
        }
    }
}