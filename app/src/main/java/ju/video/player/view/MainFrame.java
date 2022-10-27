package ju.video.player.view;

import ju.video.player.view.footer.FooterPanel;
import ju.video.player.view.information.InformationPanel;
import ju.video.player.view.materialDesing.constants.Constants;
import ju.video.player.view.playlist.playlistpanel.VideoListPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(VideoListPanel videoListPanel) {

        InformationPanel informationPanel = new InformationPanel(videoListPanel);
        //VideoPlayerPanel videoPlayerPanel = new VideoPlayerPanel(this);
        FooterPanel footerPanel = new FooterPanel();
        initialize();
        add(informationPanel, BorderLayout.WEST);
        //add(videoPlayerPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);
        pack();
    }

    private void initialize() {
        Image icon = new ImageIcon(Constants.RESOURCES_IMAGES+"\\icon.png").getImage();
        setIconImage(icon);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        setTitle("Video Player");
        setVisible(true);
    }
}
