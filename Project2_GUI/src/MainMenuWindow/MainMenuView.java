package MainMenuWindow;

import InterFaces.WindowSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuView extends JFrame implements WindowSettings {
    private JButton newGame, gameExit, highScores;
    private JPanel mainMenuPanel;
    private JTextField nameMainMenu;
    private Color color = new Color(0x086E3E);
    private ImageIcon mainIcon = new ImageIcon("src\\Images\\virusIcon1.png");
    public MainMenuView() {
        components();
        addComponentsToPanel();
        setColor();
        //---------------------------DODAWANIE DO OKNA KOMPONENTOW-----------------------------------------------------
        this.add(mainMenuPanel, BorderLayout.CENTER);
        settingsWindow();
    }

    private void components() {
        nameMainMenu = new JTextField("MAIN MENU");
        settingsJTextFiled();
        newGame = new JButton("NEW GAME");
        newGame.setFont(settingsButtonFont(Font.DIALOG, Font.ITALIC, 16));
        gameExit = new JButton("GAME EXIT");
        gameExit.setFont(settingsButtonFont(Font.DIALOG, Font.ITALIC, 16));
        highScores = new JButton("HIGH SCORES");
        highScores.setFont(settingsButtonFont(Font.DIALOG, Font.ITALIC, 16));
        mainMenuPanel = new JPanel(new GridLayout(0, 1));
    }

    @Override
    public void settingsWindow() {
        //--------------------------------------DANE OKNA----------------------------------------------------
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(mainIcon.getImage());
        this.setTitle("MAIN MENU");
        this.pack();
    }

    private void settingsJTextFiled() {
        nameMainMenu.setSize(new Dimension(100, 100));
        nameMainMenu.setHorizontalAlignment(JTextField.CENTER);
        nameMainMenu.setFont(new Font(Font.DIALOG, Font.CENTER_BASELINE, 40));
        nameMainMenu.setEnabled(false);
    }

    private void addComponentsToPanel() {
        mainMenuPanel.add(nameMainMenu);
        mainMenuPanel.add(newGame);
        mainMenuPanel.add(highScores);
        mainMenuPanel.add(gameExit);
    }

    private Font settingsButtonFont(String typeFont, int styleFont, int sizeFont) {
        return new Font(typeFont, styleFont, sizeFont);
    }

    private void setColor() {
        newGame.setForeground(Color.YELLOW);
        highScores.setForeground(Color.YELLOW);
        gameExit.setForeground(Color.YELLOW);
        nameMainMenu.setBackground(color);
        highScores.setBackground(color);
        gameExit.setBackground(color);
        newGame.setBackground(color);
}

    public void addMainMenuListner(ActionListener buttonListner) {
        newGame.addActionListener(buttonListner);
        highScores.addActionListener(buttonListner);
        gameExit.addActionListener(buttonListner);
    }
}
