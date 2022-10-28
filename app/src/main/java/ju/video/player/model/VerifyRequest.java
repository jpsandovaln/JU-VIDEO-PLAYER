package ju.video.player.model;

import java.util.ArrayList;

public class VerifyRequest {
    ArrayList<String> audioFormats = new ArrayList<>();
    ArrayList<String> videoFormats = new ArrayList<>();
    private String format;
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
    }
    public Request getRequest() {
        if(audioFormats.contains(format)) {
            System.out.println("este es el formato" + format);
            return new AudioRequest();
        }
        if(videoFormats.contains(format)) {
            return new VideoRequest();
        }
        return  null;
    }
}


