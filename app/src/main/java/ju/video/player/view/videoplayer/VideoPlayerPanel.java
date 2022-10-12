package ju.video.player.view.videoplayer;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;

import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtonsGroup;
import ju.video.player.view.videoplayer.VideoPlayerComponents.NameVideoText;
import ju.video.player.view.videoplayer.VideoPlayerComponents.VideoFrame;

public class VideoPlayerPanel extends JPanel {

    public VideoPlayerPanel() {
        setBackground(Color.GREEN);
        NameVideoText nameVideoText = new NameVideoText();
        VideoFrame videoFrame = new VideoFrame();
        ControlButtonsGroup controlButtonsGroup = new ControlButtonsGroup();
        BorderLayout borderLayout = new BorderLayout(5,5);
        setLayout(borderLayout);
        add(nameVideoText, BorderLayout.PAGE_START);
        add(videoFrame, BorderLayout.CENTER);
        add(controlButtonsGroup, BorderLayout.PAGE_END);
        setVisible(true);
        Border border = BorderFactory.createLineBorder(Color.BLUE,2);
        this.setBorder(border);
    }
}
