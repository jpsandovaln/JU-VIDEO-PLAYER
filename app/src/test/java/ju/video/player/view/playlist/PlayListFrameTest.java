/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */
package ju.video.player.view.playlist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;

import org.junit.Test;

/**
 * This test is responsible for test PlayListFrame class
 *
 * @author Sergio A. Lema Estevez
 * @version 1.0
 */

public class PlayListFrameTest {
    @Test
    public void shouldShowPlayListFrame() throws ParseException {
        PlayListFrame playListFrame = new PlayListFrame();
        assertEquals(850, playListFrame.getFrame().getWidth());
        assertEquals(600, playListFrame.getFrame().getHeight());
        assertEquals(1, playListFrame.getFrame().getComponentCount());
        assertTrue(playListFrame.getFrame().isVisible());
    }
}
