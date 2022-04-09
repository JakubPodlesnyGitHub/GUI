package MainMenuWindow;

import Other.FinalData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController implements ActionListener {
    private MainMenuView mainMenuView;
    private MainMenuModel mainMenuModel;
    public MainMenuController(MainMenuView mainMenuView,MainMenuModel mainMenuModel){
        this.mainMenuModel = mainMenuModel;
        this.mainMenuView = mainMenuView;
        this.mainMenuView.addMainMenuListner(this::actionPerformed);
    }

    @Override//ActionListner
    public void actionPerformed(ActionEvent e) {
        String mainChoice = e.getActionCommand();//Pobranie stringa z dane przycisku
        switch (mainChoice) {
            case "NEW GAME": // glowna gra
                mainMenuView.setVisible(false);
                mainMenuModel.getLevelWindow().levelWindowView.setVisible(true);
                break;
            case "GAME EXIT": // wyjscie
                System.exit(0);
                break;
            case "HIGH SCORES": // przejscie do rakingu
                mainMenuView.setVisible(false);
                mainMenuModel.getGameScoresWindow().setVisible(true);
                //mainMenuModel.getGameScoresWindow().getScoreList()
                break;
        }
    }
}
