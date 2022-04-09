package GUI1.Zadanie14;

public class Person {
    public String imie;
    public int wiek;

    public Person(String imie, int wiek) {
        this.imie = imie;
        this.wiek = wiek;
    }

    public void sayHello(Person p1) {
        System.out.println("HI " + p1.imie);
    }

    @Override
    public String toString() {
        return imie;
    }
}
