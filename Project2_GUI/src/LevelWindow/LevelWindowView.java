package LevelWindow;

import InterFaces.WindowSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LevelWindowView extends JFrame implements WindowSettings {
    private JComboBox<String> levelMenu;
    private JTextField levelMenuText;
    //------------------------------------------------------------------------------------------------------------------
    private Color generalColor = new Color(0x52709C);
    private Color selectedItemColor = new Color(0xCE9A92);
    private ImageIcon mainIcon = new ImageIcon("src\\Images\\virusIcon1.png");
    public LevelWindowView() {
        components();
        addLevelsToCheckBox();
        settingsJTextFiledLevel();
        setColor();
        //-----------------DODAWANIE KOMPONENTU DO OKNA----------------------------------------------
        this.add(levelMenu, BorderLayout.PAGE_END);
        this.add(levelMenuText, BorderLayout.PAGE_START);
        //--------------DANE OKNA------------------------------------------------
        settingsWindow();
    }

    public void components() {
        levelMenu = new JComboBox<>();
        levelMenuText = new JTextField("!LEVEL MENU!");
    }

    public void settingsJTextFiledLevel() {
        //-----------------USTAWIENIA JTEXTFIELD-----------------------------------------------------------------------
        levelMenuText.setSize(new Dimension(100, 100));
        levelMenuText.setHorizontalAlignment(JTextField.CENTER);
        levelMenuText.setFont(new Font(Font.DIALOG, Font.CENTER_BASELINE, 40));
        levelMenuText.setEnabled(false);
    }
    private void setColor() {
        //-----------------------------USTAWNIENIA KOLORU DLA KOMPONENTOW-----------------------------------------------
        levelMenuText.setBackground(generalColor);
        levelMenu.getEditor().getEditorComponent().setBackground(selectedItemColor);
    }

    public void addLevelsToCheckBox() {
        //---------------------------DODANIE DO COMBOBOXA--------------------------------------------------------------
        levelMenu.addItem("LATWY");
        levelMenu.addItem("SREDNI");
        levelMenu.addItem("TRUDNY");
        //----------------------------SETTINGS COMBOBOX--------------------------------------------------------
        levelMenu.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
    }

    @Override
    public void settingsWindow() {
        //--------------------------DANE OKNA--------------------------------------------------------------------------
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(mainIcon.getImage());
        this.setTitle("LEVEL GAME MENU");
        this.pack();
    }

    public void addActionListenerCombobox(ActionListener addComboBoxListener) {
        levelMenu.addActionListener(addComboBoxListener);
    }
    //-----------------------------------------GETERY-------------------------------------------------------------------
    public JComboBox<String> getLevelMenu() {
        return levelMenu;
    }

}
