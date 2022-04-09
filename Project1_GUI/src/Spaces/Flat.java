package Spaces;

import Other.File;
import Other.Przedmiot;
import People.Person;
import People.Tenanat;
import Wyjatki.ProblematicTenantException;
import Wyjatki.TooMannyRentals;

import java.time.LocalDate;
import java.util.ArrayList;

public class Flat implements Comparable {
    public double objetoscMieszkania; // w m^3
    public double wolnaObjetoscPomiszczeniaMieszkania;//w m^3
    public Tenanat tenanat;
    public int flatNumberF;//odbior numeru mieszkania
    public boolean czyMieszkanieOsiedle = false;//odbior(czy znajduje sie na osiedlu)
    public boolean czyPosiadaNajemcaMieszkanie = false;// sprawdzanie czy dane mieszkanie ma najemce
    //-------------------LiSTA OBIKETOW I OSOB----------------------------------
    public ArrayList<Person> listaOsobNaMieszkanie;
    public ArrayList<Przedmiot> listaObiektoWMieszkaniu;
    //-------------------------PCOZATEK I KONIEC NAJMU ORAZ EKSMISJA----------------------------
    public LocalDate poczatekNajmuMieszkania;
    public LocalDate koniecNajmuMieszkania;
    public LocalDate koniecCzasuMieszkanieEKSMISJA;
    //------------------------------------------------------------------------
    public boolean zaleglosciMieszkanie = false;//zmienna regulujaca dodawanie plikow file
    public boolean zaleglosciFlatS = false;//zmienna regulujaca powiadomienie o zaleglosciach na dane mieszkanie

    public Flat(double objetoscMieszkania) {//konstruktor z 1 zmienna(objetosc)
        this.objetoscMieszkania = objetoscMieszkania;//inicjalizacja objetosci mieszkania
        this.wolnaObjetoscPomiszczeniaMieszkania = objetoscMieszkania;//przypisanie objetosci "roboczej" objetosc rzeczywista
        //-----------------
        listaOsobNaMieszkanie = new ArrayList<>();
        listaObiektoWMieszkaniu = new ArrayList<>();

    }

    public Flat(double dlugosc, double szerokosc, double wysokosc) {//konstruktor z 3 zmiennymi(objetosc)
        this.objetoscMieszkania = dlugosc * szerokosc * wysokosc;//inicjalizacja objetosci mieszkania(poprzez wymnożenie 3 wartości)
        this.wolnaObjetoscPomiszczeniaMieszkania = objetoscMieszkania;//przypisanie objetosci "roboczej" objetosc rzeczywista
        //-----------------
        listaOsobNaMieszkanie = new ArrayList<>();
        listaObiektoWMieszkaniu = new ArrayList<>();

    }

    //-------------DODAWANIE NAJEMCY DO MIESZKANIA--------------
    public void addTenant(Tenanat tenant, LocalDate start) throws TooMannyRentals, ProblematicTenantException {//dodawanie do mieszkania najemce
        if (czyPosiadaNajemcaMieszkanie == false) {//sprawdza czy mieszkanie ma już najmce
            if (tenant.listaPlikowFile.size() >= 3) {//sprawdza czt dany najemca ma wiecej niz 3 pliki jesli tak to wyjatek
                throw new ProblematicTenantException("\nOsoba: " + tenant.imie + " " + tenant.nazwisko + " posiadala już najem pomieszczen: " + tenant.listaParkingowNajemcy + tenant.listaMieszkanNajemcy); // wyrzucenie wyjątku jeśli dany najemca posiada więcej niż 3 obiekty typu File
            } else {
                if ((tenant.listaMieszkanNajemcy.size()+tenant.listaParkingowNajemcy.size()) >= 5) {//sparawdza czy dany najemca ma wiecej niz 5 najmow
                    throw new TooMannyRentals("\nTa osoba ma za duzo najmow! Proszę usun jedno pomieszczenie");
                } else {
                    this.czyPosiadaNajemcaMieszkanie = true;// ustawia dane pole na true(czyli dane mieszkanie ma najemce)
                    this.poczatekNajmuMieszkania = start; // ustawia poczatek najmu na date dostarczona wraz z najemcą
                    this.koniecNajmuMieszkania = start.plusMonths(1); //ustawia koniec najmu na date o miesiąc do przodu od daty startowej
                    this.koniecCzasuMieszkanieEKSMISJA = koniecNajmuMieszkania.plusMonths(1); //ustawia koniec najmu na date o miesiąc do przodu od daty koncowej
                    tenant.listaMieszkanNajemcy.add(this);//dodaje do listy wynajmowanych mieszkań dane mieszkanie
                    this.tenanat = tenant;//ustawia najemce
                    tenant.czyPosiadaMieszkanie = true;//ustawia pole w najemcy na true(pole dla parkingu)
                }
            }
        } else {
            System.out.println("To mieszkanie ma już najmce.");
        }

    }

