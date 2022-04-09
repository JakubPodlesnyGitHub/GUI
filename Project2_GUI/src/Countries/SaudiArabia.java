package Countries;

import InterFaces.CreateArrayListPeople;
import Other.Person;
import Vehicles.Transport;

import java.util.ArrayList;

public class SaudiArabia extends Country implements CreateArrayListPeople {
    public ArrayList<Person> healthy;
    public ArrayList<Person> infected;
    boolean infectedCountrySaudiArabia;
    boolean healthyCountrySaudiArabia;
    public SaudiArabia(Continent continent, String name, double obszar, int numberOfPeople, ArrayList<Transport> transportArrayList) {
        super(continent, name, obszar, numberOfPeople, transportArrayList);
        people = this.createArrayListPeople(numberOfPeople);
        healthy = new ArrayList<>();
        healthyPeople = healthy;
        infected = new ArrayList<>();
        infecetdPeople = infected;
        infectedCountrySaudiArabia = infectedCountry;
        healthyCountrySaudiArabia = healthyCountry;
        flyingVehicles = 150;
        floatingVehicleBoats = 220;
        floatingVehicleCargos = 240;
        railVehicles = 310;
        roadVehiclesAutocars = 350;
        roadVehiclesCars = 380;
        singleTrackVehicles = 400;
    }

    @Override
    public String toString() {
        return "Nazwa-> " + name + " Kontynet-> " + continent + " Obszar-> " + obszar + "Liczba całej ludnosci-> " + numberOfPeople + "Liczba Wyleczonych-> " + healthy.size() + " Liczba Zarażonych-> " + infected.size();
    }
}
