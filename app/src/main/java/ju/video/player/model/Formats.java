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
    VIDEO_WEBM("video/webm"),
    AUDIO_ACC("audio/aac"),
    AUDIO_FLAC("audio/x-flac"),
    IMAGE_JPEG("image/jpeg"),
    IMAGE_PNG("image/png"),
    IMAGE_GIF("image/gif"),
    AUDIO_AIFF("audio/aiff"),
    AUDIO_3GP2("audio/3gpp2"),
    AUDIO_MIDI("audio/midi"),
    AUDIO_MPEG("audio/mpeg"),
    AUDIO_OGG("audio/ogg"),
    AUDIO_WAV("audio/wav"),
    AUDIO_WEBM("audio/webm"),
    AUDIO_VND("audio/vnd.dlna.adts"),
    AUDIO_MKG("audio/x-matroska");

    private String format;

    private Formats(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }

    /**
     * Verify whether the string belongs to the format defined in the enum.
     *
     * @param formatt
     * @return
     */
    public static Formats fromString(String formatt) {
        for (Formats format : Formats.values()) {
            if (format.format.equalsIgnoreCase(formatt)) {
                return format;
            }
        }
        return null;
    }
}

