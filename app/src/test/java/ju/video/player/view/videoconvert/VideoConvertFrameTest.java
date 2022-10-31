package ju.video.player.view.videoconvert;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class VideoConvertFrameTest {
    String path = "test";

    @Test
    public void shouldSetVideoConvertFrame() {
        VideoConvertFrame videoConvertFrame = new VideoConvertFrame(path);
        assertEquals(0, videoConvertFrame.getX());
        assertEquals(0, videoConvertFrame.getY());
        assertEquals(1, videoConvertFrame.getComponentCount());

    }
}
