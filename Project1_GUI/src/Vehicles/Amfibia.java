package Vehicles;


import InterFace.InterFacePojazdDrogowy;
import InterFace.InterFacePojazdPlywajacy;


public class Amfibia extends Transport implements InterFacePojazdDrogowy, InterFacePojazdPlywajacy {


    public Amfibia(VehiclesMake marka, String model, double pojemnosc, int iloscMiejscSiedzacyh) {
        super(marka, model, pojemnosc, iloscMiejscSiedzacyh);
    }

    public Amfibia(VehiclesMake marka, String model, int iloscMiejscSiedzacyh, double dlugosc, double szerokosc, double wysokosc) {
        super(marka, model, iloscMiejscSiedzacyh, dlugosc, szerokosc, wysokosc);
    }

    @Override
    public String toString() {
        return "AMFIBIA: " + "Marka-> " + marka + " Model-> " + model + " Dane techniczne: " + " Dlugość pojazdu-> " + "Ilość miejsc siedzących-> " + iloscMiejscSiedzacyh;
    }
    public void Strzelaj(boolean czyMaDziałko) {//podczas tworzenia tej funkcji założyłem że chodzi o amfibie produkowane podczas drugiej wojny światowej
        if (czyMaDziałko == true) {
            System.out.println("Ten pojazd potrafi strzelać");
        }
    }
}
