package GameWindow;

import Countries.*;
import GameScoresWindow.GameScoresWindow;
import Improvments.*;
import Vehicles.*;

import java.util.ArrayList;

public class GameWindowModel {
    private int timeSpreadVirus, healthTime, numberOfInfected, vaccineCounter = 0;
    private String level, playerName="PODAJ IMIE";
    private GameScoresWindow gameScoresWindow = new GameScoresWindow();
    //------------------------------------------------------------------------------------------------------------------
    private ArrayList<Country> countries;
    private ArrayList<Improvemnt> improvemnts;
    private ArrayList<Transport> transports;
    //Kraje
    private Australia australia;
    private China china;
    private Egipt egipt;
    private NewZeland newZeland;
    private Nigeria nigeria;
    private NorthKorea northKorea;
    private Pakistan pakistan;
    private Poland poland;
    private Russia russia;
    private SaintLucia saintLucia;
    private SaudiArabia saudiArabia;
    private Surinam surinam;
    private UnitedStates unitedStates;
    private Vanuatu vanuatu;
    private Wenezuela wenezuela;
    private Zimbabwe zimbabwe;
    //Ulepszenia
    private BombDrop bombDrop;
    private Hospital hospital;
    private IncreasesForScientists increasesForScientists;
    private Masks masks;
    private SocialFacilitiesClosed socialFacilitiesClosed;
    private Vacine vacine;
    private AntibacterialFluids antibacterialFluids;
    private Quarantine quarantine;
    private RutinoScorbin rutinoScorbin;
    //Transport
    private FloatingVehicleBoat floatingVehicleBoat1, floatingVehicleBoat2;
    private FloatingVehicleCargo floatingVehicleCargo1, floatingVehicleCargo2;
    private FlyingVehicle flyingVehicle1, flyingVehicle2;
    private RoadVehicleAutoCar roadVehicleAutoCar1, roadVehicleAutoCar2;
    private SingleTrackVehicle singleTrackVehicle1, singleTrackVehicle2;
    private RailVehicle railVehicle1, railVehicle2;
    private RoadVehicleCar roadVehicleCar1, roadVehicleCar2;

    public GameWindowModel(String level, int timeSpreadVirus, int healthTime, int numberOfInfectedChina) {
        this.timeSpreadVirus = timeSpreadVirus;
        this.healthTime = healthTime;
        this.numberOfInfected = numberOfInfectedChina;
        this.level = level;
        createTransport();
        countriesClases();
        improvments();
    }

    //-----------------------------------------GETERY I SETERY-------------------------------------------------------------------

    public GameScoresWindow getGameScoresWindow() {
        return gameScoresWindow;
    }

    public int getTimeSpreadVirus() {
        return timeSpreadVirus;
    }

    public int getHealthTime() {
        return healthTime;
    }


    public int getVaccineCounter() {
        return vaccineCounter;
    }

    public String getLevel() { return level; }

