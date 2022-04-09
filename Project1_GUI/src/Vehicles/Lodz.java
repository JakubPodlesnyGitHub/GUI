package Vehicles;


import InterFace.InterFacePojazdPlywajacy;



public class Lodz extends Transport implements InterFacePojazdPlywajacy{


    public Lodz(VehiclesMake marka, String model, double pojemnosc, int iloscMiejscSiedzacyh) {
        super(marka, model, pojemnosc, iloscMiejscSiedzacyh);
    }

    public Lodz(VehiclesMake marka, String model, int iloscMiejscSiedzacyh, double dlugosc, double szerokosc, double wysokosc) {
        super(marka, model, iloscMiejscSiedzacyh, dlugosc, szerokosc, wysokosc);
    }

    @Override
    public String toString() {
        return "LÓDŹ: " + "Nazwa-> " + marka + " Model-> " + model + " Dane techniczne: "  + " Ilość miejsc siedzących-> " + iloscMiejscSiedzacyh;
    }

    public void wyjmijWiosla(){//cecha unikatowa
        System.out.println("Wiosła zostały wyjęte");
    }
    public void podniesZagiel(){//cecha unikatowa
        System.out.println("Żagiel został podniesiony");
    }
}
