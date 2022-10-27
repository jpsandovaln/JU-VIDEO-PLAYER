package ju.video.player.model;

public enum Formats {

    VIDEO_3GPP("video/3gpp"),
    VIDEO_3GPP2("video/3gpp2"),
    VIDEO_QUIKTIME ("video/quicktime"),
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
    AUDIO_MP3("audio/mpeg"),
    AUDIO_FLAC("audio/x-flac"),
    IMAGE_JPEG("image/jpeg");

    private String formato;
    private Formats(String formato) {
        this.formato = formato;

    }
    public String getFormato() {
        return formato;
    }
    
    public static Formats fromString(String formato) {
        for (Formats  b : Formats.values()) {
            if (b.formato.equalsIgnoreCase(formato)) {
                return b;
            }
        }
        return null;
    }




}

