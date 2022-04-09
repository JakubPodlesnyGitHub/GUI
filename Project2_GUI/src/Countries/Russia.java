package Countries;

import InterFaces.CreateArrayListPeople;
import Other.Person;
import Vehicles.Transport;

import java.util.ArrayList;


public class Russia extends Country implements CreateArrayListPeople {

    public ArrayList<Person> healthy;
    public ArrayList<Person> infected;
    boolean infectedCountryRussia;
    boolean healthyCountryRussia;
    public Russia(Continent continent, String name, double obszar, int numberOfPeople, ArrayList<Transport> transportArrayList) {
        super(continent, name, obszar, numberOfPeople, transportArrayList);
        people = this.createArrayListPeople(numberOfPeople);
        healthy = new ArrayList<>();
        healthyPeople = healthy;
        infected = new ArrayList<>();
        infecetdPeople = infected;
        infectedCountryRussia = infectedCountry;
        healthyCountryRussia = healthyCountry;
        flyingVehicles = 300;
        floatingVehicleBoats = 350;
        floatingVehicleCargos = 500;
        railVehicles = 600;
        roadVehiclesAutocars = 750;
        roadVehiclesCars = 800;
        singleTrackVehicles = 850;
    }

    @Override
    public String toString() {
        return "Nazwa-> " + name + " Kontynet-> " + continent + " Obszar-> " + obszar + "Liczba całej ludnosci-> " + numberOfPeople + "Liczba Wyleczonych-> " + healthy.size() + " Liczba Zarażonych-> " + infected.size();
    }
}
