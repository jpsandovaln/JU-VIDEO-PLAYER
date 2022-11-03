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
 * Throws this Exception if there is a problem with the audio or video request.
 *
 * @author Alvaro Sivila Ramirez
 * @version 1.0
 */
public class RequestException extends Exception {
    public RequestException(String currentMessage) {
        super(currentMessage);
    }
    public RequestException(String currentMessage, Throwable ex) {
        super(currentMessage, ex);
    }
    public RequestException(Throwable ex) {
        super(ex);
    }
}
