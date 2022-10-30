package ju.video.player.view.playlist.filterspanel;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.text.ParseException;

public class DataComponentsPanelTest {
    String test = "test";
    DateInitListener dateInitListener = new DateInitListener();

    @Test
    public void initDateComponentsPanelTest() throws ParseException {
        DateComponentsPanel dateComponentsPanel = new DateComponentsPanel(test, dateInitListener);
        assertEquals(3, dateComponentsPanel.getComponentCount());
        assertEquals(200, dateComponentsPanel.getWidth());
        assertEquals(500, dateComponentsPanel.getHeight());
        assertEquals(0, dateComponentsPanel.getX());
        assertEquals(0, dateComponentsPanel.getY());
        assertFalse(dateComponentsPanel.isOpaque());

    }
}