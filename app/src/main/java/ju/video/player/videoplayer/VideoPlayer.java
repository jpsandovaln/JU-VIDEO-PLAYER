package ju.video.player.videoplayer;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class VideoPlayer extends JFrame {
   private static final long serialVersionUID = 1L;
   private static final String TITLE = "Media Player";

   public VideoPlayer(String title) {
      super(title);
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
            System.exit(0);
         }
      });
   }

   public static void main(String[] args) {
      VideoPlayer application = new VideoPlayer(TITLE);
   }

}