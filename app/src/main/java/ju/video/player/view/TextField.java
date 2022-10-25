package ju.video.player.view;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.Font;

public class TextField extends JTextField {
    private static final String NAME = "Arial";
    private static final int SIZE = 12;

    public TextField(String name) {
        Font font = new Font(NAME, Font.BOLD, SIZE); 
        setForeground(new Color(219, 237, 243));
        setBackground(new Color (64, 75, 105));
        setSize(100, 14);
        setFont(font);
        setBorder(BorderFactory.createTitledBorder(null, name, TitledBorder.LEFT, 0, font, new Color(219, 237, 243)));
        setBackground(new Color (64, 75, 105));
    }


}
