package ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtons;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class PauseButton extends JButton {
    public PauseButton(ActionListener listener) {
        setLocation(CENTER, CENTER);
        setPreferredSize(new Dimension(30, 30));
        ImageIcon newIcon = new ImageIcon("JU-VIDEO-PLAYER/app/src/main/java/ju/video/player/src/pause.png");
        setIcon(newIcon);
        addActionListener(listener);
    }
}
