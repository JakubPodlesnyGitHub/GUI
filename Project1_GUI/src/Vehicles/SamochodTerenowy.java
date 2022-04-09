package Vehicles;


import InterFace.InterFacePojazdDrogowy;


public class SamochodTerenowy extends Transport implements InterFacePojazdDrogowy {


    public SamochodTerenowy(VehiclesMake marka, String model, double pojemnosc, int iloscMiejscSiedzacyh) {
        super(marka, model, pojemnosc, iloscMiejscSiedzacyh);
    }

    public SamochodTerenowy(VehiclesMake marka, String model, int iloscMiejscSiedzacyh, double dlugosc, double szerokosc, double wysokosc) {
        super(marka, model, iloscMiejscSiedzacyh, dlugosc, szerokosc, wysokosc);
    }

    public void trudnetereny() {//cecha unikatowa
        System.out.println("Dzięki napędowi na 4 koła ,a takaże dużemu prześwitowi pomiędzy dolnymi częściami samochodu a podłożem samochód terenowy może poruszać się po trudnych terenach");
    }

    public void czyPosidaSkrzynieRozdzielczoRedukcyjna() {//ceha unikatowa
        System.out.println("Samochód terernowy w przeciwieństwie do innych pojazdów posiada skrzynie rozdzielczo-redukcyjną");
    }

    @Override
    public String toString() {
        return "SAMOCHÓD TERENOWY: " + "Marka-> " + marka + " Model-> " + model + " Ilość miejsc siedzących-> " + iloscMiejscSiedzacyh;
    }


}
