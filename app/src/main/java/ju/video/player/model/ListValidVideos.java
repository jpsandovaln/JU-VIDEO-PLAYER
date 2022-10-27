package ju.video.player.model;

import ju.video.player.controller.FilterFiles;
import ju.video.player.view.playlist.playlistpanel.VideoListPanel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListValidVideos {
    private static ListValidVideos instance;
    private List<String> videoList;
    private double minFileSize = 0;
    private double maxFileSize = 0;
    private String pathOfTheSelectedFolder;
    private VideoListPanel playListPanel;

    private ListValidVideos() {
        this.videoList = new ArrayList<>();
    }
    public static ListValidVideos getInstance(){
        if(instance == null) {
            instance = new ListValidVideos();
        }
        return instance;
    }//ListValidVideos.getInstance().getVideoList()
    public List<String> getVideoList(){
        return this.videoList;
    }

    public void applyFilters() {
        FilterFiles filterFiles = new FilterFiles(pathOfTheSelectedFolder, minFileSize, maxFileSize, null, null);
        try {
            videoList = filterFiles.getListFiles();
            System.out.println("Files:" + videoList);
            playListPanel.setPlayerLabel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    public void setPlayListPanel(VideoListPanel playListPanel) {
        this.playListPanel = playListPanel;
    }
}