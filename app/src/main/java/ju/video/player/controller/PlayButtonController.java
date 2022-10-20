package ju.video.player.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import ju.video.player.commons.logger.At18Logger;
import ju.video.player.view.videoplayer.VideoPlayerPanel;

public class PlayButtonController implements ActionListener {
    VideoPlayerPanel videoPlayerPanel;
    private Logger log = new At18Logger().getLogger();

    public PlayButtonController(VideoPlayerPanel videoPlayerPanel) {
        this.videoPlayerPanel = videoPlayerPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        videoPlayerPanel.createList();
        videoPlayerPanel.getMediaPlayer().mediaListPlayer().controls().play();
        //System.out.println("Play");
        log.info("Play");
    }
}
