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
    AUDIO_AIFF("audio/aiff"),
    AUDIO_3GP2("audio/3gpp2"),
    AUDIO_MIDI("audio/midi"),
    AUDIO_MPEG("audio/mpeg"),
    AUDIO_OGG("audio/ogg"),
    AUDIO_WAV("audio/wav"),
    AUDIO_WEBM("audio/webm"),
    AUDIO_VND("audio/vnd.dlna.adts"),
    AUDIO_MKG("audio/x-matroska");
    
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

