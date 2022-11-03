package ju.video.player.commons.exceptions;

public class AudioRequestException extends RequestException{
    public AudioRequestException(String currentMessage) {
        super(currentMessage);
    }

    public AudioRequestException(String currentMessage, Throwable ex) {
        super(currentMessage, ex);
    }

    public AudioRequestException(Throwable ex) {
        super(ex);
    }
}
