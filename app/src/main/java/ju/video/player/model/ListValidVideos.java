package ju.video.player.model;

import java.util.ArrayList;

public class ListValidVideos {
    private static ListValidVideos instance;
    private ArrayList<String> videoList;
    private ListValidVideos() {
        this.videoList = new ArrayList<>();
    }
    public static ListValidVideos getInstance(){
        if(instance == null) {
            instance = new ListValidVideos();
        }
        return instance;
    }//ListValidVideos.getInstance().getVideoList()
    public ArrayList<String> getVideoList(){
        return this.videoList;
    }
    public void setVideoList(ArrayList<String> videolList){ //agarra una nueva lista de videos y lo cambia a la lista anterios
        this.videoList = videolList;
    }

    
}