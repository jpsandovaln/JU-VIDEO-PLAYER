package ju.video.player.view.commons;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class SubtitleLabel extends JLabel {
    private static final int FONT_STYLE = 1;
    private static final int FONT_SIZE = 18;

    public SubtitleLabel(String title) {
        super(title, SwingConstants.LEFT);
        setFont(new Font("Arial", FONT_STYLE, FONT_SIZE));
        setForeground(new Color(219, 237, 243));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setVisible(true);
    }
    

}
