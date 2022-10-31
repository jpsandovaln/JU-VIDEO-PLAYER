package ju.video.player.view.information.search;

/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */
import org.junit.Test;

import ju.video.player.view.playlist.playlistpanel.VideoListPanel;

import static org.junit.Assert.assertEquals;

/**
 * This test is responsible for test FolderPanel class
 *
 * @author Sergio A. Lema Estevez
 * @version 1.0
 */

public class FolderPanelTest {
    @Test
    public void shouldSetFolderPanel() {
        VideoListPanel videoListPanel = new VideoListPanel();
        FolderPanel folderPanel = new FolderPanel(videoListPanel);
        assertEquals(1, folderPanel.getComponentCount());
    }
}
