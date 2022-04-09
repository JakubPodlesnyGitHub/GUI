package Countries;

import InterFaces.CreateArrayListPeople;
import Other.Person;
import Vehicles.Transport;

import java.util.ArrayList;

public class NewZeland extends Country implements CreateArrayListPeople {
    public ArrayList<Person> healthy;
    public ArrayList<Person> infected;
    boolean infectedCountryNewZeland;
    boolean healthyCountryNewZeland;
    public NewZeland(Continent continent, String name, double obszar, int numberOfPeople, ArrayList<Transport> transportArrayList) {
        super(continent, name, obszar, numberOfPeople, transportArrayList);
        people = this.createArrayListPeople(numberOfPeople);
        healthy = new ArrayList<>();
        healthyPeople = healthy;
        infected = new ArrayList<>();
        infecetdPeople = infected;
        infectedCountryNewZeland = infectedCountry;
        healthyCountryNewZeland = healthyCountry;
        flyingVehicles = 100;
        floatingVehicleBoats = 150;
        floatingVehicleCargos = 200;
        railVehicles = 300;
        roadVehiclesAutocars = 360;
        roadVehiclesCars = 385;
        singleTrackVehicles = 365;
    }

    @Override
    public String toString() {
        return "Nazwa-> " + name + " Kontynet-> " + continent + " Obszar-> " + obszar + "Liczba całej ludnosci-> " + numberOfPeople + "Liczba Wyleczonych-> " + healthy.size() + " Liczba Zarażonych-> " + infected.size();
    }
}
