package GUI1.Zadanie8;

public class Sklep {
    Pracownik[] zbiorPracownikow;
    double budget;
    private int index = 0;

    public Sklep(Cennik cennik, double budget) {
        zbiorPracownikow = new Pracownik[5];
        this.budget = budget;
    }

    public void zatrudnij(Pracownik p1) throws TooManyEmployees, ToLitlle {
        if (index < 5) {
            if (p1.wiek >= 18)
                zbiorPracownikow[index++] = p1;
            else
                throw new ToLitlle("Za mało lat");
        } else {
            throw new TooManyEmployees("Za dużo pracowników");
        }
    }

    public void zatrudnij(String imie, String nazwisko, int wiek, String pesel, int id, int pensja) throws TooManyEmployees, ToLitlle {
        Pracownik p1 = new Pracownik(imie, nazwisko, wiek, pesel, id, pensja);
        if (index < 5) {
            if (wiek >= 18)
                zbiorPracownikow[index++] = p1;
            else
                throw new ToLitlle("Za mało lat");
        } else {
            throw new TooManyEmployees("Za dużo pracowników");
        }
    }

    public void wyplacPensje() {
        for (int i = 0; i < zbiorPracownikow.length; i++) {
            if(zbiorPracownikow[i] != null)
                budget -= zbiorPracownikow[i].pensja;
        }
        if(budget > 0) {
            System.out.println("Budget po wyplaceniu pensji: " + budget);
        }else if(budget == 0){
            System.out.println("Budget wynosi: " + budget);
        }else {
            System.out.println("Budget jest po niżej zera");
        }
    }

    public void zwiekszBudget(int kwota) {
        if (kwota > 0)
            budget += kwota;
        else
            System.out.println("Kwota jest ujemna");
    }

    public void wyswietlPracownikow() {
        System.out.println("-----Lista Pracowników-------");
        for (int i = 0; i < zbiorPracownikow.length; i++) {
            if (zbiorPracownikow[i] != null)
                System.out.println(zbiorPracownikow[i]);
        }
    }

    public void zwiekszBudzet(int liczba) {
        this.budget += liczba;
        System.out.println("Stan budżetu po wpłacie " + budget);
    }
}
