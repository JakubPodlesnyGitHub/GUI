package GUI2.Zadanie1;

public class Trójkąt extends Figura {
    double bok1, wysokosc, bok2, bok3;

    public Trójkąt(String nazwa, String color, double bok1, double bok2, double bok3) {
        super(nazwa, color);
        this.bok1 = bok1;
        this.bok2 = bok2;
        this.bok3 = bok3;
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
        return 0.5 * bok1 * wysokosc;
    }

    @Override
    public double obwodFigury() {
        return bok1 + bok2 + bok3;
    }
}
