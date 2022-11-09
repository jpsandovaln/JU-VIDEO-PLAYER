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

import ju.video.player.view.playlist.playlistpanel.ExaminePanel;

import java.util.ArrayList;

/**
 * It is a enum of all the accepted formats with its respective mime type
 *
 * @author Sarai Alvarez
 * @version 1.0
 */

public class ButtonController implements ActionListener {
    static String pathOfTheSelectedFolder;
    String pathVideoFile;
    String simplePath;
    ArrayList<String> listValidVideos;
    ArrayList<String> listPathVideofile;
    ArrayList<String> simplePathFilename;
    ExaminePanel examinePanel;

    public ButtonController(ExaminePanel examinePanel) {
        this.examinePanel = examinePanel;
        listValidVideos = new ArrayList<>();
        listPathVideofile = new ArrayList<>();
        simplePathFilename = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        listValidVideos.clear();
        listPathVideofile.clear();
        simplePathFilename.clear();
        String com = e.getActionCommand();

        if (com.equals("save")) {
            JFileChooser jfileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            jfileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int invoke = jfileChooser.showSaveDialog(null);
            if (invoke == JFileChooser.APPROVE_OPTION) {
                pathOfTheSelectedFolder = jfileChooser.getSelectedFile().getAbsolutePath();
            }
        } else {
            JFileChooser jfileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
            jfileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int invoke = jfileChooser.showOpenDialog(null);
            if (invoke == JFileChooser.APPROVE_OPTION) {
                pathOfTheSelectedFolder = jfileChooser.getSelectedFile().getAbsolutePath();
            }
        }
        examinePanel.setFieldText(pathOfTheSelectedFolder);
    }
}