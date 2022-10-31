package ju.video.player.view.playlist.filterspanel;

/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */
import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Test;

/**
 * This test is responsible for test FiltersPanel class
 *
 * @author Sergio A. Lema Estevez
 * @version 1.0
 */

public class FiltersPanelTest {

    @Test
    public void ShouldShowTheFilstersPanel() throws ParseException {
        FiltersPanel filstersPanel = new FiltersPanel();
        assertEquals(250, filstersPanel.getWidth());
        assertEquals(600, filstersPanel.getHeight());
        assertEquals(filstersPanel, filstersPanel);
        assertEquals(16, filstersPanel.getComponentCount());
    }

}
