/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.model;

import java.io.IOException;
/**
 * Responsible for organizing the types of requests for the different types of conversions.
 *
 * @author Alvaro Sivila Ramirez
 * @version 1.0
 */
public interface Request {
    public void sendPost(String path, String format) throws IOException;
}
