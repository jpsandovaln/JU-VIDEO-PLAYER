/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */
package ju.video.player.view.videoplayer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;

/**
 * This test is responsible for test VideoPanelPlayer class
 *
 * @author Sergio A. Lema Estevez
 * @version 1.0
 */

public class VideoPanelPlayerTest {
    EmbeddedMediaListPlayerComponent embeddedMediaListPlayerComponent = new EmbeddedMediaListPlayerComponent();
    MediaPlayerFrame mediaPlayerFrame = new MediaPlayerFrame(null, embeddedMediaListPlayerComponent);

    @Test
    public void shouldCountComponents() {
        assertEquals(1, mediaPlayerFrame.getComponentCount());
    }

    @Test
    public void shouldVerifyIfVisible() {
        assertTrue(mediaPlayerFrame.isVisible());
    }
}
