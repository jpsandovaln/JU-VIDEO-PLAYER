/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */
package ju.video.player.view.videoconvert;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This test is responsible for test VideoConvertFrame class
 *
 * @author Sergio A. Lema Estevez
 * @version 1.0
 */

public class VideoConvertFrameTest {
    String path = "test";
    VideoConvertFrame videoConvertFrame = new VideoConvertFrame(path, null);

    @Test
    public void shouldVerifyPositionX() {
        assertEquals(0, videoConvertFrame.getX());
    }

    @Test
    public void shouldVerifyPositionY() {
        assertEquals(0, videoConvertFrame.getY());
    }

    @Test
    public void shouldCountComponents() {
        assertEquals(1, videoConvertFrame.getComponentCount());
    }
}
