package ju.video.player.commons.exceptions;

public class VideoRequestException extends RequestException {
    public VideoRequestException(String currentMessage) {
        super(currentMessage);
    }
    public VideoRequestException(String currentMessage, Throwable ex) {
        super(currentMessage, ex);
    }
    public VideoRequestException(Throwable ex) {
        super(ex);
    }
}
