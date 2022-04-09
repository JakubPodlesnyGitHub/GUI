package Spaces;

import Wyjatki.TooMannyFlats;
import Wyjatki.TooMannyParkingSpace;


import java.util.ArrayList;

public class Estate {
    public String nazwa;
    //-------------------
    public ArrayList<Flat> listaMieszkan;
    public ArrayList<ParkingSpace> listaMiejscParkingowych;

    //--------------------Mieszkanie i MiejsceParkingowe-------------------------
    public int flatNumber;
    public int parkingNumber;
    private int counterAmount = 0;
    //-------------------
    public int numberOfSurafaces;
    private static int surfaceCounter = 0;

    public Estate(String nazwa, int numberOfSurafaces) {
        this.nazwa = nazwa;//(podanie nazwy)
        this.numberOfSurafaces = numberOfSurafaces;//przypisanie ilości od użytkownika
        //-----------------------------------------------------------------------------
        listaMieszkan = new ArrayList<>();// incjonowanie listy mieszkań
        listaMiejscParkingowych = new ArrayList<>();//incjonowanie listy miejsc parkingowych
        //-----------------------------M i P---------------------------------
        flatNumber = surfaceCounter;//nadawanie mieszkanom unikalnych numerów
        parkingNumber = surfaceCounter;//nadawanie parkingom unikalnych numerów
        surfaceCounter++;//to samo co u góry
        //----------------------------------------------------------------

    }

    public void addFlat(Flat flat) throws TooMannyFlats { // dodawanie nowego obiektu "mieszkania" do tablicy(wraz z unikalnym numerem indetyfikacyjnym)
        if (counterAmount < numberOfSurafaces) {
            if (flatNumber > numberOfSurafaces) {
                throw new TooMannyFlats("Nie mozesz dodac kolejnego mieszkania do osiedla ,poniewaz już jest maksymalna ilosc.");
            } else {
                flat.flatNumberF = flatNumber;//pzekazanie numeru mieszkania
                flat.czyMieszkanieOsiedle = true;
                listaMieszkan.add(flatNumber++, flat);
                counterAmount++;
            }
        } else {
            System.out.println("Nie mozesz dodac wiecej mieszkan.");
        }
    }

    public void addParkingPlace(ParkingSpace parking) throws TooMannyParkingSpace { // dodawanie nowego obiektu "parkingu" do tablicy(wraz z unikalnym numerem indetyfikacyjnym)
        if (counterAmount < numberOfSurafaces) {
            if (parkingNumber > numberOfSurafaces) {
                throw new TooMannyParkingSpace("Nie mozesz dodac kolejnego miejsca parkingowego do osiedla poniewaz juz jest maksymalna ilosc.");
            } else {
                parking.parkingNumberP = parkingNumber;
                parking.czyMiejsceParkingoweOsiedle = true;
                listaMiejscParkingowych.add(parkingNumber++, parking);
            }
        } else {
            System.out.println("Nie mozesz dodac wiecej parkingow.");
        }
    }

    @Override
    public String toString() {
        return "Osiedle -> " + nazwa + ". Maksymalna liczba mieszkan i miejsc parkingowych wynosi: " + numberOfSurafaces + "\n";
    }
}
