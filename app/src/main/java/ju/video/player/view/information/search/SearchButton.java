package ju.video.player.view.information.search;

import javax.swing.*;

import ju.video.player.controller.Mp4ButtonController;
import ju.video.player.view.playlist.playlistpanel.VideoListPanel;

public class SearchButton extends JButton {

    public SearchButton(VideoListPanel panelSouth) {
        super("Search");
        addActionListener(new Mp4ButtonController(panelSouth));
    }
}
