package Thredy;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeThread extends Thread{
    LocalDate data = LocalDate.now();//odczytywanie obecnej daty
    LocalDateTMP localDateTMP;//klasa pomocnicza do przechowywania klasy
    JTextField jTextField;

    public TimeThread(JTextField jTextField) {
        this.jTextField = jTextField;
        localDateTMP = new LocalDateTMP(data);//przekazanie do konstruktora dzisiejszej daty oraz utworzenie obiektu kasy pomocniczej
    }

    @Override
    public void run() {
        while (true) {
            try {
                if(Thread.currentThread().isInterrupted())
                    return;
                Thread.sleep(5000);//usypia watek na 5 sekund
                data = data.plusDays(1);//Doadnie 1 dnia do daty
                localDateTMP.setLocalDate(data);// seter aby data caly czas sie zmieniala
                jTextField.setText(localDateTMP.getLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))); // ustawianie sforamtowanej(DateTimeFormater) daty pobrajnej przez geter w jTextFiledzie
            } catch (InterruptedException e) {
                System.err.println("!!Watek zostal przerwany.!!");
            }
        }
    }

    public LocalDateTMP getLocalDateTMP() {
        return localDateTMP;
    }
}
