package ju.video.player.view.videoplayer.VideoPlayerComponents;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import ju.video.player.view.commons.UIColor;

public class NameVideoText extends JPanel {
    JLabel videoName = new JLabel();
    public NameVideoText() {
        
        videoName.setText("Video Name.mp4");
        Border border = BorderFactory.createLineBorder(Color.black,1);
        this.setLayout(new GridBagLayout());
        this.add(videoName);
        this.setBorder(border);
        setBackground(UIColor.PRIMARY_BACKGROUNG_COLOR);
        setOpaque(false);
    }

    public void updateVideoName(String newVideoName){
        videoName.setText(newVideoName);
    }
}
