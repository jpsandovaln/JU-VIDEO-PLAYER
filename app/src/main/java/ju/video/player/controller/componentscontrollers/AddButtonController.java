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

import ju.video.player.model.ListValidVideos;
import ju.video.player.model.MediaList;
import ju.video.player.view.commons.TextField;
import ju.video.player.view.playlist.playlistpanel.VideoListPanel;

/**
 * It is responsible add the files from the path to the playlist whe the button is pushed.
 *
 * @author Adriana Olivera Ordoñez
 * @version 1.0
 */

public class AddButtonController implements ActionListener {
    private TextField textField;
    private VideoListPanel playListPanel;

    public AddButtonController(VideoListPanel playListPanel, TextField textField) {
        this.playListPanel = playListPanel;
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedPath = textField.getText();
        MediaList.getInstance().addFilesFromFolder(selectedPath);
        ListValidVideos.getInstance().setPlayListPanel(playListPanel);
        ListValidVideos.getInstance().applyFilters();
    }

}
