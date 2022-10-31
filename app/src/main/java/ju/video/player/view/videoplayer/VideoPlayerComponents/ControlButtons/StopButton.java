package ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtons;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class StopButton extends JButton {
    public StopButton(ActionListener listener) {
        setLocation(CENTER, CENTER);
        setSize(new Dimension(30, 30));
        ImageIcon newIcon = new ImageIcon("JU-VIDEO-PLAYER/app/src/main/resources/stop.png");
        setIcon(newIcon);
        addActionListener(listener);
    }
}
