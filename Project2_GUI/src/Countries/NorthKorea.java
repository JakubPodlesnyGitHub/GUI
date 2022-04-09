package Countries;

import InterFaces.CreateArrayListPeople;
import Other.Person;
import Vehicles.Transport;

import java.util.ArrayList;

public class NorthKorea extends Country implements CreateArrayListPeople {
    public ArrayList<Person> healthy;
    public ArrayList<Person> infected;
    boolean infectedCountryNorthKorea;
    boolean healthyCountryNorthKorea;
    public NorthKorea(Continent continent, String name, double obszar, int numberOfPeople, ArrayList<Transport> transportArrayList) {
        super(continent, name, obszar, numberOfPeople, transportArrayList);
        people = this.createArrayListPeople(numberOfPeople);
        healthy = new ArrayList<>();
        healthyPeople = healthy;
        infected = new ArrayList<>();
        infecetdPeople = infected;
        infectedCountryNorthKorea = infectedCountry;
        healthyCountryNorthKorea = healthyCountry;
        flyingVehicles = 111;
        floatingVehicleBoats = 80;
        floatingVehicleCargos = 259;
        railVehicles = 105;
        roadVehiclesAutocars = 140;
        roadVehiclesCars = 156;
        singleTrackVehicles = 202;
    }

    @Override
    public String toString() {
        return "Nazwa-> " + name + " Kontynet-> " + continent + " Obszar-> " + obszar + "Liczba całej ludnosci-> " + numberOfPeople + "Liczba Wyleczonych-> " + healthy.size() + " Liczba Zarażonych-> " + infected.size();
    }
}
