package ju.video.player.model;

import java.io.IOException;

public interface Request {
    public void sendPost(String path, String format) throws IOException;
}
