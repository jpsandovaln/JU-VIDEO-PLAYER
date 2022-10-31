package ju.video.player.view;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SplashTest {
    @Test
    public void shouldInitSplashFrame() {
        Splash splash = new Splash();
        assertEquals(850, splash.getFrame().getWidth());
        assertEquals(600, splash.getFrame().getHeight());
        assertEquals(1, splash.getFrame().getComponentCount());
    }
}
