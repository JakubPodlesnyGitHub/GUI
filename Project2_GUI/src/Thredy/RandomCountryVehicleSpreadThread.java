package Thredy;

import Countries.Country;
import Vehicles.*;

import javax.swing.*;
import java.util.ArrayList;


public class RandomCountryVehicleSpreadThread  extends Thread{
    JTextField jTexFiledNumberOfInfectedPeople;
    int timeSpreadVirus;
    ArrayList<Country> countries;
    Country selectedCountry1;
    Country selectedCountry2;
    Transport selectedTransport;

    public RandomCountryVehicleSpreadThread(JTextField jTextFieldNumberOfInfectedPeople, ArrayList<Country> countries, int timeSpreadVirus) {
        this.jTexFiledNumberOfInfectedPeople = jTextFieldNumberOfInfectedPeople;
        this.countries = countries;
        this.timeSpreadVirus = timeSpreadVirus;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if(Thread.currentThread().isInterrupted())
                    return;
                Thread.sleep(timeSpreadVirus);//uspienie watku na 1 sekund
                randomCountries();//losowanie krajow
                randomTransport();//losowanie transportu
                blockVehicle();//"Zamykanie granic"/blokowanie poczegolnych transportow wedlug liczby zakazonych
                vehicleInfection();//cialo watku do zarazania sie przez srodki transportu
            } catch (InterruptedException e) {
                System.err.println("!!Watek zostal przerwany.!!");
            }

        }

    }

    public void vehicleInfection() {
        //krutkie i dlugie dystanse
        if (!selectedCountry1.equals(selectedCountry2)) {//sprawdzam czy dane kraje są równe
            if (selectedCountry1.continent.equals(selectedCountry2.continent)) {//sprawdzam czy dane kraje sa na tym samym kontynecie
                if (((selectedTransport.shortDistances || selectedTransport.longDistances) && !selectedTransport.blocked)) {//sprawdzam czy dany transport nie jest zablokowany i czy moze poruszac sie na dlugie lub krotkie dystanse
                    if (selectedCountry1.infecetdPeople.size() - selectedTransport.iloscMiejscSiedzacyh >= 0 && selectedCountry2.infecetdPeople.size() + selectedTransport.iloscMiejscSiedzacyh <= selectedCountry2.people.size()) { //sprawdzanie czy dany transport nie przewyższa ludności
                        for (int i = 0; i < selectedTransport.iloscMiejscSiedzacyh; i++) {
                            if(selectedCountry1.people.get(i).isInfected()) {//sprawdzam czy w kraju nr 1 dana osoba jest zarazona
                                selectedCountry2.infecetdPeople.add(selectedCountry1.people.get(i));// dodaje do listy zarazonych kraju 2 ludzi zarazonych z kraju 1
                                selectedCountry1.infecetdPeople.remove(selectedCountry1.people.get(i));//usuwa ludzi zarazonych  z kraju 1
                            }
                        }
                    }
                }
                //dlugie dystanse
            } else if (!selectedCountry1.continent.equals(selectedCountry2.continent)) {
                if (selectedTransport.longDistances && !selectedTransport.blocked) {//sprawdzam czy dany transport nie jest zablokowany i czy moze poruszac sie na dlugie dystanse
                    if (selectedCountry1.infecetdPeople.size() - selectedTransport.iloscMiejscSiedzacyh >= 0 && selectedCountry2.infecetdPeople.size() + selectedTransport.iloscMiejscSiedzacyh <= selectedCountry2.people.size()) {//sprawdzanie czy dany transport nie przewyższa ludności
                        for (int i = 0; i < selectedTransport.iloscMiejscSiedzacyh; i++) {
                            if(selectedCountry1.people.get(i).isInfected()) {//sprawdzam czy w kraju nr 1 dana osoba jest zarazona
                                selectedCountry2.infecetdPeople.add(selectedCountry1.people.get(i));// dodaje do listy zarazonych kraju 2 ludzi zarazonych z kraju 1
                                selectedCountry1.infecetdPeople.remove(selectedCountry1.people.get(i));//usuwa ludzi zarazonych  z kraju 1
                            }
                        }
                    }
                }
            }
        }
    }

    public void randomCountries() {//losowy kraj
        int selectedCountryIndex1 = (int) (Math.random() * countries.size());
        selectedCountry1 = countries.get(selectedCountryIndex1);
        //System.out.println("Vehicle spread: Country1: " + selectedCountry1);
        int selectedCountryIndex2 = (int) (Math.random() * countries.size());
        selectedCountry2 = countries.get(selectedCountryIndex2);
        //System.out.println("Vehicle spread: Country2: " + selectedCountry1);
    }

    public void randomTransport() {//losowy transport
        int selectedTransportIndex = (int) (Math.random() * selectedCountry1.transportArrayList.size());
        selectedTransport = selectedCountry1.transportArrayList.get(selectedTransportIndex);
        //System.out.println("oryginal " + selectedTransport);
    }

    public void blockVehicle() {//Kod można było napisać lepiej
        //sprawdzanie czy dany transport może podrozowac czy moze juz ma blokoade
        for (Transport transport : selectedCountry1.transportArrayList) {
            if (transport.getClass().equals(FloatingVehicleCargo.class) && selectedCountry1.infecetdPeople.size() >= selectedCountry1.floatingVehicleCargos) {//cargo
                transport.blocked = true;
            } else if (transport.getClass().equals(FloatingVehicleBoat.class) && selectedCountry1.infecetdPeople.size() >= selectedCountry1.floatingVehicleBoats) {//lodzie
                transport.blocked = true;
            } else if (transport.getClass().equals(FlyingVehicle.class) && selectedCountry1.infecetdPeople.size() >= selectedCountry1.flyingVehicles) {//samoloty
                transport.blocked = true;
            } else if (transport.getClass().equals(RailVehicle.class) && selectedCountry1.infecetdPeople.size() >= selectedCountry1.railVehicles) {//pociagi
                transport.blocked = true;
            } else if (transport.getClass().equals(RoadVehicleAutoCar.class) && selectedCountry1.infecetdPeople.size() >= selectedCountry1.roadVehiclesAutocars) {//autkoary
                transport.blocked = true;
            } else if (transport.getClass().equals(RoadVehicleCar.class) && selectedCountry1.infecetdPeople.size() >= selectedCountry1.roadVehiclesCars) {//samochody
                transport.blocked = true;
            } else if (transport.getClass().equals(SingleTrackVehicle.class) && selectedCountry1.infecetdPeople.size() >= selectedCountry1.singleTrackVehicles) {//motocykele
                transport.blocked = true;
            }
        }
    }
}

