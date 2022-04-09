package GUI1.Zadanie8;

public class Cennik {
    public double cenaJablko = 2.0;
    public double cenaMajonezu = 4.6;

    public static Cennik getInstanceOf() {
        return new Cennik();
    }

    public double ileKosztuje(String nazwa){
        if(nazwa.equals("jabko")){
            return  cenaJablko;
        }
        else if(nazwa.equals("Mojenz")){
            return cenaMajonezu;
        }else{
            return -1;
        }
    }
    public void wyswietlCennik(){
        System.out.println("-----CENNIK------");
        System.out.println("Jabłko - > " + cenaJablko + " \nMajonez -> " + cenaMajonezu);
    }
}
