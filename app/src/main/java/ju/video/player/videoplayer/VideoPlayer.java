package ju.video.player.videoplayer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;

public class VideoPlayer extends JFrame {
   private static final long serialVersionUID = 1L;
   private static final String TITLE = "Media Player";

   MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
   private static EmbeddedMediaListPlayerComponent mediaPlayerComponent;

   public VideoPlayer(String title) {
      super(title);
      mediaPlayerComponent = new EmbeddedMediaListPlayerComponent();
      initialize();
      setVisible(true);
   }

   public void initialize() {
      // createList();
      this.setBounds(100, 100, 600, 400);
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            mediaPlayerComponent.release();
            System.exit(0);
         }
      });
      JPanel contentPane = new JPanel();
      contentPane.setLayout(new BorderLayout());
      contentPane.add(mediaPlayerComponent, BorderLayout.CENTER);
      this.setContentPane(contentPane);
      this.setVisible(true);
   }

   public static void main(String[] args) {
      VideoPlayer application = new VideoPlayer(TITLE);
   }

}