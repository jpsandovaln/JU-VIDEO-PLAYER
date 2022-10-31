package ju.video.player.controller;

import java.util.logging.Logger;

import ju.video.player.commons.logger.At18Logger;
import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtonsGroup;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;

public class PlayButtonController {
    EmbeddedMediaListPlayerComponent mediaPlayerComponent;
    private Logger log = new At18Logger().getLogger();
    private Boolean isPlay;
    private Boolean isFullScrean;
    private ControlButtonsGroup controlButtons;

    public PlayButtonController(EmbeddedMediaListPlayerComponent mediaComponent, ControlButtonsGroup controlButtons) {
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
    public void stopButtonAction() {
        mediaPlayerComponent.mediaListPlayer().controls().stop();
        log.info("Stop");
        isPlay = false;
        controlButtons.getPlayButton().setIcon("/play.png", 20, 20);
    }
    public void previousButtonAction() {
        mediaPlayerComponent.mediaListPlayer().controls().playPrevious();
        log.info("Previous");
    }
    public void nextButtonAction() {
        mediaPlayerComponent.mediaListPlayer().controls().playNext();
        log.info("Next");
    }
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
