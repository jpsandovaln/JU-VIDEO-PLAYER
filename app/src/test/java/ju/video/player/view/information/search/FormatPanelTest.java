/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */
package ju.video.player.view.information.search;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This test is responsible for test FormatPanel class
 *
 * @author Sergio A. Lema Estevez
 * @version 1.0
 */

public class FormatPanelTest {
    @Test
    public void shouldSetFormatPanel() {
        FormatPanel formatPanel = new FormatPanel();
        assertEquals(2, formatPanel.getComponentCount());
    }
}
