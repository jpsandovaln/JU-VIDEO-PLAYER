package ju.video.player.controller;

import ju.video.player.view.videoconvert.VideoConvertFrame;
import ju.video.player.model.Convert;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ConvertController implements ActionListener {
    private VideoConvertFrame convertFrame;

    public ConvertController(VideoConvertFrame convertVideo) {
        this.convertFrame = convertVideo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
      
        System.out.println("Pressed Convert");
        System.out.println(convertFrame.getPath());
        System.out.println(convertFrame.getFormat().getSelectedItem().toString());

        Convert convert = new Convert();
        try {
            convert.sendPost(convertFrame.getPath(), convertFrame.getFormat().getSelectedItem().toString());
            convert.sendGet();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        
    }


}
