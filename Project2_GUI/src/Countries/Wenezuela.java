package Countries;

import InterFaces.CreateArrayListPeople;
import Other.Person;
import Vehicles.Transport;

import java.util.ArrayList;

public class Wenezuela extends Country implements CreateArrayListPeople {
    public ArrayList<Person> healthy;
    public ArrayList<Person> infected;
    boolean infectedCountryWenezuela;
    boolean healthyCountryWenezuela;
    public Wenezuela(Continent continent, String name, double obszar, int numberOfPeople, ArrayList<Transport> transportArrayList) {
        super(continent, name, obszar, numberOfPeople, transportArrayList);
        people = this.createArrayListPeople(numberOfPeople);
        healthy = new ArrayList<>();
        healthyPeople = healthy;
        infected = new ArrayList<>();
        infecetdPeople = infected;
        infectedCountryWenezuela = infectedCountry;
        healthyCountryWenezuela = healthyCountry;
        flyingVehicles = 150;
        floatingVehicleBoats = 265;
        floatingVehicleCargos = 369;
        railVehicles = 390;
        roadVehiclesAutocars = 425;
        roadVehiclesCars = 435;
        singleTrackVehicles = 481;
    }

    @Override
    public String toString() {
        return "Nazwa-> " + name + " Kontynet-> " + continent + " Obszar-> " + obszar + "Liczba całej ludnosci-> " + numberOfPeople + "Liczba Wyleczonych-> " + healthy.size() + " Liczba Zarażonych-> " + infected.size();
    }
}
