package GameWindow;

public class GameWindow {
    GameWindowModel gameWindowModel;
    public GameWindowView gameWindowView;
    GameWindowController gameWindowController;

    public GameWindow(String level,int  timeSpreadVirus,int healthTime,int numberOfInfectedChina){
        gameWindowModel = new GameWindowModel(level,timeSpreadVirus,healthTime,numberOfInfectedChina);
        gameWindowView  = new GameWindowView();
        gameWindowController = new GameWindowController(gameWindowView,gameWindowModel);
    }
}
