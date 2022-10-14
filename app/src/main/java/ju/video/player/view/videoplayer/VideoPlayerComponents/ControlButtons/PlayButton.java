package ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtons;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class PlayButton extends JButton{
    public PlayButton(ActionListener listener){
        setLocation(CENTER, CENTER);
        setPreferredSize(new Dimension(30,30));
        ImageIcon newIcon = new ImageIcon("app/src/main/java/ju/video/player/src/play.png");
        setIcon(newIcon);
        addActionListener(listener);
    }
}
