package ju.video.player.controller.componentscontrollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ju.video.player.view.playlist.PlayListFrame;
import ju.video.player.view.videoplayer.MediaPlayerFrame;

public class ReturnButtonController implements ActionListener {
    private MediaPlayerFrame mediaPlayerFrame;
    private PlayListFrame playListFrame;

    public ReturnButtonController(MediaPlayerFrame mediaPlayerFrame, PlayListFrame playListFrame) {
        this.mediaPlayerFrame = mediaPlayerFrame;
        this.playListFrame = playListFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mediaPlayerFrame.dispose();
        mediaPlayerFrame.getMediaComponent().mediaListPlayer().controls().stop();
        playListFrame.setVisible(true);
    }

}
