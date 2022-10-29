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
        // if (e.getSource() == convertFrame.getButton()) {
        // convertFrame.getContentPane().removeAll();
        // convertFrame.repaint();
        System.out.println("Pressed Convert");

        // System.out.println("getname" +
        // convert.getName("D:\\videoplayer\\JU-VIDEO-PLAYER\\VID_20220521_212816.mp4"));
        try {
            ConvertFile convertFile = new ConvertFile("C:\\Users\\alvar\\Desktop\\Videos\\VID_20220521_212249.mp4", "avi");
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        // convertFrame.addNewComponents();
        // }
        // convertFrame.setLabels("Game players: " +
        // convertFrame.getChoice().getSelectedItem().toString());
        // convertFrame.setVisible(false);
        // new BoardFrame(convertFrame.getChoice().getSelectedItem().toString());
    }
}
