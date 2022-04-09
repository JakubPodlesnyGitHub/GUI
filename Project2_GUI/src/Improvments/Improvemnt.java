package Improvments;

public class Improvemnt  {
    public int numberOfHealthPeople;//ilosc zdrowych ludzi które dane ulepszenie uzdrawia
    public int pointsForUpgrading;//koszt w postaci punktów  danego ulepszenia
    public String improvmentName;// nazwa ulepszenia
    public Improvemnt(String improvmentName,int numberOfHealthPeople,int pointsForUpgrading){
        this.improvmentName = improvmentName;
        this.numberOfHealthPeople = numberOfHealthPeople;
        this.pointsForUpgrading = pointsForUpgrading;
    }
}
