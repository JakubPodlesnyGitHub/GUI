package Vehicles;

public class RailVehicle extends Transport {


    public RailVehicle(VehicleMake marka, String model, int iloscMiejscSiedzacyh, boolean longDistances, boolean shortDistances, boolean blocked) {
        super(marka, model, iloscMiejscSiedzacyh, longDistances, shortDistances, blocked);
    }

    @Override
    public String toString() {
        return "Kolej: " + "Marka-> " + marka + " Model-> " + model + " Ilość miejsc siedzących-> " + iloscMiejscSiedzacyh + "\n";
    }
}
