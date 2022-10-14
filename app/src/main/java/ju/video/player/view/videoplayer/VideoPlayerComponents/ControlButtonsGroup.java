package ju.video.player.view.videoplayer.VideoPlayerComponents;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.*;

import ju.video.player.controller.FullScreenButtonController;
import ju.video.player.controller.NextButtonController;
import ju.video.player.controller.PauseButtonController;
import ju.video.player.controller.PlayButtonController;
import ju.video.player.controller.PreviousButtonController;
import ju.video.player.controller.StopButtonController;
import ju.video.player.view.videoplayer.VideoPlayerPanel;
import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtons.FullScreenButton;
import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtons.NextButton;
import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtons.PauseButton;
import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtons.StopButton;
import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtons.PlayButton;
import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtons.PreviousButton;

import javax.swing.BorderFactory;

public class ControlButtonsGroup extends JPanel {
    private PlayButtonController playButtonController;
    private PauseButtonController pauseButtonController;
    private StopButtonController stopButtonController;
    private PreviousButtonController previousButtonController;
    private NextButtonController nextButtonController;
    private FullScreenButtonController fullScreenButtonController;
    VideoPlayerPanel videoPlayerPanel;

    public ControlButtonsGroup(VideoPlayerPanel videoPlayerPanel) {
        this.videoPlayerPanel = videoPlayerPanel;
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        playButtonController = new PlayButtonController(videoPlayerPanel);
        pauseButtonController = new PauseButtonController(videoPlayerPanel.getMediaPlayer());
        stopButtonController = new StopButtonController(videoPlayerPanel.getMediaPlayer());
        previousButtonController = new PreviousButtonController(videoPlayerPanel.getMediaPlayer());
        nextButtonController = new NextButtonController(videoPlayerPanel.getMediaPlayer());
        fullScreenButtonController = new FullScreenButtonController(videoPlayerPanel.getMediaPlayer());
        add(new PlayButton(playButtonController));
        add(new PauseButton(pauseButtonController));
        add(new StopButton(stopButtonController));
        add(new PreviousButton(previousButtonController));
        add(new NextButton(nextButtonController));
        add(new FullScreenButton(fullScreenButtonController));
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(border);
    }
}
