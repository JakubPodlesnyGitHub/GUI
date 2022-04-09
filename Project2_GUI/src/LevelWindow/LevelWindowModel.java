package LevelWindow;

import GameWindow.GameWindow;


public class LevelWindowModel {
    private int easyTimeSpreadVirus = 6000, easyHealthTime = 2000, easyNumberOfInfectedChina = 100;//poziom latwy
    private int normalTimeSpreadVirus = 3000, normalHealthTime = 3000, normalNumberOfInfectedChina = 200;//poziom sredni
    private int hardTimeSpreadVirus = 500, hardHealthTime = 6000, hardNumberOfInfectedChina = 300; //poziom trudny
    private String easyLevel = "POZIOM LATWY", normalLevel = "POZIOM NORMALNY", hardLevel = "POZIOM TRUDNY";//Level

    //-----------------------------------------GETERY-------------------------------------------------------------------
    public int getEasyTimeSpreadVirus() {
        return easyTimeSpreadVirus;
    }

    public int getEasyHealthTime() {
        return easyHealthTime;
    }

    public int getEasyNumberOfInfectedChina() {
        return easyNumberOfInfectedChina;
    }

    public int getNormalTimeSpreadVirus() {
        return normalTimeSpreadVirus;
    }

    public int getNormalHealthTime() {
        return normalHealthTime;
    }

    public int getNormalNumberOfInfectedChina() {
        return normalNumberOfInfectedChina;
    }

    public int getHardTimeSpreadVirus() {
        return hardTimeSpreadVirus;
    }

    public int getHardHealthTime() {
        return hardHealthTime;
    }

    public String getEasyLevel() {
        return easyLevel;
    }

    public String getNormalLevel() {
        return normalLevel;
    }

    public String getHardLevel() {
        return hardLevel;
    }

    public int getHardNumberOfInfectedChina() {
        return hardNumberOfInfectedChina;
    }

    public GameWindow getGameWindow(String level, int timeSpreadVirus, int healthTime, int numberOfInfectedChina) {
        return new GameWindow(level, timeSpreadVirus, healthTime, numberOfInfectedChina);
    }

}
