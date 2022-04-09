package People;

import Other.File;
import Other.Przedmiot;
import InterFace.InterFaceNajemca;
import Spaces.Flat;
import Spaces.ParkingSpace;
import Vehicles.Transport;
import Wyjatki.TooManyThingsException;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Tenanat extends Person implements InterFaceNajemca {
    //if (parkingSpace.czyMiejsceParkingoweOsiedle == true) sprawdzamy czy dane mieszkanie lub parking znajduja sie w osiedlu
    public boolean czyPosiadaMieszkanie = false;//zmienna do sprawdzania czy dany najemca ma wynajete mieszkanie w celu najmu parkingu
    //--------------------------------------------------
    public ArrayList<Flat> listaMieszkanNajemcy;
    public ArrayList<ParkingSpace> listaParkingowNajemcy;
    public ArrayList<File> listaPlikowFile;
    public ArrayList<Flat> zalegleMieszkania;
    public ArrayList<ParkingSpace> zalegleParkingi;

    public Tenanat(String imie, String nazwisko, String pesel, String adres, String dataUrodzenia) {
        super(imie, nazwisko, pesel, adres, dataUrodzenia);
        this.listaMieszkanNajemcy = new ArrayList<>();
        this.listaParkingowNajemcy = new ArrayList<>();
        this.listaPlikowFile = new ArrayList<>();
        this.zalegleMieszkania = new ArrayList<>();
        this.zalegleParkingi = new ArrayList<>();
    }


    public void addPerson(Flat flat, Person person) {
        if (flat.czyMieszkanieOsiedle == true) {
            if (listaMieszkanNajemcy.contains(flat)) {
                if (person != null)
                    flat.listaOsobNaMieszkanie.add(person);
                else {
                    System.err.println("Brak osoby");
                }
            } else {
                System.out.println("Dane mieszkanie nr: " + flat.flatNumberF + " nie znajduje sie w pomieszczeniach najemcy");
            }
        }
    }

    public void removePerson(Flat flat, Person person) {
        if (flat.listaOsobNaMieszkanie.contains(person)) {
            if (listaMieszkanNajemcy.contains(flat)) {
                if (person != null) {
                    System.out.println("Usunales osobe: " + person + "z mieszkania nr: " + flat.flatNumberF);
                    flat.listaOsobNaMieszkanie.remove(person);
                } else {
                    System.err.println("Brak osoby");
                }
            } else {
                System.out.println("Dane mieszkanie nr: " + flat.flatNumberF + " nie znajduje sie w pomieszczeniach najemcy");
            }
        }
    }

    public void createPersonANDaddFlat(Scanner scanner, ArrayList<Person> personArrayList, Tenanat tenanat, Flat flat) {
        try {
            //Podawanie roznych parametrow do osoby
            System.out.println("Podaj imie: ");
            String imie = scanner.next();
            System.out.println("Podaj nazwisko: ");
            String nazwisko = scanner.next();
            System.out.println("Podaj pesel (9 cyfr): ");
            String pesel = scanner.next();
            System.out.println("Podaj date urodzenia format(dd.mm.rrrr): ");
            String data = scanner.next();
            //System.out.println("Podaj adres format(ulica nrBudynku/nrMieszkania): "); Problem ze scanerem nie chce wczytac adresu
            //String adres = scanner.nextLine();
            String adres = "Akacjowa 2/34";
            tenanat.addPerson(flat, new Person(imie, nazwisko, pesel, adres, data));
            personArrayList.add(new Person(imie, nazwisko, pesel, adres, data));
        } catch (InputMismatchException e) {
            System.err.println("Zle wpisane dane");
        }
    }

    public void addObjectFlat(Przedmiot przedmiot, Flat flat) throws TooManyThingsException {
        if (flat.czyMieszkanieOsiedle == true) { // sprawdzanie czy dane mieszkanie jest w osidelu
            if (listaMieszkanNajemcy.contains(flat)) {
                if (flat.wolnaObjetoscPomiszczeniaMieszkania < przedmiot.objetoscPrzedmiotu) {
                    throw new TooManyThingsException("Remove some old items to insert a new item");
                } else {
                    if (przedmiot != null) {
                        flat.listaObiektoWMieszkaniu.add(przedmiot);//doodanie przedmiotu do listy obiektów w danym mieszkaniu
                        flat.wolnaObjetoscPomiszczeniaMieszkania -= przedmiot.objetoscPrzedmiotu;//odjęcie od objetości(mieszkania) objętość przedmiotu
                        System.out.println("Dodales do mieszkania nr:" + flat.flatNumberF + " przedmiot: " + przedmiot + "\n");
                    } else {
                        System.err.println("Brak przedmiotu");
                    }
                }
            } else {
                System.out.println("Dane mieszkanie nr: " + flat.flatNumberF + " nie znajduje sie w pomieszczeniach najemcy");

            }
        }
    }

    public void removeObjectFlat(Przedmiot przedmiot, Flat flat) {
        if (flat.czyMieszkanieOsiedle == true) { // sprawdzanie czy dane mieszkanie jest w osidelu
            if (listaMieszkanNajemcy.contains(flat)) {
                if (flat.listaObiektoWMieszkaniu.contains(przedmiot)) {// sprawdzanie czy zbiór obiektów które są w mieszkaniu rzeczywiście zawiera dany przedmiot przed usunięciem
                    if (przedmiot != null) {
                        System.out.println("Usunales z mieszkania nr:" + flat.flatNumberF + " przedmiot: " + przedmiot + "\n");
                        flat.listaObiektoWMieszkaniu.remove(przedmiot);//usunięcie przedmiotu z listy obiektów w danym mieszkaniu
                        flat.wolnaObjetoscPomiszczeniaMieszkania += przedmiot.objetoscPrzedmiotu;//po zabraniu przedmiotu objetosc mieszkania powieksza
                    } else {
                        System.err.println("Brak przedmiotu");
                    }
                } else {
                    System.out.println("Tego przedmiotu: " + przedmiot + " nie ma w mieszkaniu nr: " + flat.flatNumberF);
                }
            } else {
                System.out.println("Dane mieszkanie nr: " + flat.flatNumberF + " nie znajduje sie w pomieszczeniach najemcy");
            }
        }
    }

    public void addObjectParkingSpace(ParkingSpace parkingSpace, Przedmiot przedmiot) throws TooManyThingsException {
        if (parkingSpace.czyMiejsceParkingoweOsiedle == true) {// sprawdzanie czy dany parking jest w osiedlu
            if (listaParkingowNajemcy.contains(parkingSpace)) {//sprawdzanie czy dany parking znajduje sie w parkingach najemcy(zeby nie mogl dodac do nie swojego parkingu)
                parkingSpace.wolnaObjetoscPomiszczeniaParkingu -= przedmiot.objetoscPrzedmiotu;//odjęcie od objetości(parkingu) objętość przedmiotu
                if (parkingSpace.wolnaObjetoscPomiszczeniaParkingu < przedmiot.objetoscPrzedmiotu) {
                    throw new TooManyThingsException("Remove some old items to insert a new item");
                } else {
                    System.out.println("Do parkingu nr: " + parkingSpace.parkingNumberP + " zostal dodany przedmiot: " + przedmiot + "\n");
                    parkingSpace.parkingSpaceObjectList.add(przedmiot);
                }
            } else {
                System.out.println("Dany parking nr: " + parkingSpace.parkingNumberP + " nie znajduje sie w pomieszczeniach najemcy");
            }
        }
    }

    public void removeObjectParkingSpace(ParkingSpace parkingSpace, Przedmiot przedmiot) {
        if (parkingSpace.czyMiejsceParkingoweOsiedle == true) {// sprawdzanie czy dane mieszkanie jest w osiedlu
            if (listaParkingowNajemcy.contains(parkingSpace)) {//sprawdzanie czy dany parking znajduje sie w parkingach najemcy(zeby nie mogl usunac z nie swojego parkingu)
                if (parkingSpace.parkingSpaceObjectList.contains(przedmiot)) {// sprawdzanie czy zbiór obiektów które są w parkingu rzeczywiście zawiera dany przedmiot przed usunięciem
                    parkingSpace.wolnaObjetoscPomiszczeniaParkingu += przedmiot.objetoscPrzedmiotu;//po zabraniu przedmiotu objetosc parkingu powieksza
                    System.out.println("Usunales z parkingu nr: " + parkingSpace.parkingNumberP + "przedmiot: " + przedmiot + "\n");
                    parkingSpace.parkingSpaceObjectList.remove(przedmiot);
                } else {
                    System.out.println("Tego przedmiotu: " + przedmiot + " nie ma w parkingu nr: " + parkingSpace.parkingNumberP);
                }
            } else {
                System.out.println("Dany parking nr: " + parkingSpace.parkingNumberP + " nie znajduje sie w pomieszczeniach najemcy");
            }
        }
    }

    public void addVehileParkingSpace(ParkingSpace parkingSpace, Transport transport) throws TooManyThingsException {
        if (parkingSpace.czyMiejsceParkingoweOsiedle == true) {// sprawdzanie czy dane mieszkanie jest w osiedlu
            if (listaParkingowNajemcy.contains(parkingSpace)) {//sprawdzanie czy dany parking znajduje sie w parkingach najemcy(zeby nie mogl dodac do nie swojego parkingu)
                parkingSpace.wolnaObjetoscPomiszczeniaParkingu -= transport.pojemnosc;//odjęcie od całkowitej objetości(parkingu) objętość pojazdu
                if (parkingSpace.wolnaObjetoscPomiszczeniaParkingu < transport.pojemnosc) {
                    throw new TooManyThingsException("Remove some old items to insert a new item");
                } else {
                    System.out.println("Do parkingu nr: " + parkingSpace.parkingNumberP + " zostal dodany pojazd: " + transport + "\n");
                    parkingSpace.pojazd = transport;//przypisuje do pola pojazd obiekt typu transport(dodanie pojazdu do parkingu)
                }
            } else {
                System.out.println("Dany parking nr: " + parkingSpace.parkingNumberP + " nie znajduje sie w pomieszczeniach najemcy");
            }
        }
    }

    public void removeVehicleParkingSpace(ParkingSpace parkingSpace, Transport transport) {
        if (parkingSpace.czyMiejsceParkingoweOsiedle == true) { // sprawdzanie czy dane mieszkanie jest w osiedlu
            if (parkingSpace.pojazd != null) {//sprawdzanie czy miejsce parkingowe zawiera pojazd
                parkingSpace.wolnaObjetoscPomiszczeniaParkingu += transport.pojemnosc;//po zabraniu pojazdu objetosc parkingu powieksza
                System.out.println("Usunales z parkingu nr: " + parkingSpace.parkingNumberP + " pojazd: " + parkingSpace.pojazd + "\n");
                parkingSpace.pojazd = null;//usunięcie pojazdu
            }
        } else {
            System.out.println("Na tym parkignu nr: " + parkingSpace.parkingNumberP + " znajduje sie już pojazd " + transport);
        }
    }

    public void resingnFlat(Flat flat) {
        if (listaMieszkanNajemcy.contains(flat)) {//sprawdzanie czy dane mieszkanie znajduje sie w mieszkaniach najemcy(zeby nie mogl zrezygnowac z nie swojego mieszkania)
            System.out.println("Najemca-> " + this.imie + " " + this.nazwisko + " zrezygnowal z mieszkania nr: " + flat.flatNumberF + "\n");
            flat.czyPosiadaNajemcaMieszkanie = false;
            flat.zaleglosciMieszkanie = false;
            flat.zaleglosciFlatS = false;
            flat.listaOsobNaMieszkanie.clear();//usuniecie osob w mieszkaniu
            flat.wolnaObjetoscPomiszczeniaMieszkania = flat.objetoscMieszkania;//przywraca objetosc pomieszczenia do oryginalnej
            flat.listaObiektoWMieszkaniu.clear();//czyczenie mieszkania z przedmiotow
            listaPlikowFile.clear();//usuniecie plikow file
            flat.tenanat = null;
        } else {
            System.out.println("Mieszkanie nr: " + flat.flatNumberF + " nie podlega danemu najemcy. Prosze wybrac inne\n");
        }
    }

    public void resingnParkingSpace(ParkingSpace parkingSpace) {
        if (listaParkingowNajemcy.contains(parkingSpace)) {//sprawdzanie czy dany parking znajduje sie w parkingach najemcy(zeby nie mogl zrezygnowac z nie swojego parkingu)
            System.out.println("Najemca-> " + this.imie + " " + this.nazwisko + " zrezygnowal z parkingu nr: " + parkingSpace + "\n");
            parkingSpace.czyPosiadaNajemcaParking = false;
            parkingSpace.zaleglosciParkingu = false;
            parkingSpace.zaleglosciParknigS = false;
            parkingSpace.wolnaObjetoscPomiszczeniaParkingu = parkingSpace.objetoscMiejscaParkingowego; // przywraca objetosc pomieszczenia do oryginalnej
            parkingSpace.parkingSpaceObjectList.clear();// czyszczenie parkingu z przedmiotow
            listaParkingowNajemcy.remove(parkingSpace);//usuwa parking z parkingow najemcy
            parkingSpace.tenanat = null;
        } else {
            System.out.println("Parking nr: " + parkingSpace.parkingNumberP + " nie podlega danemu najemcy. Prosze wybrac inny\n");
        }
    }

    public void payForFlat(Flat flat, Scanner scanner) {
        if (flat.czyPosiadaNajemcaMieszkanie == true && listaMieszkanNajemcy.contains(flat)) {
            if (flat.zaleglosciMieszkanie == true) { //sprawdza czy dane mieszkanie ma zaleglosci
                listaPlikowFile.clear();
                System.out.println("Podaj o ile miesiecy chcesz przedluzyc najem parkingu: ");
                int iloscMiesiecyMieszkanie = scanner.nextInt();
                flat.koniecNajmuMieszkania = flat.koniecNajmuMieszkania.plusMonths(iloscMiesiecyMieszkanie);//przedluzenie o 1 miesiac najmu
                flat.koniecCzasuMieszkanieEKSMISJA = flat.koniecCzasuMieszkanieEKSMISJA.plusMonths(iloscMiesiecyMieszkanie);//przedluzenie o 1 miesiac do eksmisji
                flat.zaleglosciFlatS = false;//jesli najemca zaplaci za mieszkaie to powiadomienie przy nastepnej zaleglosci pojawi sie
                flat.zaleglosciMieszkanie = false;//jesli najemca zaplaci za mieszkanie to przy nastepnej zaleglosci doda sie plik file do listy
                System.out.println("Oplaciles mieszkanie nr: " + flat.flatNumberF + " na kolejne  " + iloscMiesiecyMieszkanie + " miesiace do dnia-> " + flat.koniecNajmuMieszkania);
            }
        }
    }

    public void payForParkingSpace(ParkingSpace parkingSpace, Scanner scanner) {
        if (parkingSpace.czyPosiadaNajemcaParking == true && listaMieszkanNajemcy.contains(parkingSpace)) {
            if (parkingSpace.zaleglosciParkingu == true) {//sprawdza czy dany parking ma zaleglosci
                listaPlikowFile.clear();
                System.out.println("Podaj o ile miesiecy chcesz przedluzyc najem parkingu: ");
                int iloscMiesiecyParking = scanner.nextInt();
                parkingSpace.koniecNajmuParkingu = parkingSpace.koniecNajmuParkingu.plusMonths(iloscMiesiecyParking);//przedluzenie o iloscMiesiecy najmu
                parkingSpace.koniecCzasuParkingEKSMISJA = parkingSpace.koniecCzasuParkingEKSMISJA.plusMonths(iloscMiesiecyParking);//przedluzenie o koniec najmu plus1 do eksmisji
                parkingSpace.zaleglosciParknigS = false;//jesli na najemca zaplaci za parking to powiadomienie przy nastepnej zaleglosci pojawi sie
                parkingSpace.zaleglosciParkingu = false;//jesli najemca zaplaci za parking to przy nastepnej zaleglosci doda sie plik file do listy
                System.out.println("Oplaciles parking nr: " + parkingSpace.parkingNumberP + " na kolejne " + iloscMiesiecyParking + " miesiace do dnia-> " + parkingSpace.koniecNajmuParkingu);
            }
        }
    }

}
