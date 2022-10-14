package ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtons;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class PreviousButton extends JButton {
    public PreviousButton(ActionListener listener) {
        setLocation(CENTER, CENTER);
        setPreferredSize(new Dimension(30, 30));
        ImageIcon newIcon = new ImageIcon("JU-VIDEO-PLAYER/app/src/main/resources/previous.png");
        setIcon(newIcon);
        addActionListener(listener);
    }
}
