package main.java.ju.video.player.view;

import main.java.ju.video.player.view.footer.FooterPanel;
import main.java.ju.video.player.view.information.InformationPanel;
import main.java.ju.video.player.view.videoplayer.VideoPlayerPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private static final int DEFAULT_POS = 30;
    private static final int DEFAULT_WIDTH = 700;
    private static final int DEFAULT_HEIGHT = 600;
    public MainFrame() {
        InformationPanel informationPanel = new InformationPanel();
        VideoPlayerPanel videoPlayerPanel = new VideoPlayerPanel();
        FooterPanel footerPanel = new FooterPanel();
        initialize();
        add(informationPanel, BorderLayout.WEST);
        add(videoPlayerPanel, BorderLayout.CENTER);
        add(footerPanel, BorderLayout.SOUTH);
    }

    private void initialize() {
        setBounds(DEFAULT_POS, DEFAULT_POS, DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Video Player");
        setVisible(true);

    }
}
