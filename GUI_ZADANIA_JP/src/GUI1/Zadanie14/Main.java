package GUI1.Zadanie14;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("Jan", 50);
        Student s1 = new Student("Jasiek", 20);
        Person p3 = (Person) s1;
        p1.sayHello(p3);
        p3.sayHello(p1);
        Subject s = new Subject("GUI");
        s.setTeacher(p1);
        try{
            s.addStudent(s1);
        }catch (TooMannyStudentsException e){
            e.printStackTrace();
        }
        System.out.println(s);
    }
}
