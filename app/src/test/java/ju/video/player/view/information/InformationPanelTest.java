package ju.video.player.view.information;

import org.junit.Test;

import ju.video.player.view.playlist.playlistpanel.VideoListPanel;

import static org.junit.Assert.assertEquals;

public class InformationPanelTest {
    @Test
    public void shouldInitInformationPanel() {
        VideoListPanel videoListPanel = new VideoListPanel();
        InformationPanel informationPanel = new InformationPanel(videoListPanel);
        assertEquals(1, informationPanel.getComponentCount());
    }
}
