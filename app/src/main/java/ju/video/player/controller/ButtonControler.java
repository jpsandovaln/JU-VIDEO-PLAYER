package ju.video.player.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import ju.video.player.model.Formats;
import ju.video.player.model.ListValidVideos;
import ju.video.player.view.information.list.VideoListPanel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class ButtonControler implements ActionListener {
    static String pathOfTheSelectedFolder;
    String pathVideoFile;
    VideoListPanel panelSouth;
    ArrayList<String> listvalidVideos;
    ArrayList<String> listPathVideofile;

    public ButtonControler(VideoListPanel panelSouth) {
        this.panelSouth = panelSouth;

        listvalidVideos = new ArrayList<>();
        listPathVideofile = new ArrayList<>();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        listvalidVideos.clear();
        listPathVideofile.clear();
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

        showFilesSelectedFolder();
        verify();
        panelSouth.setPlayerLabel();
    }

    public void showFilesSelectedFolder() {
        File paths = new File(pathOfTheSelectedFolder);
        String[] nameFiles = paths.list();
        for (int index = 0; index < nameFiles.length; index++) {
            pathVideoFile = "../" + nameFiles[index];
            listPathVideofile.add(pathVideoFile);
            File f = new File(paths.getAbsolutePath(), nameFiles[index]);
            if (f.isDirectory()) {
                String[] fileinSubfolder = f.list();
                for (int indej = 0; indej < fileinSubfolder.length; indej++) {
                    pathVideoFile = "../" + fileinSubfolder[indej];
                    listPathVideofile.add(pathVideoFile);
                }
            }
        }
    }

    // verify if a file is of the correct format
    public void verify() {
        String verifyMetadataVideoFile;
        for (int index = 0; index < listPathVideofile.size(); index++) {
            File videoPath = new File(listPathVideofile.get(index));
            try {
                verifyMetadataVideoFile = Files.probeContentType(videoPath.toPath());
                if (verifyMetadataVideoFile != null) {
                    for (Formats formats : Formats.values()) {
                        if (verifyMetadataVideoFile.equals(formats.getFormato())) {
                            listvalidVideos.add(listPathVideofile.get(index));
                        }
                    }
                }
                // grab the list of valid videos and set it to the class of video list valid
                // videos
                ListValidVideos.getInstance().setVideoList(listvalidVideos);
            } catch (IOException ioException) {
                System.out.println("Error: " + ioException.getMessage());
            }
        }
        System.out.println(listvalidVideos);
    }

    public static String getpathOfTheSelectedFolder() {
        return pathOfTheSelectedFolder;
    }

}