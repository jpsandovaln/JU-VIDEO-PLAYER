/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */

package ju.video.player.model;

import ju.video.player.view.commons.ComboBox;
import ju.video.player.view.commons.TextField;
import ju.video.player.view.playlist.filterspanel.DateComponentsPanel;
import ju.video.player.view.playlist.filterspanel.FiltersPanel;
import ju.video.player.view.playlist.filterspanel.SizeFilterPanel;
import ju.video.player.view.playlist.filterspanel.DateFilterPanel;
import ju.video.player.commons.exceptions.FilterFilesException;
import ju.video.player.view.playlist.playlistpanel.VideoListPanel;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class ListValidVideos {
    private static ListValidVideos instance;
    private List<File> videoList;
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
     * @throws FilterFilesException if there is a problem with the filters
     */
    public void applyFilters() {
        FilterFiles filterFiles = new FilterFiles(minFileSize, maxFileSize, initDate, endDate, formatSelected);
        try {
            videoList = filterFiles.getListFiles();
            playListPanel.setPlayerLabel();
        } catch (FilterFilesException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFormatSelected(String formatSelected) {
        this.formatSelected = formatSelected;
    }

    public List<File> getVideoList() {
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

    public void restoreFilters(FiltersPanel filtersPanel) {
        ((TextField) ((SizeFilterPanel) filtersPanel.getComponent(7)).getComponent(1)).setText("");
        ((TextField) ((SizeFilterPanel) filtersPanel.getComponent(7)).getComponent(2)).setText("");
        minFileSize = 0;
        maxFileSize = 0;
        ((TextField) ((DateComponentsPanel) ((DateFilterPanel) filtersPanel.getComponent(11)).getComponent(0)).getComponent(0)).setText("");
        ((TextField) ((DateComponentsPanel) ((DateFilterPanel) filtersPanel.getComponent(11)).getComponent(2)).getComponent(0)).setText("");
        initDate = null;
        endDate = null;
        ((ComboBox) ((JPanel) filtersPanel.getComponent(15)).getComponent(0)).setSelectedItem("All formats");
        formatSelected = null;
        applyFilters();
    }
}