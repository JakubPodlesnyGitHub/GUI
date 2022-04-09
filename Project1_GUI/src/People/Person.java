package People;

public class Person implements Comparable{
    public String imie;
    public String nazwisko;
    public String pesel;
    public String adres;
    public String dataUrodzenia;


    public Person(String imie, String nazwisko, String pesel, String adres, String dataUrodzenia){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.adres = adres;
        this.dataUrodzenia = dataUrodzenia;
    }

    @Override
    public String toString() {
        return "Imie: " + imie + " Nazwisko: " + nazwisko + " Pesel: " + pesel + " Adres: " + adres + " DataUrodzenia: " + dataUrodzenia  ;
    }

    @Override
    public int compareTo(Object o) {
        Person person = (Person)o;
        return nazwisko.compareTo(person.nazwisko);
    }
}
