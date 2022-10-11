package ju.video.player.view.information;

import ju.video.player.view.information.list.VideoListPanel;
import ju.video.player.view.information.search.SearchVideoPanel;

import javax.swing.*;

public class InformationPanel extends JPanel {

    public InformationPanel() {
        SearchVideoPanel searchVideoPanel = new SearchVideoPanel();
        VideoListPanel videoListPanel = new VideoListPanel();
        initialize();
        add(searchVideoPanel);
        add(videoListPanel);

    }

    private void initialize() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
