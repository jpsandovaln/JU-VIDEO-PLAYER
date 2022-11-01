package ju.video.player.view.videoplayer;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ju.video.player.controller.componentscontrollers.ReturnButtonController;
import ju.video.player.view.commons.Button;
import ju.video.player.view.commons.UIColor;
import ju.video.player.view.playlist.PlayListFrame;

public class NameVideoText extends JPanel {
    private JLabel videoName = new JLabel();

    public NameVideoText(MediaPlayerFrame mediaPlayerFrame, PlayListFrame playListFrame) {
        videoName.setText(" ");
        //Border border = BorderFactory.createLineBorder(Color.black,1);
        this.setLayout(new BorderLayout());
        Button returnButton = new Button("");
        returnButton.setIcon("back.png", 15, 15);
        returnButton.addActionListener(new ReturnButtonController(mediaPlayerFrame, playListFrame));
        add(returnButton, BorderLayout.WEST);
        add(videoName, BorderLayout.CENTER);
        //this.setBorder(border);
        setBackground(UIColor.PRIMARY_BACKGROUNG_COLOR);
    }

    public void updateMediaName(String newVideoName){
        videoName.setText(newVideoName);
    }
}
