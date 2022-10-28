/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view.playlist.playlistpanel;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ju.video.player.controller.PlayMediaButtonController;
import ju.video.player.view.commons.Button;
import ju.video.player.view.commons.Colors;

/**
 * It is the Panel for each File that is showed in the play list
 *
 * @author Adriana Olivera
 * @version 1.0
 */

public class MediaPanel extends JPanel{

    public MediaPanel(String mediaName, int index) {
        initPanel();
        JLabel name = new JLabel(mediaName);
        name.setForeground(Colors.COMPONETS_COLOR);
        Button playButton = new Button("");
		playButton.setIcon("play.png", 20, 20);
        playButton.addActionListener(new PlayMediaButtonController(index));
        Button convertButton = new Button("");
        convertButton.setIcon("convert.png", 20, 20);
		
        add(name);
        add(Box.createRigidArea(new Dimension(400 - name.getText().length()*7, 0)));
        add(playButton);
        add(Box.createRigidArea(new Dimension(5, 0)));
        add(convertButton);
    }

    /**
     * Initialize the panel
     */
    public void initPanel() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBorder(BorderFactory.createLineBorder(Colors.COMPONETS_COLOR));
        setBackground(Colors.PRIMARY_BACKGROUNG_COLOR);
    }

}
