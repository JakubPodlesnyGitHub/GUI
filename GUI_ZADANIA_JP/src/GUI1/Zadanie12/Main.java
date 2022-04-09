package GUI1.Zadanie12;

public class Main {
    public static void main(String[] args) {
        Pacjent jan = new Pacjent("Jan") {
            @Override
            public String nazwisko() {
                return imie;
            }
            public String choroba(){
                return "głowa";
            }

            @Override
            public String leczenie() {
                return "leczenie";
            }

        };
        Pacjent edzio = new Pacjent("Edzio") {
            @Override
            public String nazwisko() {
                return imie;
            }
            public String choroba(){
                return "noga";
            }

            @Override
            public String leczenie() {
                return "gips";
            }
        };
        Pacjent marian = new Pacjent("Marian") {
            @Override
            public String nazwisko() {
                return imie;
            }
            public String choroba(){
                return "dyspepsja";
            }

            @Override
            public String leczenie() {
                return "węgiel";
            }
        };

        Pacjent[] pacjenci = { jan, edzio, marian} ;

        for (Pacjent p : pacjenci) {
            System.out.println("Pacjent: " + p.nazwisko() + '\n' +
                    "Chory na: " + p.choroba() + '\n' +
                    "Zastosowano: " + p.leczenie() +"\n\n"
            );
        }
    }
}
