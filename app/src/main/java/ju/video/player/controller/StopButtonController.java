package ju.video.player.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;
public class StopButtonController implements ActionListener{
    EmbeddedMediaListPlayerComponent mediaPlayerComponent;

    public StopButtonController(EmbeddedMediaListPlayerComponent mediaPlayerComponent){
        this.mediaPlayerComponent = mediaPlayerComponent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mediaPlayerComponent.mediaListPlayer().controls().playPrevious();
        System.out.println("Stop");
    }
}
