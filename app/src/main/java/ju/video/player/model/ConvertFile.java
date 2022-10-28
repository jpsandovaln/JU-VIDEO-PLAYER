package ju.video.player.model;

import java.io.IOException;

public class ConvertFile {
    private String path;
    private String format;
    public ConvertFile(String path, String format) throws IOException {
        this.path = path;
        this.format = format;
        convert();
    }
    private void convert() throws IOException {
        VerifyRequest verifyRequest = new VerifyRequest(format);
        Request request = verifyRequest.getRequest();
        request.sendPost(path, format);

    }

}
