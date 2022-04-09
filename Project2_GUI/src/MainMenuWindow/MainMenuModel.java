package MainMenuWindow;

import GameScoresWindow.GameScoresWindow;
import LevelWindow.LevelWindow;


public class MainMenuModel {
    //------------------Stworzenie obiektow klas LEVELWINDOW I GAMESCOREWINDOW------------------------------------------
    private LevelWindow levelWindow = new LevelWindow();
    private GameScoresWindow gameScoresWindow = new GameScoresWindow();
    public LevelWindow getLevelWindow() {
        return levelWindow;
    }
    public GameScoresWindow getGameScoresWindow(){return gameScoresWindow;}

}
