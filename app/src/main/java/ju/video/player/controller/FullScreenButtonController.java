package ju.video.player.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;

public class FullScreenButtonController implements ActionListener {
    EmbeddedMediaListPlayerComponent mediaPlayerComponent;

    public FullScreenButtonController(EmbeddedMediaListPlayerComponent mediaPlayerComponent) {
        this.mediaPlayerComponent = mediaPlayerComponent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mediaPlayerComponent.mediaPlayer().fullScreen().toggle();
        System.out.println("Full Screen");
    }

}
