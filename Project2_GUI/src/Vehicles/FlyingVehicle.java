package Vehicles;

public class FlyingVehicle extends Transport{


    public FlyingVehicle(VehicleMake marka, String model, int iloscMiejscSiedzacyh, boolean longDistances, boolean shortDistances, boolean blocked) {
        super(marka, model, iloscMiejscSiedzacyh, longDistances, shortDistances, blocked);
    }

    @Override
    public String toString() {
        return "Samolot: " + "Marka-> " + marka + " Model-> " + model + " Ilość miejsc siedzących-> " + iloscMiejscSiedzacyh + " Ilość miejsc siedzacych-> " + iloscMiejscSiedzacyh + "\n";
    }
}
