package GUI2.Zadanie1;

public class Main {
    public static void main(String[] args) {


        Kwadrat k1 = new Kwadrat("Kwadrat", "czarny", 10);
        Kolo k2 = new Kolo("Kolo", "niebieski", 5);
        Prostokat p1 = new Prostokat("Prostokat", "bialy", 5, 4);
        Figura[] tablica = {k1, k2, p1};
        for (Figura tmp : tablica) {
            System.out.println(tmp);
        }
    }
}
