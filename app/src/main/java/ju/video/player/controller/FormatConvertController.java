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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is responsible for updating the ComboBox of the formats.
 *
 * @author Jose Antonio Romay Ayarachi 
 * @version 1.0
 */

public class FormatConvertController implements ActionListener {
    private VideoConvertFrame convertFrame;

    public FormatConvertController(VideoConvertFrame convertVideo) {
        this.convertFrame = convertVideo;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        
        convertFrame.fillFormat((String) convertFrame.getTypeFormat().getSelectedItem());
    }

}
