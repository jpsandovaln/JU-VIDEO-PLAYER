package ju.video.player.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ju.video.player.view.videoplayer.MediaPlayerFrame;

public class PlayMediaButtonController implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        new MediaPlayerFrame();
        
    }
    
}
