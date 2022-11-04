package ju.video.player.view.footer;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

public class FooterPanel extends JPanel {
    public FooterPanel() {
        add(new FooterLabel(), BorderLayout.EAST);
        setBackground(Color.GRAY);
    }
}
