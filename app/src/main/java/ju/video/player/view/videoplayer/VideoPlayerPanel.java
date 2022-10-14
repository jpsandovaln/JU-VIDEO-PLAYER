package ju.video.player.view.videoplayer;

import javax.swing.*;
import java.awt.*;

import ju.video.player.view.MainFrame;
import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtonsGroup;
import ju.video.player.view.videoplayer.VideoPlayerComponents.NameVideoText;
import ju.video.player.view.videoplayer.VideoPlayerComponents.VideoFrame;

public class VideoPlayerPanel extends JPanel {
    MainFrame mainFrame;

    public VideoPlayerPanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        NameVideoText nameVideoText = new NameVideoText();
        VideoFrame videoFrame = new VideoFrame(mainFrame);
        ControlButtonsGroup controlButtonsGroup = new ControlButtonsGroup(videoFrame);
        BorderLayout borderLayout = new BorderLayout(3, 3);
        setLayout(borderLayout);
        add(nameVideoText, BorderLayout.PAGE_START);
        add(videoFrame, BorderLayout.CENTER);
        add(controlButtonsGroup, BorderLayout.PAGE_END);
        setVisible(true);
    }
}
