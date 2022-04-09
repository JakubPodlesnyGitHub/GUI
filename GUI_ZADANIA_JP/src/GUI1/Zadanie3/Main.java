package GUI1.Zadanie3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rozmiar = in.nextInt();
        int[][] tablica = new int[rozmiar][rozmiar];
        System.out.println("Wpisz liczby do tablicy: ");
        for (int i = 0; i < tablica.length; i++) {
            for (int j=0;j<tablica.length;j++) {
                tablica[i][j] = (int)(Math.random()*12);
                System.out.print(tablica[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        odbicie(tablica,rozmiar);
    }

    public static void odbicie(int[][] tablica, int rozmiar) {
        for (int i = 0; i < tablica.length; i++) {
            for (int j = tablica[i].length-1; j >= 0; j--) {
                System.out.print(tablica[i][j]);
            }
            System.out.println();
        }
    }
}
