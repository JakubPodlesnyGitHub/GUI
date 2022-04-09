package GUI1.Zadanie8;

public class Main {
    public static void main(String[] args) {
        Cennik cennik = Cennik.getInstanceOf();
        cennik.wyswietlCennik();
        Sklep sklep = new Sklep(cennik, 10500); //cennik, budżet
        System.out.println(Pracownik.ileStworzonych);
        Pracownik pracownik = new Pracownik("Anna", "Nowak", 1990, "00023003203",23,1200);
        System.out.println(pracownik);
        System.out.println(Pracownik.ileStworzonych);
        try {
            sklep.zatrudnij(pracownik);
            sklep.zatrudnij("Jan", "Kowalski", 1982, "2039023032923", 43, 2000);
        }catch (TooManyEmployees e){
            e.getMessage();
        }catch (ToLitlle ex){
            ex.getCause();
        }
        sklep.wyswietlPracownikow();
        sklep.wyplacPensje();
        sklep.zwiekszBudzet(1000);
        cennik.ileKosztuje("jablko");
        cennik.ileKosztuje("kgakasdf");
    }
}
