package GUI1.Zadanie8;

public class Pracownik {
    //public static boolean ileStworzonych;
    public String imie;
    public String nazwisko;
    public int wiek;
    public String pesel;
    public int id;
    public int pensja;
    public static int ileStworzonych;
    public Pracownik(String imie, String nazwisko, int wiek, String pesel, int id, int pensja) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.pesel = pesel;
        this.id = id;
        this.pensja = pensja;
        this.ileStworzonych++;
    }
    @Override
    public String toString() {
        return "Imie: " + imie + " Nazwisko: " + nazwisko + " Wiek: " + wiek + " Pesel: " + pesel + " Id: " + id + " Pensja: " + pensja;
    }


}
