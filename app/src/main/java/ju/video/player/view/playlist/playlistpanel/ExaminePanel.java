/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view.playlist.playlistpanel;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import ju.video.player.controller.componentscontrollers.ButtonController;
import ju.video.player.view.commons.Button;
import ju.video.player.view.commons.TextField;

/**
 * It is the Panel search the directory
 *
 * @author Adriana Olivera
 * @version 1.0
 */

public class ExaminePanel extends JPanel {

    public ExaminePanel(VideoListPanel videoListPanel) {
        initPanel();
        TextField pathField = new TextField("Path");
        add(pathField);
        Button examineButton = new Button("Examine");
        examineButton.addActionListener(new ButtonController(videoListPanel));
        add(examineButton);
    }

    /**
     * Initialize the panel
     */
    private void initPanel() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setSize(0, 30);
        setMaximumSize(new Dimension(700,30));
        setOpaque(false);
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}
