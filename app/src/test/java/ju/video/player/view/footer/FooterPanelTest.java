/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */
package ju.video.player.view.footer;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * This test is responsible for test FooterPanel class
 *
 * @author Sergio A. Lema Estevez
 * @version 1.0
 */

public class FooterPanelTest {
    @Test
    public void shouldSetFooterPanel() {
        FooterPanel footerPanel = new FooterPanel();
        assertEquals(1, footerPanel.getComponentCount());
    }
}