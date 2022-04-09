package Countries;

import Vehciles.Transport;

import java.util.ArrayList;


public class Country {
    public Continent continent;
    public String name;
    public double obszar;
    public ArrayList<Transport> transportArrayList;
    public int numberOfHealthyPeople;
    public int numberOfInfectedPeople;
    public int maxCountry;
    public Country(Continent continent, String name, double obszar,int numberOfHealthyPeople,int numberOfInfectedPeople) {
        this.continent = continent;
        this.name = name;
        this.obszar = obszar;
        this.numberOfHealthyPeople = numberOfHealthyPeople;
        this.numberOfInfectedPeople = numberOfInfectedPeople;
    }

    @Override
    public String toString() {
        return "\nSrodki Transportu -> " + transportArrayList;
    }
}
