package Countries;

import Other.Person;
import Vehicles.Transport;
import java.util.ArrayList;


public class Country {
    //---------------------DANE DANEGO KRAJU----------------------------------------------------------------------------
    public Continent continent;
    public String name;
    public double obszar;
    public int numberOfPeople;
    //----------------------LISTY OBIEKTOW KTORE ZAWIERA KAZDY KRAJ-----------------------------------------------------
    public ArrayList<Transport> transportArrayList;
    public ArrayList<Person> infecetdPeople;
    public ArrayList<Person> healthyPeople;
    public ArrayList<Person> people;
    //-----------------------PRZY JAKICH WARTOSCIACH ZAMYKANE SA POSZCZEGOLNE SRODKI TRANSPORTU-------------------------
    public int flyingVehicles;
    public int floatingVehicleBoats;
    public int floatingVehicleCargos;
    public int railVehicles;
    public int roadVehiclesAutocars;
    public int roadVehiclesCars;
    public int singleTrackVehicles;
    //-------------------------------------SPRAWDZANIE CZY DANY KRAJ JUZ JEST ZARAZONY LUB ULECZONY-----------------------------------------------
    public boolean infectedCountry = false;
    public boolean healthyCountry = false;
    public Country(Continent continent, String name, double obszar, int numberOfPeople, ArrayList<Transport> transportArrayList) {
        this.continent = continent;//ENUM
        this.name = name;
        this.obszar = obszar;
        this.numberOfPeople = numberOfPeople;
        this.transportArrayList = transportArrayList;
        infecetdPeople = new ArrayList<>();
        healthyPeople = new ArrayList<>();
        people = new ArrayList<>();

    }
}