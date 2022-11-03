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
import java.io.File;

import ju.video.player.view.playlist.PlayListFrame;
import ju.video.player.view.videoconvert.VideoConvertFrame;

public class PlayConvertButtonController implements ActionListener {
    private File file;
    private PlayListFrame playListFrame;

    public PlayConvertButtonController(File file, PlayListFrame playListFrame) {
        this.file = file;
        this.playListFrame = playListFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String path = file.getPath();
        playListFrame.setVisible(false);
        new VideoConvertFrame(path, playListFrame);
    }

}
