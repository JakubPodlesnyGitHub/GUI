package GUI1.Zadanie4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Podaj liczbe: ");
        System.out.println(sumaMniejszych(in.nextInt()));
    }

    public static int sumaMniejszych(int liczba) {
        if (liczba == 0) {
            return 0;
        }
        return liczba + sumaMniejszych(liczba - 1);
    }
}
