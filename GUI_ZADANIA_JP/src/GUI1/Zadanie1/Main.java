package GUI1.Zadanie1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        wyswietlZnaki();
    }
    public static void wyswietlZnaki(){
        Scanner in = new Scanner(System.in);
        char litera1 = in.next().charAt(0);
        char litera2 = in.next().charAt(0);
        for(int i = litera1+1;i<litera2;i++){
            System.out.println((char)i);
        }
    }
}
