package ju.video.player.view.playlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.Test;

public class PlayListFrameTest {
    @Test
    public void shouldShowPlayListFrame() throws ParseException {
        PlayListFrame playListFrame = new PlayListFrame();
        assertEquals(850, playListFrame.frame.getWidth());
        assertEquals(600, playListFrame.frame.getHeight());
        assertEquals(1, playListFrame.frame.getComponentCount());
        assertTrue(playListFrame.frame.isVisible());
    }
}
