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
 * Throws this ContentFileException if the content type of the file is not valid
 *
 * @author Rodrigo Bernal
 * @version 1.0
 */
public class ContentFileException extends Exception {

    public ContentFileException(String message) {
        super(message);
    }

    public ContentFileException(String message, Throwable ex) {
        super(message,ex);
    }
}
