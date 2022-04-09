package InterFaces;

import Other.Person;

import java.util.ArrayList;

public interface CreateArrayListPeople {
    default ArrayList<Person> createArrayListPeople(int numberOfPeople){//Tworzenie dla każdego państwa listy osob
        ArrayList<Person> peopleArrayList = new ArrayList<>();
        for(int i =0;i<numberOfPeople;i++){
            peopleArrayList.add(new Person());
        }
        return peopleArrayList;
    }
}
