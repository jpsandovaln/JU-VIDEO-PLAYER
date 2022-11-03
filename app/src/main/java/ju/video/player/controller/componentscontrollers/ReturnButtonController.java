/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.controller.componentscontrollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ju.video.player.view.playlist.PlayListFrame;
import ju.video.player.view.videoplayer.MediaPlayerFrame;

/**
 * It is responsible for return from the VideoPlayerFrame to the playListFrame.
 *
 * @author Adriana Olivera Ordoñez
 * @version 1.0
 */

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
