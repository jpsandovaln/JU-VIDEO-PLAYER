package ju.video.player.videoplayer;

import java.util.List;

import javax.swing.JFrame;

import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;

public class VideoPlayer extends JFrame {
   private static final long serialVersionUID = 1L;
   private static final String TITLE = "Media Player";

   MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
   private static EmbeddedMediaListPlayerComponent mediaPlayerComponent;

   public VideoPlayer(String title) {
      super(title);
      mediaPlayerComponent = new EmbeddedMediaListPlayerComponent();
   }

   public static void createList(List<String> paths) {
      for (int index = 0; index < paths.size(); index++) {
         mediaPlayerComponent.mediaListPlayer().list().media().add(paths.get(index));
      }
   }
}