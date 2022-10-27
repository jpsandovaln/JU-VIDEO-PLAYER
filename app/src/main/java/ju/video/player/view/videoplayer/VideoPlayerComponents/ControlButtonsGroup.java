/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view.videoplayer.VideoPlayerComponents;

import javax.swing.JPanel;
import java.awt.FlowLayout;

import ju.video.player.controller.FullScreenButtonController;
import ju.video.player.controller.NextButtonController;
import ju.video.player.controller.PauseButtonController;
import ju.video.player.controller.PlayButtonController;
import ju.video.player.controller.PreviousButtonController;
import ju.video.player.controller.StopButtonController;
import ju.video.player.view.commons.Colors;
import ju.video.player.view.commons.Button;
import ju.video.player.view.videoplayer.VideoPlayerPanel;

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
        setBackground(Colors.PRIMARY_BACKGROUNG_COLOR);

        playButtonController = new PlayButtonController(videoPlayerPanel.getMediaPlayer());
        pauseButtonController = new PauseButtonController(videoPlayerPanel.getMediaPlayer());
        stopButtonController = new StopButtonController(videoPlayerPanel.getMediaPlayer());
        previousButtonController = new PreviousButtonController(videoPlayerPanel.getMediaPlayer());
        nextButtonController = new NextButtonController(videoPlayerPanel.getMediaPlayer());
        fullScreenButtonController = new FullScreenButtonController(videoPlayerPanel.getMediaPlayer());

        Button playButton = new Button("");
		playButton.setIcon("/play.png", 20, 20);
        playButton.addActionListener(playButtonController);
        Button pauseButton = new Button("");
		pauseButton.setIcon("/pause.png", 20, 20);
        pauseButton.addActionListener(pauseButtonController);
        Button stopButton = new Button("");
		stopButton.setIcon("/stop.png", 20, 20);
        stopButton.addActionListener(stopButtonController);
        Button previousButton = new Button("");
		previousButton.setIcon("/previous.png", 20, 20);
        previousButton.addActionListener(previousButtonController);
        Button nextButton = new Button("");
		nextButton.setIcon("/next.png", 20, 20);
        nextButton.addActionListener(nextButtonController);
        Button fullScreanButton = new Button("");
		fullScreanButton.setIcon("/fullScreen.png", 20, 20);
        fullScreanButton.addActionListener(fullScreenButtonController);

        add(playButton);
        add(pauseButton);
        add(stopButton);
        add(previousButton);
        add(nextButton);
        add(fullScreanButton);
    }
}
