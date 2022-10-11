package main.java.ju.video.player.view.information.search;

import javax.swing.*;
import java.awt.*;

public class FormatPanel extends JPanel {
    public FormatPanel() {
        FormatLabel formatLabel = new FormatLabel();
        FormatList formatList = new FormatList();
        initialize();
        add(formatLabel);
        add(formatList);
        setBackground(Color.PINK);

    }

    private void initialize() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }
}
