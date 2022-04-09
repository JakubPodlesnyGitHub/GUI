import Other.File;
import Other.Przedmiot;
import Other.PrzedmiotTMP;
import People.Person;
import People.PersonTMP;
import People.Tenanat;
import People.TenanatTMP;
import Spaces.*;
import Vehicles.*;
import Wyjatki.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final LocalDate[] data = new LocalDate[1];
        data[0] = LocalDate.now();
        //---------------------------Liczenie czasu co 5 sek(WĄTEK) ----------------------------------------------------
        Thread time5sek = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    data[0] = data[0].plusDays(1);//zmiana daty o 1 dzien co 5 sek
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        time5sek.start();//rozpoczecie watku 5 sek
        //------------------Osiedle-------------------------------------------------------------------------------------
        Estate patium = new Estate("Patium", 20);
        //ArrayList<Estate> listaOsiedli = new ArrayList<>(); - mozliwosc dodania kolejnych osiedli
        //listaOsiedli.add(patium);
        //---------------------------------------Osoby------------------------------------------------------------------
        ArrayList<Person> listaOsob = new ArrayList<>();
        Person person1 = new Person("Magda", "Krychowiak", "432334344", "Tomcia Palucha 48/31", "20.02.1968");
        Person person2 = new Person("Mateusz", "Romaniuk", "458748532", "Akacjowa 31/52", "12.02.2000");
        Person person3 = new Person("Ola", "Gutowska", "325654739", "Jacka i Agatki 6/69", "15.08.1958");
        Person person4 = new Person("Jakub", "Sylwestrzak", "029354873", "Oknicka 23/65", "12.12.1919");
        Person person5 = new Person("Marta", "Fernandes", "987456321", "Hassa 23/45", "21.01.1932");
        Person person6 = new Person("Katarzyna", "Lewandowska", "565654588", "Jacka i Agatki 6/37", "29.06.2001");
        Person person7 = new Person("Szymon", "Pietruszka", "785321459", "Sosnowa 26/34", "28.03.1948");
        Person person8 = new Person("Ania", "Jantar", "632048276", "Lipowa 245/43", "28.03.1961");
        Person person9 = new Person("Stanisława", "Pietruszka", "139746579", "Brzozowa 23/65", "19.03.1948");
        addPersonToList(listaOsob, person1, person2, person3, person4, person5, person6, person7, person8, person9);
        //-------------------------------------Najemcy------------------------------------------------------------------
        ArrayList<Tenanat> tenanats = new ArrayList<>();
        Tenanat tenant1 = new Tenanat("Maciej", "Maciejewski", "344344409", "Szymanowskiego 23/45", "25.05.1965");
        Tenanat tenant2 = new Tenanat("Jakub", "Tolak", "534542119", "Kolorowa 45/114", "06.11.1969");
        Tenanat tenant3 = new Tenanat("Agnieszka", "Kowalska", "159753456", "Szymanowskiego 30/115", "28.02.1940");
        Tenanat tenant4 = new Tenanat("Alicja", "Nowak", "753652458", "Dantego 5/114", "27.10.1971");
        Tenanat tenant5 = new Tenanat("John", "Doe", "7456985412", "Skoroszewska 34/95", "13.05.1967");
        //----------------------------Dodawanie najemcow do listy----------------------------------------------------
        tenanats.add(tenant1);
        tenanats.add(tenant2);
        tenanats.add(tenant3);
        tenanats.add(tenant4);
        tenanats.add(tenant5);
        //-------------------------------------Mieszkania---------------------------------------------------------------
        Flat flat1 = new Flat(50.5);
        Flat flat2 = new Flat(68.8);
        Flat flat3 = new Flat(18.5);
        Flat flat4 = new Flat(10.5, 20.3, 15.4);
        Flat flat5 = new Flat(89.9);
        Flat flat6 = new Flat(69);
        Flat flat7 = new Flat(6.5, 4, 7);
        Flat flat8 = new Flat(100.4);
        Flat flat9 = new Flat(40.7);
        //----------------------------------Parkingi--------------------------------------------------------------------
        ParkingSpace parkingSpace1 = new ParkingSpace(60);
        ParkingSpace parkingSpace2 = new ParkingSpace(70);
        ParkingSpace parkingSpace3 = new ParkingSpace(80);
        ParkingSpace parkingSpace4 = new ParkingSpace(5.6, 8.3, 3.8);
        //----------------------Dodawanie mieszkań i parkingow do osiedla-----------------------------------------------
        try {
            patium.addFlat(flat1);
            patium.addFlat(flat2);
            patium.addFlat(flat3);
            patium.addFlat(flat4);
            patium.addFlat(flat5);
            patium.addFlat(flat6);
            patium.addFlat(flat7);
            patium.addFlat(flat8);
            patium.addFlat(flat9);
            patium.addParkingPlace(parkingSpace1);
            patium.addParkingPlace(parkingSpace2);
            patium.addParkingPlace(parkingSpace3);
            patium.addParkingPlace(parkingSpace4);
        } catch (TooMannyFlats | TooMannyParkingSpace tooMannyFlats) {
            tooMannyFlats.getMessage();
        }
        //---------------------------------Przedmioty-----------------------------------------
        ArrayList<Przedmiot> przedmiots = new ArrayList<>();
        Przedmiot przedmiot1 = new Przedmiot("Narzędzia", 0.999);
        Przedmiot przedmiot2 = new Przedmiot("Mlotek", 0.125);
        Przedmiot przedmiot3 = new Przedmiot("Sofa", 0.2, 1.5, 2.6);
        Przedmiot przedmiot4 = new Przedmiot("Regal", 4.01);
        Przedmiot przedmiot5 = new Przedmiot("Telewizor", 0.2, 0.5, 0.4);
        Przedmiot przedmiot6 = new Przedmiot("Stolik", 2.5);
        Przedmiot przedmiot7 = new Przedmiot("Opony", 2.09);
        Przedmiot przedmiot8 = new Przedmiot("Lozko", 4.5);
        Przedmiot przedmiot9 = new Przedmiot("Lodowka", 3.124);
        addObjectToList(przedmiots, przedmiot1, przedmiot2, przedmiot3, przedmiot4, przedmiot5, przedmiot6, przedmiot7, przedmiot8, przedmiot9, flat1, flat2, flat3, flat4, flat5, flat6, flat7, parkingSpace1, parkingSpace2, parkingSpace3);
        //----------------------------Pojazdy---------------------------------------------------------------------------
        ArrayList<Transport> transports = new ArrayList<>();
        Amfibia amfibia1 = new Amfibia(VehiclesMake.Baz, "ZiŁ-485", 20, 8);
        Amfibia amfibia2 = new Amfibia(VehiclesMake.Volkswagen, "VW typ 166 Schwimmwagen", 6, 4, 4.5, 1.6);
        Motocykl motocykl1 = new Motocykl(VehiclesMake.Yamaha, "MT-125", 25, 2);
        Motocykl motocykl2 = new Motocykl(VehiclesMake.Suzuki, " GSXR 750", 2, 1, 1.5, 0.55);
        SamochodTerenowy samochodTerenowy1 = new SamochodTerenowy(VehiclesMake.Jeep, "Wrangler", 4, 4, 3.9, 1.6);
        SamochodTerenowy samochodTerenowy2 = new SamochodTerenowy(VehiclesMake.RangeRover, "Sport", 4, 5, 4.7, 1.9);
        SamochodMiejski samochodMiejski1 = new SamochodMiejski(VehiclesMake.Honda, "Civic", 30, 4);
        SamochodMiejski samochodMiejski2 = new SamochodMiejski(VehiclesMake.Skoda, "Octavia", 4, 5, 3.6, 1.5);
        Lodz lodz1 = new Lodz(VehiclesMake.Lagoon, "Sixty5", 7, 10, 20, 10);
        Lodz lodz2 = new Lodz(VehiclesMake.Cnb, "Bordeaux 60", 9, 8, 18, 5);
        //---------------Dodawanie do mieszkań listy pojazdów - pojazdy-----------------------------------------------------------------------------------------------
        addVehicleToList(transports, amfibia1, amfibia2, motocykl1, motocykl2, samochodMiejski1, samochodMiejski2, lodz1, lodz2, samochodTerenowy1, samochodTerenowy2, parkingSpace1, parkingSpace2, parkingSpace3, parkingSpace4);
        //---------------Dodawanie do mieszkań osób przez najemców -----------------------------------------------------
        mieszkanieOsoba(flat1, flat2, flat3, flat4, flat5, flat6, flat7, flat8, flat9, person1, person2, person3, person4, person5, person6, person7, person8, person9);
        //---------------------------Liczenie czasu co 10 sek(WĄTEK) ---------------------------------------------------r
        Thread time10sek = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10000);//usypianie watku na 10 sekund
                    for (Flat flat : patium.listaMieszkan) {//przechodzenie po wszystkich mieszkaniach
                        flat.checkPayment(data[0]);//sprawdzanie co 10 sek czy dane mieszkanie nie ma zaleglosci z oplatami
                    }
                    for (ParkingSpace parkingSpace : patium.listaMiejscParkingowych) {//przechpodzenie po wszystkich parkingach
                        parkingSpace.checkPayment(data[0]); // sprawdzanie czy dany parking nie ma zaleglosci z oplatami
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        time10sek.start();//rozpoczecie dzialania watku 10 sek
        // --------------------------------------------MENU-------------------------------------------------------------
        int wybor;
        TenanatTMP tenanatTMP = new TenanatTMP(null);
        PersonTMP personTMP = new PersonTMP(null);
        FlatTMP flatTMP = new FlatTMP(null);
        ParkingSpaceTMP parkingSpaceTMP = new ParkingSpaceTMP(null);
        PrzedmiotTMP przedmiotTMP = new PrzedmiotTMP(null);
        TransportTMP transportTMP = new TransportTMP(null);
        do {
            displayMainMenu();
            switch ((wybor = scanner.nextInt())) {
                case 1:
                    displayChoiceMenu();//menu wybierania osoby,najemcy,przedmiotu,mieszkania,parkingu,pojazdu,
                    choice(personTMP, tenanatTMP, flatTMP, parkingSpaceTMP, przedmiotTMP, transportTMP, scanner, listaOsob, tenanats, patium.listaMieszkan, patium.listaMiejscParkingowych, przedmiots, transports);
                    break;
                case 2:
                    showTeanatMenu();//menu najemcy ze wszystkimi jego funkcjami
                    TenantMenu(personTMP.getPerson(), tenanatTMP.getTenanat(), flatTMP.getFlat(), parkingSpaceTMP.getParkingSpace(), przedmiotTMP.getPrzedmiot(), transportTMP.getTransport(), scanner, data[0], listaOsob, tenanatTMP.getTenanat().listaMieszkanNajemcy, tenanatTMP.getTenanat().listaParkingowNajemcy);
                    break;
                case 3://wyswietlanie pustych pomieszczen
                    showEmptySpaces(patium);
                    break;
                case 4://zapis osiedla do pliku
                    estateToFile(patium);
                    break;
            }
        } while (wybor != 0);

        System.out.println("Dziękujemy za skorzystanie z systemu");
    }

    //------------------WYSWIETLANIE MENU I POZOSTALYCH FUNKCJI NP NAJMECY--------------------------------------------
    public static void displayMainMenu() {
        System.out.println("!WITAMY W MENU GLÓWNYM!");
        System.out.println("Wybierz 1: Menu operacyjne.");
        System.out.println("Wybierz 2: Menu najemcy.");
        System.out.println("Wybierz 3: Wyswietlanie pustych pomieszczen.");
        System.out.println("Wybierz 4: Zapis do pliku.");
        System.out.println("Wybierz 0: Wyjscie z systemu.");
    }

    public static void displayChoiceMenu() {
        System.out.println("MENU WYBORU!");
        System.out.println("Wybierz 1: Wybranie Osoby");
        System.out.println("Wybierz 2: Wybranie Najemcy");
        System.out.println("Wybierz 3: Wybranie Mieszkania");
        System.out.println("Wybierz 4: Wybranie Parkingu");
        System.out.println("Wybierz 5: Wybranie Przedmiotu");
        System.out.println("Wybierz 6: Wybranie Pojzadu");
    }

    public static void showTeanatMenu() {
        System.out.println("Funkcjonalnosc najemcy!");
        System.out.println("Wybierz 1: Dodaj lub Usun osobe do/z mieszkania.");
        System.out.println("Wybierz 2: Wynajmij wybrane mieszkanie lub parking.");
        System.out.println("Wybierz 3: Dodaj pojazd lub obiekt do parkingu.");
        System.out.println("Wybierz 4: Usun pojazd lub obiekt z parkingu.");
        System.out.println("Wybierz 5: Dodaj lub usun przedmiot z mieszkania.");
        System.out.println("Wybierz 6: Zapłac za mieszkanie lub zrezygnuj z mieszkania.");
        System.out.println("Wybierz 7: Zapłac za parking lub zrezygnuj z parkingu.");
        System.out.println("Wybierz 8: Wyswietl parkingi i mieszkania aktualnego najemcy.");
    }

    public static void showPerson(PersonTMP personTMP) {
        System.out.println("Dane wybranej osoby: " + personTMP.getPerson() + "\n");
    }

    public static void displayTenant(ArrayList<Tenanat> tenanats) {
        System.out.println("!NAJEMCY!");
        tenanats.forEach(tenanat -> System.out.println("Wybierz Najemce: " + tenanat.imie + " " + tenanat.nazwisko));
    }

    public static void displayPerson(ArrayList<Person> people) {
        System.out.println("!OSOBY!");
        people.forEach(person -> System.out.println("Wybierz Osobe: " + person.imie + " " + person.nazwisko));
    }

    public static void displayPersonFlat(Flat flat) {
        System.out.println("Osoby w aktualnie wybranym mieszkaniu nr: " + flat.flatNumberF);
        flat.listaOsobNaMieszkanie.forEach(person -> System.out.println("Osoba nr-> " + person.imie + " " + person.nazwisko));
    }//aktualnie wybrane mieszkanie

    public static void displayVehicles(ArrayList<Transport> transportArrayList) {
        System.out.println("MENU TRANSPORT!");
        transportArrayList.forEach(transport -> System.out.println("Wybierz Pojazd: " + transport.marka + " " + transport.model));
    }

    public static void displayVehiclesParking(ParkingSpace parkingSpace) {
        System.out.println("Pojazd w aktualnie wybranym parkingu nr " + parkingSpace.parkingNumberP);
        System.out.println("Pojazd : " + " Marka-> " + parkingSpace.pojazd.marka + " Model-> " + parkingSpace.pojazd.model);
    } //aktualnie wybrany parking

    public static void displayObejcts(ArrayList<Przedmiot> przedmiots) {
        System.out.println("!PRZEDMIOTY!");
        przedmiots.forEach(przedmiot -> System.out.println("Wybierz Przedmiot: " + przedmiot.name));
    }

    public static void displayObejctsParking(ParkingSpace parkingSpace) {
        System.out.println("Przedmioty w aktualnie wybranym prakingu: " + parkingSpace.parkingNumberP);
        parkingSpace.parkingSpaceObjectList.forEach(przedmiot -> System.out.println("Przedmiot-> " + przedmiot.name));
    }//aktualnie wybrane mieszkanie

    public static void displayObejctsFlats(Flat flat) {
        System.out.println("Przedmioty w aktualnie wybranym mieszkaniu: " + flat.flatNumberF);
        flat.listaObiektoWMieszkaniu.forEach(przedmiot -> System.out.println("Przedmiot-> " + przedmiot.name));
    }//aktualnie wybrane mieszkanie

    public static void displayFlats(ArrayList<Flat> flats) {
        System.out.println("!MIESZKANIA!");
        flats.forEach(flat -> System.out.println("Wybierz Mieszkanie nr: " + flat.flatNumberF));
    }

    public static void displayParkingSpaces(ArrayList<ParkingSpace> parkingSpaceArrayList) {
        System.out.println("!PARKINGI!");
        parkingSpaceArrayList.forEach(parkingSpace -> System.out.println("Parking nr: " + parkingSpace.parkingNumberP));
    }//aktualnie wybrany parking

    public static void displayTenantParkingPlaces(Tenanat tenanat, ArrayList<ParkingSpace> parkingSpaces) {
        System.out.println("Parkingi najemcy: " + tenanat.imie + " " + tenanat.nazwisko);
        if (!parkingSpaces.isEmpty()) {
            parkingSpaces.forEach(parkingSpace -> System.out.println("Parking nr: " + parkingSpace.parkingNumberP + " Objetosc parkingu: " + parkingSpace.parkingNumberP));
            System.out.println();
        } else {
            System.out.println("Brak wynajetych parkingow\n");
        }

    }

    public static void displayTenantFlats(Tenanat tenanat, ArrayList<Flat> flats) {
        System.out.println("Mieszkania najemcy: " + tenanat.imie + " " + tenanat.nazwisko);
        if (!flats.isEmpty()) {
            flats.forEach(flat -> System.out.println("Mieszkanie nr " + flat.flatNumberF + " Obejtosc mieszkania: " + flat.objetoscMieszkania));
            System.out.println();
        } else {
            System.out.println("Brak wynajetych mieszkan");
        }
    }

    public static void showEmptySpaces(Estate estate) {
        System.out.println("Puste mieszkania: ");
        for (Flat flat : estate.listaMieszkan) {
            if (flat.czyPosiadaNajemcaMieszkanie == false) {
                if (flat.listaOsobNaMieszkanie.isEmpty() && flat.listaObiektoWMieszkaniu.isEmpty()) {
                    System.out.println("Mieszkanie nr: " + flat.flatNumberF);
                }
            }
        }
        System.out.println("Puste parkingi: ");
        for (ParkingSpace parkingSpace : estate.listaMiejscParkingowych) {
            if (parkingSpace.czyPosiadaNajemcaParking == false) {
                if (parkingSpace.parkingSpaceObjectList.isEmpty() && parkingSpace.pojazd == null) {
                    System.out.println("Parking nr: " + parkingSpace.parkingNumberP);
                }
            }
        }
        System.out.println();
    }//pokazuje puste mieszkania

    //------------------------WYBORY------------------------------------------
    public static void choice(PersonTMP personTMP, TenanatTMP tenanatTMP, FlatTMP flatTMP, ParkingSpaceTMP parkingSpaceTMP, PrzedmiotTMP przedmiotTMP, TransportTMP transportTMP, Scanner scanner, ArrayList<Person> personArrayList, ArrayList<Tenanat> tenanats, ArrayList<Flat> flats, ArrayList<ParkingSpace> parkingSpaceArrayList, ArrayList<Przedmiot> przedmiotArrayList, ArrayList<Transport> transportArrayList) {
        //mozliwosc wyboru najemcy, osoby,pojazdu,przedmiotu,parkingu,mieszkania
        try {
            System.out.println("Podaj numer: ");
            int choice = scanner.nextInt();
            if (choice > 0 && choice < 7) {
                switch (choice) {
                    case 1://osoba
                        displayPerson(personArrayList);
                        System.out.println("Podaj numer osoby: ");
                        int wyborOsoby = scanner.nextInt();
                        personTMP.setPerson(personArrayList.get(wyborOsoby - 1));
                        //showPerson(personTMP);
                        break;
                    case 2://najemca
                        displayTenant(tenanats);
                        System.out.println("Podaj numer najemcy: ");
                        int wyborTenant = scanner.nextInt();
                        tenanatTMP.setTenanat(tenanats.get(wyborTenant - 1));
                        break;
                    case 3://mieszkanie
                        displayFlats(flats);
                        System.out.println("Podaj numer mieszkania: ");
                        int wyborMieszkania = scanner.nextInt();
                        flatTMP.setFlat(flats.get(wyborMieszkania - 1));
                        break;
                    case 4:
                        displayParkingSpaces(parkingSpaceArrayList);
                        System.out.println("Podaj numer parkingu: ");
                        int wyborParkingu = scanner.nextInt();
                        parkingSpaceTMP.setParkingSpace(parkingSpaceArrayList.get(wyborParkingu - 1));
                        break;
                    case 5://przedmiot
                        displayObejcts(przedmiotArrayList);
                        System.out.println("Podaj numer przedmiotu: ");
                        int wyborPrzedmiot = scanner.nextInt();
                        przedmiotTMP.setPrzedmiot(przedmiotArrayList.get(wyborPrzedmiot - 1));
                        break;
                    case 6://pojazd
                        displayVehicles(transportArrayList);
                        System.out.println("Podaj numer pojazdu: ");
                        int wyborPojazd = scanner.nextInt();
                        transportTMP.setTransport(transportArrayList.get(wyborPojazd - 1));
                        break;
                }
            } else {
                System.err.println("Zostal wybrany zly numer");
            }
        } catch (NullPointerException ex) {
            System.err.println("Podales zly numer. Prosze wybrac ponownie.\n");
        } catch (IndexOutOfBoundsException ex) {
            System.err.println("Podales zly numer. Prosze wybrac ponownie.\n");
        }
    }

    public static void TenantMenu(Person personTMP, Tenanat tenanatTMP, Flat flatTMP, ParkingSpace parkingSpaceTMP, Przedmiot przedmiotTMP, Transport transportTMP, Scanner scanner, LocalDate data, ArrayList<Person> listaOsob, ArrayList<Flat> flats, ArrayList<ParkingSpace> parkingSpaceArrayList) {

        try {
            int wyborFunkcjonalnosci = scanner.nextInt();
            if (wyborFunkcjonalnosci > 0 && wyborFunkcjonalnosci < 10) {
                switch (wyborFunkcjonalnosci) {
                    case 1://mozliwosc usuniecia osoby,dodania osoby,stworzenia osoby i dodania jej do mieszkania
                        selectAddPersonRemovePerson(tenanatTMP, personTMP, flatTMP, scanner, listaOsob, flats);
                        break;
                    case 2://mzoliwosc wynajecia danego pomoieszczenia
                        selectRentParkingSpaceFlat(parkingSpaceTMP, flatTMP, tenanatTMP, data, scanner);
                        break;
                    case 3://mozliwosc dodania do parkingu przedmiotu albo pojazadu
                        addThingToParkingSpace(parkingSpaceTMP, tenanatTMP, przedmiotTMP, transportTMP, scanner);
                        break;
                    case 4://mozliwosc usuniecia daengo przedmiotu,pojazdu z parkingu
                        removeThingFromParkingSpace(parkingSpaceTMP, tenanatTMP, przedmiotTMP, transportTMP, scanner);
                        break;
                    case 5://mozliowsc dodania lub usuniecia przedimotu do/z mieszkania
                        addThingRemoveToFromFlat(flatTMP, tenanatTMP, przedmiotTMP, scanner);
                        break;
                    case 6://zaplac lub zrezygnuj z mieszkania
                        selectPayResignFlat(tenanatTMP, flatTMP, scanner);
                        break;
                    case 7://zaplac lub zrezygnuj z parkingu
                        selectPayResignParkingSpace(tenanatTMP, parkingSpaceTMP, scanner);
                        break;
                    case 8://informacje na teamt parkingow i mieszkan najemcy
                        displayTenantParkingPlaces(tenanatTMP, parkingSpaceArrayList);
                        displayTenantFlats(tenanatTMP, flats);
                        break;
                }
            } else {
                System.err.println("Zostal wybrany zly numer");
            }
        } catch (Exception e) {
            System.err.println("Brak wybranego najemcy");
        }
    }

    public static void selectPayResignFlat(Tenanat tenanat, Flat flat, Scanner scanner) {
        System.out.println("Wybierz 1: Zaplac za mieszkanie.");
        System.out.println("Wybierz 2: Zrezygnuj z mieszkania.");
        int wyborFlatResignPay = scanner.nextInt();
        try {
            if (wyborFlatResignPay > 0 && wyborFlatResignPay < 3) {
                switch (wyborFlatResignPay) {
                    case 1:
                        tenanat.payForFlat(flat,scanner);
                        break;
                    case 2:
                        tenanat.resingnFlat(flat);
                        break;
                }
            } else {
                System.out.println("Zostal wybrany zly numer");
            }
        } catch (NullPointerException e) {
            System.err.println("Mieszkanie lub Najemca nie zostali wybrani.\n");
        }
    }

    public static void selectPayResignParkingSpace(Tenanat tenanat, ParkingSpace parkingSpace, Scanner scanner) {
        System.out.println("Wybierz 1: Zaplac za parking.");
        System.out.println("Wybierz 2: Zrezygnuj z parkingu.");
        int wyborParkingResignPay = scanner.nextInt();
        try {
            if (wyborParkingResignPay > 0 && wyborParkingResignPay < 3) {
                switch (wyborParkingResignPay) {
                    case 1:
                        tenanat.payForParkingSpace(parkingSpace,scanner);
                        break;
                    case 2:
                        tenanat.resingnParkingSpace(parkingSpace);
                        break;
                }
            } else {
                System.err.println("Zostal wybrany zly numer");
            }
        } catch (NullPointerException e) {
            System.err.println("Nie zostal wybrany parking albo najemca.");
        }
    }

    public static void selectRentParkingSpaceFlat(ParkingSpace parkingSpace, Flat flat, Tenanat tenanat, LocalDate date, Scanner scanner) {
        System.out.println("Wybierz 1: Wynajmij mieszkanie.");
        System.out.println("Wybierz 2: Wynajmij parking.");
        int wyborParkingFlat = scanner.nextInt();
        if (wyborParkingFlat > 0 && wyborParkingFlat < 3) {
            switch (wyborParkingFlat) {
                case 1:
                    try {
                        flat.addTenant(tenanat, date);
                        if (tenanat.listaPlikowFile.size() < 3)
                            System.out.println("Data rozpoczęcia najmu mieszkania nr: " + flat.flatNumberF + "-> " + date + "\n");
                    } catch (TooMannyRentals tooMannyRentals) {
                        tooMannyRentals.printStackTrace();
                    } catch (ProblematicTenantException e) {
                        e.printStackTrace();
                    } catch (NullPointerException e) {
                        System.err.println("Brak wybranego najemcy lub mieszkania\n");
                    }
                    break;
                case 2:
                    try {
                        parkingSpace.addTenant(tenanat, date);
                        if (tenanat.listaPlikowFile.size() < 3 && tenanat.czyPosiadaMieszkanie == true)
                            System.out.println("Data rozpoczęcia najmu parkingu nr: " + parkingSpace.parkingNumberP + " -> " + date + "\n");
                    } catch (TooMannyRentals tooMannyRentals) {
                        tooMannyRentals.printStackTrace();
                    } catch (ProblematicTenantException e) {
                        e.printStackTrace();
                    } catch (NullPointerException e) {
                        System.err.println("Brak wybranego najemcy lub parkingu\n");
                    }
                    break;
            }
        } else {
            System.err.println("Zostal wybrany zly numer");
        }
    }

    public static void selectAddPersonRemovePerson(Tenanat tenanat, Person person, Flat flat, Scanner scanner, ArrayList<Person> people, ArrayList<Flat> flats) {
        try {
            displayTenantFlats(tenanat, flats);
            System.out.println("Wybierz 1: Dodaj osobe do mieszkania.");
            System.out.println("Wybierz 2: Usun osobe z mieszkania przez wybranie osoby.");
            System.out.println("Wybierz 3: Usun osobe z mieszkania przez liste.");
            System.out.println("Wybierz 4: Utworz osobe i dodaj do mieszkania.");
            int wyborADDREMOVE = scanner.nextInt();
            try {
                if (wyborADDREMOVE > 0 && wyborADDREMOVE < 5) {
                    switch (wyborADDREMOVE) {
                        case 1:
                            tenanat.addPerson(flat, person);
                            break;
                        case 2:
                            tenanat.removePerson(flat, person);
                            break;
                        case 3:
                            if (!flat.listaOsobNaMieszkanie.isEmpty()) {
                                displayPersonFlat(flat);
                                System.out.println("Osoby sa numerowane od zera");
                                System.out.println("Podaj numer osoby ktora chcesz usunac: ");
                                int numerOsoby = scanner.nextInt();
                                tenanat.removePerson(flat, flat.listaOsobNaMieszkanie.get(numerOsoby));
                            } else {
                                System.err.println("Brak osoby w mieszkaniu.");
                            }
                            break;
                        case 4:
                            tenanat.createPersonANDaddFlat(scanner, people, tenanat, flat);
                            break;
                    }
                } else {
                    System.err.println("Zostal wybrany zly numer");
                }
            } catch (NullPointerException e) {
                System.err.println("Brak wybranego mieszkania albo osoby");

            }
        } catch (NullPointerException e) {
            System.err.println("Brak wybranego najemcy");
        }
    }

    //-------------------DODAWANIE PRZEDMIOTÓW I POJAZDÓW ORAZ WYNAJMOWANIE I OSÓB DO MIESZKAN -------------------------------

    public static void addThingToParkingSpace(ParkingSpace parkingSpace, Tenanat tenanat, Przedmiot przedmiot, Transport transport, Scanner scanner) {
        try {
            System.out.println("Wybierz 1: Dodanie przedmiotu do parkingu.");
            System.out.println("Wybierz 2: Dodanie pojazdu do parkingu.");
            int wyborTransportPrzedmiot = scanner.nextInt();
            if (wyborTransportPrzedmiot > 0 && wyborTransportPrzedmiot < 3) {
                switch (wyborTransportPrzedmiot) {
                    case 1:
                        if (przedmiot != null) {
                            tenanat.addObjectParkingSpace(parkingSpace, przedmiot);
                        } else {
                            System.err.println("Brak wybranego przedmiotu. Prosze wybrac przedmiot!.");
                        }
                        break;
                    case 2:
                        if (transport != null) {
                            tenanat.addVehileParkingSpace(parkingSpace, transport);
                        } else {
                            System.err.println("Brak wybranego pojazdu. Prosze wybrac pojazd!.");
                        }
                        break;
                }
            } else {
                System.err.println("Zostal wybrany zly numer");
            }
        } catch (TooManyThingsException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("Brak wynajętego parkingu.");
        }
    }

    public static void addThingRemoveToFromFlat(Flat flat, Tenanat tenanat, Przedmiot przedmiot, Scanner scanner) {
        try {
            System.out.println("Wybierz 1: Dodanie przedmiotu do mieszkania.");
            System.out.println("Wybierz 2: Usunięcie przedmiotu z mieszkania.");
            System.out.println("Wybierz 3: Usunięcie wybranego przedmiotu z listy z mieszkania.");
            int wyborPrzedmiotMieszkanie = scanner.nextInt();
            if (wyborPrzedmiotMieszkanie > 0 && wyborPrzedmiotMieszkanie < 4) {
                switch (wyborPrzedmiotMieszkanie) {
                    case 1:
                        tenanat.addObjectFlat(przedmiot, flat);
                        break;
                    case 2:
                        displayObejctsFlats(flat);
                        tenanat.removeObjectFlat(przedmiot, flat);
                        break;
                    case 3:
                        if (!flat.listaObiektoWMieszkaniu.isEmpty()) {
                            displayObejctsFlats(flat);
                            System.out.println("Parkingi sa numerowane od zera");
                            System.out.println("Podaj numer przedmiotu ktory chcesz usunac:");
                            int numerPrzedmiotu = scanner.nextInt();
                            tenanat.removeObjectFlat(flat.listaObiektoWMieszkaniu.get(numerPrzedmiotu), flat);
                        } else {
                            System.err.println("Brak przedmiotow w danym mieszkaniu");
                        }
                        break;
                }
            } else {
                System.err.println("Zostal wybrany zly numer");
            }
        } catch (TooManyThingsException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.err.println("Brak wynajetego mieszknia lub przedmiotu");
        }
    }

    public static void removeThingFromParkingSpace(ParkingSpace parkingSpace, Tenanat tenanat, Przedmiot przedmiot, Transport transport, Scanner scanner) {
        try {
            System.out.println("Wybierz 1: Usuniecie przedmiotu z parkingu.");
            System.out.println("Wybierz 2: Usuniecie wybranego przedmiotu z listy z parkingu.");
            System.out.println("Wybierz 3: Usuniecie pojazdu z parkingu.");
            System.out.println("Wybierz 4: Usuniecie pojazdu znajdujacego sie na parkingu.");
            int wyborTransportPrzedmiot = scanner.nextInt();
            if (wyborTransportPrzedmiot > 0 && wyborTransportPrzedmiot < 5) {
                switch (wyborTransportPrzedmiot) {
                    case 1:
                        displayObejctsParking(parkingSpace);
                        tenanat.removeObjectParkingSpace(parkingSpace, przedmiot);
                        break;
                    case 2:
                        if (!parkingSpace.parkingSpaceObjectList.isEmpty()) {
                            displayObejctsParking(parkingSpace);
                            System.out.println("Przedmioty sa numerowane od zera");
                            System.out.println("Podaj numer przedmiotu ktory chcesz usunac:");
                            int numerPrzedmiotu = scanner.nextInt();
                            tenanat.removeObjectParkingSpace(parkingSpace, parkingSpace.parkingSpaceObjectList.get(numerPrzedmiotu));
                        } else {
                            System.err.println("Brak przedmiotow w danym parkingu");
                        }
                        break;
                    case 3:
                        displayVehiclesParking(parkingSpace);
                        tenanat.removeVehicleParkingSpace(parkingSpace, transport);
                        break;
                    case 4:
                        if (parkingSpace.pojazd != null) {
                            displayVehiclesParking(parkingSpace);
                            tenanat.removeVehicleParkingSpace(parkingSpace, parkingSpace.pojazd);
                        } else {
                            System.err.println("Brak pojazdu na miejscu parkingowym");
                        }
                        break;
                }
            } else {
                System.err.println("Zostal wybrany zly numer");
            }
        } catch (NullPointerException e) {
            System.err.println("Brak wynajetego pojazdu,przedmiotu lub parkingu");
        }
    }

    //-------------------------ZAPIS DO PLIKU-----------------------------------------------------
    public static void estateToFile(Estate estate) {
        try {
            PrintWriter printWriter = new PrintWriter("ZapisOsiedla.txt");
            Collections.sort(estate.listaMieszkan);//sortowanie po objetosci mieszkan
            Collections.sort(estate.listaMiejscParkingowych);//sortowanie po objetosci parkingow
            printWriter.println("Osiedle: " + estate.nazwa + " Ilosc mieszkan i parkingow: " + estate.numberOfSurafaces + "\n");
            printWriter.println("\n!MIESZKANIA!\n");
            for (Flat flat : estate.listaMieszkan) {
                Collections.sort(flat.listaOsobNaMieszkanie);//sortowanie alfabetycznie po nazwisku ludzi
                if (flat.tenanat != null)
                    printWriter.println("Mieszkanie NR: " + flat.flatNumberF + " Rzeczywista objetosc pomieszczenia: " + flat.objetoscMieszkania + " Wolna objestosc mieszkania: " + flat.wolnaObjetoscPomiszczeniaMieszkania + "\nNajemca: " + flat.tenanat + "\nLiczba osob w mieszkaniu: " + flat.listaOsobNaMieszkanie.size() + "\nLista osob znajdujacych sie w mieszkaniu -> " + flat.listaOsobNaMieszkanie + "\nLiczba przedmiotow w mieszkaniu: " + flat.listaObiektoWMieszkaniu.size() + "\nLista przedmiotow znajdujacych sie w mieszkaniu -> " + flat.listaObiektoWMieszkaniu + "\n");
                else
                    printWriter.println("Mieszkanie NR: " + flat.flatNumberF + " Rzeczywista objetosc pomieszczenia: " + flat.objetoscMieszkania + " Wolna objestosc mieszkania: " + flat.wolnaObjetoscPomiszczeniaMieszkania + "\nNajemca: Brak najemcy" + "\nLiczba osob w mieszkaniu: " + flat.listaOsobNaMieszkanie.size() + "\nLista osob znajdujacych sie w mieszkaniu -> " + flat.listaOsobNaMieszkanie + "\nLiczba przedmiotow w mieszkaniu: " + flat.listaObiektoWMieszkaniu.size() + "\nLista przedmiotow znajdujacych sie w mieszkaniu -> " + flat.listaObiektoWMieszkaniu + "\n");

            }
            printWriter.println("\n!PARKINGI!\n");
            for (ParkingSpace parkingSpace : estate.listaMiejscParkingowych) {
                Collections.sort(parkingSpace.parkingSpaceObjectList);//sortowanie po objetosci przedmiotow a jesli sa takie same to alfabetycznie
                if (parkingSpace.tenanat != null)
                    printWriter.println("Parking NR: " + parkingSpace.parkingNumberP + " Rzeczywista objetosc pomieszczenia: " + parkingSpace.objetoscMiejscaParkingowego + " Wolna objestosc mieszkania: " + parkingSpace.wolnaObjetoscPomiszczeniaParkingu + "\nNajemca: " + parkingSpace.tenanat + "\nLiczba przedmiotow w parkingu: " + parkingSpace.parkingSpaceObjectList.size() + "\nLista przedmiotow znajdujacych sie w parkingu -> " + parkingSpace.parkingSpaceObjectList + "\nPojazd: " + parkingSpace.pojazd + "\n");
                else
                    printWriter.println("Parking NR: " + parkingSpace.parkingNumberP + " Rzeczywista objetosc pomieszczenia: " + parkingSpace.objetoscMiejscaParkingowego + " Wolna objestosc mieszkania: " + parkingSpace.wolnaObjetoscPomiszczeniaParkingu + "\nNajemca: Brak najemcy" + "\nLiczba przedmiotow w parkingu: " + parkingSpace.parkingSpaceObjectList.size() + "\nLista przedmiotow znajdujacych sie w parkingu -> " + parkingSpace.parkingSpaceObjectList + "\nPojazd: " + parkingSpace.pojazd + "\n");

            }
            printWriter.close();
            System.out.println("Stan osiedla zostal zapisany do pliku\n");
        } catch (FileNotFoundException e) {
            System.err.println("Brak pliku");
        }
    }

    //-------------NAJEMCA OSOBA I MIESZKANIE----------------------------------------------------
    public static void mieszkanieOsoba(Flat flat1, Flat flat2, Flat flat3, Flat flat4, Flat flat5, Flat
            flat6, Flat flat7, Flat flat8, Flat flat9, Person person1, Person person2, Person person3, Person
                                               person4, Person person5, Person person6, Person person7, Person person8, Person person9) {
        flat1.addPerson(person1);
        flat1.addPerson(person2);
        flat6.addPerson(person2);
        flat6.addPerson(person3);
        flat2.addPerson(person2);
        flat7.addPerson(person4);
        flat4.addPerson(person8);
        flat2.addPerson(person5);
        flat3.addPerson(person7);
        flat3.addPerson(person8);
        flat8.addPerson(person9);
        flat5.addPerson(person5);
        flat9.addPerson(person6);
        flat9.addPerson(person3);

    }

    //-------------LISTA OSÓB - OSOBA--------------------------------------------------------------
    public static void addPersonToList(ArrayList<Person> personArrayList, Person person1, Person person2, Person
            person3, Person person4, Person person5, Person person6, Person person7, Person person8, Person person9) {
        personArrayList.add(person1);
        personArrayList.add(person2);
        personArrayList.add(person3);
        personArrayList.add(person4);
        personArrayList.add(person5);
        personArrayList.add(person6);
        personArrayList.add(person7);
        personArrayList.add(person8);
        personArrayList.add(person9);

    }

    //------------LISTA POJAZDÓW - POJAZD ORAZ PARKING - POJAZD------------------------------------------------------------------
    public static void addVehicleToList(ArrayList<Transport> listaPojzdow, Transport transport1, Transport
            transport2, Transport transport3, Transport transport4, Transport transport5, Transport transport6, Transport
                                                transport7, Transport transport8, Transport transport9, Transport transport10, ParkingSpace parkingSpace1, ParkingSpace parkingSpace2, ParkingSpace parkingSpace3, ParkingSpace parkingSpace4) {
        listaPojzdow.add(transport1);
        listaPojzdow.add(transport2);
        listaPojzdow.add(transport3);
        listaPojzdow.add(transport4);
        listaPojzdow.add(transport5);
        listaPojzdow.add(transport6);
        listaPojzdow.add(transport7);
        listaPojzdow.add(transport8);
        listaPojzdow.add(transport9);
        listaPojzdow.add(transport10);
        parkingSpace1.addVehicle(transport1);
        parkingSpace2.addVehicle(transport5);
        parkingSpace3.addVehicle(transport6);
        parkingSpace4.addVehicle(transport10);
    }

    //------------LISTA PRZEDMIOTÓW - PRZEDMIOT ORAZ MIESZKANIE - PRZEDMIOT  ORAZ PRZEDMIOT - PARKING---------------------------------------------------------------
    public static void addObjectToList(ArrayList<Przedmiot> listaPrzedmiotow, Przedmiot przedmiot1, Przedmiot
            przedmiot2, Przedmiot przedmiot3, Przedmiot przedmiot4, Przedmiot przedmiot5, Przedmiot przedmiot6, Przedmiot
                                               przedmiot7, Przedmiot przedmiot8, Przedmiot przedmiot9, Flat flat1, Flat flat2, Flat flat3, Flat flat4, Flat flat5, Flat flat6, Flat flat7, ParkingSpace parkingSpace1, ParkingSpace parkingSpace2, ParkingSpace parkingSpace3) {
        listaPrzedmiotow.add(przedmiot1);
        listaPrzedmiotow.add(przedmiot2);
        listaPrzedmiotow.add(przedmiot3);
        listaPrzedmiotow.add(przedmiot4);
        listaPrzedmiotow.add(przedmiot5);
        listaPrzedmiotow.add(przedmiot6);
        listaPrzedmiotow.add(przedmiot7);
        listaPrzedmiotow.add(przedmiot8);
        listaPrzedmiotow.add(przedmiot9);
        flat1.addObject(przedmiot1);
        flat1.addObject(przedmiot2);
        flat2.addObject(przedmiot3);
        flat2.addObject(przedmiot4);
        flat3.addObject(przedmiot5);
        flat3.addObject(przedmiot6);
        flat4.addObject(przedmiot7);
        flat5.addObject(przedmiot8);
        flat5.addObject(przedmiot4);
        flat6.addObject(przedmiot9);
        flat6.addObject(przedmiot3);
        flat7.addObject(przedmiot1);
        flat7.addObject(przedmiot2);
        parkingSpace1.addObejct(przedmiot1);
        parkingSpace1.addObejct(przedmiot2);
        parkingSpace1.addObejct(przedmiot3);
        parkingSpace2.addObejct(przedmiot4);
        parkingSpace2.addObejct(przedmiot5);
        parkingSpace2.addObejct(przedmiot6);
        parkingSpace3.addObejct(przedmiot7);
        parkingSpace3.addObejct(przedmiot8);
    }
}