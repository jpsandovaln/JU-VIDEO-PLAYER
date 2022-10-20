package ju.video.player.view.information;

import ju.video.player.view.information.list.VideoListSectionPanel;
import ju.video.player.view.information.search.SearchVideoPanel;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class InformationPanel extends JPanel {

    public InformationPanel() {

        VideoListSectionPanel videoListPanel = new VideoListSectionPanel();
        SearchVideoPanel searchVideoPanel = new SearchVideoPanel(videoListPanel.getVideoListPanel());
        initialize();
        //add(searchVideoPanel);
        add(videoListPanel);
    }

    private void initialize() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
