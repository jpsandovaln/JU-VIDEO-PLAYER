package ju.video.player.view.videoplayer;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

import ju.video.player.view.commons.Colors;
import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtonsGroup;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.fullscreen.adaptive.AdaptiveFullScreenStrategy;

public class VideoPlayerPanel extends JPanel {
    JFrame mainFrame;
    private EmbeddedMediaListPlayerComponent mediaPlayerComponent;

    public VideoPlayerPanel(MediaPlayerFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.mediaPlayerComponent = mainFrame.getMediaComponent();
        initialize();
        mediaPlayerComponent.mediaPlayer().fullScreen().strategy(new AdaptiveFullScreenStrategy(mainFrame));
        ControlButtonsGroup controlButtonsGroup = new ControlButtonsGroup(this);
        add(mediaPlayerComponent, BorderLayout.CENTER);
        add(controlButtonsGroup, BorderLayout.PAGE_END);
    }
    public void initialize() {
        BorderLayout borderLayout = new BorderLayout(3, 3);
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        setBorder(border);
        setVisible(true);
        setLayout(borderLayout);
        setVisible(true);
        setBackground(Colors.PRIMARY_BACKGROUNG_COLOR);
    }

    public EmbeddedMediaListPlayerComponent getMediaPlayer() {
        return mediaPlayerComponent;
    }
}
