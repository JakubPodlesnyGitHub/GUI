package InterFace;

import Other.Przedmiot;
import People.Person;
import Spaces.Flat;
import Spaces.ParkingSpace;
import Vehicles.Transport;
import Wyjatki.TooManyThingsException;

import java.util.Scanner;


public interface InterFaceNajemca {
    void addPerson(Flat flat, Person person);//dodaje osobe

    void removePerson(Flat flat, Person person);//usuwa osobe

    void addObjectFlat(Przedmiot przedmiot, Flat flat) throws TooManyThingsException;//dodaje przedmiot do mieszkania z ewentualnym rzuceniem wyjątku

    void removeObjectFlat(Przedmiot przedmiot, Flat flat);//usuwa przedmiot z mieszkania

    void addObjectParkingSpace(ParkingSpace parkingSpace, Przedmiot przedmiot) throws TooManyThingsException; //dodaje przedmiot do parkingu z ewentualnym rzuceniem wyjątku

    void removeObjectParkingSpace(ParkingSpace parkingSpace, Przedmiot przedmiot);//usuwa przedmiot z parkingu

    void addVehileParkingSpace(ParkingSpace parkingSpace, Transport transport) throws TooManyThingsException;//dodaje pojazd do parkingu z ewentualnym rzucenim wyjątku

    void removeVehicleParkingSpace(ParkingSpace parkingSpace, Transport transport);//usuwa pojazd z parkingu

    void resingnParkingSpace(ParkingSpace parkingSpace);//rezygnuje z opłat za parking(powoduje to usunięcie wszystkiego z danego parkingu)

    void resingnFlat(Flat flat);//rezygnuje z opłat za mieszkanie(powoduje to usunięcie wszystkiego z danego mieszkania)

    void payForFlat(Flat flat, Scanner scanner);//zapłacenie za mieszkanie(powoduje to usunięcie plikow file)

    void payForParkingSpace(ParkingSpace parkingSpace,Scanner scanner);//zapłacenie za parking(powoduje to usunięcie plikow file)
}
