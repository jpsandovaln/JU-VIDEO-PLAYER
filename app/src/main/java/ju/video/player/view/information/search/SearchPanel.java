package main.java.ju.video.player.view.information.search;

import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel {
    public SearchPanel() {
        SearchButton searchButton = new SearchButton();
        add(searchButton);
        setBackground(Color.LIGHT_GRAY);
    }
}
