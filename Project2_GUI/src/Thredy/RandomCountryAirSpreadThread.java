package Thredy;


import Countries.Country;
import GameScoresWindow.GameScoresWindow;
import GameWindow.GameWindowView;
import Other.Person;

import javax.swing.*;
import java.util.ArrayList;

public class RandomCountryAirSpreadThread extends Thread {
    int timeSpreadVirus;
    ArrayList<Country> countries;
    Country selectedCountry;
    Person selectedPerson;
    JTextField jTextFieldInfected;
    int selectedPersonIndex;
    GameScoresWindow gameScoresWindow;
    GameWindowView gameWindowView;
    int allPeople;

    public RandomCountryAirSpreadThread(JTextField jTextFieldNumberOfInfectedPeople, int timeSpreadVirus, ArrayList<Country> countries, GameScoresWindow gameScoresWindow, GameWindowView gameWindowView, int allPeople) {
        this.jTextFieldInfected = jTextFieldNumberOfInfectedPeople;
        this.timeSpreadVirus = timeSpreadVirus;
        this.countries = countries;
        this.gameScoresWindow = gameScoresWindow;
        this.gameWindowView = gameWindowView;
        this.allPeople = allPeople;//przekazanie z int-a ze wszystkimi osobami
    }

    @Override
    public void run() {
        while (true) {
            try {
                if(Thread.currentThread().isInterrupted())
                    return;
                Thread.sleep(timeSpreadVirus);//usaypianie wątku na 2 sekuny
                randomCountry();//losowanie kraju w którym dochodzi do zarazenia
                randomPerson();//losowanie randomowej osoby(od nie zaczyna sie zakażanie)
                infection();//nastepuje infeckja(przechodzi w petlach od wybranego zarazonego)
                jTextFieldInfected.setText(Integer.toString(infectionALL()));//ustawienie tekstu
            } catch (InterruptedException e) {
                System.err.println("!!!Watek zostal przerwany!!!");
            }
        }
    }

    public void randomCountry() {//losowanie randomowego kraju
        int selectedCountryIndex = (int) (Math.random() * countries.size());
        selectedCountry = countries.get(selectedCountryIndex);
        //System.out.println("WYBRANY KRAJ: " + selectedCountry);
    }

    public void infection() {
        if(!selectedCountry.infectedCountry) {
            for (int i = selectedPersonIndex; i < selectedCountry.people.size(); i++) {
                if (!selectedCountry.people.get(i).isInfected()) {//sprawdzanie czy dana osoba jest juz zarazona
                    selectedCountry.people.get(i).setInfected(true);//flaga czy jest zarazony
                    selectedCountry.infecetdPeople.add(selectedCountry.people.get(i));//dodanie do zarazonych danej osoby w danym kraju
                }
            }
            for (int i = selectedPersonIndex; i >= 0; i--) {
                if (!selectedCountry.people.get(i).isInfected()) {//sprawdzanie czy dana osoba jest juz zarazona
                    selectedCountry.people.get(i).setInfected(true);//flaga czy jest zarazony
                    selectedCountry.infecetdPeople.add(selectedCountry.people.get(i));//dodanie do zarazonych danej osoby w danym kraju

                }
            }
            selectedCountry.infectedCountry = true;//zmienia na true jeśli dany kraj ma wszystkich ludzi zarażonych
        }
    }


    public void randomPerson() {//losowanie randomowej osoby
        selectedPersonIndex = (int) (Math.random() * selectedCountry.people.size());
        selectedPerson = selectedCountry.people.get(selectedPersonIndex);
        //System.out.println("WYBRANA OSOBA: " + selectedPersonIndex);
    }

    public int infectionALL() {
        int infected = 0;
        for (Country country : countries) {//zliczanie zarazonych we wszystkich krajach
            infected += country.infecetdPeople.size();
        }
        //1 sposob zakonczenia gry
        if (infected >= allPeople) {//sprawdzanie czy zarazonych jest wiecej lub tyle samo ludzi na swiecie
            this.interrupt();//przerwanie watku
            gameWindowView.dispose();//zakonczenie  i zamkniecie okna gry
            gameScoresWindow.setVisible(true);//pokazanie okna z wynikami
        }
        //System.out.println("Ilosc zarazonych: " + infected);
        return infected;
    }
}
