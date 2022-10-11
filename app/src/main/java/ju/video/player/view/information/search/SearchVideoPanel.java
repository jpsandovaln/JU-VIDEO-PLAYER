package ju.video.player.view.information.search;

import javax.swing.*;

public class SearchVideoPanel extends JPanel {
    public SearchVideoPanel() {
        FolderPanel folderPanel = new FolderPanel();
        FormatPanel formatPanel = new FormatPanel();
        SearchPanel searchPanel = new SearchPanel();
        initialize();
        add(folderPanel);
        add(formatPanel);
        add(searchPanel);
    }

    private void initialize() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
