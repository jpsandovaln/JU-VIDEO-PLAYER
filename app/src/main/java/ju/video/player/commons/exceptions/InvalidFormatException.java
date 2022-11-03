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
 * Throws this Exception if the format is null or empty
 *
 * @author Alvaro Sivila Ramirez
 * @version 1.0
 */
public class InvalidFormatException extends RequestException {
    public InvalidFormatException(String currentMessage) {
        super(currentMessage);
    }
    public InvalidFormatException(String currentMessage, Throwable ex) {
        super(currentMessage, ex);
    }
    public InvalidFormatException(Throwable ex) {
        super(ex);
    }
}
