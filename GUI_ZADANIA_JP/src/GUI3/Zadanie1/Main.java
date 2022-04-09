package GUI3.Zadanie1;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Square s1 = new Square(10);
        Square s2 = new Square(2);
        Square s3 = new Square(12);
        Square s4 = new Square(15);
        Square s5 = new Square(20);
        ArrayList<Square> tablica = new ArrayList<>();
        tablica.add(s1);
        tablica.add(s2);
        tablica.add(s3);
        tablica.add(s4);
        tablica.add(s5);
        System.out.println("Przed sortowaniem: ");
        System.out.println(tablica);
        System.out.println("Po sortowaniu: ");
        Collections.sort(tablica);
        System.out.println(tablica);
    }
}
