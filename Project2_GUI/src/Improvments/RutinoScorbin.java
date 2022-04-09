package Improvments;

public class RutinoScorbin extends Improvemnt {
    public RutinoScorbin(String improvmentName, int numberOfHealthPeople, int pointsForUpgrading) {
        super(improvmentName, numberOfHealthPeople, pointsForUpgrading);
    }

    @Override
    public String toString() {
        return "Nazwa: " + improvmentName + " Ilosc Punktów: " + pointsForUpgrading + " Ilość ozdrowiałej ludności: " + numberOfHealthPeople;
    }
}
