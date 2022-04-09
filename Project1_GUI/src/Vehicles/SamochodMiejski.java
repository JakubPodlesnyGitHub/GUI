package Vehicles;


import InterFace.InterFacePojazdDrogowy;

public class SamochodMiejski extends Transport implements InterFacePojazdDrogowy {


    public SamochodMiejski(VehiclesMake marka, String model, double pojemnosc, int iloscMiejscSiedzacyh) {
        super(marka, model, pojemnosc, iloscMiejscSiedzacyh);
    }

    public SamochodMiejski(VehiclesMake marka, String model, int iloscMiejscSiedzacyh, double dlugosc, double szerokosc, double wysokosc) {
        super(marka, model, iloscMiejscSiedzacyh, dlugosc, szerokosc, wysokosc);
    }

    @Override
    public String toString() {
        return "SAMOCHÓD MIEJSKI: " + "Nazwa-> " + marka + " Model-> " + model +  " Ilość miejsc siedzących-> " + iloscMiejscSiedzacyh;
    }

    public void niskieSpalanie(){//cecha unikatowa
        System.out.println("Samochód miejski posiada niskie spalanie");
    }
}
