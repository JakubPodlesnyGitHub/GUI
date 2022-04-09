package GUI3.Zadanie3;

public class Urzadzenie implements Comparable{
    public String nazwaProducenta;
    public   double cenaUrzadzenia;

    @Override
    public int compareTo(Object o) {
        Urzadzenie u = (Urzadzenie)o;
        return (int)(cenaUrzadzenia) - (int)u.cenaUrzadzenia;
    }
}
