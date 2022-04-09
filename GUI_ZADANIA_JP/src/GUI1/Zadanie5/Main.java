package GUI1.Zadanie5;

public class Main {
    public static void main(String[] args) {
    String nazwa = "Ala ma kota";
    szyfrCezara(nazwa,2);
    }

    public static void szyfrCezara(String ciagznakow, int przesuniecie) {
        String ciagznakowZmieniony = "";
        for (int i = 0; i < ciagznakow.length(); i++) {
            if (ciagznakow.charAt(i) == ' ') {
                ciagznakow.replace(' ', '?');
            } else {
                ciagznakowZmieniony += (char)((ciagznakow.charAt(i) + przesuniecie));
            }
        }
        System.out.println(ciagznakowZmieniony);
    }
}
