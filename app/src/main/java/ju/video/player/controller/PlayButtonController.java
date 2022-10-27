package ju.video.player.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import ju.video.player.commons.logger.At18Logger;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;

public class PlayButtonController implements ActionListener {
    EmbeddedMediaListPlayerComponent mediaPlayerComponent;
    private Logger log = new At18Logger().getLogger();

    public PlayButtonController(EmbeddedMediaListPlayerComponent mediaPlayerComponent) {
        this.mediaPlayerComponent = mediaPlayerComponent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mediaPlayerComponent.mediaListPlayer().controls().play();
        //System.out.println("Play");
        log.info("Play");
    }
}
