package ju.video.player.view.videoplayer.VideoPlayerComponents;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.*;

public class VideoFrame extends JPanel{
    public VideoFrame(){
        Border border = BorderFactory.createLineBorder(Color.BLUE,2);
        this.setBorder(border);
    }
}
