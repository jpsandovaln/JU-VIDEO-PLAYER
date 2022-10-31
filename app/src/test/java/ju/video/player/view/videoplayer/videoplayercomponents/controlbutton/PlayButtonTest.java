package ju.video.player.view.videoplayer.videoplayercomponents.controlbutton;

import static org.junit.Assert.assertEquals;

import java.awt.event.ActionListener;

import org.junit.Test;

import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtons.PlayButton;

public class PlayButtonTest {
    ActionListener listener;

    @Test
    public void shouldShowStopButton() {
        PlayButton playButton = new PlayButton(listener);
        assertEquals(30, playButton.getWidth());
        assertEquals(30, playButton.getHeight());
    }
}