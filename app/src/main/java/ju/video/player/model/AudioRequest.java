/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
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
/**
 * It is responsible for setting up a Http Client to consume the audio converter service.
 *
 * @author Alvaro Sivila Ramirez
 * @version 1.0
 */
public class AudioRequest implements Request {
    private static final String HTTP_POST = "http://localhost:5000/uploadAudio";
    private static final String HTTP_GET = "http://localhost:5000/downloadFile/";
    private String path;
    private String newFormat;

    /**
     *
     */
    public  AudioRequest () {
        createDirectory();
    }

    /**
     * @param path
     * @param format
     * @throws IOException
     */
    @Override
    public void sendPost(String path, String format) throws IOException {
        this.path = path;
        this.newFormat = format;
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(HTTP_POST);
        FileBody bin = new FileBody(new File(path));
        //StringBody outName = new StringBody(separateFormat(getName(path)));
        //StringBody outFormat = new StringBody("." + format);
        StringBody bitrate = new StringBody("");
        StringBody channels = new StringBody("");
        StringBody samplingFrequency  = new StringBody("");
        StringBody outFormat = new StringBody(newFormat);

        MultipartEntity reqEntity = new MultipartEntity();
        reqEntity.addPart("file", bin);
        reqEntity.addPart("bitrate", bitrate);
        reqEntity.addPart("channels", channels);
        reqEntity.addPart("sampling frequency", samplingFrequency);
        reqEntity.addPart("format", outFormat);


        httppost.setEntity(reqEntity);
        HttpResponse response = httpclient.execute(httppost);
        HttpEntity resEntity = response.getEntity();
        sendGet();
    }

    /**
     * @throws IOException
     */
    private void sendGet() throws IOException {
        URL url = new URL(HTTP_GET + getName(path));
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

    /**
     *
     */
    private void createDirectory() {
        File dir = new File("Download");
        if (!dir.exists()) {
            if (dir.mkdirs()) {
                System.out.println("Successful");
            }
        }
    }

    /**
     * @param name
     * @return
     */
    private String getName(String name) {
        Path path = Paths.get(name);
        return String.valueOf(path.getFileName());
    }

    /**
     * @param name
     * @return
     */
    private String separateFormat(String name) {
        String[] parts = name.split("\\.");
        return parts[0];
    }
}