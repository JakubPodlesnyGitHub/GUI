package Countries;

import InterFaces.CreateArrayListPeople;
import Other.Person;
import Vehicles.Transport;

import java.util.ArrayList;


public class Pakistan extends Country implements CreateArrayListPeople {

    public ArrayList<Person> healthy;
    public ArrayList<Person> infected;
    boolean infectedCountryPakistan;
    boolean healthyCountryPakistan;
    public Pakistan(Continent continent, String name, double obszar, int numberOfPeople, ArrayList<Transport> transportArrayList) {
        super(continent, name, obszar, numberOfPeople, transportArrayList);
        people = this.createArrayListPeople(numberOfPeople);
        healthy = new ArrayList<>();
        healthyPeople = healthy;
        infected = new ArrayList<>();
        infecetdPeople = infected;
        infectedCountryPakistan = infectedCountry;
        healthyCountryPakistan = healthyCountry;
        flyingVehicles = 200;
        floatingVehicleBoats = 100;
        floatingVehicleCargos = 500;
        railVehicles = 150;
        roadVehiclesAutocars = 206;
        roadVehiclesCars = 309;
        singleTrackVehicles = 320;

    }

    @Override
    public String toString() {
        return "Nazwa-> " + name + " Kontynet-> " + continent + " Obszar-> " + obszar + "Liczba całej ludnosci-> " + numberOfPeople + "Liczba Wyleczonych-> " + healthy.size() + " Liczba Zarażonych-> " + infected.size();
    }
}
