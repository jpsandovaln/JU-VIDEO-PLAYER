package ju.video.player.view.playlist.filterspanel;

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

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.text.ParseException;

public class DataComponentsPanelTest {
    String test = "test";
    DateInitListener dateInitListener = new DateInitListener();

    @Test
    public void initCountComponents() throws ParseException {
        DateComponentsPanel dateComponentsPanel = new DateComponentsPanel(test, dateInitListener);
        assertEquals(2, dateComponentsPanel.getComponentCount());
    }

    @Test
    public void initVerifyWidth() throws ParseException {
        DateComponentsPanel dateComponentsPanel = new DateComponentsPanel(test, dateInitListener);
        assertEquals(180, dateComponentsPanel.getWidth());
    }

    @Test
    public void initVerifyHeight() throws ParseException {
        DateComponentsPanel dateComponentsPanel = new DateComponentsPanel(test, dateInitListener);
        assertEquals(100, dateComponentsPanel.getHeight());
    }

    @Test
    public void initVerifyPositionX() throws ParseException {
        DateComponentsPanel dateComponentsPanel = new DateComponentsPanel(test, dateInitListener);
        assertEquals(0, dateComponentsPanel.getX());
    }

    @Test
    public void initVerifyPositionY() throws ParseException {
        DateComponentsPanel dateComponentsPanel = new DateComponentsPanel(test, dateInitListener);
        assertEquals(0, dateComponentsPanel.getY());
    }

    @Test
    public void initVerifyIfOpaque() throws ParseException {
        DateComponentsPanel dateComponentsPanel = new DateComponentsPanel(test, dateInitListener);
        assertFalse(dateComponentsPanel.isOpaque());
    }
}