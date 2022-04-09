package Vehicles;

public class RoadVehicleAutoCar extends Transport {


    public RoadVehicleAutoCar(VehicleMake marka, String model, int iloscMiejscSiedzacyh, boolean longDistances, boolean shortDistances, boolean blocked) {
        super(marka, model, iloscMiejscSiedzacyh, longDistances, shortDistances, blocked);
    }

    @Override
    public String toString() {
        return "AUTOKAR: " + "Marka-> " + marka + " Model-> " + model + " Ilość miejsc siedzących-> " + iloscMiejscSiedzacyh +"\n";
    }
}
