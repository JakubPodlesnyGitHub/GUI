package LevelWindow;
import GameWindow.GameWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelWindowController implements ActionListener {
    private LevelWindowView levelWindowView;
    private LevelWindowModel levelWindowModel;

    public LevelWindowController(LevelWindowView levelWindowView, LevelWindowModel levelWindowModel) {
        this.levelWindowModel = levelWindowModel;
        this.levelWindowView = levelWindowView;
        this.levelWindowView.addActionListenerCombobox(this::actionPerformed);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch ((String) levelWindowView.getLevelMenu().getSelectedItem()) {//actionlistner w zalezonsi jaki element sie wybierze
            case "LATWY":
                levelWindowView.setVisible(false);
                levelWindowModel.getGameWindow(levelWindowModel.getEasyLevel(),levelWindowModel.getEasyTimeSpreadVirus(),levelWindowModel.getEasyHealthTime(),levelWindowModel.getEasyNumberOfInfectedChina()).gameWindowView.setVisible(true);
                System.out.println("POZIOM LATWY");
                break;
            case "SREDNI":
                levelWindowView.setVisible(false);
                levelWindowModel.getGameWindow(levelWindowModel.getNormalLevel(),levelWindowModel.getNormalTimeSpreadVirus(),levelWindowModel.getNormalHealthTime(),levelWindowModel.getNormalNumberOfInfectedChina()).gameWindowView.setVisible(true);
                System.out.println("POZIOM SREDNI");
                break;
            case "TRUDNY":
                levelWindowView.setVisible(false);
                levelWindowModel.getGameWindow(levelWindowModel.getHardLevel(),levelWindowModel.getHardTimeSpreadVirus(), levelWindowModel.getHardHealthTime(),levelWindowModel.getHardNumberOfInfectedChina()).gameWindowView.setVisible(true);
                System.out.println("POZIOM TRUDNY");
                break;
        }

    }
}
