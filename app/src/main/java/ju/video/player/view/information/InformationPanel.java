package ju.video.player.view.information;

import ju.video.player.view.information.list.VideoListPanel;
import ju.video.player.view.information.list.VideoListSectionPanel;
import ju.video.player.view.information.search.SearchVideoPanel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class InformationPanel extends JPanel {

    public InformationPanel(VideoListPanel videoList) {

        VideoListSectionPanel videoListPanel = new VideoListSectionPanel(videoList);
        SearchVideoPanel searchVideoPanel = new SearchVideoPanel(videoListPanel.getVideoListPanel());
        initialize();
        //add(searchVideoPanel);
        add(videoListPanel);
    }

    private void initialize() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
