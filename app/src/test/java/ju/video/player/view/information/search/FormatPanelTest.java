package ju.video.player.view.information.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FormatPanelTest {
    @Test
    public void shouldSetFormatPanel() {
        FormatPanel formatPanel = new FormatPanel();
        assertEquals(2, formatPanel.getComponentCount());
    }
}
