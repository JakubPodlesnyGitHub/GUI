package GUI2.Zadanie2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Spiewak s1 = new Spiewak("Eminem") {
            @Override
            public String spiewaj() {
                return "Jak TO Moze Byc";
            }
        };
        Spiewak s2 = new Spiewak("Eagles") {
            @Override
            public String spiewaj() {
                return "AAAAAAAAAAAAAADDDDDDDDDDDDDSD";
            }
        };
        Spiewak s3 = new Spiewak("Dżem") {
            @Override
            public String spiewaj() {
                return "spsosad";
            }
        };
        Spiewak sp[] = {s1, s2, s3};
        for (Spiewak s : sp) System.out.println(s);
        System.out.println("\n" + Spiewak.najglosniej(sp));
    }
}
