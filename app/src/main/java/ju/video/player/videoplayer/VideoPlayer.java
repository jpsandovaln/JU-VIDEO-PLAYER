package ju.video.player.videoplayer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.border.Border;

import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;

public class VideoPlayer extends JFrame {
   private static final long serialVersionUID = 1L;
   private static final String TITLE = "Media Player";
   private JButton playButton;
   private JButton pauseButton;
   private JButton rewindButton;
   private JButton skipButton;
   private JToggleButton toggleButton;

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
      Border videoBorder = BorderFactory.createTitledBorder("Video Controls");
      Border othersBorder = BorderFactory.createTitledBorder("Others");
      JPanel videoControlsPane = new JPanel();
      videoControlsPane.setBorder(videoBorder);
      playButton = new JButton("Play");
      videoControlsPane.add(playButton);
      pauseButton = new JButton("Pause");
      videoControlsPane.add(pauseButton);
      rewindButton = new JButton("Previus");
      videoControlsPane.add(rewindButton);
      skipButton = new JButton("Next");
      videoControlsPane.add(skipButton);

      JPanel othersPane = new JPanel();
      othersPane.setBorder(othersBorder);
      toggleButton = new JToggleButton("Full Screen");
      othersPane.add(toggleButton);

      JPanel controlsPane = new JPanel();
      controlsPane.add(videoControlsPane);
      controlsPane.add(othersPane);
      controlsPane.setPreferredSize(new Dimension(400, 120));
      contentPane.add(controlsPane, BorderLayout.SOUTH);
      this.setContentPane(contentPane);
      this.setVisible(true);
   }

   public static void main(String[] args) {
      VideoPlayer application = new VideoPlayer(TITLE);
   }

}