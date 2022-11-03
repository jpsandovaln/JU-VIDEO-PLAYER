/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.controller;

import ju.video.player.commons.exceptions.RequestException;
import ju.video.player.view.playlist.PlayListFrame;
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
    private PlayListFrame playListFrame;
    private ConvertFile convertFile;
    public ConvertController(VideoConvertFrame convertVideo, PlayListFrame playListFrame) {
        this.convertFrame = convertVideo;
        this.playListFrame = playListFrame;
    }

    /**
     * It is responsible for performing the conversion when receiving an event, and configuring a Videoconvertframe label.
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            convertFile = new ConvertFile(convertFrame.getPath(), convertFrame.getFormat().getSelectedItem().toString());
            convertFrame.setLabel(convertFile.getOutputPath());
        } catch (RequestException e1) {
            e1.printStackTrace();
        }

    }

}
