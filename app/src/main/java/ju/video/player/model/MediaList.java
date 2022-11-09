/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 * It is the original list of files that the user is gonna add before apply the filters.
 *
 * @author Adriana Olivera Ordoñez
 * @version 1.0
 */
public class MediaList {
    private static MediaList instance;
    private List<File> mediaList;

    private MediaList() {
        this.mediaList = new ArrayList<>();
    }

    /**
     * @return media list instance
     */
    public static MediaList getInstance() {
        if (instance == null) {
            instance = new MediaList();
        }
        return instance;
    }

    /**
     * If the path is valid, make the list of files from the selected folder
     * 
     * @param pathOfTheSelectedFolder
     */
    public void addFilesFromFolder(String pathOfTheSelectedFolder) {
        if(pathOfTheSelectedFolder == null || !(new File(pathOfTheSelectedFolder)).exists()) {
            JOptionPane.showMessageDialog(null, "Playlist empty");
            return;
        }
        try {
            makeList(pathOfTheSelectedFolder);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Add elements to the mediaList
     * 
     * @param filesFolder
     * @throws IOException
     */
    public void makeList(String filesFolder) throws IOException {
        File paths = new File(filesFolder);
        String[] nameFiles = paths.list();
        for (String fileName : nameFiles) {
            File file = new File(filesFolder, fileName);
            if (!file.isDirectory() && verifyIsMediaFile(file) && verifyThereIsNotInList(file)) {
                mediaList.add(file);
            }
        }
    }
    
    /**
     * Verify if the file is not already in the mediaList
     * @param file input file
     * @return true/false
     */
    private boolean verifyThereIsNotInList(File file) {
        for (File fileInList : mediaList) {
            if (file.equals(fileInList)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verify if the file have a accepted format
     * 
     * @param file
     * @return
     * @throws IOException
     */
    public boolean verifyIsMediaFile(File file) throws IOException {
        String fileContentType = Files.probeContentType(file.toPath());
        Format formats = Format.fromString(fileContentType);
        return formats != null;
    }

    /**
     * Get the List of files in mediaList
     * 
     * @return mediaList
     */
    public List<File> getMediaList() {
        return mediaList;
    }

    /**
     * Remove a element of mediaList
     * 
     * @param file
     */
    public void removeFile(File file) {
        mediaList.remove(file);
    }
}
