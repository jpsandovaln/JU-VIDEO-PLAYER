/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jala University
 */
package ju.video.player.controller.componentscontrollers;

import java.util.logging.Logger;

import ju.video.player.commons.logger.At18Logger;
import ju.video.player.view.videoplayer.ControlButtonsGroup;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;

/**
 * It is responsible handle the player fuctions.
 *
 * @author Adriana Olivera Ordoñez
 * @version 1.0
 */

public class ControlButtonsController {
    EmbeddedMediaListPlayerComponent mediaPlayerComponent;
    private Logger log = new At18Logger().getLogger();
    private Boolean isPlay;
    private Boolean isFullScrean;
    private ControlButtonsGroup controlButtons;

    public ControlButtonsController(EmbeddedMediaListPlayerComponent mediaComponent, ControlButtonsGroup controlButtons) {
        this.mediaPlayerComponent = mediaComponent;
        this.controlButtons = controlButtons;
        controlButtons.getPlayButton().addActionListener(e -> playButtonAction());
        controlButtons.getStopButton().addActionListener(e -> stopButtonAction());
        controlButtons.getPreviousButton().addActionListener(e -> previousButtonAction());
        controlButtons.getNextButton().addActionListener(e -> nextButtonAction());
        controlButtons.getFullScreenButton().addActionListener(e -> fullScreenButtonAction());
        isPlay = false;
        isFullScrean = false;
    }

    /**
     * Handle the PlayButton behavior and actions
     */
    public void playButtonAction() {
        if (isPlay) {
            mediaPlayerComponent.mediaListPlayer().controls().pause();
            log.info("Pause");
            isPlay = false;
            controlButtons.getPlayButton().setIcon("/play.png", 20, 20);
        } else {
            mediaPlayerComponent.mediaListPlayer().controls().play();
            log.info("Play");
            isPlay = true;
            controlButtons.getPlayButton().setIcon("/pause.png", 20, 20);
        }
    }

    /**
     * Stop the mediaplayer when button is pressed
     */
    public void stopButtonAction() {
        mediaPlayerComponent.mediaListPlayer().controls().stop();
        log.info("Stop");
        isPlay = false;
        controlButtons.getPlayButton().setIcon("/play.png", 20, 20);
    }
    /**
     * Set the played media to the previous file
     */
    public void previousButtonAction() {
        mediaPlayerComponent.mediaListPlayer().controls().playPrevious();
        log.info("Previous");
    }

    /**
     * Set the played media to the next file
     */
    public void nextButtonAction() {
        mediaPlayerComponent.mediaListPlayer().controls().playNext();
        log.info("Next");
    }

    /**
     * Set the played media to the previous file
     */
    public void fullScreenButtonAction() {
        if (isFullScrean) {
            mediaPlayerComponent.mediaPlayer().fullScreen().toggle();
            controlButtons.getFullScreenButton().setIcon("/full_screen.png", 20, 20);
            isFullScrean = false;
        } else {
            mediaPlayerComponent.mediaPlayer().fullScreen().toggle();
            controlButtons.getFullScreenButton().setIcon("/full_screen_activate.png", 20, 20);
            isFullScrean = true;
        }
    }

}
