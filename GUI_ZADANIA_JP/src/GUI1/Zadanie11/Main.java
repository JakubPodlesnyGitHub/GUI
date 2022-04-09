package GUI1.Zadanie11;

public class Main {
    public static void main(String[] args) {
        Pacjent[] pacjenci = { new ChorynaGlowe("Janek"),
                new ChorynaNoge("Edzio"),
                new ChoryNaDyspepsje("Marian")
        };

        for (Pacjent p : pacjenci) {
            System.out.println("Pacjent: " + p.nazwisko() + '\n' +
                    "Chory na: " + p.choroba() + '\n' +
                    "Zastosowano: " + p.leczenie() +"\n\n"
            );
        }

    }
}
