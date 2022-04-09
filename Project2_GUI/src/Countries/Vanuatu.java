package Countries;

import InterFaces.CreateArrayListPeople;
import Other.Person;
import Vehicles.Transport;

import java.util.ArrayList;


public class Vanuatu extends Country implements CreateArrayListPeople {
    public ArrayList<Person> healthy;
    public ArrayList<Person> infected;
    boolean infectedCountryVanuatu;
    boolean healthyCountryVanuatu;
    public Vanuatu(Continent continent, String name, double obszar, int numberOfPeople, ArrayList<Transport> transportArrayList) {
        super(continent, name, obszar, numberOfPeople, transportArrayList);
        people = this.createArrayListPeople(numberOfPeople);
        healthy = new ArrayList<>();
        healthyPeople = healthy;
        infected = new ArrayList<>();
        infecetdPeople = infected;
        infectedCountryVanuatu = infectedCountry;
        healthyCountryVanuatu = healthyCountry;
        flyingVehicles = 20;
        floatingVehicleBoats = 30;
        floatingVehicleCargos = 41;
        railVehicles = 51;
        roadVehiclesAutocars = 61;
        roadVehiclesCars = 71;
        singleTrackVehicles = 81;
    }

    @Override
    public String toString() {
        return "Nazwa-> " + name + " Kontynet-> " + continent + " Obszar-> " + obszar + "Liczba całej ludnosci-> " + numberOfPeople + "Liczba Wyleczonych-> " + healthy.size() + " Liczba Zarażonych-> " + infected.size();
    }
}
