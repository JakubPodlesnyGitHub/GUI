package Other;

import People.Tenanat;
import Spaces.Flat;
import Spaces.ParkingSpace;

public class File {
    Flat flat;
    Tenanat tenanat;
    ParkingSpace parkingSpace;

    public File(Flat flat, Tenanat tenanat) {
        this.flat = flat;
        this.tenanat = tenanat;
    }

    public File(ParkingSpace parkingSpace, Tenanat tenanat) {
        this.parkingSpace = parkingSpace;
        this.tenanat = tenanat;
    }

}
