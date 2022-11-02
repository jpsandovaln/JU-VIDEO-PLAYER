package ju.video.player.commons.exceptions;

public class ContentFileException extends Exception {

    public ContentFileException(String message) {
        super(message);
    }

    public ContentFileException(String message, Throwable ex) {
        super(message,ex);
    }
}
