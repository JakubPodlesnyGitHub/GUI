package Vehicles;



public class Transport {
    public VehiclesMake marka;
    public String model;
    public double pojemnosc; // w m^3
    public int iloscMiejscSiedzacyh;


    public Transport(VehiclesMake marka,String model, double pojemnosc, int iloscMiejscSiedzacyh) {
        this.model = model;
        this.pojemnosc = pojemnosc;
        this.iloscMiejscSiedzacyh = iloscMiejscSiedzacyh;
        this.marka = marka;
    }
    public Transport(VehiclesMake marka,String model, int iloscMiejscSiedzacyh, double dlugosc, double szerokosc,double wysokosc) {
        this.model = model;
        this.pojemnosc = (dlugosc*szerokosc*wysokosc);
        this.iloscMiejscSiedzacyh = iloscMiejscSiedzacyh;
        this.marka = marka;
    }

}
