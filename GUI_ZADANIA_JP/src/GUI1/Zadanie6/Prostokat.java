package GUI1.Zadanie6;

import java.util.Scanner;

public class Prostokat {
    private int a;
    private int b;
    private int pole;
    private double przekonta;
    public Prostokat(){
       a=0;
       b=0;
       pole=0;
       czytajDane();
    }
    public void czytajDane(){
        Scanner in = new Scanner(System.in);
        this.a = in.nextInt();
        this.b = in.nextInt();
        this.pole = 2;
        this.przekonta = 4;
    }
    public int obliczPole(){
        this.pole = a * b;
        return this.pole;
    }
    public double obliczPrzekonta(){
        this.przekonta =  Math.sqrt(Math.pow(a,2)+Math.pow(b,2));
        return this.przekonta;
    }

    @Override
    public String toString() {
        return "Prostokat" + " A: " + a + " B: " + b + " Pole: " + pole + " Przekonta: " + przekonta;
    }
}
