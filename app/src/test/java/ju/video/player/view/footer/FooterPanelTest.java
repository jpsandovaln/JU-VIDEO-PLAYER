package ju.video.player.view.footer;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FooterPanelTest {
    @Test
    public void shouldSetFooterPanel() {
        FooterPanel footerPanel = new FooterPanel();
        assertEquals(1, footerPanel.getComponentCount());
    }
}