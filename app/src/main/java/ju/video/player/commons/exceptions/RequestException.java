package ju.video.player.commons.exceptions;

import java.io.IOException;

public class RequestException extends Exception {
    public RequestException(String currentMessage) {
        super(currentMessage);
    }
    public RequestException(String currentMessage, Throwable ex) {
        super(currentMessage, ex);
    }
    public RequestException(Throwable ex) {
        super(ex);
    }
}
