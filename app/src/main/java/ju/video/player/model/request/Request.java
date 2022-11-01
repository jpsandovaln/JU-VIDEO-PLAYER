/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jala University
 */
package ju.video.player.model.request;

import java.io.IOException;
/**
 * Responsible for organizing the types of requests for the different types of conversions.
 *
 * @author Alvaro Sivila Ramirez
 * @version 1.0
 */
public interface Request {
    void sendPost(String path, String format) throws IOException;
}
