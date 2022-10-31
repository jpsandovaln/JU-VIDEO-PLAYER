/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ju.video.player.model.ListValidVideos;
import ju.video.player.view.playlist.PlayListFrame;
import ju.video.player.view.videoplayer.MediaPlayerFrame;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;

public class PlayMediaButtonController implements ActionListener {
    private EmbeddedMediaListPlayerComponent mediaPlayerComponent;
    private PlayListFrame playListFrame;
    private int initialMedia = 0;
    

    public PlayMediaButtonController(PlayListFrame playListFrame, int initialMedia) {
        this.initialMedia = initialMedia;
        this.playListFrame = playListFrame;
        mediaPlayerComponent = new EmbeddedMediaListPlayerComponent();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        createList();
        playListFrame.setVisible(false);
        new MediaPlayerFrame(playListFrame, mediaPlayerComponent);
    }

    public void createList() {
        //mediaPlayerComponent.removeAll();
        int listSize = ListValidVideos.getInstance().getVideoList().size();
        for (int position = 0; position < listSize; position++) {
            int index = (initialMedia + position) < listSize ? initialMedia + position: (initialMedia + position) - listSize;
            String path = ListValidVideos.getInstance().getPathOfTheSelectedFolder() + "\\" + ListValidVideos.getInstance().getVideoList().get(index);
            System.out.println(path);
            mediaPlayerComponent.mediaListPlayer().list().media().add(path);
        }
    }

    public EmbeddedMediaListPlayerComponent getMediaPlayer() {
        return mediaPlayerComponent;
    }
}
