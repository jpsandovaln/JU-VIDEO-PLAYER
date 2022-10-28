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
 * It is responsible for managing the request to the converter service depending on the type of file to be converted.
 *
 * @author Alvaro Sivila Ramirez
 * @version 1.0
 */
public class ConvertFile {
    private String path;
    private String format;

    /**
     * @param path
     * @param format
     * @throws IOException
     */
    public ConvertFile(String path, String format) throws IOException {
        this.path = path;
        this.format = format;
        convert();
    }

    /**
     * @throws IOException
     */
    private void convert() throws IOException {
        VerifyRequest verifyRequest = new VerifyRequest(format);
        Request request = verifyRequest.getRequest();
        request.sendPost(path, format);

    }

}
