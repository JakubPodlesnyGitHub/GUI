package Countries;

import InterFaces.CreateArrayListPeople;
import Other.Person;
import Vehicles.Transport;

import java.util.ArrayList;

public class Surinam extends Country implements CreateArrayListPeople {
    public ArrayList<Person> healthy;
    public ArrayList<Person> infected;
    boolean infectedCountrySurinam;
    boolean healthyCountrySurinam;
    public Surinam(Continent continent, String name, double obszar, int numberOfPeople, ArrayList<Transport> transportArrayList) {
        super(continent, name, obszar, numberOfPeople, transportArrayList);
        people = this.createArrayListPeople(numberOfPeople);
        healthy = new ArrayList<>();
        healthyPeople = healthy;
        infected = new ArrayList<>();
        infecetdPeople = infected;
        healthyCountrySurinam = healthyCountry;
        infectedCountrySurinam = infectedCountry;
        flyingVehicles = 30;
        floatingVehicleBoats = 60;
        floatingVehicleCargos = 90;
        railVehicles = 110;
        roadVehiclesAutocars = 120;
        roadVehiclesCars = 140;
        singleTrackVehicles = 130;
    }

    @Override
    public String toString() {
        return "Nazwa-> " + name + " Kontynet-> " + continent + " Obszar-> " + obszar + "Liczba całej ludnosci-> " + numberOfPeople + "Liczba Wyleczonych-> " + healthy.size() + " Liczba Zarażonych-> " + infected.size();
    }
}
