package ju.video.player.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import ju.video.player.model.ListValidVideos;
import ju.video.player.view.playlist.playlistpanel.VideoListPanel;

public class Mp4ButtonController implements ActionListener {
    public static String ruta;
    VideoListPanel panelSouth;
    public static ArrayList<String> listFilesmp4;

    public Mp4ButtonController(VideoListPanel panelSouth) {
        this.panelSouth = panelSouth;
        listFilesmp4 = new ArrayList();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int index = 0; index < ListValidVideos.getInstance().getVideoList().size(); index++) {
            //if (ListValidVideos.getInstance().getVideoList().get(index).contains(".mp4")) {
                //listFilesmp4.add(ListValidVideos.getInstance().getVideoList().get(index));
            //}
        }
        System.out.println(" archivo mp4 : " + listFilesmp4);
        //panelSouth.setPlayerLabel(listFilesmp4);
    }

}