    public void setVaccineCounter(int vaccineCounter) {
        this.vaccineCounter = vaccineCounter;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    //-----------------------------------------------KRAJE I ULEPSZENIA-------------------------------------------------
    private void countriesClases() {
        countries = new ArrayList<>();
        australia = new Australia(Continent.Australia, "AUSTRALIA", 686.850, 600, transports);
        china = new China(Continent.Asia, "CHINY", 9597000, 800, transports, numberOfInfected);
        egipt = new Egipt(Continent.Africa, "EGIPT", 1001450, 300, transports);
        newZeland = new NewZeland(Continent.Australia, "NOWA ZELANDIA", 268680, 400, transports);
        nigeria = new Nigeria(Continent.Africa, "NIGERIA", 1267000, 400, transports);
        northKorea = new NorthKorea(Continent.Asia, "POLNOCNA KOREA", 120538, 300, transports);
        pakistan = new Pakistan(Continent.Asia, "PAKISTAN", 881913, 700, transports);
        poland = new Poland(Continent.Europe, "POLSKA", 312679, 301, transports);
        russia = new Russia(Continent.Europe, "ROSJA", 17100000, 1000, transports);
        saintLucia = new SaintLucia(Continent.NorthAmerica, "SAINT LUCIA", 617, 200, transports);
        saudiArabia = new SaudiArabia(Continent.Asia, "ARABIA SAUDYJSKA", 2149690, 450, transports);
        surinam = new Surinam(Continent.SouthAmerica, "SURINAM", 163821, 150, transports);
        unitedStates = new UnitedStates(Continent.NorthAmerica, "STANY ZJEDNOCZONE (USA)", 9834000, 1000, transports);
        vanuatu = new Vanuatu(Continent.Africa, "VANUATU", 12199, 100, transports);
        wenezuela = new Wenezuela(Continent.SouthAmerica, "WENEZUELA", 916445, 500, transports);
        zimbabwe = new Zimbabwe(Continent.Africa, "ZIMBABWE", 390757, 100, transports);
        addToArrayListCountries();//Dodawnie karajow do listy
    }

    private void addToArrayListCountries() {
        countries.add(australia);
        countries.add(china);
        countries.add(egipt);
        countries.add(newZeland);
        countries.add(nigeria);
        countries.add(northKorea);
        countries.add(pakistan);
        countries.add(poland);
        countries.add(russia);
        countries.add(saintLucia);
        countries.add(saudiArabia);
        countries.add(surinam);
        countries.add(unitedStates);
        countries.add(vanuatu);
        countries.add(wenezuela);
        countries.add(zimbabwe);
    }

    private void improvments() {
        improvemnts = new ArrayList<>();
        bombDrop = new BombDrop("ZRZUCENIE BOMBY", 500, 600);
        hospital = new Hospital("POSTAWIENIE SZPITALA", 50, 150);
        increasesForScientists = new IncreasesForScientists("PODWYZSZKI DLA NAUKOWCOW", 400, 300);
        masks = new Masks("NAKAZ NOSZENIA MASEK", 60, 120);
        vacine = new Vacine("WYNALEZIENIE SZCZEPINKI", AllPeople(), 3000);
        socialFacilitiesClosed = new SocialFacilitiesClosed("ZAMKNIECIE PLACOWEK PUBLICZNYCH", 50, 200);
        antibacterialFluids = new AntibacterialFluids("PLYNY ANTYBAKTERYJNE", 100, 250);
        quarantine = new Quarantine("KWARANTANNA", 200, 300);
        rutinoScorbin = new RutinoScorbin("RUTINOSCORBIN", 1, 2);
        addToArrayListImprovemnts();
    }

    private void addToArrayListImprovemnts() {
        improvemnts.add(bombDrop);
        improvemnts.add(hospital);
        improvemnts.add(increasesForScientists);
        improvemnts.add(masks);
        improvemnts.add(vacine);
        improvemnts.add(socialFacilitiesClosed);
        improvemnts.add(antibacterialFluids);
        improvemnts.add(quarantine);
        improvemnts.add(rutinoScorbin);
    }

    public int AllPeople() {
        int people = 0;
        for (Country country : countries) {
            people += country.people.size();
        }
        //System.out.println("LUDZIE: " + people);
        return people;
    }

    //--------------------------------------------TRANSPORT-------------------------------------------------------------
    private void createTransport() {
        transports = new ArrayList<>();
        floatingVehicleBoat1 = new FloatingVehicleBoat(VehicleMake.Cnb, "ZM1", 7, true, true, false);
        floatingVehicleBoat2 = new FloatingVehicleBoat(VehicleMake.Lagoon, "JP2", 6, true, true, false);
        floatingVehicleCargo1 = new FloatingVehicleCargo(VehicleMake.RoyalCaribbean, "ROYAL QEEN DELUXE", 70, true, true, false);
        floatingVehicleCargo2 = new FloatingVehicleCargo(VehicleMake.RoyalAmplified, "ROYAL KING", 70, true, true, false);
        flyingVehicle1 = new FlyingVehicle(VehicleMake.Airbus, "JUMBOJET", 40, true, true, false);
        flyingVehicle2 = new FlyingVehicle(VehicleMake.Boeing, "FX-100", 35, true, true, false);
        railVehicle1 = new RailVehicle(VehicleMake.CaptrainPolska, "M-200", 55, false, true, false);
        railVehicle2 = new RailVehicle(VehicleMake.OTTIMA, "SDA-100", 54, false, true, false);
        singleTrackVehicle1 = new SingleTrackVehicle(VehicleMake.Honda, "ZM-359", 2, false, true, false);
        singleTrackVehicle2 = new SingleTrackVehicle(VehicleMake.Yamaha, "23000", 2, false, true, false);
        roadVehicleAutoCar1 = new RoadVehicleAutoCar(VehicleMake.FlixBus, "CA-100", 25, false, true, false);
        roadVehicleAutoCar2 = new RoadVehicleAutoCar(VehicleMake.Polonus, "CA-400", 30, false, true, false);
        roadVehicleCar1 = new RoadVehicleCar(VehicleMake.Volkswagen, "PASSAT", 5, false, true, false);
        roadVehicleCar2 = new RoadVehicleCar(VehicleMake.RangeRover, "SPORT", 5, false, true, false);
        addToArrayListTransport();
    }

    private void addToArrayListTransport() {
        transports.add(floatingVehicleBoat1);
        transports.add(floatingVehicleBoat2);
        transports.add(flyingVehicle1);
        transports.add(flyingVehicle2);
        transports.add(floatingVehicleCargo1);
        transports.add(floatingVehicleCargo2);
        transports.add(roadVehicleAutoCar1);
        transports.add(roadVehicleAutoCar2);
        transports.add(railVehicle1);
        transports.add(railVehicle2);
        transports.add(roadVehicleCar1);
        transports.add(roadVehicleCar2);
        transports.add(floatingVehicleBoat2);
        transports.add(floatingVehicleBoat2);
        transports.add(floatingVehicleBoat2);
        transports.add(singleTrackVehicle1);
        transports.add(singleTrackVehicle2);

    }

    ///////////////////////////////GETERY(ULEPSZENIA)///////////////////////////////////////////////////////////////////

    public BombDrop getBombDrop() {
        return bombDrop;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public IncreasesForScientists getIncreasesForScientists() {
        return increasesForScientists;
    }

    public Masks getMasks() {
        return masks;
    }

    public SocialFacilitiesClosed getSocialFacilitiesClosed() {
        return socialFacilitiesClosed;
    }

    public Vacine getVacine() {
        return vacine;
    }

    public AntibacterialFluids getAntibacterialFluids() {
        return antibacterialFluids;
    }

    public Quarantine getQuarantine() {
        return quarantine;
    }

    public RutinoScorbin getRutinoScorbin() {
        return rutinoScorbin;
    }
    ///////////////////////////////GETERY(KRAJE)////////////////////////////////////////////////////////////////////////

    public Australia getAustraliaC() {
        return australia;
    }

    public China getChinaC() {
        return china;
    }

    public Egipt getEgiptC() {
        return egipt;
    }

    public NewZeland getNewZelandC() {
        return newZeland;
    }

    public Nigeria getNigeriaC() {
        return nigeria;
    }

    public NorthKorea getNorthKoreaC() {
        return northKorea;
    }

    public Pakistan getPakistanC() {
        return pakistan;
    }

    public Poland getPolandC() {
        return poland;
    }

    public Russia getRussiaC() {
        return russia;
    }

    public SaintLucia getSaintLuciaC() {
        return saintLucia;
    }

    public SaudiArabia getSaudiArabiaC() {
        return saudiArabia;
    }

    public Surinam getSurinamC() {
        return surinam;
    }

    public UnitedStates getUnitedStatesC() {
        return unitedStates;
    }

    public Vanuatu getVanuatuC() {
        return vanuatu;
    }

    public Wenezuela getWenezuelaC() {
        return wenezuela;
    }

    public Zimbabwe getZimbabweC() {
        return zimbabwe;
    }

    public ArrayList<Country> getCountries() {
        return countries;
    }


}