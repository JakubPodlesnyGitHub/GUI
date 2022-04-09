package GUI1.Zadanie11;

public class Pacjent {
    String imie;


    public Pacjent(String imie) {
        this.imie = imie;

    }

    public String nazwisko() {
        return imie;
    }
    public String choroba() {
        return"nic";
    }
    public String leczenie() {
        return"nic";
    }
}
