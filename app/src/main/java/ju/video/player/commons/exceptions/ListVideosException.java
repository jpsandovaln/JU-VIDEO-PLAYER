/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and property information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.commons.exceptions;

/**
 * Throws this ListVideosException if the folder selected doesn't have files of the supported formats
 *
 * @author Rodrigo Bernal
 * @version 1.0
 */
public class ListVideosException extends Exception{

    public ListVideosException(String message) {
        super(message);
    }

    public ListVideosException(String message, Throwable ex) {
        super(message,ex);
    }
}
