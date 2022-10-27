package ju.video.player.view.information.search;

import javax.swing.*;

import ju.video.player.view.playlist.playlistpanel.VideoListPanel;

import java.awt.*;

public class SearchPanel extends JPanel {

    public SearchPanel(VideoListPanel panelSouth) {

        SearchButton searchButton = new SearchButton(panelSouth);
        add(searchButton);
        setBackground(Color.LIGHT_GRAY);
    }
}
