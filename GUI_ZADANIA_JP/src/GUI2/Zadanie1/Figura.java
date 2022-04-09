package GUI2.Zadanie1;

public abstract class Figura {
    public String nazwa;
    public String color;

    public Figura(String nazwa, String color) {
        this.nazwa = nazwa;
        this.color = color;

    }

    public abstract void setNazwa(String nazwa);
    public abstract void setColor(String color);
    public abstract double poleFigury();
    public abstract double obwodFigury();

    @Override
    public String toString() {
        return "Nazwa: " + nazwa + " Kolor: " + color + " Pole: " + poleFigury() + " Obwód: " + obwodFigury();
    }
}
