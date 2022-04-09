package Countries;


public class Vanuatu extends Country {

    public Vanuatu(Continent continent, String name, double obszar, int numberOfHealthyPeople, int numberOfInfectedPeople) {
        super(continent, name, obszar, numberOfHealthyPeople, numberOfInfectedPeople);
        maxCountry = numberOfHealthyPeople;
    }

    @Override
    public String toString() {
        return "Nazwa-> " + name + " Kontynet-> " + continent + " Obszar-> " + obszar + " Liczba Wyleczonych-> " + numberOfHealthyPeople + " Liczba Zarażonych-> " + numberOfInfectedPeople;
    }
}
