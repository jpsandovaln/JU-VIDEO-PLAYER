package ju.video.player.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ju.video.player.view.playlist.playlistpanel.VideoListPanel;

public class MediaList {
    private static MediaList instance;
    private List<File> mediaList;
    private VideoListPanel playListPanel;

    private MediaList() {
        this.mediaList = new ArrayList<>();
    }

    public static MediaList getInstance() {
        if (instance == null) {
            instance = new MediaList();
        }
        return instance;
    }

    public void addFilesFromFolder(String pathOfTheSelectedFolder) {
        if(pathOfTheSelectedFolder == null || !(new File(pathOfTheSelectedFolder)).exists()) {
            JOptionPane.showMessageDialog(null, "Playlist empty");
            return;
        }
        try {
            makeList(pathOfTheSelectedFolder);
            //playListPanel.setPlayerLabel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void makeList(String filesFolder) throws IOException {
        File paths = new File(filesFolder);
        String[] nameFiles = paths.list();
        //List<File> listFiles = new ArrayList<>();
        for (String fileName : nameFiles) {
            File file = new File(filesFolder, fileName);
            if (!file.isDirectory() && verifyIsMediaFile(file)) {
                mediaList.add(file);
            }
        }
    }
    
    public boolean verifyIsMediaFile(File file) throws IOException {
        String fileContentType = Files.probeContentType(file.toPath());
        Format formats = Format.fromString(fileContentType);
        return formats != null;
    }

    public void setPlayListPanel(VideoListPanel playListPanel) {
        this.playListPanel = playListPanel;
    }

    public List<File> getMediaList() {
        return mediaList;
    }
}
