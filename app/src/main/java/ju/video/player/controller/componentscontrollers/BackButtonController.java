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

import javax.swing.JFrame;

import ju.video.player.view.playlist.PlayListFrame;

/**
 * It is responsible for return to the playList frame from the ConvertFrame.
 *
 * @author Adriana Olivera Ordoñez
 * @version 1.0
 */

public class BackButtonController implements ActionListener {
    private JFrame convertFrame;
    private PlayListFrame playListFrame;

    public BackButtonController(JFrame convertFrame, PlayListFrame playListFrame) {
        this.convertFrame = convertFrame;
        this.playListFrame = playListFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        convertFrame.dispose();
        playListFrame.setVisible(true);
    }

}
