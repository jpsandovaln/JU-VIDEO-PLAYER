package ju.video.player.view.information.search;

import ju.video.player.view.materialDesing.components.date.fields.DateField;
import ju.video.player.view.materialDesing.components.input.TextArea;
import ju.video.player.view.playlist.playlistpanel.VideoListPanel;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FolderChooserButton extends JButton {

    private static final int WIDTH = 200;
    private static final int HEIGHT = 200;

    public FolderChooserButton(VideoListPanel panelSouth, JFrame frame, TextArea area, DateField date) {
        super("Choose file");
        initComponents();
        // addActionListener(new ButtonController(panelSouth, frame, area, date));
    }

    private void initComponents() {
        setSize(new Dimension(WIDTH, HEIGHT));
    }
}
