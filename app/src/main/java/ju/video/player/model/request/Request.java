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
    /**
     * It is responsible for constructing the body of the request and executing the request.
     * @param path It is the directory where the file to be converted is located.
     * @param format Is the format to which the file is to be converted.
     * @throws IOException
     */
    void sendPost(String path, String format) throws IOException;

    /**
     * It is responsible for returning the path of the converted file.
     * @return A string with the path address of the converted file is returned.
     */
    String getOutputPath();
}
