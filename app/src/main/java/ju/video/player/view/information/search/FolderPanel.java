package ju.video.player.view.information.search;

import javax.swing.*;
import ju.video.player.view.information.list.VideoListPanel;

import java.awt.*;

public class FolderPanel extends JPanel {

    public FolderPanel(VideoListPanel panelSouth) {
        FolderLabel folderLabel = new FolderLabel();
        FolderChooserButton folderChooserButton = new FolderChooserButton(panelSouth);
        initialize();
        add(folderLabel);
        add(folderChooserButton);
        setBackground(Color.CYAN);
    }

    private void initialize() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }
}
