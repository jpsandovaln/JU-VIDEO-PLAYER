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
import java.io.File;

import ju.video.player.model.ListValidVideos;
import ju.video.player.model.MediaList;

/**
 * It is responsible for remove a element of the playlist
 *
 * @author Adriana Olivera Ordoñez
 * @version 1.0
 */
public class RemoveButtonController implements ActionListener {
    private File file;

    public RemoveButtonController(File file) {
        this.file = file;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MediaList.getInstance().removeFile(file);
        ListValidVideos.getInstance().applyFilters();
    }

}
