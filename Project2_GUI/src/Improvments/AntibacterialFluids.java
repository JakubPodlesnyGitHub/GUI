package Improvments;

public class AntibacterialFluids extends Improvemnt {
    public AntibacterialFluids(String improvmentName, int numberOfHealthPeople, int pointsForUpgrading) {
        super(improvmentName, numberOfHealthPeople, pointsForUpgrading);
    }

    @Override
    public String toString() {
        return "Nazwa: " + improvmentName + " Ilosc Punktów: " + pointsForUpgrading + " Ilość ozdrowiałej ludności: " + numberOfHealthPeople;
    }
}
