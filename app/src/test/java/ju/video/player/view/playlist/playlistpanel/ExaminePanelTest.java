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
import static org.junit.Assert.assertFalse;

/**
 * This test is responsible for test ExaminePanel class
 *
 * @author Sergio A. Lema Estevez
 * @version 1.0
 */

public class ExaminePanelTest {
    VideoListPanel videoListPanel = new VideoListPanel(null);
    ExaminePanel examinePanel = new ExaminePanel(videoListPanel);

    @Test
    public void shouldCountComponents() {
        assertEquals(2, examinePanel.getComponentCount());
    }

    @Test
    public void shouldVerifyIfOpaque() {
        assertFalse(examinePanel.isOpaque());
    }
}
