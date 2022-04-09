package Countries;

import InterFaces.CreateArrayListPeople;
import Other.Person;
import Vehicles.Transport;

import java.util.ArrayList;

public class UnitedStates extends Country implements CreateArrayListPeople {

    public ArrayList<Person> healthy;
    public ArrayList<Person> infected;
    boolean infectedCountryUSA;
    boolean healthyCountryUSA;
    public UnitedStates(Continent continent, String name, double obszar, int numberOfPeople, ArrayList<Transport> transportArrayList) {
        super(continent, name, obszar, numberOfPeople, transportArrayList);
        people = this.createArrayListPeople(numberOfPeople);
        healthy = new ArrayList<>();
        healthyPeople = healthy;
        infected = new ArrayList<>();
        infecetdPeople = infected;
        infectedCountryUSA = infectedCountry;
        healthyCountryUSA =  healthyCountry;
        flyingVehicles = 304;
        floatingVehicleBoats = 425;
        floatingVehicleCargos = 503;
        railVehicles = 658;
        roadVehiclesAutocars = 746;
        roadVehiclesCars = 869;
        singleTrackVehicles = 921;
    }

    @Override
    public String toString() {
        return "Nazwa-> " + name + " Kontynet-> " + continent + " Obszar-> " + obszar + "Liczba całej ludnosci-> " + numberOfPeople + "Liczba Wyleczonych-> " + healthy.size() + " Liczba Zarażonych-> " + infected.size();
    }

}
