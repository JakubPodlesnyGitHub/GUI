package InterFace;

public interface InterFacePojazdDrogowy {
    //cechy wspólne dla wszystkich pojazdów drogowych
    default void drive(){
        System.out.println("Ten pojazd może poruszać się na drodze");
    };
    default void stopDrogowy(){ System.out.println("Ten pojazd może zatrzymać się na drodze"); };
    default void drift(){
        System.out.println("Ten pojazd może driftować");
    }

}
