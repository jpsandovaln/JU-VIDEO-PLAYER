/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */

/**
 * This test is responsible for test DataComponentsPanel class
 *
 * @author Sergio A. Lema Estevez
 * @version 1.0
 */

package ju.video.player.view.playlist.filterspanel;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.text.ParseException;

public class DataComponentsPanelTest {
    String test = "test";
    DateInitListener dateInitListener = new DateInitListener();

    @Test
    public void initDateComponentsPanelTest() throws ParseException {
        DateComponentsPanel dateComponentsPanel = new DateComponentsPanel(test, dateInitListener);
        assertEquals(3, dateComponentsPanel.getComponentCount());
        assertEquals(200, dateComponentsPanel.getWidth());
        assertEquals(500, dateComponentsPanel.getHeight());
        assertEquals(0, dateComponentsPanel.getX());
        assertEquals(0, dateComponentsPanel.getY());
        assertFalse(dateComponentsPanel.isOpaque());

    }
}