package Spaces;

import Other.File;
import Other.Przedmiot;
import People.Tenanat;
import Vehicles.Transport;
import Wyjatki.ProblematicTenantException;
import Wyjatki.TooMannyRentals;

import java.time.LocalDate;
import java.util.ArrayList;

public class ParkingSpace implements Comparable {
    public double objetoscMiejscaParkingowego;//w m^3
    public double wolnaObjetoscPomiszczeniaParkingu;//w m^3
    public Tenanat tenanat;
    public int parkingNumberP;//odbiór numeru mieszkania
    public boolean czyMiejsceParkingoweOsiedle = false;//odbiór(czy znajduje sie w osiedlu)
    public boolean czyPosiadaNajemcaParking = false; //sprawdza czy dla danego miejsca parkingowego jest juz przypisany najemca
    public boolean zaleglosciParkingu = false;//zmienna regulujaca dodawanie plikow file
    public boolean zaleglosciParknigS = false;//zmienna regulujaca powiadomienie o zaleglosciach na dane mieszkanie
    //-----------------------------------------------------------
    public LocalDate poczatekNajmuParkingu;
    public LocalDate koniecNajmuParkingu;
    public LocalDate koniecCzasuParkingEKSMISJA;
    //-----------------------------------------------------------
    public ArrayList<Przedmiot> parkingSpaceObjectList; // tworzenie listy z obiektami na parkingu
    public Transport pojazd;//tworzenie pola z obiektem klasy Transport(pojazd)

    public ParkingSpace(double objetoscMiejscaParkingowego) {//konstruktor z 1 zmienna(objetosc)
        this.objetoscMiejscaParkingowego = objetoscMiejscaParkingowego;//incjalizacja objetosci miejsca parkingowego
        this.wolnaObjetoscPomiszczeniaParkingu = objetoscMiejscaParkingowego;//przypisanie objetosci "roboczej" objetosc rzeczywista
        //-------------------------
        this.parkingSpaceObjectList = new ArrayList<>(); // inicjalizacja listy obiektów

    }

    public ParkingSpace(double dlugosc, double szerokosc, double wysokosc) {//konstruktor z 3 zmiennymi(objetosc)
        this.objetoscMiejscaParkingowego = dlugosc * szerokosc * wysokosc;//incjalizacja objetosci(przez wymnożenie) miejsca parkingowego
        this.wolnaObjetoscPomiszczeniaParkingu = objetoscMiejscaParkingowego;//przypisanie objetosci "roboczej" objetosc rzeczywista
        //-------------------------
        this.parkingSpaceObjectList = new ArrayList<>(); // inicjalizacja listy obiektow

    }

    //-----------------------------
    public void addTenant(Tenanat tenant, LocalDate start) throws TooMannyRentals, ProblematicTenantException {//dodawanie do mieszkania najemce
        if (tenant.czyPosiadaMieszkanie == true) {
            if (czyPosiadaNajemcaParking == false) {//sprawdza czy parking ma już najmce
                if (tenant.listaPlikowFile.size() >= 3) {//sprawdza czt dany najemca ma wiecej niz 3 pliki jesli tak to wyjatek
                    throw new ProblematicTenantException("\nOsoba: " + tenant.imie + tenant.nazwisko + " posiadala juz najem pomieszczen: Mieszkania: " + tenant.zalegleMieszkania + " Parkingi: " + tenant.zalegleParkingi); // wyrzucenie wyjątku jeśli dany najemca posiada więcej niż 3 obiekty typu File
                } else {
                    if ((tenant.listaMieszkanNajemcy.size() + tenant.listaParkingowNajemcy.size()) >= 5) {//sparawdza czy dany najemca ma wiecej niz 5 najmow
                        throw new TooMannyRentals("\nTa osoba ma za duzo najmow! Prosze usun jedno pomieszczenie.");
                    } else {
                        czyPosiadaNajemcaParking = true;// ustawia dane pole na true(czyli dane mieszkanie ma najemce)
                        this.poczatekNajmuParkingu = start; // ustawia poczatek najmu na date dostarczona wraz z najemcą
                        this.koniecNajmuParkingu = start.plusMonths(1); //ustawia koniec najmu na date dostarczona wraz z najemcą
                        this.koniecCzasuParkingEKSMISJA = koniecNajmuParkingu.plusMonths(1);//ustawia eksmisje na date miesiac poxniej daty konca najmu
                        tenant.listaParkingowNajemcy.add(this);//dodaje do lisy wynajmowanych parkingów dany parking
                        this.tenanat = tenant;//przypisanie najemcy do pola najemcy w parkingu
                    }
                }
            } else {
                System.out.println("Ten parking nr: " + parkingNumberP + " ma już najmce.\n");
            }

        } else {
            System.out.println("Tego parkingu nr: " + parkingNumberP + " nie mozna wynajac poniewaz najemca nie ma wynajetego mieszkania\n");
        }
    }

