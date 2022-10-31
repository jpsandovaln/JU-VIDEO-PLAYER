package ju.video.player.view.information.search;

import org.junit.Test;

import ju.video.player.view.playlist.playlistpanel.VideoListPanel;

import static org.junit.Assert.assertEquals;

public class FolderPanelTest {
    @Test
    public void shouldSetFolderPanel() {
        VideoListPanel videoListPanel = new VideoListPanel();
        FolderPanel folderPanel = new FolderPanel(videoListPanel);
        assertEquals(1, folderPanel.getComponentCount());
    }
}
