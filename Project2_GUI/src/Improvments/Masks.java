package Improvments;

public class Masks extends Improvemnt {

    public Masks(String improvmentName, int numberOfHealthPeople, int pointsForUpgrading) {
        super(improvmentName, numberOfHealthPeople, pointsForUpgrading);
    }
    @Override
    public String toString() {
        return "Nazwa: NAJLEPSZY LEK NA WIRUSA" + improvmentName + " Ilosc Punktów: " + pointsForUpgrading + " Ilość ozdrowiałej ludności: " + numberOfHealthPeople;
    }
}
