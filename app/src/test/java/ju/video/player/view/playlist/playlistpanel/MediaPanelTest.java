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
 * This test is responsible for test MediaPanel class
 *
 * @author Sergio A. Lema Estevez
 * @version 1.0
 */

public class MediaPanelTest {
    @Test
    public void shouldSetMediaPanel() {
        String mediaName = "test";
        int index = 2;
        MediaPanel mediaPanel = new MediaPanel(mediaName, index);
        assertEquals(5, mediaPanel.getComponentCount());
        assertEquals(0, mediaPanel.getWidth());
        assertEquals(0, mediaPanel.getHeight());
    }
}
