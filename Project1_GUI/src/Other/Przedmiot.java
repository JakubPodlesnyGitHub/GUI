package Other;

import javax.swing.*;

public class Przedmiot implements Comparable {
    public String name;
    public double objetoscPrzedmiotu;

    public Przedmiot(String name, double objetoscPrzedmiotu) {
        this.name = name;
        this.objetoscPrzedmiotu = objetoscPrzedmiotu;
    }
    public Przedmiot(String name, double dlugosc, double szerekosc,double wysokosc) {
        this.name = name;
        this.objetoscPrzedmiotu = (dlugosc*szerekosc*wysokosc);
    }
    @Override
    public int compareTo(Object o) { // do porównywania objętosci przedmiotu
        Przedmiot przedmiot = (Przedmiot) (o);
        if(this !=  przedmiot)
            return (int) (przedmiot.objetoscPrzedmiotu-objetoscPrzedmiotu);//sortowanie malejaco
        else
            return  name.compareTo(przedmiot.name);//sorotwanie wedlug nazwy
    }

    @Override
    public String toString() {
        return "Nazwa przedmiotu -> " + name + " Objętosc przedmiotu: " + objetoscPrzedmiotu + " m^3";
    }



}
