package ju.video.player.controller;

import ju.video.player.model.ConvertFile;
import ju.video.player.view.videoconvert.VideoConvertFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ConvertController implements ActionListener {
    private VideoConvertFrame convertFrame;

    public ConvertController(VideoConvertFrame convert) {
        this.convertFrame = convert;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Pressed Convert");
        try {
            ConvertFile convertFile = new ConvertFile("C:\\Users\\alvar\\Desktop\\Videos\\VID_20220521_212249.mp4", "avi");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
    }
}