    //-----------------SPRAWDZANIE OPLAT ZA MIESZKANIE-------------------------
    public void checkPayment(LocalDate aktualnaData) {
        if (czyPosiadaNajemcaMieszkanie == true) {//sprawdzanie czy dane mieszkanie posiada najemce
            if (aktualnaData.isAfter(koniecNajmuMieszkania)) {//sprawdzanie czy dana data sie przedawnila
                if (zaleglosciMieszkanie == false) {//sprawdza czy pole zaleglosi jest == false
                    tenanat.listaPlikowFile.add(new File(this, tenanat));//dodanie pliku file do listy
                    zaleglosciMieszkanie = true;//ustawia zaleglosci na true
                    tenanat.zalegleMieszkania.add(this);//dodaje dane mieszkanie do listy zalelych mieszkan(probelematicTenantException e)
                }
               if (zaleglosciFlatS == false) {
                    System.out.println("Najemca: " + tenanat.imie + " " + tenanat.nazwisko + " ma zaleglosci w placeniu.");
                    zaleglosciFlatS = true;
                }
            }
            if (aktualnaData.isAfter(koniecCzasuMieszkanieEKSMISJA) && zaleglosciMieszkanie == true) {//sprawdza czy aktualna data jest po koniecCzasuEksmisja i czy mieszkanie ma rzeczywiscie zaleglosci z oplatami
                if (tenanat.listaMieszkanNajemcy.contains(this)) {//sprawdza czy dana lista mieszkan najemcy zawiera dane mieszkanie
                    czyPosiadaNajemcaMieszkanie = false;
                    wolnaObjetoscPomiszczeniaMieszkania = objetoscMieszkania;//powrot do oryginalnej wersji pomieszczenia
                    listaOsobNaMieszkanie.clear();//usuwanie osob z mieszkania przez eksmisje
                    listaObiektoWMieszkaniu.clear(); // usuwanie obiektow z mieszkania przez eksmisje
                    System.out.println("Nastapilo wyrzucenie najemcy: " + tenanat.imie + " " + tenanat.nazwisko + " z mieszkania nr: " + flatNumberF);
                    tenanat = null;//usuniecie najemcy
                } else {
                    System.out.println("Miszkanie nr: " + flatNumberF + " nie podlega danemu najemcy. Prosze wybrac inne");
                }
            }
        }
    }

    //------------------------metody do przygotowania pomieszczen-------------------------
    public void addPerson(Person person) {
        listaOsobNaMieszkanie.add(person);
    }

    public void addObject(Przedmiot przedmiot) {
        wolnaObjetoscPomiszczeniaMieszkania -= przedmiot.objetoscPrzedmiotu;
        if (przedmiot.objetoscPrzedmiotu < wolnaObjetoscPomiszczeniaMieszkania) {
            listaObiektoWMieszkaniu.add(przedmiot);
        } else {
            System.err.println("Brak miejsca. Musisz usunac przedmioty.");
        }
    }

    //--------------------------------------------------------------------------------------
    @Override//do porównania objetosci mieszkania(posortowanie rosnąco)
    public int compareTo(Object o) {
        Flat flat = (Flat) (o);
        return (int) (objetoscMieszkania - flat.objetoscMieszkania);
    }

    @Override
    public String toString() {//do ProblematicTenantException
        return "Mieszkanie nr: " + flatNumberF;
    }
}
