package MainMenuWindow;

public class MainMenu {
    MainMenuModel mainMenuModel;
    MainMenuView mainMenuView;
    MainMenuController mainMenuController;

    public MainMenu() {
        mainMenuModel = new MainMenuModel();
        mainMenuView = new MainMenuView();
        mainMenuController = new MainMenuController(mainMenuView, mainMenuModel);
        mainMenuView.setVisible(true);
    }

}
