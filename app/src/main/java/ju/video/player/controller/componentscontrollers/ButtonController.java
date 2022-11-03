/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */
package ju.video.player.controller.componentscontrollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import ju.video.player.commons.exceptions.FilterFilesException;
import ju.video.player.commons.logger.At18Logger;
import ju.video.player.model.Format;
import ju.video.player.view.playlist.playlistpanel.ExaminePanel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * It is a enum of all the accepted formats with its respective mime type
 *
 * @author Sarai Alvarez
 * @version 1.0
 */

public class ButtonController implements ActionListener {
    //private Logger log = new At18Logger().getLogger();
    static String pathOfTheSelectedFolder;
    String pathVideoFile;
    String simplePath;
    
    //VideoListPanel playListPanel;
    ArrayList<String> listValidVideos;
    ArrayList<String> listPathVideofile;
    ArrayList<String> simplePathFilename;
    ExaminePanel examinePanel;

    //public ButtonController(VideoListPanel playListPanel) {
    public ButtonController(ExaminePanel examinePanel) {
        this.examinePanel = examinePanel;
        listValidVideos = new ArrayList<>();
        listPathVideofile = new ArrayList<>();
        simplePathFilename = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // closeFrame();
        listValidVideos.clear();
        listPathVideofile.clear();
        simplePathFilename.clear();
        // if the user presses the save button show the save dialog
        String com = e.getActionCommand();

        if (com.equals("save")) {
            // create an object of JFileChooser class
            JFileChooser jfileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            // set the selection mode to directories only
            jfileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            // invoke the showsSaveDialog function to show the save dialog
            int invoke = jfileChooser.showSaveDialog(null);
            if (invoke == JFileChooser.APPROVE_OPTION) {
                // set the label to the path of the selected directory
                pathOfTheSelectedFolder = jfileChooser.getSelectedFile().getAbsolutePath();
            }
        }
        // if the user presses the open dialog show the open dialog
        else {
            // create an object of JFileChooser class
            JFileChooser jfileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            // set the selection mode to directories only
            jfileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            // invoke the showsOpenDialog function to show the save dialog
            int invoke = jfileChooser.showOpenDialog(null);
            if (invoke == JFileChooser.APPROVE_OPTION) {
                // set the label to the path of the selected directory
                pathOfTheSelectedFolder = jfileChooser.getSelectedFile().getAbsolutePath();
            }
        }
        examinePanel.setFieldText(pathOfTheSelectedFolder);
        //ListValidVideos.getInstance().setPathOfTheSelectedFolder(pathOfTheSelectedFolder);
        //ListValidVideos.getInstance().setPlayListPanel(playListPanel);
        //ListValidVideos.getInstance().applyFilters();
    }
}