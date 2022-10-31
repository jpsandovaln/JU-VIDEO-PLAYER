package ju.video.player.view.playlist.playlistpanel;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ExaminePanelTest {
    @Test
    public void shouldSetExaminePanel() {
        VideoListPanel videoListPanel = new VideoListPanel();
        ExaminePanel examinePanel = new ExaminePanel(videoListPanel);
        assertEquals(2, examinePanel.getComponentCount());
        assertFalse(examinePanel.isOpaque());
    }
}
