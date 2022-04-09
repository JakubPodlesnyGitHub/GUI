package Countries;

import InterFaces.CreateArrayListPeople;
import Other.Person;
import Vehicles.Transport;

import java.util.ArrayList;

public class Zimbabwe extends Country implements CreateArrayListPeople {
    public ArrayList<Person> healthy;
    public ArrayList<Person> infected;
    boolean infectedCountryZimbabwe;
    boolean healthyCountryZimbabwe;
    public Zimbabwe(Continent continent, String name, double obszar, int numberOfPeople, ArrayList<Transport> transportArrayList) {
        super(continent, name, obszar, numberOfPeople, transportArrayList);
        people = this.createArrayListPeople(numberOfPeople);
        healthy = new ArrayList<>();
        healthyPeople = healthy;
        infected = new ArrayList<>();
        infecetdPeople = infected;
        infectedCountryZimbabwe = infectedCountry;
        healthyCountryZimbabwe = healthyCountry;
        flyingVehicles = 20;
        floatingVehicleBoats = 45;
        floatingVehicleCargos = 45;
        railVehicles = 55;
        roadVehiclesAutocars = 68;
        singleTrackVehicles = 79;
        roadVehiclesCars = 88;
    }

    @Override
    public String toString() {
        return "Nazwa-> " + name + " Kontynet-> " + continent + " Obszar-> " + obszar + "Liczba całej ludnosci-> " + numberOfPeople + "Liczba Wyleczonych-> " + healthy.size() + " Liczba Zarażonych-> " + infected.size();
    }
}
