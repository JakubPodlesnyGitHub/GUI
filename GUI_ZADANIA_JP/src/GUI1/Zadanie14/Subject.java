package GUI1.Zadanie14;

import java.util.TooManyListenersException;

public class Subject {
    String nazwaPrzedmiotu;
    String teacher;
    Student[] listaStudentow;
    private int index = 0;

    public Subject(String nazwaPrzedmiotu) {
        this.nazwaPrzedmiotu = nazwaPrzedmiotu;
        this.listaStudentow = new Student[5];
    }

    public void setTeacher(Person p1) {
        this.teacher = p1.imie;
    }

    public void addStudent(Student student) throws TooMannyStudentsException {
        if (index > 4) {
            throw new TooMannyStudentsException();
        } else {
            listaStudentow[index++] = student;
        }
    }

    public String zwrocStudentow() {
        String lista = "";
        for (int i = 0; i < listaStudentow.length; i++) {
            if(listaStudentow[i] != null)
            lista += listaStudentow[i] + " . ";
        }
        return lista;
    }

    @Override
    public String toString() {
        return nazwaPrzedmiotu + " , " + "teacher: " + teacher + " , " + "students: " + zwrocStudentow();
    }
}
