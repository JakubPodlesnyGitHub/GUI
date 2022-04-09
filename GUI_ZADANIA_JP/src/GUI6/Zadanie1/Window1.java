package GUI6.Zadanie1;

import javax.swing.*;
import java.awt.*;

public class Window1 extends JFrame {
    JPanel jPanel;
    public Window1() {
        jPanel = new JPanel(){
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponents(g);
                int height = getHeight() - 1;
                int width = getWidth() - 1;
                g.setColor(Color.green);
                g.drawLine(0, 0, width, height);
                g.drawLine(0,height,width,0);
            }
        };
        this.add(jPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setTitle("Zadanie1");
        this.setVisible(true);
    }



}
