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

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.filechooser.FileSystemView;

import ju.video.player.controller.componentscontrollers.AddButtonController;
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
    private TextField pathField = new TextField("Path");

    public ExaminePanel(VideoListPanel videoListPanel) {
        initPanel();
        pathField.setText(FileSystemView.getFileSystemView().getHomeDirectory().toString());
        add(pathField);
        Button examineButton = new Button("Examine");
        examineButton.addActionListener(new ButtonController(this));
        add(examineButton);
        Button addButton = new Button("Add");
        addButton.addActionListener(new AddButtonController(videoListPanel, pathField));
        add(Box.createRigidArea(new Dimension(5, 0)));
        add(addButton);
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

    /**
     * Edit the content of the TextField
     * 
     * New path for the TextField
     * @param text 
     */
    public void setFieldText(String text) {
        pathField.setText(text);
    }
}
