package ju.video.player.view.playlist.playlistpanel;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VideoListPanelTest {

    @Test
    public void shouldInitVideoListPanel() {
        VideoListPanel videoListPanel = new VideoListPanel();
        assertEquals(1, videoListPanel.getComponentCount());
    }

}
