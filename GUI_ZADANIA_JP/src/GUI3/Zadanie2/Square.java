package GUI3.Zadanie2;

public class Square implements Figure {
    public int length;

    public Square(int length) throws TooBigSquareException {
        if (length > max) {
            throw new TooBigSquareException("Maximum length is " + max);
        }
        this.length = length;
    }

    @Override
    public int getArea() {
        return length * length;
    }

    @Override
    public int getPerimeter() {
        return 4*length;
    }

    @Override
    public String toString() {
        return "Square: " + " Area: " + getArea() + " Paramiter: " + getPerimeter();
    }
}
