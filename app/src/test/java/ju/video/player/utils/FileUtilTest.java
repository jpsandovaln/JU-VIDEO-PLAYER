/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */

package ju.video.player.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

/**
 * This test is responsible for test Splash class
 *
 * @author Sergio A. Lema Estevez
 * @version 1.0
 */

public class FileUtilTest {
    @Test
    public void shouldConvertKBToMB() {
        double fileSizeKB = 5242880 / 1024;
        double fileSizeMB = fileSizeKB / 1024;
        assertEquals(fileSizeMB, FileUtil.convertKBToMB(5242880), 0);
    }

    @Test
    public void shouldntConvertKBToMB() {
        double fileSizeKB = 5242880 / 1024;
        double fileSizeMB = fileSizeKB / 1024;
        assertNotEquals(fileSizeMB, FileUtil.convertKBToMB(5542885), 0);

    }
}
