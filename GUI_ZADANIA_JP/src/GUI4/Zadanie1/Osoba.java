package GUI4.Zadanie1;

public class Osoba {
    String imie;
    String nazwisko;

    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + " -> ";
    }
}
