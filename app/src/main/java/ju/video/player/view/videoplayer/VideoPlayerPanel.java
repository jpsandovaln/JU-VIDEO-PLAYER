package ju.video.player.view.videoplayer;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

import ju.video.player.model.ListValidVideos;

import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtonsGroup;
import ju.video.player.view.videoplayer.VideoPlayerComponents.NameVideoText;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.fullscreen.adaptive.AdaptiveFullScreenStrategy;

public class VideoPlayerPanel extends JPanel {
    JFrame mainFrame;
    private static EmbeddedMediaListPlayerComponent mediaPlayerComponent;

    public VideoPlayerPanel(JFrame mainFrame) {
        this.mainFrame = mainFrame;
        NameVideoText nameVideoText = new NameVideoText();
        mediaPlayerComponent = new EmbeddedMediaListPlayerComponent();
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(border);
        setVisible(true);
        mediaPlayerComponent.mediaPlayer().fullScreen().strategy(new AdaptiveFullScreenStrategy(mainFrame));
        ControlButtonsGroup controlButtonsGroup = new ControlButtonsGroup(this);
        BorderLayout borderLayout = new BorderLayout(3, 3);
        setLayout(borderLayout);
        add(nameVideoText, BorderLayout.PAGE_START);
        add(mediaPlayerComponent, BorderLayout.CENTER);
        add(controlButtonsGroup, BorderLayout.PAGE_END);
        setVisible(true);
    }

    public void createList() {
        for (int index = 0; index < ListValidVideos.getInstance().getVideoList().size(); index++) {
            String path = "";
            /*path = ButtonController.getpathOfTheSelectedFolder()
                    + ListValidVideos.getInstance().getVideoList().get(index).substring(2);*/
            System.out.println(ListValidVideos.getInstance().getVideoList().get(index).getPath());
            path = ListValidVideos.getInstance().getVideoList().get(index).getPath();
            mediaPlayerComponent.mediaListPlayer().list().media().add(path);
        }
    }

    public EmbeddedMediaListPlayerComponent getMediaPlayer() {
        return mediaPlayerComponent;
    }
}
