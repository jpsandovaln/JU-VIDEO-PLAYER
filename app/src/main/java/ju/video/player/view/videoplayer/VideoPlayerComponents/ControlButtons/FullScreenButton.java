package ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtons;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

import java.awt.event.ActionListener;

public class FullScreenButton extends JToggleButton {
    public FullScreenButton(ActionListener listener) {
        setLocation(CENTER, CENTER);
        setPreferredSize(new Dimension(30, 30));
        ImageIcon newIcon = new ImageIcon(
                "JU-VIDEO-PLAYER/app/src/main/resources/full-screen-activate.png");
        setIcon(newIcon);
        addActionListener(listener);
    }
}
