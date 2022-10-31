/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */
package ju.video.player.view;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This test is responsible for test Splash class
 *
 * @author Sergio A. Lema Estevez
 * @version 1.0
 */
public class SplashTest {
    @Test
    public void shouldInitSplashFrame() {
        Splash splash = new Splash();
        assertEquals(850, splash.getFrame().getWidth());
        assertEquals(600, splash.getFrame().getHeight());
        assertEquals(1, splash.getFrame().getComponentCount());
    }
}
