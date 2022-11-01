/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */
package ju.video.player.view.playlist.playlistpanel;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * This test is responsible for test PlayListPanel class
 *
 * @author Sergio A. Lema Estevez
 * @version 1.0
 */

public class PlayListPanelTest {
    @Test
    public void shouldSetPlayListPanel() {
        PlayListPanel playListPanel = new PlayListPanel(null);
        assertEquals(4, playListPanel.getComponentCount());
        assertEquals(585, playListPanel.getWidth());
        assertEquals(600, playListPanel.getHeight());
    }
}
