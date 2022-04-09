package GUI4.Zadanie1;

public class Samochod {
    Marka marka;
    String numerRejestracyjnyPojazdu;

    public Samochod(String numerRejestracyjnyPojazdu, Marka marka) {
        this.marka = marka;
        this.numerRejestracyjnyPojazdu = numerRejestracyjnyPojazdu;
    }

    public enum Marka {
        SKODA,MAZDA,VOLVO,AUDI,BMW,SEAT,PORSCHE,FERRARI,NISSAN,OPEL
    }

    @Override
    public String toString() {
        return " Marka: " + marka + " NumerRejestracyjny: " + numerRejestracyjnyPojazdu;
    }
}
