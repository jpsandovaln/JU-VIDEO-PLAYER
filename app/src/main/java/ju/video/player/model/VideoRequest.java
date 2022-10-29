/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jala University
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
 * It is responsible for setting up a Http Client to consume the video converter service.
 *
 * @author Daniela Martinez && Alvaro Sivila Ramirez
 * @version 1.0
 */
public class VideoRequest implements  Request{
    private static final String HTTP_POST = "http://localhost:5000/uploadVideo";
    private static final String HTTP_GET = "http://localhost:5000/downloadFile/";
    private String path;
    private String newFormat;

    VideoRequest() {
        createDirectory();
    }

    /**
     * It is responsible for constructing the body of the request and executing the request.
     * @param path It is the directory where the file to be converted is located.
     * @param format Is the format to which the file is to be converted.
     * @throws IOException
     */
    @Override
    public void sendPost(String path, String format) throws IOException{
        this.path = path;
        this.newFormat = format;
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(HTTP_POST);
        FileBody bin = new FileBody(new File(path));
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
        sendGet();
    }

    /**
     * Is responsible for performing a request to obtain the converted file.
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
     * It is responsible for creating a folder in the root of the project.
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
     * It is responsible for obtaining the name of the file to be converted from the path received.
     * @param name Is the complete path of the file to convert
     * @return Returns the file name as a string
     */
    private String getName(String name) {
        Path path = Paths.get(name);
        return String.valueOf(path.getFileName());
    }

    /**
     * Is responsible for separating the format from the name of the file to be converted
     * @param name It is the name of the file with its format
     * @return Returns the file name
     */
    private String separateFormat(String name) {
        String[] parts = name.split("\\.");
        return parts[0];
    }
}