package GUI2.Zadanie1;

public class Kolo extends Figura {
    double promien;

    public Kolo(String nazwa, String color, double promien) {
        super(nazwa, color);
        this.promien = promien;
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
        return Math.pow(promien, 2) * Math.PI;
    }

    @Override
    public double obwodFigury() {
        return 2 * Math.PI * promien;
    }
}
