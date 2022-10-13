package ju.video.player.view.videoplayer.VideoPlayerComponents;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class NameVideoText extends JPanel {
    
    public NameVideoText() {
        JLabel videoName = new JLabel();
        videoName.setText("Video Name.mp4");
        Border border = BorderFactory.createLineBorder(Color.black,1);
        this.setLayout(new GridBagLayout());
        this.add(videoName);
        this.setBorder(border);
    }
}
