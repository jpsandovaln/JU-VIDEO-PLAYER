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
import ju.video.player.model.ListValidVideos;
import ju.video.player.view.playlist.playlistpanel.VideoListPanel;

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
    private Logger log = new At18Logger().getLogger();
    static String pathOfTheSelectedFolder;
    String pathVideoFile;
    String simplePath;
    VideoListPanel playListPanel;
    ArrayList<String> listValidVideos;
    ArrayList<String> listPathVideofile;
    ArrayList<String> simplePathFilename;

    public ButtonController(VideoListPanel playListPanel) {
        this.playListPanel = playListPanel;
        listValidVideos = new ArrayList<>();
        listPathVideofile = new ArrayList<>();
        simplePathFilename = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // closeFrame();
        try {
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
            ListValidVideos.getInstance().setPathOfTheSelectedFolder(pathOfTheSelectedFolder);
            ListValidVideos.getInstance().setPlayListPanel(playListPanel);
            ListValidVideos.getInstance().applyFilters();
        } catch (FilterFilesException ex) {
            log.warning(ex.getMessage());
            ex.printStackTrace();
        }

    }

    public void showFilesSelectedFolder() {
        File paths = new File(pathOfTheSelectedFolder);
        String[] nameFiles = paths.list();
        for (int index = 0; index < nameFiles.length; index++) {
            pathVideoFile = "../" + nameFiles[index];
            simplePath = nameFiles[index];
            listPathVideofile.add(pathVideoFile);
            simplePathFilename.add(simplePath);
            File f = new File(paths.getAbsolutePath(), nameFiles[index]);
            if (f.isDirectory()) {
                String[] fileinSubfolder = f.list();
                for (int indej = 0; indej < fileinSubfolder.length; indej++) {
                    pathVideoFile = "../" + fileinSubfolder[indej];
                    simplePath = fileinSubfolder[indej];
                    listPathVideofile.add(pathVideoFile);
                    simplePathFilename.add(simplePath);
                }
            }
        }
    }

    public void verify() {
        String verifyMetadataVideoFile;
        for (int index = 0; index < listPathVideofile.size(); index++) {
            File videoPath = new File(listPathVideofile.get(index));
            try {
                verifyMetadataVideoFile = Files.probeContentType(videoPath.toPath());
                BasicFileAttributes attributes = Files.readAttributes(getCompletePath(index),
                        BasicFileAttributes.class);
                try {
                    printBasicAttributes(attributes);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (verifyMetadataVideoFile != null) {
                    for (Format formats : Format.values()) {
                        if (verifyMetadataVideoFile.equals(formats.getFormat())) {
                            listValidVideos.add(listPathVideofile.get(index));
                        }
                    }
                }
                // grab the list of valid videos and set it to the class of video list valid
                // videos
                // ListValidVideos.getInstance().setVideoList(listvalidVideos);
            } catch (IOException ioException) {
                System.out.println("Error: " + ioException.getMessage());
            }
        }
    }

    public static String getpathOfTheSelectedFolder() {
        return pathOfTheSelectedFolder;
    }

    private static void printBasicAttributes(BasicFileAttributes attributes) throws Exception {
        System.out.printf("creationTime     = %s%n", attributes.creationTime());
        System.out.printf("lastAccessTime   = %s%n", attributes.lastAccessTime());
        System.out.printf("lastModifiedTime = %s%n", attributes.lastModifiedTime());
        System.out.printf("size             = %s%n", attributes.size());
    }

    public boolean verifySize(BasicFileAttributes attributes, int definedSize) {
        if (attributes.size() <= definedSize || definedSize == 0) {
            return true;
        }
        return false;
    }

    public boolean verifyDate(BasicFileAttributes attributes, String datem) {
        String creation = (attributes.creationTime()).toString();
        System.out.println(datem);
        if (creation.contains(datem) || datem.equals((java.time.LocalDate.now()).toString())) {
            return true;
        }
        return false;
    }

    public Path getCompletePath(int index) {
        File completePath = new File(simplePathFilename.get(index));
        Path path = Paths.get(pathOfTheSelectedFolder + "\\" + completePath);
        return path;
    }
}