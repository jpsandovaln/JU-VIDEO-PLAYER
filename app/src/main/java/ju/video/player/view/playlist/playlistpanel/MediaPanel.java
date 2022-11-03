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
import java.io.File;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ju.video.player.controller.componentscontrollers.PlayConvertButtonController;
import ju.video.player.controller.componentscontrollers.PlayMediaButtonController;
import ju.video.player.controller.componentscontrollers.RemoveButtonController;
import ju.video.player.view.commons.Button;
import ju.video.player.view.commons.UIColor;
import ju.video.player.view.playlist.PlayListFrame;

/**
 * It is the Panel for each File that is showed in the play list
 *
 * @author Adriana Olivera
 * @version 1.0
 */

public class MediaPanel extends JPanel{

    public MediaPanel(File file, int index, PlayListFrame playListFrame) {
        initPanel();
        JLabel name = new JLabel(file.getName());
        name.setForeground(UIColor.COMPONETS_COLOR);
        Button playButton = new Button("");
		playButton.setIcon("/play.png", 20, 20);
        playButton.addActionListener(new PlayMediaButtonController(playListFrame, index));
        Button convertButton = new Button("");
        convertButton.setIcon("/convert.png", 20, 20);
        convertButton.addActionListener(new PlayConvertButtonController(file, playListFrame));
        Button removeButton = new Button("");
        removeButton.setIcon("/remove.png", 20, 20);
        removeButton.addActionListener(new RemoveButtonController(file));
		
        add(name);
        add(Box.createHorizontalGlue());
        add(playButton);
        add(Box.createRigidArea(new Dimension(5, 0)));
        add(convertButton);
        add(Box.createRigidArea(new Dimension(5, 0)));
        add(removeButton);
    }

    /**
     * Initialize the panel
     */
    public void initPanel() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setSize(700,600);
        setBorder(BorderFactory.createLineBorder(UIColor.SECONDARY_BACKGROUNG_COLOR));
        setBackground(UIColor.PRIMARY_BACKGROUNG_COLOR);
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }

}
