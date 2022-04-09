package Countries;

import InterFaces.CreateArrayListPeople;
import Other.Person;
import Vehicles.Transport;

import java.util.ArrayList;


public class China extends Country implements CreateArrayListPeople {

    public ArrayList<Person> healthy;
    public ArrayList<Person> infected;
    public int numberOfInfectedCHINA;
    boolean infectedCountryChina;
    boolean healthyCountryChiana;
    public China(Continent continent, String name, double obszar, int numberOfPeople, ArrayList<Transport> transportArrayList, int numberOfInfectedCHINA) {
        super(continent, name, obszar, numberOfPeople, transportArrayList);
        this.numberOfInfectedCHINA = numberOfInfectedCHINA;
        people =this.createArrayListPeople(numberOfPeople);
        healthy = new ArrayList<>();
        healthyPeople = healthy;
        infected = new ArrayList<>();
        addToInfected();
        infecetdPeople = infected;
        infectedCountryChina = infectedCountry;
        healthyCountryChiana = healthyCountry;
        flyingVehicles = 150;
        floatingVehicleBoats = 200;
        floatingVehicleCargos = 250;
        railVehicles = 300;
        roadVehiclesAutocars = 350;
        singleTrackVehicles = 270;
        roadVehiclesCars = 400;
    }

    public void addToInfected() {
        for (int i = 0; i < numberOfInfectedCHINA; i++) {
            people.get(i).setInfected(true);
            infected.add(people.get(i));
        }
    }

    @Override
    public String toString() {
        return "Nazwa-> " + name + " Kontynet-> " + continent + " Obszar-> " + obszar + "Liczba całej ludnosci-> " + numberOfPeople + "Liczba Wyleczonych-> " + healthy.size() + " Liczba Zarażonych-> " + infected.size();
    }
}
