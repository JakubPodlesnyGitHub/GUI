package Vehicles;

public class RoadVehicleCar extends Transport{


    public RoadVehicleCar(VehicleMake marka, String model, int iloscMiejscSiedzacyh, boolean longDistances, boolean shortDistances, boolean blocked) {
        super(marka, model, iloscMiejscSiedzacyh, longDistances, shortDistances, blocked);
    }

    @Override
    public String toString() {
        return "SAMOCHÓD: " + "Marka-> " + marka + " Model-> " + model + " Ilość miejsc siedzących-> " + iloscMiejscSiedzacyh + "\n";
    }
}
