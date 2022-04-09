package GameScoresWindow;

import InterFaces.WindowSettings;
import Other.FinalData;

import javax.swing.*;

public class GameScoresWindow extends JFrame implements WindowSettings {
    //Zrobione ale nie wiem dlaczego mi się nie wyświetla
    private JPanel scoreJPanel;
    private JList scoreList;//lista
    private GameScoresWindowModel gameScoresWindowModel;
    private JScrollPane scrollPane;//scroll do przesuwania listy
    private ImageIcon mainIcon = new ImageIcon("src\\Images\\virusIcon1.png");//ustawienie ikony okna
    public GameScoresWindow() {
        scoreJPanel = new JPanel();
        gameScoresWindowModel = new GameScoresWindowModel();
        scoreList = new JList();
        scoreList.setModel(gameScoresWindowModel);//ustawienie własnego modelu
        scoreList.setCellRenderer(new MyListCellRenderer());//ustawienie CellRenderera
        scrollPane = new JScrollPane(scoreList);//dodanie do scrollPane listy
        scoreJPanel.add(scrollPane);
        addComponentsToJFrame();
        settingsWindow();
    }

    public void addComponentsToJFrame() {
        this.add(scoreJPanel);
    }

    public void addScoreList(FinalData finalData) {
        gameScoresWindowModel.addScoreToList(finalData);
    }

    public JList getScoreList() {
        return scoreList;
    }

    @Override
    public void settingsWindow() {
        //--------------------------------------DANE OKNA---------------------------------------------------------------
        this.setSize(400, 400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(mainIcon.getImage());
        this.setTitle("SCORES");
    }
}
