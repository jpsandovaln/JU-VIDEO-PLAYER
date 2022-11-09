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
    PlayListPanel playListPanel = new PlayListPanel(null);

    @Test
    public void shouldCountComponents() {
        assertEquals(6, playListPanel.getComponentCount());
    }

    @Test
    public void shouldVerifyWidth() {
        assertEquals(545, playListPanel.getWidth());
    }

    @Test
    public void shouldVerifyHeight() {
        assertEquals(550, playListPanel.getHeight());
    }
}
