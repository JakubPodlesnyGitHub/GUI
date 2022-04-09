package GUI3.Zadanie3;
import GUI3.Zadanie3.Phones.Smartfon;
import GUI3.Zadanie3.Phones.TelefonKomorkowy;
import GUI3.Zadanie3.Phones.TelefonStacjonarny;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        TelefonStacjonarny telefonStacjonarny1 = new TelefonStacjonarny("Samsung", 200);
        TelefonStacjonarny telefonStacjonarny2 = new TelefonStacjonarny("Xiaomi", 150);
        Konsola_Do_Gier konsola_do_gier1 = new Konsola_Do_Gier("Playstation", 400);
        Konsola_Do_Gier konsola_do_gier2 = new Konsola_Do_Gier("Nintendo", 300);
        Smartfon smartfon1 = new Smartfon("Nokia", 500);
        Smartfon smartfon2 = new Smartfon("Backberry", 50);
        TelefonKomorkowy telefonKomorkowy1 = new TelefonKomorkowy("Oppo", 175.55);
        TelefonKomorkowy telefonKomorkowy2 = new TelefonKomorkowy("Pixel", 180.55);
        Urzadzenie [] listaUrzadzen = new Urzadzenie[8];
        listaUrzadzen[0] = telefonStacjonarny1;
        listaUrzadzen[1] = telefonStacjonarny2;
        listaUrzadzen[2] = telefonKomorkowy1;
        listaUrzadzen[3] = telefonKomorkowy2;
        listaUrzadzen[4] = konsola_do_gier1;
        listaUrzadzen[5] = konsola_do_gier2;
        listaUrzadzen[6] = smartfon1;
        listaUrzadzen[7] = smartfon2;
        System.out.println("Przed posortowaniem: ");
        for(Urzadzenie u : listaUrzadzen){
            System.out.println(u);
        }
        System.out.println("Po sortowaniu: ");
        Arrays.sort(listaUrzadzen);
        for(Urzadzenie u : listaUrzadzen){
            System.out.println(u);
        }



    }
}
