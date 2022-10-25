package ju.video.player.view;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class TitleLabel extends JLabel {
    private static final int FONT_STYLE = 0;
    private static final int FONT_SIZE = 25;

    public TitleLabel(String title) {
        super(title, SwingConstants.LEFT);
        setFont(new Font("Impact", FONT_STYLE, FONT_SIZE));
        setForeground(new Color(219, 237, 243));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setVisible(true);
    }
    

}
