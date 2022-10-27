package ju.video.player.controller;

import ju.video.player.view.videoconvert.VideoConvertFrame;
import ju.video.player.model.Convert;
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
        Convert convert = new Convert();
        // System.out.println("getname" +
        // convert.getName("D:\\videoplayer\\JU-VIDEO-PLAYER\\VID_20220521_212816.mp4"));
        try {
            convert.sendPost("C:\\Users\\Tonio\\taza.mkv", "avi");
            convert.sendGet();
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
