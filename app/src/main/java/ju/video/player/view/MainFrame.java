package ju.video.player.view;

import ju.video.player.view.footer.FooterPanel;
import ju.video.player.view.information.InformationPanel;
import ju.video.player.view.videoplayer.VideoPlayerPanel;

import javax.swing.JFrame;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        InformationPanel informationPanel = new InformationPanel();
        VideoPlayerPanel videoPlayerPanel = new VideoPlayerPanel(this);
        FooterPanel footerPanel = new FooterPanel();
        initialize();
        add(informationPanel, BorderLayout.WEST);
        add(videoPlayerPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);
        pack();
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        setTitle("Video Player");
        setVisible(true);
    }
}
