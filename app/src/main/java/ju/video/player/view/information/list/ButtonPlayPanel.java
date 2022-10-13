package ju.video.player.view.information.list;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Container;

public class ButtonPlayPanel extends JButton {
     public ButtonPlayPanel() {
         super("Play Video");
         setAlignmentX(Container.CENTER_ALIGNMENT);
         setBackground(Color.CYAN);
     }
}
