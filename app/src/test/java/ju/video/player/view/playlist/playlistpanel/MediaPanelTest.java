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
    String mediaName = "test";
    int index = 2;
    MediaPanel mediaPanel = new MediaPanel(mediaName, index, null);

    @Test
    public void shouldCountComponents() {
        assertEquals(5, mediaPanel.getComponentCount());
    }

    @Test
    public void shouldVerifyWidth() {
        assertEquals(700, mediaPanel.getWidth());
    }

    @Test
    public void shouldVerifyHeight() {
        assertEquals(600, mediaPanel.getHeight());
    }
}
