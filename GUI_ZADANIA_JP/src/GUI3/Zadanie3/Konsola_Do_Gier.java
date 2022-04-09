package GUI3.Zadanie3;

import GUI3.Zadanie3.InterFaces.KonsolaInterfejs;

public class Konsola_Do_Gier extends Urzadzenie implements KonsolaInterfejs {

    public Konsola_Do_Gier(String producent,double cena){
        nazwaProducenta = producent;
        cenaUrzadzenia = cena;
    }

    @Override
    public String toString() {
        return "Nazwa Urządzenia: Konsola Do Gier: " + " Producent: " + nazwaProducenta + " Cena Urządzenia: " + cenaUrzadzenia;
    }

    @Override
    public void setDostepDoInternetu(boolean wartosc_Internet) {
        boolean mozliwoscDostepuDoInternetu = wartosc_Internet;
        if(mozliwoscDostepuDoInternetu == false)
            System.out.println("Brak połączenia z siecią WIFI!!!");
        else
            System.out.println("Połączono z siecią UPC!" );
    }

    @Override
    public void Granie() {
        System.out.println("Mozna zacząć rozgrywke!");
    }
}
