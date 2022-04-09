package Improvments;

public class IncreasesForScientists extends Improvemnt {

    public IncreasesForScientists(String improvmentName, int numberOfHealthPeople, int pointsForUpgrading) {
        super(improvmentName, numberOfHealthPeople, pointsForUpgrading);
    }

    @Override
    public String toString() {
        return "Nazwa: " + improvmentName + " Ilosc Punktów: " + pointsForUpgrading + " Ilość ozdrowiałej ludności: " + numberOfHealthPeople;
    }
}
