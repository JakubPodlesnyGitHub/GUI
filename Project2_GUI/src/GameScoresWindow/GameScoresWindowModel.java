package GameScoresWindow;

import Other.FinalData;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class GameScoresWindowModel extends AbstractListModel {
    private ArrayList<FinalData> score;

    public GameScoresWindowModel() {
        if ((score = readFile()) == null) {
            score = new ArrayList<>();
            fileSave();
            Collections.sort(score);
        }
        //System.out.println(score);
    }

    //DODAJE DO LISTY NA PODANY INDEX
    public void addScoreToList(FinalData finalData) {
        score.add(finalData);
        Collections.sort(score);
        fileSave();
        fireIntervalAdded(this, 0, score.size() - 1);
    }

    //USUWA DANY ELEMNT NA PODANYM INDEXIE
    public void removeScoreFromArray(FinalData finalData) {
        score.remove(finalData);
        Collections.sort(score);
        fileSave();
        fireIntervalRemoved(this, 0, score.size() - 1);
    }

    //ZWRACA ROZMIAR LISTY
    @Override
    public int getSize() {
        return score.size();
    }

    //ZWRACA DANY ELEMENT NA PODANYM INDEXIE
    @Override
    public Object getElementAt(int index) {
        return score.get(index);
    }
    //ZAPIS DO PLIKU
    public void fileSave() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src\\RankingFile.txt"));
            objectOutputStream.writeObject(score);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //ODCZYT Z PLIKU
    public ArrayList<FinalData> readFile() {
        try {
            ObjectInputStream objectInputPutStream = new ObjectInputStream(new FileInputStream("src\\RankingFile.txt"));
            score = (ArrayList) objectInputPutStream.readObject();
            objectInputPutStream.close();
            return score;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
