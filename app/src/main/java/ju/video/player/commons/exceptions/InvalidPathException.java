/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jala University
 */
package ju.video.player.commons.exceptions;
/**
 * Throws this Exception if the path is null, empty or if the file does not exist..
 *
 * @author Alvaro Sivila Ramirez
 * @version 1.0
 */
public class InvalidPathException extends RequestException{
    public InvalidPathException(String currentMessage) {
        super(currentMessage);
    }
    public InvalidPathException(String currentMessage, Throwable ex) {
        super(currentMessage, ex);
    }
    public InvalidPathException(Throwable ex) {
        super(ex);
    }
}
