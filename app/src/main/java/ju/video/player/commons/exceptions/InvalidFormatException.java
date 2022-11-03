package ju.video.player.commons.exceptions;

public class InvalidFormatException extends RequestException {
    public InvalidFormatException(String currentMessage) {
        super(currentMessage);
    }
    public InvalidFormatException(String currentMessage, Throwable ex) {
        super(currentMessage, ex);
    }
    public InvalidFormatException(Throwable ex) {
        super(ex);
    }
}
