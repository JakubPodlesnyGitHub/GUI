package GUI2.Zadanie1;

public class Kwadrat extends Figura {
    double bok;
    public Kwadrat(String nazwa, String color,double bok) {
        super(nazwa, color);
        this.bok = bok;
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
        return bok * bok;
    }

    @Override
    public double obwodFigury() {
        return 4 * bok;
    }
}
