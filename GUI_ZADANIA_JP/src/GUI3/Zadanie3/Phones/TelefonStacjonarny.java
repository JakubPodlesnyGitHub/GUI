package GUI3.Zadanie3.Phones;

import GUI3.Zadanie3.InterFaces.TelefonStacjoInterfejs;
import GUI3.Zadanie3.Urzadzenie;

public class TelefonStacjonarny extends Urzadzenie implements TelefonStacjoInterfejs {

    public TelefonStacjonarny(String producent,double cena){
        nazwaProducenta = producent;
        cenaUrzadzenia = cena;
    }


    @Override
    public String toString() {
        return "Nazwa Urządzenia: TelefonStacjonarny: " + " Producent: " + nazwaProducenta + " Cena Urządzenia: " + cenaUrzadzenia;
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
