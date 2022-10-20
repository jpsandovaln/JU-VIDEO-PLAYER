package ju.video.player.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import ju.video.player.commons.logger.At18Logger;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;
public class NextButtonController implements ActionListener{
    private Logger log = new At18Logger().getLogger();
    EmbeddedMediaListPlayerComponent mediaPlayerComponent;
    public NextButtonController(EmbeddedMediaListPlayerComponent mediaPlayerComponent){
        this.mediaPlayerComponent = mediaPlayerComponent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mediaPlayerComponent.mediaListPlayer().controls().playNext();
        //System.out.println("Next");
        log.info("Next");
    }
}
