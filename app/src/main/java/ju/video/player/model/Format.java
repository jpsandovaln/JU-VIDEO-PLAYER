/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */
package ju.video.player.model;

/**
 * It is a enum of all the accepted formats with its respective mime type
 *
 * @author Sarai Alvarez
 * @version 1.0
 */

public enum Format {
    VIDEO_MP4("video/mp4"),
    VIDEO_AVI("video/avi"),
    VIDEO_3GPP("video/3gpp"),
    VIDEO_3GPP2("video/3gpp2"),
    VIDEO_QUIKTIME("video/quicktime"),
    VIDEO_VND_DVB("video/vnd.dvb.file"),
    VIDEO_3gpp2("video/3gpp2"),
    VIDEO_XM4V("video/x-m4v"),
    VIDEO_MJ2("video/mj2"),
    VIDEO_XFLV("video/x-flv"),
    VIDEO_MKV("video/x-matroska"),
    VIDEO_WEBM("video/webm"),
    AUDIO_ACC("audio/aac"),
    AUDIO_FLAC("audio/x-flac"),
    AUDIO_AIFF("audio/aiff"),
    AUDIO_3GP2("audio/3gpp2"),
    AUDIO_MIDI("audio/midi"),
    AUDIO_MPEG("audio/mpeg"),
    AUDIO_OGG("audio/ogg"),
    AUDIO_WAV("audio/wav"),
    AUDIO_WEBM("audio/webm"),
    AUDIO_VND("audio/vnd.dlna.adts"),
    AUDIO_MKG("audio/x-matroska"),
    IMAGE_JPEG("image/jpeg"),
    IMAGE_PNG("image/png"),
    IMAGE_GIF("image/gif"),
    VIDEO_VARIOUS("various");
    
    private String format;
    private Format(String format) {
        this.format = format;
    }

    /**
     * @return format
     */
    public String getFormat() {
        return format;
    }

    /**
     * Verify if the parameter is equeals to some Format in the enum
     * @param formatt
     * @return formatl
     */
    public static Format fromString(String formatt) {
        for (Format format : Format.values()) {
            if (format.format.equalsIgnoreCase(formatt)) {
                return format;
            }
        }
        return null;
    }
}

