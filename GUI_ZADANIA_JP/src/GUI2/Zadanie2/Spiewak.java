package GUI2.Zadanie2;

public abstract class Spiewak {
    public String nazwisko;
    public static int numer = 1;
    public int numerSpiewaka;

    public Spiewak(String nazwisko) {
        this.nazwisko = nazwisko;
        numerSpiewaka = numer;
        numer += 1;
    }

    public abstract String spiewaj();

    public static Spiewak najglosniej(Spiewak[] tablica) {
        int licznik = 0;
        int max = 0;
        Spiewak s1 = null;
        for (int i = 0; i < tablica.length; i++) {
            for (int j = 0; j < tablica[i].spiewaj().length(); j++) {
                if ((tablica[i].spiewaj().charAt(0)) >= 'A' && (tablica[i].spiewaj().charAt(0)) <= 'Z') {
                    licznik++;
                }
            }
            if (max < licznik) {
                max = licznik;
                s1 = tablica[i];
            }
            licznik = 0;
        }

        return s1;
    }

    @Override
    public String toString() {
        return "Imie: " + nazwisko + " Numer: " + this.numerSpiewaka + " Tekst: " + spiewaj();
    }
}
