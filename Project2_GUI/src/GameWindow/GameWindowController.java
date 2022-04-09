package GameWindow;

import MainMenuWindow.MainMenu;
import Thredy.RandomCountryAirSpreadThread;
import Thredy.RandomCountryHealingThread;
import Thredy.RandomCountryVehicleSpreadThread;
import Thredy.TimeThread;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class GameWindowController implements ActionListener, KeyListener {
    private GameWindowModel gameWindowModel;
    private GameWindowView gameWindowView;
    private TimeThread timeThread;
    private RandomCountryHealingThread randomCountryHealingThread;
    private RandomCountryAirSpreadThread randomCountryAirSpreadThread;
    private RandomCountryVehicleSpreadThread randomCountryVehicleSpreadThread;
    private Clip audioClip;

    public GameWindowController(GameWindowView gameWindowView, GameWindowModel gameWindowModel) {
        gameWindowView.displayInformation();
        this.gameWindowModel = gameWindowModel;
        this.gameWindowView = gameWindowView;
        this.gameWindowView.aAddShortCut(this);
        playMusic("src\\Sounds\\CORONA PURGE ANNOUNCEMENT.wav");
        thready();
        this.gameWindowView.addButtonListener(this::actionPerformed);
    }

    public void thready() {
        //Thread thread = new Thread(() -> {
        //try {
        //Thread.sleep(50000);
        timeThread = new TimeThread(gameWindowView.getTime());
        timeThread.start();
        randomCountryHealingThread = new RandomCountryHealingThread(gameWindowView.getNumberOfHealthyJText(), gameWindowView.getPointsJText(), gameWindowModel.getCountries(), gameWindowModel.getLevel(), timeThread, gameWindowModel.getHealthTime(), gameWindowModel.getGameScoresWindow(), gameWindowView, gameWindowModel, gameWindowModel.AllPeople());
        randomCountryHealingThread.start();
        randomCountryAirSpreadThread = new RandomCountryAirSpreadThread(gameWindowView.getNumberOfInfectedJText(), gameWindowModel.getTimeSpreadVirus(), gameWindowModel.getCountries(), gameWindowModel.getGameScoresWindow(), gameWindowView, gameWindowModel.AllPeople());
        randomCountryAirSpreadThread.start();
        randomCountryVehicleSpreadThread = new RandomCountryVehicleSpreadThread(this.gameWindowView.getNumberOfInfectedJText(), gameWindowModel.getCountries(), gameWindowModel.getTimeSpreadVirus());
        randomCountryVehicleSpreadThread.start();
        //} catch (InterruptedException e) {
        //e.printStackTrace();
        //}


        //});
        //thread.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();//bierze aktualny przycisk
        if (source.equals(gameWindowView.getChina())) {
            gameWindowView.displayInformationMessageCountry(gameWindowModel.getChinaC());
        } else if (source.equals(gameWindowView.getAustralia())) {
            gameWindowView.displayInformationMessageCountry(gameWindowModel.getAustraliaC());
        } else if (source.equals(gameWindowView.getNewZeland())) {
            gameWindowView.displayInformationMessageCountry(gameWindowModel.getNewZelandC());
        } else if (source.equals(gameWindowView.getNorthKorea())) {
            gameWindowView.displayInformationMessageCountry(gameWindowModel.getNorthKoreaC());
        } else if (source.equals(gameWindowView.getNigeria())) {
            gameWindowView.displayInformationMessageCountry(gameWindowModel.getNigeriaC());
        } else if (source.equals(gameWindowView.getPoland())) {
            gameWindowView.displayInformationMessageCountry(gameWindowModel.getPolandC());
        } else if (source.equals(gameWindowView.getRussia())) {
            gameWindowView.displayInformationMessageCountry(gameWindowModel.getRussiaC());
        } else if (source.equals(gameWindowView.getSaintLucia())) {
            gameWindowView.displayInformationMessageCountry(gameWindowModel.getSaintLuciaC());
        } else if (source.equals(gameWindowView.getPakistan())) {
            gameWindowView.displayInformationMessageCountry(gameWindowModel.getPakistanC());
        } else if (source.equals(gameWindowView.getSaudiArabia())) {
            gameWindowView.displayInformationMessageCountry(gameWindowModel.getSaudiArabiaC());
        } else if (source.equals(gameWindowView.getUnitedStates())) {
            gameWindowView.displayInformationMessageCountry(gameWindowModel.getUnitedStatesC());
        } else if (source.equals(gameWindowView.getSurinam())) {
            gameWindowView.displayInformationMessageCountry(gameWindowModel.getSurinamC());
        } else if (source.equals(gameWindowView.getVanuatu())) {
            gameWindowView.displayInformationMessageCountry(gameWindowModel.getVanuatuC());
        } else if (source.equals(gameWindowView.getWenezuela())) {
            gameWindowView.displayInformationMessageCountry(gameWindowModel.getWenezuelaC());
        } else if (source.equals(gameWindowView.getZimbabwe())) {
            gameWindowView.displayInformationMessageCountry(gameWindowModel.getZimbabweC());
        } else if (source.equals(gameWindowView.getEgipt())) {
            gameWindowView.displayInformationMessageCountry(gameWindowModel.getEgiptC());
        } else if (source.equals(gameWindowView.getBombDrop())) {
            playMusic("src\\Sounds\\Creeper.wav");
            gameWindowView.displayInformationMessageImprovment(gameWindowModel.getBombDrop(), randomCountryHealingThread, "src\\Images\\BombDrop.png");
        } else if (source.equals(gameWindowView.getVaccine())) {
            if (gameWindowModel.getPlayerName().equals("PODAJ IMIE")) {
                gameWindowModel.setPlayerName(gameWindowView.windowName());
            }
            gameWindowView.displayVaccineInprovment(gameWindowModel.getVacine(), this.randomCountryHealingThread, this.randomCountryVehicleSpreadThread, this.randomCountryAirSpreadThread, this.timeThread, "src\\Images\\vaccineIcon.png", gameWindowModel.getVaccineCounter(), gameWindowModel.getLevel(), gameWindowModel.getPlayerName(), gameWindowModel.getGameScoresWindow());
        } else if (source.equals(gameWindowView.getSocialFacilitiesClosed())) {
            gameWindowView.displayInformationMessageImprovment(gameWindowModel.getSocialFacilitiesClosed(), randomCountryHealingThread, "src\\Images\\facilities.jpg");
        } else if (source.equals(gameWindowView.getMasks())) {
            gameWindowView.displayInformationMessageImprovment(gameWindowModel.getMasks(), randomCountryHealingThread, "src\\Images\\masksIcon.png");
        } else if (source.equals(gameWindowView.getHospital())) {
            gameWindowView.displayInformationMessageImprovment(gameWindowModel.getHospital(), randomCountryHealingThread, "src\\Images\\hospitalIcon.png");
        } else if (source.equals(gameWindowView.getIncreasesForScientists())) {
            gameWindowView.displayInformationMessageImprovment(gameWindowModel.getIncreasesForScientists(), randomCountryHealingThread, "src\\Images\\moneyIcon.png");
            gameWindowModel.setVaccineCounter(gameWindowModel.getVaccineCounter() + 1);
        } else if (source.equals(gameWindowView.getAntibacterialFluids())) {
            gameWindowView.displayInformationMessageImprovment(gameWindowModel.getAntibacterialFluids(), randomCountryHealingThread, "src\\Images\\antibacterial_gel.png");
        } else if (source.equals(gameWindowView.getQuarantine())) {
            gameWindowView.displayInformationMessageImprovment(gameWindowModel.getQuarantine(), randomCountryHealingThread, "src\\Images\\Lockdown.png");
        } else if (source.equals(gameWindowView.getRutinoScorbin())) {
            gameWindowView.displayInformationMessageImprovment(gameWindowModel.getRutinoScorbin(), randomCountryHealingThread, "src\\Images\\RutinoScorbin.png");
        }
    }

    //-------------------------------ODTWARZANIE MUZYKI-----------------------------------------------------------------
    private void playMusic(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            audioClip = AudioSystem.getClip();
            audioClip.open(audioInputStream);
            audioClip.start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    //-------------------------------KEYLISTNER (SHORTCUT)-------------------------------------------------------------
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_Q) {
            gameWindowView.dispose();//zatrzymuje okno gry
            audioClip.stop();//zatrzumuje clip z ogloszeniem
            timeThread.interrupt();//przerywa liczenie czasu
            randomCountryAirSpreadThread.interrupt();//przerwya watek do zarazania sie przez powietrze
            randomCountryVehicleSpreadThread.interrupt();// przerywa watek do zarazania sie przez transport
            randomCountryHealingThread.interrupt();// przerywa watek z leczeniem
            SwingUtilities.invokeLater(() -> {
                new MainMenu();//odpala nowe menu
            });
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

