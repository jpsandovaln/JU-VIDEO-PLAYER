/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jala University
 */
package ju.video.player.model.request;

import java.io.*;

import ju.video.player.commons.exceptions.*;
import org.apache.http.HttpResponse;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.http.client.ClientProtocolException;
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
    private static final String HTTP_GET_TOKEN = "http://localhost:5000/getToken";
    private String path;
    private String newFormat;
    private String outputPath;
    private String token;

    /**
     * The constructor is responsible for creating the Downloads directory in the project and
     * initialize outputPath variable.
     */
    VideoRequest() {
        createDirectory();
        outputPath = "Successful conversion: ";
    }

    /**
     * It is responsible for constructing the body of the request and executing the request.
     * @param path It is the directory where the file to be converted is located.
     * @param format Is the format to which the file is to be converted.
     * @throws VideoRequestException
     */
    @Override
    public void sendPostRequest(String path, String format) throws VideoRequestException {
        this.path = path;
        this.newFormat = format;
        getToken();
        try {
            validateFormat();
            validatePath();
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost(HTTP_POST);
            FileBody binaryFile = new FileBody(new File(path));
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
            reqEntity.addPart("file", binaryFile);
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
            httpPost.setHeader("Authorization", "Bearer " + token);
            httpPost.setEntity(reqEntity);
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity resEntity = response.getEntity();
            sendGetRequest();
        } catch (Exception e) {
            throw new VideoRequestException(e);
        }
    }

    /**
     * It is responsible for returning the path of the converted file.
     * @return A string with the path address of the converted file is returned.
     */
    @Override
    public String getOutputPath() {
        return outputPath;
    }

    /**
     * Is responsible for performing a request to obtain the converted file.
     * @throws VideoRequestException
     */
    private void sendGetRequest() throws VideoRequestException {
        try {
            URL url = new URL(HTTP_GET + getName(path));
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                throw new VideoRequestException("An error has occurred: " + responseCode);
            } else {
                InputStream inputStream = connection.getInputStream();
                byte[] bytes = new byte[2048];
                int length;
                OutputStream outputStream = new FileOutputStream("Download\\" + separateFormat(getName(path)) + "." + newFormat);
                outputPath += System.getProperty("user.dir") + "\\Download\\" + separateFormat(getName(path)) + "." + newFormat;
                while ((length = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, length);
                }
                outputStream.close();
            }
        } catch (Exception e) {
            throw new VideoRequestException("Failed to get the converted file", e);
        }
    }

    /**
     * It is responsible for obtaining a token to consume the Video converter service.
     * @throws VideoRequestException
     */
    private void getToken() throws VideoRequestException{
        try {
            URL urlGetToken = new URL(HTTP_GET_TOKEN);
            HttpURLConnection connection = (HttpURLConnection) urlGetToken.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("An error has occurred: " + responseCode);
            } else {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = bufferedReader.readLine()) != null) {
                    response.append(inputLine);
                }
                bufferedReader.close();
                String[] partsToken = response.toString().split(": ");
                token = partsToken[1];
            }
        } catch (Exception e) {
            throw new VideoRequestException("Failure to obtain token", e);
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

    /**
     * Responsible for verifying empty, null or non-existent paths.
     * @throws InvalidPathException
     */
    private void validatePath() throws InvalidPathException {
        File file = new File (path);
        if (path == null) {
            throw new InvalidPathException("The path is null");
        }
        if (path.equals("")) {
            throw new InvalidPathException("The Path is empty");
        }
        if (!file.isFile()) {
            throw new InvalidPathException("File does not exist");
        }

    }

    /**
     * Responsible for verifying null or empty formats
     * @throws InvalidFormatException
     */
    private void validateFormat() throws InvalidFormatException {
        if (newFormat == null) {
            throw new InvalidFormatException("The Format is null");
        }
        if (newFormat.equals("")) {
            throw new InvalidFormatException("The Format is empty");
        }
    }
}
