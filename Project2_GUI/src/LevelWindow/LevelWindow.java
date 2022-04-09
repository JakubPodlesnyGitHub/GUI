package LevelWindow;


public class LevelWindow {
    LevelWindowModel levelWindowModel;
    public LevelWindowView levelWindowView;
    LevelWindowController levelWindowController;
    public LevelWindow(){
        levelWindowModel = new LevelWindowModel();
        levelWindowView = new LevelWindowView();
        levelWindowController = new LevelWindowController(levelWindowView,levelWindowModel);

    }
}
