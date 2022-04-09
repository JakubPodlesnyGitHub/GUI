package GUI1.Zadanie9;

import java.util.ArrayList;

public class BankCustomer {
    Person wlasciciel;
    Account konto;
    ArrayList<Account> listaKont;

    public BankCustomer(Person wlasciciel) {
        this.wlasciciel = wlasciciel;
        this.konto = new Account();
        listaKont = new ArrayList<>();
        listaKont.add(konto);
    }

    public Account getAccount(){
        Account acc = listaKont.get(0);
        return acc;
    }

    @Override
    public String toString() {
        return "Klient: "+ wlasciciel.imie+" stan konta: "+ konto.balance;
    }
}
