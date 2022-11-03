/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jala University
 */
package ju.video.player.model;

import java.io.IOException;

import ju.video.player.commons.exceptions.AudioRequestException;
import ju.video.player.commons.exceptions.RequestException;
import ju.video.player.commons.exceptions.VideoRequestException;
import ju.video.player.model.request.Request;
import ju.video.player.model.request.VerifyRequest;
/**
 * It is responsible for managing the request to the converter service depending on the type of file to be converted.
 *
 * @author Alvaro Sivila Ramirez
 * @version 1.0
 */
public class ConvertFile {
    private String path;
    private String format;
    private  Request request;
    /**
     * It is responsible for calling the convert method and receiving the necessary data for the conversion.
     * @param path Is the address of the file to be converted
     * @param format This is the format to which the file is to be converted.
     * @throws IOException
     */
    public ConvertFile(String path, String format) throws RequestException {
        this.path = path;
        this.format = format;
        convert();
    }
    /**
     * Is responsible for verifying the type of request needed for the conversion and executing the request.
     * @throws RequestException
     */
    private void convert() throws RequestException {
        try {
            VerifyRequest verifyRequest = new VerifyRequest(format);
            request = verifyRequest.getRequest();
            request.sendPost(path, format);
        } catch (AudioRequestException | VideoRequestException e) {
            throw new RequestException(e);
        }
    }

    /**
     * It is responsible for returning the path of the converted file.
     * @return A string with the path address of the converted file is returned.
     */
    public String getOutputPath() {
        return request.getOutputPath();
    }
}
