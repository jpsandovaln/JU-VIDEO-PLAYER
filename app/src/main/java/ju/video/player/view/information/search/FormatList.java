package main.java.ju.video.player.view.information.search;

import javax.swing.*;


public class FormatList extends JComboBox<String> {
    private String[] formats = new String[]{"mp4", "mkv", "mov" };

    public FormatList() {
        super();
        new JComboBox<String>();
        addItem(null);
        for (String format : formats) {
            addItem(format);
        }
    }
}
