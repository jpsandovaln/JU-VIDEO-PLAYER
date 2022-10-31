package ju.video.player.view.videoplayer.videoplayercomponents.controlbutton;

import static org.junit.Assert.assertEquals;

import java.awt.event.ActionListener;

import org.junit.Test;

import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtons.PreviousButton;

public class PreviousButtonTest {
    ActionListener listener;

    @Test
    public void shouldShowStopButton() {
        PreviousButton previousButton = new PreviousButton(listener);
        assertEquals(30, previousButton.getWidth());
        assertEquals(30, previousButton.getHeight());
    }
}
