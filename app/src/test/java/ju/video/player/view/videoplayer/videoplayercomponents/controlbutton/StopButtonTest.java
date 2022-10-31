package ju.video.player.view.videoplayer.videoplayercomponents.controlbutton;

import static org.junit.Assert.assertEquals;

import java.awt.event.ActionListener;

import org.junit.Test;

import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtons.StopButton;

public class StopButtonTest {
    ActionListener listener;

    @Test
    public void shouldShowStopButton() {
        StopButton stopButton = new StopButton(listener);
        assertEquals(30, stopButton.getWidth());
        assertEquals(30, stopButton.getHeight());
    }
}
