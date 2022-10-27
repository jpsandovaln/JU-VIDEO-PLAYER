package ju.video.player.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ju.video.player.model.ListValidVideos;
import ju.video.player.view.videoplayer.MediaPlayerFrame;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;

public class PlayMediaButtonController implements ActionListener {
    private EmbeddedMediaListPlayerComponent mediaPlayerComponent;
    private int initialMedia = 0;
    

    public PlayMediaButtonController(int initialMedia) {
        this.initialMedia = initialMedia;
        mediaPlayerComponent = new EmbeddedMediaListPlayerComponent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        createList();
        new MediaPlayerFrame(mediaPlayerComponent);
    }

    public void createList() {
        //mediaPlayerComponent.removeAll();
        int listSize = ListValidVideos.getInstance().getVideoList().size();
        for (int position = 0; position < listSize; position++) {
            int index = (initialMedia + position) < listSize ? initialMedia + position: (initialMedia + position) - listSize;
            String path = ListValidVideos.getInstance().getVideoList().get(index).getPath();
            mediaPlayerComponent.mediaListPlayer().list().media().add(path);
        }
    }

    public EmbeddedMediaListPlayerComponent getMediaPlayer() {
        return mediaPlayerComponent;
    }
}
