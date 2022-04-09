package Countries;

import InterFaces.CreateArrayListPeople;
import Other.Person;
import Vehicles.Transport;

import java.util.ArrayList;

public class SaintLucia extends Country implements CreateArrayListPeople {

    public ArrayList<Person> healthy;
    public ArrayList<Person> infected;
    boolean infectedCountrySaintLucia;
    boolean healthyCountrySaintLucia;
    public SaintLucia(Continent continent, String name, double obszar, int numberOfPeople, ArrayList<Transport> transportArrayList) {
        super(continent, name, obszar, numberOfPeople, transportArrayList);
        people = this.createArrayListPeople(numberOfPeople);
        healthy = new ArrayList<>();
        healthyPeople = healthy;
        infected = new ArrayList<>();
        infecetdPeople = infected;
        infectedCountrySaintLucia = infectedCountry;
        healthyCountrySaintLucia = healthyCountry;
        flyingVehicles = 50;
        floatingVehicleBoats = 65;
        floatingVehicleCargos = 75;
        railVehicles = 100;
        roadVehiclesAutocars = 115;
        roadVehiclesCars = 150;
        singleTrackVehicles = 180;
    }

    @Override
    public String toString() {
        return "Nazwa-> " + name + " Kontynet-> " + continent + " Obszar-> " + obszar + "Liczba całej ludnosci-> " + numberOfPeople + "Liczba Wyleczonych-> " + healthy.size() + " Liczba Zarażonych-> " + infected.size();
    }
}
