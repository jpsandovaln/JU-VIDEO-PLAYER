package ju.video.player.view.videoplayer.videoplayercomponents.controlbutton;

import static org.junit.Assert.assertEquals;

import java.awt.event.ActionListener;

import org.junit.Test;

import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtons.PauseButton;

public class PauseButtonTest {
    ActionListener listener;

    @Test
    public void shouldShowStopButton() {
        PauseButton pauseButton = new PauseButton(listener);
        assertEquals(30, pauseButton.getWidth());
        assertEquals(30, pauseButton.getHeight());
    }
}