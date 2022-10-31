package ju.video.player.view.videoplayer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;

public class VideoPanelPlayerTest {
    @Test
    public void shouldSetVideoPanelPlayer() {
        EmbeddedMediaListPlayerComponent embeddedMediaListPlayerComponent = new EmbeddedMediaListPlayerComponent();
        MediaPlayerFrame mediaPlayerFrame = new MediaPlayerFrame(embeddedMediaListPlayerComponent);
        VideoPlayerPanel videoPlayerPanel = new VideoPlayerPanel(mediaPlayerFrame);
        assertEquals(2, videoPlayerPanel.getComponentCount());
        assertTrue(videoPlayerPanel.isVisible());

    }
}