    //-----------------------------------
    public void checkPayment(LocalDate aktualnaData) {
        if (czyPosiadaNajemcaParking == true) {
            if (aktualnaData.isAfter(koniecNajmuParkingu)) {
                if (zaleglosciParkingu == false) {
                    tenanat.listaPlikowFile.add(new File(this, tenanat));//dodanie pliku file do listy
                    zaleglosciParkingu = true;//ustawia zaleglosci na true
                    tenanat.zalegleParkingi.add(this);//dodaje dane mieszkanie do listy zaleglych mieszkan(probelematicTenantException e)
                }
                if (zaleglosciParknigS == false) {
                    System.out.println("Najemca: " + tenanat.imie + " " + tenanat.nazwisko + " ma zaleglosci w placeniu.");
                    zaleglosciParknigS = true;
                }
            }
            if (aktualnaData.isAfter(koniecCzasuParkingEKSMISJA) && zaleglosciParkingu == true) {
                if (tenanat.listaParkingowNajemcy.contains(this)) {
                    if (pojazd == null) {//sprawdza czy znajduje sie na miejscu parkingowym pojazd
                        // sprawdza czy dany parking zawiera sie w mieszkaniach najemcy
                        czyPosiadaNajemcaParking = false;
                        wolnaObjetoscPomiszczeniaParkingu = objetoscMiejscaParkingowego;//powrot do oryginalnej wersji pomieszczenia
                        parkingSpaceObjectList.clear();//czyszczenie pomieszczenia z obiektow
                        System.out.println("Nastapilo wyrzucenie najemcy: " + tenanat.imie + " " + tenanat.nazwisko + " z parkingu nr: " + parkingNumberP);
                        tenanat = null;//usuniecie najemcy
                    } else {
                        pojazd = null;//usuniecie pojazdu przez eksmisje
                        koniecCzasuParkingEKSMISJA = koniecNajmuParkingu.plusMonths(2); // pokrycie najmu na najblizsze dwa miesiace(usuniecie pojazdu)
                        System.out.println("Pojazd zostal usuniety z parkingu natomiast najem zostal przedluzony do dnia-> " + koniecNajmuParkingu.plusMonths(2));
                    }
                } else {
                    System.out.println("Parking nr: " + parkingNumberP + " nie podlega danemu najemcy. Prosze wybrac inny");
                }
            }
        }
    }

    //------------------------metody do przygotowania pomieszczen-------------------------
    public void addObejct(Przedmiot przedmiot) {
        wolnaObjetoscPomiszczeniaParkingu -= przedmiot.objetoscPrzedmiotu;
        if (przedmiot.objetoscPrzedmiotu < wolnaObjetoscPomiszczeniaParkingu) {
            parkingSpaceObjectList.add(przedmiot);
        } else {
            System.err.println("Brak miejsca. Musisz usunac przedmioty lub pojazd.");
        }
    }

    public void addVehicle(Transport transport) {
        wolnaObjetoscPomiszczeniaParkingu -= transport.pojemnosc;
        if (transport.pojemnosc < wolnaObjetoscPomiszczeniaParkingu) {
            pojazd = transport;
        } else {
            System.err.println("Brak miejsca. Musisz usunac przedmioty lub pojazd.");
        }
    }

    //-----------------------------------------------------------------------------------
    @Override
    public int compareTo(Object o) { //porównanie objętości miejsca parkingowego z objetoscią dostarczonego obiektu
        ParkingSpace parkingSpace = (ParkingSpace) (o);
        return (int) (objetoscMiejscaParkingowego - parkingSpace.objetoscMiejscaParkingowego);
    }

    @Override
    public String toString() { //do ProblematicTenantException
        if (!tenanat.listaParkingowNajemcy.isEmpty())
            return "Parking: " + parkingNumberP;
        else
            return "Parking nr: Brak parkignow";
    }
}
