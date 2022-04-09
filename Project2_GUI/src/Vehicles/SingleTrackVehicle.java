package Vehicles;

public class SingleTrackVehicle extends Transport {


    public SingleTrackVehicle(VehicleMake marka, String model, int iloscMiejscSiedzacyh, boolean longDistances, boolean shortDistances, boolean blocked) {
        super(marka, model, iloscMiejscSiedzacyh, longDistances, shortDistances, blocked);
    }

    @Override
    public String toString() {
        return "MOTOCYKL: " + "Nazwa-> " + marka + " Model-> " + model + " Ilość miejsc siedzących-> " + iloscMiejscSiedzacyh + "\n";
    }
}
