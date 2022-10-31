package ju.video.player.view.playlist.playlistpanel;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PlayListPanelTest {
    @Test
    public void shouldSetPlayListPanel() {
        PlayListPanel playListPanel = new PlayListPanel();
        assertEquals(4, playListPanel.getComponentCount());
        assertEquals(585, playListPanel.getWidth());
        assertEquals(600, playListPanel.getHeight());
    }
}
