package ju.video.player.view.playlist.filterspanel;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Test;

public class FilstersPanelTest {

    @Test
    public void ShouldShowTheFilstersPanel() throws ParseException {
        FiltersPanel filstersPanel = new FiltersPanel();
        assertEquals(250, filstersPanel.getWidth());
        assertEquals(600, filstersPanel.getHeight());
        assertEquals(filstersPanel, filstersPanel);
        assertEquals(16, filstersPanel.getComponentCount());
    }

}
