package GUI1.Zadanie2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rozmiar = in.nextInt();
        int[] tablica = new int[rozmiar];
        System.out.println("Wpisz liczby do tablicy: ");
        for (int i = 0; i < rozmiar; i++) {
            tablica[i] = in.nextInt();
        }
        System.out.println(ileNieparzystych(tablica, rozmiar));
    }

    public static int ileNieparzystych(int[] tablica, int romziar) {
        int licznik = 0;
        for (int i = 0; i < tablica.length; i++) {
            if (tablica[i] % 2 == 1) {
                licznik++;
            }
        }
        return licznik;
    }
}
