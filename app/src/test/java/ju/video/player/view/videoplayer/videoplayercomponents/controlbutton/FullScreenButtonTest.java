package ju.video.player.view.videoplayer.videoplayercomponents.controlbutton;

import static org.junit.Assert.assertEquals;

import java.awt.event.ActionListener;

import org.junit.Test;

import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtons.FullScreenButton;

public class FullScreenButtonTest {
    ActionListener listener;

    @Test
    public void shouldShowFullScreeenButton() {
        FullScreenButton fullScreenButton = new FullScreenButton(listener);
        assertEquals(30, fullScreenButton.getWidth());
        assertEquals(30, fullScreenButton.getHeight());
    }
}