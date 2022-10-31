package ju.video.player.view.videoplayer.videoplayercomponents.controlbutton;

import static org.junit.Assert.assertEquals;

import java.awt.event.ActionListener;

import org.junit.Test;

import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtons.NextButton;

public class NextButtonTest {
    ActionListener listener;

    @Test
    public void shouldShowStopButton() {
        NextButton nextButton = new NextButton(listener);
        assertEquals(30, nextButton.getWidth());
        assertEquals(30, nextButton.getHeight());
    }
}
