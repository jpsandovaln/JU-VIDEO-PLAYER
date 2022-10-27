package ju.video.player.model;

import java.io.*;
import org.apache.http.HttpResponse;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.HttpEntity;
public class Convert {
    private final String httpPost = "http://localhost:5000/uploadVideo";
    private final String httpGet = "http://localhost:5000/downloadFile/";
    private String format;
    private String name;
    private String path;
    private String newFormat;
    public Convert() {
        createDirectory();
    }

    public void sendPost(String path, String format) throws IOException {
        this.path = path;
        this.newFormat = format;
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(httpPost);
        FileBody bin = new FileBody(new File(path));
        System.out.println(getName(path));
        StringBody outName = new StringBody(separateFormat(getName(path)));
        StringBody outFormat = new StringBody("." + format);
        StringBody volume = new StringBody("");
        StringBody removeAudio = new StringBody("");
        StringBody videoBitrate = new StringBody("");
        StringBody audioBitrate = new StringBody("");
        StringBody videoFragment = new StringBody("");
        StringBody rotate = new StringBody("");
        StringBody fps = new StringBody("");
        StringBody color = new StringBody("");
        StringBody size = new StringBody("");
        StringBody cropVideo = new StringBody("");


        MultipartEntity reqEntity = new MultipartEntity();
        reqEntity.addPart("file", bin);
        reqEntity.addPart("outName", outName);
        reqEntity.addPart("outFormat", outFormat);
        reqEntity.addPart("volume", volume);
        reqEntity.addPart("removeAudio", removeAudio);
        reqEntity.addPart("videoBitrate", videoBitrate);
        reqEntity.addPart("audioBitrate", audioBitrate);
        reqEntity.addPart("videoFragment", videoFragment);
        reqEntity.addPart("rotate", rotate);
        reqEntity.addPart("fps", fps);
        reqEntity.addPart("color", color);
        reqEntity.addPart("size", size);
        reqEntity.addPart("cropVideo", cropVideo);

        httppost.setEntity(reqEntity);
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity resEntity = response.getEntity();
    }

    public void sendGet() throws IOException {
        URL url = new URL(httpGet + getName(path));
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new RuntimeException("An error has occurred: " + responseCode);
        } else {
            InputStream in = conn.getInputStream();
            byte[] bytes = new byte[2048];
            int length;
            OutputStream out = new FileOutputStream("Download\\" + separateFormat(getName(path)) + "." + newFormat);
            while ((length = in.read(bytes)) != -1) {
                out.write(bytes, 0, length);
            }
            out.close();
            }
    }
    private void createDirectory() {
        File dir = new File("Download");
        if (!dir.exists()) {
            if (dir.mkdirs()) {
                System.out.println("Succesfull");
            }
        }
    }
    private String getName(String name) {
        Path path = Paths.get(name);
        return String.valueOf(path.getFileName());
    }
    private String separateFormat(String name) {
        String[] parts = name.split("\\.");
        format = parts[1];
        return parts[0];
    }

}
