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
import org.mockito.InjectMocks;
import org.mockito.Mock;

import ju.video.player.view.playlist.PlayListFrame;

import static org.junit.Assert.assertEquals;

import java.io.File;

/**
 * This test is responsible for test MediaPanel class
 *
 * @author Sergio A. Lema Estevez
 * @version 1.0
 */

public class MediaPanelTest {

    File mediaName = new File("", "");
    int index = 2;
    PlayListFrame playListFrame = new PlayListFrame();
    MediaPanel mediaPanel = new MediaPanel(mediaName, index, playListFrame);

    @Test
    public void shouldCountComponents() {
        assertEquals(7, mediaPanel.getComponentCount());
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
