package Thredy;

import Countries.Country;
import GameScoresWindow.GameScoresWindow;
import GameWindow.GameWindowModel;
import GameWindow.GameWindowView;
import Other.FinalData;
import Other.Person;

import javax.swing.*;
import java.util.ArrayList;

public class RandomCountryHealingThread extends Thread {
    String level;
    TimeThread timeThread;
    JTextField jTextFieldNumberOFHealthyPeople;
    JTextField jTextFieldPoints;
    int healTime, points, healthy;
    ArrayList<Country> countries;
    Country selectedCountry;
    Person selectedPerson;
    int randomPersonIndex;
    GameScoresWindow gameScoresWindow;
    GameWindowView gameWindowView;
    GameWindowModel gameWindowModel;
    int allPeople;

    public RandomCountryHealingThread(JTextField jTextFieldNumberOFHealthyPeople, JTextField pointsTEXT, ArrayList<Country> countries, String level, TimeThread timeThread, int healTime, GameScoresWindow gameScoresWindow, GameWindowView gameWindowView, GameWindowModel gameWindowModel, int allPeople) {
        this.jTextFieldNumberOFHealthyPeople = jTextFieldNumberOFHealthyPeople;
        this.jTextFieldPoints = pointsTEXT;
        this.countries = countries;
        this.healTime = healTime;
        this.gameScoresWindow = gameScoresWindow;
        this.gameWindowView = gameWindowView;
        this.allPeople = allPeople;
        this.timeThread  = timeThread;
        this.level = level;
        this.gameWindowModel = gameWindowModel;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);//uspienie watku na 2 sekundy
        } catch (InterruptedException e) {
            System.err.println("!!Watek zostal przerwany.!!");
        }
        while (true) {
            try {
                if(Thread.currentThread().isInterrupted())
                    return;
                Thread.sleep(healTime); // uspienie watku na 10 sekund
                getRandomCountry();//wylosowanie kraju
                healingRandomPerson(); // wylosowanie osoby
                healing();//leczenie w petlach danych panstw wzaleznoci od danej osoby
                jTextFieldNumberOFHealthyPeople.setText(Integer.toString(healALL()));
                jTextFieldPoints.setText(Integer.toString(points));
                //System.out.println("Uleczono: " + healALL());
            } catch (Exception e) {
                System.err.println("!!Watek zostal przerwany.!!");
            }

        }

    }

    public int healALL() {
        healthy = 0;
        for (Country country : countries) {
            healthy += country.healthyPeople.size();//dodawnie wszystkich osob wyleczonych ze wszystkich panstw
        }
        //2 sposob wygrania
        if (healthy >= allPeople) {
            this.interrupt();//przerwanie watku
            timeThread.interrupt();
            gameWindowModel.setPlayerName(JOptionPane.showInputDialog(gameWindowView, "PODAJ SWOJE IMIE: ", "IMIE", JOptionPane.INFORMATION_MESSAGE));
            gameScoresWindow.addScoreList(new FinalData(timeThread.getLocalDateTMP().getLocalDate().toString(),level,gameWindowModel.getPlayerName(),getPoints()));
            gameWindowView.dispose();
            gameScoresWindow.setVisible(true);//pokazanie sie okna z rankingiem
        }
        return healthy;
    }


    public void healing() {
        if (selectedCountry.infectedCountry && !selectedCountry.healthyCountry) {//sprawdza czy dany kraj jest zainfekowny i czy nie był uleczony
            for (int i = randomPersonIndex; i < selectedCountry.people.size(); i++) {
                if (selectedCountry.people.get(i).isInfected() && !selectedCountry.people.get(i).isHealthy()) {//sprawdza czy dana osoba jest zakazona i czy nie byla leczona
                    selectedCountry.people.get(i).setHealthy(true);//"ulecznie danej osoby"
                    selectedCountry.healthyPeople.add(selectedCountry.people.get(i));//dodaje zdrowych ludzi do listy
                    selectedCountry.infecetdPeople.remove(selectedCountry.people.get(i));//usuwa zakazonych z kraju
                    points++;//dodaje punkty za kazdego wyzdrowialego
                }
            }
            for (int i = randomPersonIndex; i >= 0; i--) {
                if (selectedCountry.people.get(i).isInfected() && !selectedCountry.people.get(i).isHealthy()) {//sprawdza czy dana osoba jest zakazona i czy nie byla leczona
                    selectedCountry.people.get(i).setHealthy(true);//"ulecznie danej osoby"
                    selectedCountry.healthyPeople.add(selectedCountry.people.get(i));//dodaje zdrowych ludzi do listy
                    selectedCountry.infecetdPeople.remove(selectedCountry.people.get(i));//usuwa zakazonych z kraju
                    points++;//dodaje punkty za kazdego wyzdrowialego
                }
            }
            selectedCountry.healthyCountry = true;
        }
    }

    public void getRandomCountry() {//randomowy kraj
        int randomCountryIndex = (int) (Math.random() * countries.size());
        selectedCountry = countries.get(randomCountryIndex);
        //System.out.println("Kraj do uleczenia: " + selectedCountry);
    }

    public void healingRandomPerson() {//randomowa osoba
        randomPersonIndex = (int) (Math.random() * selectedCountry.people.size());
        selectedPerson = selectedCountry.people.get(randomPersonIndex);
        //System.out.println("Randomowa osoba do ulecznia: " + randomPersonIndex);
    }
    //--------------------------------------------GETERY I SETERY-------------------------------------------------------
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }
}
