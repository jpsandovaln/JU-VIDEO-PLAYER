package ju.video.player.view.playlist.playlistpanel;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MediaPanelTest {
    @Test
    public void shouldSetMediaPanel() {
        String mediaName = "test";
        int index = 2;
        MediaPanel mediaPanel = new MediaPanel(mediaName, index);
        assertEquals(5, mediaPanel.getComponentCount());
        assertEquals(0, mediaPanel.getWidth());
        assertEquals(0, mediaPanel.getHeight());
    }
}
