package GUI3.Zadanie3.Phones;

import GUI3.Zadanie3.InterFaces.TelefonKomInterfejs;
import GUI3.Zadanie3.InterFaces.TelefonStacjoInterfejs;
import GUI3.Zadanie3.Urzadzenie;

public class TelefonKomorkowy extends Urzadzenie implements TelefonStacjoInterfejs, TelefonKomInterfejs {
    boolean sim;
    public TelefonKomorkowy(String producent,double cena){
        nazwaProducenta = producent;
        cenaUrzadzenia = cena;
    }@Override
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


    @Override
    public String toString() {
        return "Nazwa Urządzenia: TelefonKomórkowy: " + " Producent: " + nazwaProducenta + " Cena Urządzenia: " + cenaUrzadzenia;
    }
}
