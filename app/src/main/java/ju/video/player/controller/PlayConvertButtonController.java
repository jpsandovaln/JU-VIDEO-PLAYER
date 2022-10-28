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
import ju.video.player.view.videoconvert.VideoConvertFrame;

public class PlayConvertButtonController implements ActionListener {
    private String nameMedia;

    public PlayConvertButtonController(String mediaName) {
        this.nameMedia = mediaName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String path = ListValidVideos.getInstance().getPathOfTheSelectedFolder() + "\\" + this.nameMedia;
        new VideoConvertFrame(path);
    }

}
