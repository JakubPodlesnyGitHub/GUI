import MainMenuWindow.MainMenu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            MainMenu mainMenu = new MainMenu();
        });
    }
    //Kod mogl byc lepiej napisany szczegolnie getery i setery
    // oraz watek zwiazany z rozsprzestrzenianiem wirusa przez transport
}
