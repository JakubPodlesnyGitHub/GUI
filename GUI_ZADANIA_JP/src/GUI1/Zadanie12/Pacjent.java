package GUI1.Zadanie12;

public abstract class Pacjent {
    String imie;

    public Pacjent(String imie) {
        this.imie = imie;

    }
    public abstract String nazwisko();


    public abstract String choroba();

    public abstract String leczenie();
}
