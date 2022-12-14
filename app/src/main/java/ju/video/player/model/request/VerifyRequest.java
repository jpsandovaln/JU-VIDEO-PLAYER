/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jala University
 */
package ju.video.player.model.request;
import ju.video.player.commons.exceptions.InvalidFormatException;
import ju.video.player.commons.exceptions.RequestException;

import java.util.ArrayList;
/**
 * Responsible for Verifying the type of request necessary for the consumption of the converter service.
 *
 * @author Alvaro Sivila Ramirez
 * @version 1.0
 */
public class VerifyRequest {
    ArrayList<String> audioFormats = new ArrayList<>();
    ArrayList<String> videoFormats = new ArrayList<>();
    private String format;

    /**
     * It is responsible for adding the supported formats for audio and video conversion.
     * @param format It is the format for conversion
     */
    public VerifyRequest(String format) {
        this.format = format;
        audioFormats.add("mp3");
        audioFormats.add("aac");
        audioFormats.add("ogg");
        audioFormats.add("flac");
        audioFormats.add("wma");
        audioFormats.add("wav");
        videoFormats.add("flv");
        videoFormats.add("mkv");
        videoFormats.add("avi");
        videoFormats.add("mov");
        videoFormats.add("mp4");
    }

    /**
     * Is responsible for verifying if the format is video or audio.
     * @return Returns the request required for the conversion type
     */
    public Request getRequest() throws RequestException {
        try {
            validateFormat();
            if (audioFormats.contains(format)) {
                return new AudioRequest();
            }
            if (videoFormats.contains(format)) {
                return new VideoRequest();
            }
            return  null;
        } catch (Exception e) {
            throw new RequestException(e);
        }

    }

    /**
     * Responsible for verifying null, empty or unsupported forms
     * @throws InvalidFormatException
     */
    private void validateFormat() throws InvalidFormatException {
        if (format == null) {
            throw new InvalidFormatException("The format is null");
        }
        if (format.equals("")) {
            throw new InvalidFormatException("The format is empty");
        }
        if (!videoFormats.contains(format) && !audioFormats.contains(format)) {
            throw new InvalidFormatException("Format not supported");
        }
    }
}


