package GameScoresWindow;

import javax.swing.*;
import java.awt.*;

public class MyListCellRenderer extends JLabel implements ListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        setOpaque(true);
        setText((String) value.toString());
        if (index == 0) {//jeśli indeks(Pierwsze miejsce)
            this.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 25));
            setBackground(Color.GREEN);
        } else {
            this.setFont(new Font(Font.DIALOG, Font.BOLD, 14));
            setBackground(Color.GRAY);
        }

        return this;
    }
}
