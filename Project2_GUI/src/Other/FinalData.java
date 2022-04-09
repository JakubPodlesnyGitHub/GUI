package Other;

import java.io.Serializable;

public class FinalData implements Serializable , Comparable {
    //Klasa do licznia punktów (wykorzystywana w rakingu)
    String time;
    String difficultyLevel;
    String name;
    int points;
    public FinalData(String time,String difficultyLevel,String name,int points){
        this.time = time;
        this.difficultyLevel = difficultyLevel;
        this.name = name;
        this.points = points;
    }
    @Override
    public int compareTo(Object o) {
        FinalData finalData =(FinalData)o;
        return finalData.points - points;
    }
    @Override
    public String toString() {
        return "IMIE: " + name + " POZIOM TRUDNOSCI: " + difficultyLevel + " POINTS: " + points + " CZAS: " + time;
    }


}
