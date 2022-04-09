package Vehicles;


import InterFace.InterFacePojazdDrogowy;


public class Motocykl extends Transport implements InterFacePojazdDrogowy{


    public Motocykl(VehiclesMake marka, String model, double pojemnosc, int iloscMiejscSiedzacyh) {
        super(marka, model, pojemnosc, iloscMiejscSiedzacyh);
    }

    public Motocykl(VehiclesMake marka, String model, int iloscMiejscSiedzacyh, double dlugosc, double szerokosc, double wysokosc) {
        super(marka, model, iloscMiejscSiedzacyh, dlugosc, szerokosc, wysokosc);
    }

    @Override
    public String toString() {
        return "MOTOCYKL: " + "Nazwa-> " + marka + " Model-> " + model +  " Ilość miejsc siedzących-> " + iloscMiejscSiedzacyh;
    }

    public void poruszanieSieWZatloczonychMiejscach(){//cecha unikatowa
        System.out.println("Dzięki motocylkowi możesz poruszać po zatłoczonych drogach miasta i omijać korki ");
    }


}
