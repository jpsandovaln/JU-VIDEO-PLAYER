/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view.videoplayer;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ju.video.player.controller.componentscontrollers.ReturnButtonController;
import ju.video.player.view.commons.Button;
import ju.video.player.view.commons.UIColor;
import ju.video.player.view.playlist.PlayListFrame;


/**
 * It is the panel that go up to the media player
 *
 * @author Rodrigo Valda
 * @version 1.0
 */

public class NameVideoText extends JPanel {
    private JLabel videoName = new JLabel();

    public NameVideoText(MediaPlayerFrame mediaPlayerFrame, PlayListFrame playListFrame) {
        videoName.setText(" ");
        this.setLayout(new BorderLayout());
        Button returnButton = new Button("");
        returnButton.setIcon("/back.png", 15, 15);
        returnButton.addActionListener(new ReturnButtonController(mediaPlayerFrame, playListFrame));
        add(returnButton, BorderLayout.WEST);
        add(videoName, BorderLayout.CENTER);
        setBackground(UIColor.PRIMARY_BACKGROUNG_COLOR);
    }

    /**
     * For change the text of the media name field
     * 
     * @param newVideoName
     */
    public void updateMediaName(String newVideoName){
        videoName.setText(newVideoName);
    }
}
