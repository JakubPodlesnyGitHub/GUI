package Countries;

public class SaintLucia extends Country {


    public SaintLucia(Continent continent, String name, double obszar, int numberOfHealthyPeople, int numberOfInfectedPeople) {
        super(continent, name, obszar, numberOfHealthyPeople, numberOfInfectedPeople);
    }

    @Override
    public String toString() {
        return "Nazwa-> " + name + " Kontynet-> " + continent + " Obszar-> " + obszar + " Liczba Wyleczonych-> " + numberOfHealthyPeople + " Liczba Zarażonych-> " + numberOfInfectedPeople;
    }
}
