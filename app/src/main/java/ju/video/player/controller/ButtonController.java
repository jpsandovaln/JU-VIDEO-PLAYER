/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */
package ju.video.player.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import ju.video.player.model.Formats;
import ju.video.player.model.ListValidVideos;
import ju.video.player.view.playlist.playlistpanel.VideoListPanel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class ButtonController implements ActionListener {
    static String pathOfTheSelectedFolder;
    String pathVideoFile;
    String simplePath;
    VideoListPanel playListPanel;
    ArrayList<String> listvalidVideos;
    ArrayList<String> listPathVideofile;
    ArrayList<String> simplePathFilename;
    private JFrame frame;
    //private TextArea fileSize;
    //private DateField dateField;


    //public ButtonController(VideoListPanel panelSouth, JFrame frame, TextArea textArea, DateField date) {
    public ButtonController(VideoListPanel playListPanel) {
        this.playListPanel = playListPanel;
        listvalidVideos = new ArrayList<>();
        listPathVideofile = new ArrayList<>();
        simplePathFilename = new ArrayList<>();
        //this.frame = frame;
        //fileSize = textArea;
        //dateField = date;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //closeFrame();
        listvalidVideos.clear();
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
        //showFilesSelectedFolder();
        ;
        //playListPanel.setPlayerLabel();
        //new MainFrame(playListPanel);
    }

    private void closeFrame() {
        frame.dispose();
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
                BasicFileAttributes attributes = Files.readAttributes(getCompletePath(index), BasicFileAttributes.class);
                try {
                    printBasicAttributes(attributes);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (verifyMetadataVideoFile != null) {
                    for (Formats formats : Formats.values()) {
                        if (verifyMetadataVideoFile.equals(formats.getFormat())/*&&verifySize(attributes,Integer.parseInt(fileSize.getText()))&&verifyDate(attributes,dateField.toString())*/) {
                            listvalidVideos.add(listPathVideofile.get(index));
                        /*if (verifyMetadataVideoFile.equals(formats.getFormato())/*&&verifySize(attributes,Integer.parseInt(fileSize.getText()))&&verifyDate(attributes,dateField.toString())) {
                            //listvalidVideos.add(pathOfTheSelectedFolder + listPathVideofile.get(index));
                            System.out.println(pathOfTheSelectedFolder + listPathVideofile.get(index).substring(2));
                            ListValidVideos.getInstance().addMedia(new File(pathOfTheSelectedFolder, listPathVideofile.get(index).substring(2)));*/
                        }
                    }
                }
                // grab the list of valid videos and set it to the class of video list valid videos
                //ListValidVideos.getInstance().setVideoList(listvalidVideos);
            } catch (IOException ioException) {
                System.out.println("Error: " + ioException.getMessage());
            }
        }
        System.out.println(listvalidVideos);
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
        if(attributes.size() <= definedSize || definedSize == 0){
            return true;
        }
        return false;
    }

    public boolean verifyDate(BasicFileAttributes attributes, String datem) {
        String creation = (attributes.creationTime()).toString();
        System.out.println(datem);
        if(creation.contains(datem) || datem.equals((java.time.LocalDate.now()).toString())){
            return true;
        }
        return false;
    }

    public Path getCompletePath(int index){
        File completePath = new File(simplePathFilename.get(index));
        Path path = Paths.get(pathOfTheSelectedFolder + "\\" +completePath);
        return path;
    }
}