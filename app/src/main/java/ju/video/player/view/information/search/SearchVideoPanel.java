package ju.video.player.view.information.search;

import javax.swing.*;

import ju.video.player.view.information.list.VideoListPanel;

public class SearchVideoPanel extends JPanel {
    public SearchVideoPanel(VideoListPanel panelSouth) {
        FolderPanel folderPanel = new FolderPanel(panelSouth);
        FormatPanel formatPanel = new FormatPanel();
        SearchPanel searchPanel = new SearchPanel(panelSouth);

        initialize();
        add(folderPanel);
        add(formatPanel);
        add(searchPanel);
    }

    private void initialize() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
