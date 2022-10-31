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
import ju.video.player.view.commons.UIColor;
import ju.video.player.view.commons.Button;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;

public class ControlButtonsGroup extends JPanel {
    private PreviousButtonController previousButtonController;
    private NextButtonController nextButtonController;
    private FullScreenButtonController fullScreenButtonController;
    private EmbeddedMediaListPlayerComponent mediaComponent;
    private Button playButton;
    private Button stopButton;
    private Button previousButton;
    private Button nextButton;
    private Button fullScreenButton;

    public ControlButtonsGroup(EmbeddedMediaListPlayerComponent mediaComponent) {
        FlowLayout layout = new FlowLayout();
        setLayout(layout);
        setBackground(UIColor.PRIMARY_BACKGROUNG_COLOR);

        playButton = new Button("");
		playButton.setIcon("/play.png", 20, 20);
        stopButton = new Button("");
		stopButton.setIcon("/stop.png", 20, 20);
        previousButton = new Button("");
		previousButton.setIcon("/previous.png", 20, 20);
        nextButton = new Button("");
		nextButton.setIcon("/next.png", 20, 20);
        fullScreenButton = new Button("");
		fullScreenButton.setIcon("/full_screen.png", 20, 20);
        //fullScreenButton.addActionListener(new FullScreenButtonController(mediaComponent));
        
        add(playButton);
        add(stopButton);
        add(previousButton);
        add(nextButton);
        add(fullScreenButton);

        PlayButtonController controlButtonsController = new PlayButtonController(mediaComponent, this);
    }

    public EmbeddedMediaListPlayerComponent getMediaComponent() {
        return mediaComponent;
    }

    public Button getPlayButton() {
        return playButton;
    }
    public Button getPreviousButton() {
        return previousButton;
    }
    public Button getNextButton() {
        return nextButton;
    }
    public Button getStopButton() {
        return stopButton;
    }
    public Button getFullScreenButton() {
        return fullScreenButton;
    }

}
