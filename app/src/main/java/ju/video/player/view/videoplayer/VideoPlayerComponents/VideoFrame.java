package ju.video.player.view.videoplayer.VideoPlayerComponents;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import ju.video.player.controller.ButtonControler;
import ju.video.player.model.ListValidVideos;
import ju.video.player.view.MainFrame;
import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.fullscreen.adaptive.AdaptiveFullScreenStrategy;

import java.awt.*;

public class VideoFrame extends JPanel {
    MainFrame mainFrame;
    // MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
    private static EmbeddedMediaListPlayerComponent mediaPlayerComponent;

    public VideoFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        mediaPlayerComponent = new EmbeddedMediaListPlayerComponent();
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        this.setBorder(border);
        add(mediaPlayerComponent, BorderLayout.CENTER);
        setVisible(true);
        mediaPlayerComponent.mediaPlayer().fullScreen().strategy(new AdaptiveFullScreenStrategy(mainFrame));
    }

    public EmbeddedMediaListPlayerComponent getMediaPlayer() {
        return mediaPlayerComponent;
    }

    public void createList() {
        System.out.println(ListValidVideos.getInstance().getVideoList().get(1));
        for (int index = 0; index < ListValidVideos.getInstance().getVideoList().size(); index++) {
            String path = "";
            path = ButtonControler.getpathOfTheSelectedFolder()
                    + ListValidVideos.getInstance().getVideoList().get(index).substring(2);
            mediaPlayerComponent.mediaListPlayer().list().media()
                    .add(path);
        }
    }
}
