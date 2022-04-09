package Vehicles;

public class FloatingVehicleBoat extends Transport {


    public FloatingVehicleBoat(VehicleMake marka, String model, int iloscMiejscSiedzacyh, boolean longDistances, boolean shortDistances, boolean blocked) {
        super(marka, model, iloscMiejscSiedzacyh, longDistances, shortDistances, blocked);
    }

    @Override
    public String toString() {
        return "LÓDŹ: " + "Nazwa-> " + marka + " Model-> " + model + " Dane techniczne: " + " Ilość miejsc siedzących-> " + iloscMiejscSiedzacyh + "\n";
    }
}
