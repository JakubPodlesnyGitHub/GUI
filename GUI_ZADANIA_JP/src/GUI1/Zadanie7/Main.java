package GUI1.Zadanie7;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Podaj rozmiar: ");
        Scanner in = new Scanner(System.in);
        int rozmiar = in.nextInt();
        int[] tablica = new int[rozmiar];

        losuj(tablica, rozmiar);

        System.out.println("Przed sortowaniem");
        printTablica(tablica);

        System.out.println("Po sortowaniu MERGE SORT");
        Sortowanie ob = new Sortowanie();
        ob.sort(tablica, 0, tablica.length - 1);
        printTablica(tablica);

        losuj(tablica, rozmiar);

        System.out.println("Przed sortowaniem");
        printTablica(tablica);

        System.out.println("Po sortowaniu SELECTION SORT");
        ob.sort(tablica);
        printTablica(tablica);

        losuj(tablica, rozmiar);

        System.out.println("Przed sortowaniem");
        printTablica(tablica);

        System.out.println("Po sortowaniu INSERTION SORT ");
        ob.sortI(tablica);
        printTablica(tablica);
    }

    public static void losuj(int[] tablica, int rozmiar) {

        for (int i = 0; i < rozmiar; i++) {
            tablica[i] = (int) (Math.random() * 15 + 1);
        }
    }

    public static void printTablica(int[] tablica) {
        for (int i = 0; i < tablica.length; i++) {
            System.out.println(tablica[i] + " ");
        }
    }
}
