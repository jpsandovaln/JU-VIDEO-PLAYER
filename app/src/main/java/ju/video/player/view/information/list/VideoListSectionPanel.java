package ju.video.player.view.information.list;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.Color;

public class VideoListSectionPanel extends JPanel {

    public VideoListSectionPanel() {

        VideoListPanel videoListPanel = new VideoListPanel();
        ButtonPlayPanel buttonPlayPanel1 = new ButtonPlayPanel();
        initialize();
        add(videoListPanel);
        add(buttonPlayPanel1);

        setBackground(Color.RED);
    }

    private void initialize() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    }
}
