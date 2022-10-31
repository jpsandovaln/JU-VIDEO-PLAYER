package ju.video.player.controller.componentscontrollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import ju.video.player.view.playlist.PlayListFrame;

public class BackButtonController implements ActionListener {
    private JFrame convertFrame;
    private PlayListFrame playListFrame;

    public BackButtonController(JFrame convertFrame, PlayListFrame playListFrame) {
        this.convertFrame = convertFrame;
        this.playListFrame = playListFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        convertFrame.dispose();
        playListFrame.setVisible(true);
    }

}
