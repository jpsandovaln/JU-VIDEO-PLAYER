package ju.video.player.view.information.search;

import org.junit.Test;

import ju.video.player.view.playlist.playlistpanel.VideoListPanel;

import static org.junit.Assert.assertEquals;

public class SearchVideoPanelTest {
    VideoListPanel videoListPanel = new VideoListPanel();

    @Test
    public void SetSearchVideoPanel() {
        SearchVideoPanel searchVideoPanel = new SearchVideoPanel(videoListPanel);
        assertEquals(3, searchVideoPanel.getComponentCount());
    }
}
