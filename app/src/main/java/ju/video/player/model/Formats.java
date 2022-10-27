package ju.video.player.model;

/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */
public enum Formats {
    VIDEO_3GPP("video/3gpp"),
    VIDEO_3GPP2("video/3gpp2"),
    VIDEO_QUIKTIME("video/quicktime"),
    VIDEO_MP4("video/mp4"),//video/mp4
    VIDEO_VARIOUS("various"),
    VIDEO_VND_DVB("video/vnd.dvb.file"),
    VIDEO_3gpp2("video/3gpp2"),
    VIDEO_XM4V("video/x-m4v"),
    VIDEO_MJ2("video/mj2"),
    VIDEO_AVI("video/avi"),
    VIDEO_XFLV("video/x-flv"),
    VIDEO_MKV("video/x-matroska"),
    AUDIO_ACC("audio/aac"),
    AUDIO_ADTS("audio/vnd.dlna.adts"),
    AUDIO_MP3("audio/mpeg"),
    VIDEO_WEBM("video/webm");

    private String format;

    private Formats(String formatt) {
        this.format = formatt;
    }

    public String getFormat() {
        return format;
    }

    public static Formats fromString(String formatt) {
        for (Formats format : Formats.values()) {
            if (format.format.equalsIgnoreCase(formatt)) {
                return format;
            }
        }
        return null;
    }
}

