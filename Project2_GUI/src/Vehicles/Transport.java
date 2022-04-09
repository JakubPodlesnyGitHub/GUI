package Vehicles;

public class Transport {
    public VehicleMake marka;
    public String model;
    public int iloscMiejscSiedzacyh;
    public boolean longDistances;
    public boolean shortDistances;
    public boolean blocked;
    public Transport(VehicleMake marka,String model,int iloscMiejscSiedzacyh,boolean longDistances,boolean shortDistances,boolean blocked) {
        this.model = model;
        this.iloscMiejscSiedzacyh = iloscMiejscSiedzacyh;
        this.marka = marka;
        this.longDistances = longDistances;
        this.shortDistances = shortDistances;
        this.blocked = blocked;
    }

}
