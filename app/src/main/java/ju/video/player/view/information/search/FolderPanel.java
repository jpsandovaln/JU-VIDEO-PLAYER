package ju.video.player.view.information.search;

import javax.swing.*;
import java.awt.*;

public class FolderPanel extends JPanel {

    public FolderPanel() {
        FolderLabel folderLabel = new FolderLabel();
        FolderChooserButton folderChooserButton = new FolderChooserButton();
        initialize();
        add(folderLabel);
        add(folderChooserButton);
        setBackground(Color.CYAN);
    }

    private void initialize() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }
}
