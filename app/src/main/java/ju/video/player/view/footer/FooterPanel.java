package ju.video.player.view.footer;

import javax.swing.*;
import java.awt.*;

public class FooterPanel extends JPanel {
    public FooterPanel() {
        //setLayout(new BorderLayout());
        add(new FooterLabel(), BorderLayout.EAST);
        setBackground(Color.GRAY);
    }
}
