package GameWindow;

import Countries.Country;
import GameScoresWindow.GameScoresWindow;
import Improvments.Improvemnt;
import Improvments.Vacine;
import InterFaces.WindowSettings;
import Other.FinalData;
import Thredy.RandomCountryAirSpreadThread;
import Thredy.RandomCountryHealingThread;
import Thredy.RandomCountryVehicleSpreadThread;
import Thredy.TimeThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GameWindowView extends JFrame implements WindowSettings {
    private JLabel infectedLabel, timeLabel, pointsLabel, healthyLabel;
    private JPanel picture;
    private JPanel dataPanel, improvmentPanel;
    private JTextField time, numberOfInfectedJText, numberOfHealthyJText, pointsJText;
    private ImageIcon worldMap;
    private JButton china, egipt, northKorea, newZeland, pakistan, poland, russia, saintLucia, australia, saudiArabia, surinam, unitedStates, vanuatu, wenezuela, zimbabwe, nigeria;
    private JButton hospital, vaccine, bombDrop, increasesForScientists, socialFacilitiesClosed, masks, antibacterialFluids, quarantine, rutinoScorbin;
    private JButton a = new JButton();
    private ArrayList<JButton> coutriesButtons;
    private ArrayList<JButton> arrayListButtons;
    private ImageIcon mainIcon = new ImageIcon("src\\Images\\virusIcon1.png");
    private Font labelFont = new Font(Font.SERIF, Font.ITALIC, 20);

    public GameWindowView() {
        buttonsCountries();
        setButtonMap();
        setInconForButtons();
        createJPanel();
        gameImprovementsButton();
        otherComponents();
        settingsJLabel();
        settingsJFiledText();
        settingsWindow();
        addToPanel();
        addComponentsMap();
    }

    public void addComponentsMap() {
        this.add(a);
        this.add(egipt);
        this.add(china);
        this.add(northKorea);
        this.add(newZeland);
        this.add(pakistan);
        this.add(poland);
        this.add(russia);
        this.add(saintLucia);
        this.add(australia);
        this.add(saudiArabia);
        this.add(surinam);
        this.add(unitedStates);
        this.add(vanuatu);
        this.add(wenezuela);
        this.add(zimbabwe);
        this.add(nigeria);
        picture.repaint();
        this.add(picture, BorderLayout.CENTER);
        this.add(dataPanel, BorderLayout.PAGE_START);
        this.add(improvmentPanel, BorderLayout.PAGE_END);
    }

    public void addToPanel() {
        //-------------------------------DODANIE KOMPONENTOW DO JPANELU-------------------------------------------------
        dataPanel.add(timeLabel);
        dataPanel.add(time);
        dataPanel.add(healthyLabel);
        dataPanel.add(numberOfHealthyJText);
        dataPanel.add(infectedLabel);
        dataPanel.add(numberOfInfectedJText);
        dataPanel.add(pointsLabel);
        dataPanel.add(pointsJText);
        improvmentPanel.add(hospital);
        improvmentPanel.add(vaccine);
        improvmentPanel.add(bombDrop);
        improvmentPanel.add(increasesForScientists);
        improvmentPanel.add(socialFacilitiesClosed);
        improvmentPanel.add(antibacterialFluids);
        improvmentPanel.add(masks);
        improvmentPanel.add(quarantine);
        improvmentPanel.add(rutinoScorbin);
    }

    public void createJPanel() {
        //-----------------------------------------SKALOWANIE MAPY------------------------------------------------------
        picture = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(worldMap.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        dataPanel = new JPanel(new GridLayout(1, 0));
        improvmentPanel = new JPanel(new GridLayout(1, 0));
    }

    public void otherComponents() {
        //------------------MAPA I KOMPONENTY--------------------------------------------------------------------------
        worldMap = new ImageIcon("src\\Images\\Large_WorldMap.png");
        time = new JTextField();
        numberOfHealthyJText = new JTextField();
        numberOfInfectedJText = new JTextField();
        pointsJText = new JTextField();
        infectedLabel = new JLabel("ZARAZENI");
        timeLabel = new JLabel("CZAS");
        healthyLabel = new JLabel("ZDROWI");
        pointsLabel = new JLabel("PUNKTY");
    }

    //-----------------------------------BUTTONY-----------------------------------------------------------------------
    public void buttonsCountries() {
        //--------------------------------INICJOWANIE BUTTONÓW(TWORZENIE)----------------------------------------------
        coutriesButtons = new ArrayList<>();
        china = new JButton();
        egipt = new JButton();
        northKorea = new JButton();
        newZeland = new JButton();
        pakistan = new JButton();
        poland = new JButton();
        russia = new JButton();
        saintLucia = new JButton();
        australia = new JButton();
        saudiArabia = new JButton();
        surinam = new JButton();
        unitedStates = new JButton();
        vanuatu = new JButton();
        wenezuela = new JButton();
        zimbabwe = new JButton();
        nigeria = new JButton("NIGERIA");
        addToArrayListButtons(coutriesButtons);
    }

    public void setInconForButtons() {
        //--------------------------------USTAWIANIE IKON NA BUTTONACH-------------------------------------------------
        china.setIcon(resizeImageIcon("src\\Images\\Chiny.png", china));
        egipt.setIcon(resizeImageIcon("src\\Images\\Egipt.png", egipt));
        australia.setIcon(resizeImageIcon("src\\Images\\Australia.jpg", australia));
        saudiArabia.setIcon(resizeImageIcon("src\\Images\\Arabia Saudyjska.png", saudiArabia));
        nigeria.setIcon(resizeImageIcon("src\\Images\\Nigeria.png", nigeria));
        newZeland.setIcon(resizeImageIcon("src\\Images\\NowaZelandia.png", newZeland));
        pakistan.setIcon(resizeImageIcon("src\\Images\\Pakistan.png", pakistan));
        northKorea.setIcon(resizeImageIcon("src\\Images\\PolnocnaKorea.png", northKorea));
        poland.setIcon(resizeImageIcon("src\\Images\\Polska.png", poland));
        saintLucia.setIcon(resizeImageIcon("src\\Images\\SaintLucia.png", saintLucia));
        surinam.setIcon(resizeImageIcon("src\\Images\\Suriname.png", surinam));
        unitedStates.setIcon(resizeImageIcon("src\\Images\\Usa.png", unitedStates));
        vanuatu.setIcon(resizeImageIcon("src\\Images\\Vaunatus.png", vanuatu));
        wenezuela.setIcon(resizeImageIcon("src\\Images\\Wenezuela.png", wenezuela));
        zimbabwe.setIcon(resizeImageIcon("src\\Images\\Zimbabwe.png", zimbabwe));
        russia.setIcon(resizeImageIcon("src\\Images\\Rosja.png", russia));

    }

    public ImageIcon resizeImageIcon(String fileName, JButton jButton) {
        //---------------------------------ZMIANA ROZMIARU IKON--------------------------------------------------------
        ImageIcon imageIcon1 = new ImageIcon(fileName);
        Image imageIcon2;
        imageIcon2 = imageIcon1.getImage().getScaledInstance(jButton.getWidth(), jButton.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon3 = new ImageIcon(imageIcon2);
        return imageIcon3;
    }

    public void addToArrayListButtons(ArrayList<JButton> buttonArrayList) {
        //----------------------------KRAJE BUTTONY---------------------------------------------------------------------
        buttonArrayList.add(australia);
        buttonArrayList.add(china);
        buttonArrayList.add(egipt);
        buttonArrayList.add(zimbabwe);
        buttonArrayList.add(newZeland);
        buttonArrayList.add(nigeria);
        buttonArrayList.add(poland);
        buttonArrayList.add(northKorea);
        buttonArrayList.add(pakistan);
        buttonArrayList.add(russia);
        buttonArrayList.add(saintLucia);
        buttonArrayList.add(saudiArabia);
        buttonArrayList.add(surinam);
        buttonArrayList.add(unitedStates);
        buttonArrayList.add(vanuatu);
        buttonArrayList.add(wenezuela);
    }

    public void setButtonMap() {
        //--------------------------------------LOKALIZACJE BUTTONOW NA MAPIE-------------------------------------------
        int buttonWidth = 40;//DLUGOSC BUTTONA
        int buttonHeight = 30;//SZEROKOSC BUTTONA
        china.setBounds(999, 193, buttonWidth, buttonHeight);
        egipt.setBounds(712, 220, buttonWidth, buttonHeight);
        northKorea.setBounds(1083, 190, buttonWidth, buttonHeight);
        newZeland.setBounds(1190, 482, buttonWidth, buttonHeight);
        pakistan.setBounds(889, 235, buttonWidth, buttonHeight);
        poland.setBounds(694, 120, buttonWidth, buttonHeight);
        russia.setBounds(793, 100, buttonWidth, buttonHeight);
        saintLucia.setBounds(360, 210, buttonWidth, buttonHeight);
        australia.setBounds(1102, 395, buttonWidth, buttonHeight);
        saudiArabia.setBounds(780, 206, buttonWidth, buttonHeight);
        unitedStates.setBounds(240, 150, buttonWidth, buttonHeight);
        surinam.setBounds(469, 327, buttonWidth, buttonHeight);
        vanuatu.setBounds(1200, 380, buttonWidth, buttonHeight);
        wenezuela.setBounds(350, 300, buttonWidth, buttonHeight);
        zimbabwe.setBounds(713, 390, buttonWidth, buttonHeight);
        nigeria.setBounds(677, 285, buttonWidth, buttonHeight);
        a.setBounds(1, 1, 0, 0);
    }

    public void gameImprovementsButton() {
        //-----------------------------TWORZENIE ULEPSZEN(BUTTONOW)---------------------------------------------------
        arrayListButtons = new ArrayList<>();
        hospital = new JButton("POSTAW SZPITAL");
        hospital.setBackground(new Color(0xDFDEE1));
        vaccine = new JButton("SZCZEPIONKA");
        vaccine.setBackground(new Color(0x0EC897));
        bombDrop = new JButton("ZRZUCENIE BOMBY");
        bombDrop.setBackground(new Color(0xC88A00));
        increasesForScientists = new JButton("PODWYŻKI DLA NAUKOWCÓW");
        increasesForScientists.setBackground(new Color(0xB7C80C));
        socialFacilitiesClosed = new JButton("ZAMKNIECIE PLACÓWEK");
        socialFacilitiesClosed.setBackground(new Color(0x4E9425));
        masks = new JButton("NAKAZ NOSZENIA MASEK");
        masks.setBackground(new Color(0x035E45));
        antibacterialFluids = new JButton("PLYNY ANTYBAKTERYJNE");
        antibacterialFluids.setBackground(new Color(0x8C5373));
        quarantine = new JButton("KWARANTANNA");
        quarantine.setBackground(new Color(0xC835C2));
        rutinoScorbin = new JButton("RUTINOSCORBIN");
        rutinoScorbin.setBackground(new Color(0x10BFBD));
        addToArrayListButtonsImprovments(arrayListButtons);
    }

    public void addToArrayListButtonsImprovments(ArrayList<JButton> arrayListButtons) {
        //------------------DODAWANIE DO LISTY ULEPSZEN----------------------------------------------------------------
        arrayListButtons.add(hospital);
        arrayListButtons.add(vaccine);
        arrayListButtons.add(bombDrop);
        arrayListButtons.add(increasesForScientists);
        arrayListButtons.add(socialFacilitiesClosed);
        arrayListButtons.add(masks);
        arrayListButtons.add(antibacterialFluids);
        arrayListButtons.add(quarantine);
        arrayListButtons.add(rutinoScorbin);
    }

    public void addButtonListener(ActionListener actionListener) {
        //----------------------------------DODAWANIE BUTTONOW DO ACTIONLISTENEROW--------------------------------------
        for (JButton jButton : coutriesButtons) {
            jButton.addActionListener(actionListener);
        }
        for (JButton jButton : arrayListButtons) {
            jButton.addActionListener(actionListener);
        }
    }


    @Override
    public void settingsWindow() {
        //---------------------------------USTAWIENIA KOMPONONTOW-------------------------------------------------------
        this.setSize(new Dimension(worldMap.getIconWidth(), worldMap.getIconHeight() + 50));
        this.setLocationRelativeTo(null);
        setIconImage(mainIcon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("PLAUGE HEALTH GAME");
    }

    public void settingsJFiledText() {
        //---------------------------USTAWIENIA JTEXTFILED------------------------------------------------------------
        time.setEnabled(false);//Brak mozliwosci edycji
        time.setHorizontalAlignment(JTextField.CENTER);//Wysrodkowanie tekstu
        //----------------------------------------------
        numberOfHealthyJText.setEnabled(false);//Brak mozliwosci edycji
        numberOfHealthyJText.setHorizontalAlignment(JTextField.CENTER);
        //------------------------------------------------
        numberOfInfectedJText.setEnabled(false);//Brak mozliwosci edycji
        numberOfInfectedJText.setHorizontalAlignment(JTextField.CENTER);
        //-----------------------------------------------
        pointsJText.setEnabled(false);//Brak mozliwosci edycji
        pointsJText.setHorizontalAlignment(JTextField.CENTER);
    }

    public void settingsJLabel() {
        //-------------------------------------USTAWIENIA JLABEL--------------------------------------------------------
        infectedLabel.setFont(labelFont);
        infectedLabel.setForeground(Color.RED);
        timeLabel.setFont(labelFont);
        timeLabel.setForeground(Color.ORANGE);
        healthyLabel.setFont(labelFont);
        healthyLabel.setForeground(Color.GREEN);
        pointsLabel.setFont(labelFont);
        pointsLabel.setForeground(Color.MAGENTA);
    }

    //----------------------------------------WYSWIETLANIE INFORMACJI---------------------------------------------------
    public void displayInformation() {
        JOptionPane.showMessageDialog(null,"!!!PROSZE USTAWIC GLOSNOSC MIEDZY 10% A 15%!!!","!OSTRZEŻENIE(DZWIEK)!",JOptionPane.WARNING_MESSAGE,new ImageIcon("src\\Images\\Volume.png"));
    }

    public void displayInformationMessageCountry(Country country) {
        JOptionPane.showMessageDialog(this, country);
    }

    public void displayInformationMessageImprovment(Improvemnt improvemnt, RandomCountryHealingThread randomCountryHealingThread, String path) {

        int a = JOptionPane.showInternalConfirmDialog(null, "CZY NA PEWNO CHCESZ TO WLACZYC: " + improvemnt, "ULEPSZENIE", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(path));
        if (a == JOptionPane.YES_OPTION) {
            if (randomCountryHealingThread.getPoints() - improvemnt.pointsForUpgrading >= 0) {
                int improvmentPoints = randomCountryHealingThread.getPoints() - improvemnt.pointsForUpgrading;
                int healthyPeople = randomCountryHealingThread.getHealthy() + improvemnt.numberOfHealthPeople;
                randomCountryHealingThread.setPoints(improvmentPoints);
                randomCountryHealingThread.setHealthy(healthyPeople);
            } else {
                JOptionPane.showMessageDialog(null, "!!!!MASZ ZA MALO PUNKTOW DO KUPIENIA TEGO ULEPSZENIA!!!!!");
            }
        }

    }

    public void displayVaccineInprovment(Vacine vacine, RandomCountryHealingThread randomCountryHealingThread, RandomCountryVehicleSpreadThread randomCountryVehicleSpreadThread, RandomCountryAirSpreadThread randomCountryAirSpreadThread, TimeThread timeThread, String path, int counter, String level, String name, GameScoresWindow gameScoresWindow) {
        int a = JOptionPane.showInternalConfirmDialog(null, "CZY NA PEWNO CHCESZ TO WLACZYC: " + vacine, "SZCZEPIONKA", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(path));
        if (a == JOptionPane.YES_OPTION) {
            if (counter >= 4) {
                if (randomCountryHealingThread.getPoints() - vacine.pointsForUpgrading >= 0) {
                    JOptionPane.showMessageDialog(this, "!!YOU WIN!! \nWSZYSCY WYZDROWIELI");
                    randomCountryHealingThread.interrupt();
                    randomCountryAirSpreadThread.interrupt();
                    randomCountryVehicleSpreadThread.interrupt();
                    timeThread.interrupt();
                    gameScoresWindow.setVisible(true);
                    gameScoresWindow.addScoreList(new FinalData(timeThread.getLocalDateTMP().getLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), level, name, randomCountryHealingThread.getPoints()));
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "!!!!MASZ ZA MALO PUNKTOW DO KUPIENIA TEGO ULEPSZENIA!!!!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "NIE DOFINASOWALAS/ES WYSTARCZAJACO NAUKOWCOW. MUSISZ JESZCZE " + (4 - counter) + " RAZY PRZEZNACZYC PIENIADZE DLA NAUKOWCOW");
            }

        }
    }

    public String windowName() {
        return JOptionPane.showInputDialog(null, "PODAJ SWOJE IMIE: ", "IMIE", JOptionPane.INFORMATION_MESSAGE);
    }

    ///////////////////////////////////////GETTERY(JBUTTON_KRAJE)///////////////////////////////////////////////////////
    public JButton getChina() {
        return china;
    }

    public JButton getEgipt() {
        return egipt;
    }

    public JButton getNorthKorea() {
        return northKorea;
    }

    public JButton getNewZeland() {
        return newZeland;
    }

    public JButton getPakistan() {
        return pakistan;
    }

    public JButton getPoland() {
        return poland;
    }

    public JButton getRussia() {
        return russia;
    }

    public JButton getSaintLucia() {
        return saintLucia;
    }

    public JButton getAustralia() {
        return australia;
    }

    public JButton getSaudiArabia() {
        return saudiArabia;
    }

    public JButton getSurinam() {
        return surinam;
    }

    public JButton getUnitedStates() {
        return unitedStates;
    }

    public JButton getVanuatu() {
        return vanuatu;
    }

    public JButton getWenezuela() {
        return wenezuela;
    }

    public JButton getZimbabwe() {
        return zimbabwe;
    }

    public JButton getNigeria() {
        return nigeria;
    }

    ////////////////////////////////////////GETERY(ULEPSZENIA)//////////////////////////////////////////////////////////
    public JButton getHospital() {
        return hospital;
    }

    public JButton getVaccine() {
        return vaccine;
    }

    public JButton getBombDrop() {
        return bombDrop;
    }

    public JButton getIncreasesForScientists() {
        return increasesForScientists;
    }

    public JButton getSocialFacilitiesClosed() {
        return socialFacilitiesClosed;
    }

    public JButton getMasks() {
        return masks;
    }

    public JButton getAntibacterialFluids() {
        return antibacterialFluids;
    }

    public JButton getQuarantine() {
        return quarantine;
    }

    public JButton getRutinoScorbin() {
        return rutinoScorbin;
    }

    ////////////////////////////////////////GETERY KOMPONENTOW//////////////////////////////////////////////////////////
    public JTextField getTime() {
        return time;
    }

    public JTextField getNumberOfHealthyJText() {
        return numberOfHealthyJText;
    }

    public JTextField getNumberOfInfectedJText() {
        return numberOfInfectedJText;
    }

    public JTextField getPointsJText() {
        return pointsJText;
    }

    public void aAddShortCut(KeyListener keyListener) {
        a.addKeyListener(keyListener);
    }
}
