/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.controller;

import ju.video.player.view.videoconvert.VideoConvertFrame;
import ju.video.player.model.ConvertFile;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * This class is responsible for sending the path and format to the spring converter service.
 *
 * @author Jose Antonio Romay Ayarachi 
 * @version 1.0
 */

public class ConvertController implements ActionListener {
    private VideoConvertFrame convertFrame;

    public ConvertController(VideoConvertFrame convertVideo) {
        this.convertFrame = convertVideo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            new ConvertFile(convertFrame.getFormat().getSelectedItem().toString(), convertFrame.getPath());
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

}
