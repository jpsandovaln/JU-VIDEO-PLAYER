package ju.video.player.commons.exceptions;

public class InvalidPathException extends RequestException{
    public InvalidPathException(String currentMessage) {
        super(currentMessage);
    }
    public InvalidPathException(String currentMessage, Throwable ex) {
        super(currentMessage, ex);
    }
    public InvalidPathException(Throwable ex) {
        super(ex);
    }
}
