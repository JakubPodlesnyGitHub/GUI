package GUI2.Zadanie1;

public class Prostokat extends Figura {
    double bok1,bok2;
    public Prostokat(String nazwa, String color,double bok1,double bok2) {
        super(nazwa, color);
        this.bok1 = bok1;
        this.bok2 = bok2;
    }

    @Override
    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public double poleFigury() {
        return bok1 * bok2;
    }

    @Override
    public double obwodFigury() {
        return  2 * bok1 + 2 * bok2;
    }
}
