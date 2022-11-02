package ju.video.player.commons.exceptions;

public class ListVideosException extends Exception{

    public ListVideosException(String message) {
        super(message);
    }

    public ListVideosException(String message, Throwable ex) {
        super(message,ex);
    }
}
