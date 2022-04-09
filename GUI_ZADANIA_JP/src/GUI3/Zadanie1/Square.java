package GUI3.Zadanie1;

public class Square implements Comparable {
    int length;
    int number;
    private static int counter = 1;

    public Square(int length) {
        this.length = length;
        number = counter++;
    }

    public int getArea() {
        return length * length;
    }

    @Override
    public int compareTo(Object o) {
        Square s = (Square)o;
        return length - s.length;
    }

    @Override
    public String toString() {
        return "(" + number + "): " + getArea();
    }
}


