package Countries;

import InterFaces.CreateArrayListPeople;
import Other.Person;
import Vehicles.Transport;

import java.util.ArrayList;

public class Nigeria extends Country implements CreateArrayListPeople {
    public ArrayList<Person> healthy;
    public ArrayList<Person> infected;
    boolean infectedCountryNigeria;
    boolean healthyCountryNigeria;
    public Nigeria(Continent continent, String name, double obszar, int numberOfPeople, ArrayList<Transport> transportArrayList) {
        super(continent, name, obszar, numberOfPeople, transportArrayList);
        people = this.createArrayListPeople(numberOfPeople);
        healthy = new ArrayList<>();
        healthyPeople = healthy;
        infected = new ArrayList<>();
        infecetdPeople = infected;
        infectedCountryNigeria = infectedCountry;
        healthyCountryNigeria = healthyCountry;
        flyingVehicles = 10;
        floatingVehicleBoats= 22;
        floatingVehicleCargos= 75;
        railVehicles=30;
        roadVehiclesAutocars=65;
        roadVehiclesCars = 71;
        singleTrackVehicles= 70;

    }

    @Override
    public String toString() {
        return "Nazwa-> " + name + " Kontynet-> " + continent + " Obszar-> " + obszar + "Liczba całej ludnosci-> " + numberOfPeople + "Liczba Wyleczonych-> " + healthy.size() + " Liczba Zarażonych-> " + infected.size();
    }
}
