package ju.video.player.model;

import java.io.File;
import java.util.ArrayList;

public class ListValidVideos {
    private static ListValidVideos instance;
    private ArrayList<File> videoList;

    private ListValidVideos() {
        this.videoList = new ArrayList<>();
    }

    public static ListValidVideos getInstance(){
        if(instance == null) {
            instance = new ListValidVideos();
        }
        return instance;
    }

    public ArrayList<File> getVideoList(){
        return this.videoList;
    }

    public void setVideoList(ArrayList<File> videoList) {
        this.videoList = videoList;
    }

    public void addMedia(File elemet) {
        videoList.add(elemet);
    }

    public void removeMedia(String elemet) {
        videoList.remove(elemet);
    }
}