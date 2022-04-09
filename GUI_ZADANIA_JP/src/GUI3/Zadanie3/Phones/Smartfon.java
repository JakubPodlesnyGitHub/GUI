package GUI3.Zadanie3.Phones;

import GUI3.Zadanie3.InterFaces.KonsolaInterfejs;
import GUI3.Zadanie3.InterFaces.TelefonKomInterfejs;
import GUI3.Zadanie3.InterFaces.TelefonStacjoInterfejs;
import GUI3.Zadanie3.Urzadzenie;

public class Smartfon extends Urzadzenie implements KonsolaInterfejs, TelefonKomInterfejs, TelefonStacjoInterfejs {
    boolean sim;
    public Smartfon(String producent,double cena){
        nazwaProducenta = producent;
        cenaUrzadzenia = cena;
    }

    @Override
    public String toString() {
        return "Nazwa Urządzenia: Smartfon: " + " Producent: " + nazwaProducenta + " Cena Urządzenia: " + cenaUrzadzenia;
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


    @Override
    public void sms() {
        if(sim==true)
            System.out.println("Mozna pisac SMS");
        else
            System.out.println("Nie mozna pisac SMS");

    }

    @Override
    public void setSim(boolean CzyJestKartaSim) {
        if(CzyJestKartaSim == true){
            sim=true;
            System.out.println("Jest karta sim");

        }else{
            sim=false;
            System.out.println("Nie ma kart sim");
        }
    }

    @Override
    public void dzwon(boolean Mozliwoscdzwonienia) {
        if(Mozliwoscdzwonienia == true){
            System.out.println("Można dzwonić");
        }else{
            System.out.println("Nie mozna dzwonić");
        }
    }
}
