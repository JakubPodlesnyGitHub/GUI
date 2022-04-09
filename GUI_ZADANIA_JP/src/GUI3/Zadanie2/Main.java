package GUI3.Zadanie2;

public class Main {
    public static void main(String[] args) {
        try {
            Square s1 = new Square(2);
            System.out.println(s1);
            Square s2 = new Square(2);
            System.out.println(s2);
            Square s3 = new Square(12);
            System.out.println(s3);
            Square s4 = new Square(15);
            System.out.println(s4);
            Square s5 = new Square(20);
            System.out.println(s5);

        }catch (TooBigSquareException e){
            e.printStackTrace();
        }
    }
}
