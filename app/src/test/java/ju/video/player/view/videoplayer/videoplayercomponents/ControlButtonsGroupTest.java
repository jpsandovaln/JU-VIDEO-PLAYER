package ju.video.player.view.videoplayer.videoplayercomponents;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ju.video.player.view.videoplayer.MediaPlayerFrame;
import ju.video.player.view.videoplayer.VideoPlayerPanel;
import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtonsGroup;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;

public class ControlButtonsGroupTest {

    @Test
    public void shouldInitControlButtonsGroup() {
        EmbeddedMediaListPlayerComponent embeddedMediaListPlayerComponent = new EmbeddedMediaListPlayerComponent();
        MediaPlayerFrame mediaPlayerFrame = new MediaPlayerFrame(null, embeddedMediaListPlayerComponent);
        VideoPlayerPanel videoPlayerPanel = new VideoPlayerPanel(mediaPlayerFrame);
        ControlButtonsGroup controlButtonsGroup = new ControlButtonsGroup(videoPlayerPanel);
        assertEquals(6, controlButtonsGroup.getComponentCount());
    }

}
