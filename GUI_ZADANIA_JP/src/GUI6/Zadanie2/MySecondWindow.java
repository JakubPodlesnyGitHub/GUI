package GUI6.Zadanie2;

import javax.swing.*;
import java.awt.*;

public class MySecondWindow extends JFrame {
    JTextArea jTextArea;
    public MySecondWindow(){
        jTextArea = new JTextArea();
        this.add(jTextArea);
        jTextArea.setFont(change(Color.RED,Color.BLUE,Font.DIALOG,Font.ITALIC,15));
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Zadanie2");
    }
    public Font change(Color colorBackGround, Color colorText,String typeFont,int styleFont,int sizeFont) {
        jTextArea.setBackground(colorBackGround);//kolor tla
        jTextArea.setForeground(colorText);//kolor pisma
        return new Font(typeFont,styleFont,sizeFont);
    }

}
