package ju.video.player.view.videoplayer;

import javax.swing.*;
import java.awt.*;
import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtonsGroup;
import ju.video.player.view.videoplayer.VideoPlayerComponents.NameVideoText;
import ju.video.player.view.videoplayer.VideoPlayerComponents.VideoFrame;

public class VideoPlayerPanel extends JPanel {

    public VideoPlayerPanel() {
        NameVideoText nameVideoText = new NameVideoText();
        VideoFrame videoFrame = new VideoFrame();
        ControlButtonsGroup controlButtonsGroup = new ControlButtonsGroup();
        BorderLayout borderLayout = new BorderLayout(3, 3);
        setLayout(borderLayout);
        add(nameVideoText, BorderLayout.PAGE_START);
        add(videoFrame, BorderLayout.CENTER);
        add(controlButtonsGroup, BorderLayout.PAGE_END);
        setVisible(true);
    }
}
