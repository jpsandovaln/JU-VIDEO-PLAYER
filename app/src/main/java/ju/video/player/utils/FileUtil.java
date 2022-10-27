package ju.video.player.utils;

import java.nio.file.attribute.BasicFileAttributes;

/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */
public class FileUtil {

    public static double convertKBToMB(long fileSizeInBytes) {
        double fileSizeInKB = fileSizeInBytes / 1024;
        double fileSizeInMB = fileSizeInKB / 1024;
        return fileSizeInMB;
    }
}
