package InterFace;

public interface InterFacePojazdPlywajacy {
    //cechy wspólne dla wszystkich pojazdów pływających
    default void sale(){
        System.out.println("Ten pojazd może poruszać sie po wodzie(pływać)");
    };
    default void stopPlywajacy(){
        System.out.println("Ten pojazd może zatrzymać sie na wodzie");
    };
    default void IsNatatorial(){
        System.out.println("Masa tego pojazdu wypiera taką samą mase wody dzięki czemu może unosić się na jej powierzchni!");
    }
}
