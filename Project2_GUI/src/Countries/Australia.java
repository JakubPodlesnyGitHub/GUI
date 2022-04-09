package Countries;

import InterFaces.CreateArrayListPeople;
import Other.Person;
import Vehicles.Transport;

import java.util.ArrayList;

public class Australia extends Country implements CreateArrayListPeople {

    public ArrayList<Person> healthy;
    public ArrayList<Person> infected;
    public boolean infectedCountryAustralia;
    public boolean healthyCountryAustralia;
    public Australia(Continent continent, String name, double obszar, int numberOfPeople, ArrayList<Transport> transportArrayList) {
        super(continent, name, obszar, numberOfPeople, transportArrayList);
        people = this.createArrayListPeople(numberOfPeople);
        healthy = new ArrayList<>();
        healthyPeople = healthy;
        infected = new ArrayList<>();
        infecetdPeople = infected;
        infectedCountryAustralia = infectedCountry;
        healthyCountryAustralia = healthyCountry;
        flyingVehicles = 50;
        floatingVehicleBoats = 300;
        floatingVehicleCargos = 350;
        railVehicles = 100;
        roadVehiclesCars = 300;
        singleTrackVehicles = 302;
        roadVehiclesAutocars = 230;

    }

    @Override
    public String toString() {
        return "Nazwa-> " + name + " Kontynet-> " + continent + " Obszar-> " + obszar + "Liczba całej ludnosci-> " + numberOfPeople + "Liczba Wyleczonych-> " + healthy.size() + " Liczba Zarażonych-> " + infected.size();
    }
}
