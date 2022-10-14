package ju.video.player.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ju.video.player.view.videoplayer.VideoPlayerComponents.VideoFrame;

public class PlayButtonController implements ActionListener {
    VideoFrame videoFrame;

    public PlayButtonController(VideoFrame videoFrame) {
        this.videoFrame = videoFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        videoFrame.createList();
        videoFrame.getMediaPlayer().mediaListPlayer().controls().play();
        System.out.println("Play");
    }
}
