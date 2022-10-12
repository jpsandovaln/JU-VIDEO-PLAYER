package ju.video.player.view.information;

import ju.video.player.view.information.saved.SavedVideosPanel;
import ju.video.player.view.information.search.SearchVideoPanel;

import javax.swing.*;

public class InformationPanel extends JPanel {

    public InformationPanel() {
        SearchVideoPanel searchVideoPanel = new SearchVideoPanel();
        SavedVideosPanel savedVideosPanel = new SavedVideosPanel();
        initialize();
        add(searchVideoPanel);
        add(savedVideosPanel);

    }

    private void initialize() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
}
