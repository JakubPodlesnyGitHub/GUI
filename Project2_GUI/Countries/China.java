package Countries;

public class China extends Country {

    public China(Continent continent, String name, double obszar, int numberOfHealthyPeople, int numberOfInfectedPeople) {
        super(continent, name, obszar, numberOfHealthyPeople, numberOfInfectedPeople);
        maxCountry = numberOfHealthyPeople;
    }

    @Override
    public String toString() {
        return "Nazwa-> " + name + " Kontynet-> " + continent + " Obszar-> " + obszar + " Liczba Wyleczonych-> " + numberOfHealthyPeople + " Liczba Zarażonych-> " + numberOfInfectedPeople;
    }
}
