package main.java.ju.video.player.view.information.search;

import main.java.ju.video.player.view.information.search.FolderPanel;
import main.java.ju.video.player.view.information.search.FormatPanel;
import main.java.ju.video.player.view.information.search.SearchPanel;

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
