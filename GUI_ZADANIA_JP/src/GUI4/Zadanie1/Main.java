package GUI4.Zadanie1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Osoba kowalski = new Osoba("Jan", "Kowalski");
        Osoba nowak = new Osoba("Adam", "Nowak");
        Osoba krawczyk = new Osoba("Bartosz", "Krawczyk");
        Osoba heniek = new Osoba("Kierownik", "Heniek");

        Samochod skoda1 = new Samochod("WA00001", Samochod.Marka.SKODA);
        Samochod skoda2 = new Samochod("SC36010", Samochod.Marka.SKODA);
        Samochod mazda1 = new Samochod("WA01234", Samochod.Marka.MAZDA);
        Samochod mazda2 = new Samochod("DW01ASD", Samochod.Marka.MAZDA);
        Samochod bmw = new Samochod("WA12690", Samochod.Marka.BMW);
        Samochod volvo = new Samochod("KR60606", Samochod.Marka.VOLVO);

        ArrayList<Samochod> samochodsKowalski = new ArrayList<>();
        samochodsKowalski.add(skoda1);
        samochodsKowalski.add(bmw);
        ArrayList<Samochod> samochodsNowak = new ArrayList<>();
        samochodsNowak.add(mazda2);
        ArrayList<Samochod> samochodsKrawczyk = new ArrayList<>();
        samochodsKrawczyk.add(skoda2);
        samochodsKrawczyk.add(mazda1);
        samochodsKrawczyk.add(volvo);
        ArrayList<Samochod> samochodsHeniek = new ArrayList<>();
        samochodsHeniek.add(null);

        HashMap<Osoba, ArrayList<Samochod>> hashMap = new HashMap<>();
        hashMap.put(kowalski, samochodsKowalski);
        hashMap.put(nowak, samochodsNowak);
        hashMap.put(krawczyk, samochodsKrawczyk);
        hashMap.put(heniek, samochodsHeniek);

        System.out.println(hashMap + "\n");

        System.out.println("Samochody których numer rejestracyjne zaczynaja sie na WA: ");

        /*for(ArrayList<Samochod> samochods : hashMap.values()){
            Pattern pattern = Pattern.compile("\bWA.*");
            Matcher matcher = pattern.matcher(samochods.);
            while(matcher.find()){
                System.out.println(s1);
            }
        }*/

        for (HashMap.Entry<Osoba, ArrayList<Samochod>> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey().imie + " " + entry.getKey().nazwisko + " posiada: " + entry.getValue().size());
        }

        System.out.println(hashMap.get(nowak).get(0));


    }
}
