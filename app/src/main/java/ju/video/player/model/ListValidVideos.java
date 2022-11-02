/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */

package ju.video.player.model;

import ju.video.player.commons.FilterFiles;
import ju.video.player.commons.exceptions.FilterFilesException;
import ju.video.player.view.playlist.playlistpanel.VideoListPanel;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ListValidVideos {
    private static ListValidVideos instance;
    private List<String> videoList;
    private double minFileSize = 0;
    private double maxFileSize = 0;
    private String pathOfTheSelectedFolder;
    private VideoListPanel playListPanel;
    private LocalDate initDate;
    private LocalDate endDate;

    private String formatSelected;

    private ListValidVideos() {
        this.videoList = new ArrayList<>();
    }

    public static ListValidVideos getInstance() {
        if (instance == null) {
            instance = new ListValidVideos();
        }
        return instance;
    }

    /**
     * Set the list of files filtered to the Panel.
     * @throws FilterFilesException
     */
    public void applyFilters() throws FilterFilesException {
        FilterFiles filterFiles = new FilterFiles(pathOfTheSelectedFolder, minFileSize, maxFileSize, initDate, endDate, formatSelected);
        if(pathOfTheSelectedFolder == null || !(new File(pathOfTheSelectedFolder)).exists()) {
            JOptionPane.showMessageDialog(null, "Playlist empty");
            return;
        }
        videoList = filterFiles.getListFiles();
        playListPanel.setPlayerLabel();
    }

    public void setFormatSelected(String formatSelected) {
        this.formatSelected = formatSelected;
    }

    public List<String> getVideoList() {
        return this.videoList;
    }

    public void setMinFileSize(double minFileSize) {
        this.minFileSize = minFileSize;
    }

    public double getMinFileSize() {
        return minFileSize;
    }

    public void setMaxFileSize(double maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public double getMaxFileSize() {
        return maxFileSize;
    }

    public void setPathOfTheSelectedFolder(String pathOfTheSelectedFolder) {
        this.pathOfTheSelectedFolder = pathOfTheSelectedFolder;
    }

    public String getPathOfTheSelectedFolder() {
        return pathOfTheSelectedFolder;
    }

    public void setPlayListPanel(VideoListPanel playListPanel) {
        this.playListPanel = playListPanel;
    }

    public void setInitDate(LocalDate initDate) {
        this.initDate = initDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}