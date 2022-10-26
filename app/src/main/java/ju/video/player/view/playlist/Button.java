package ju.video.player.view.playlist;

import java.awt.Dimension;

import javax.swing.JButton;


public class Button extends JButton {

    public Button(String text) {
        super(text);
        setSize(new Dimension(100, 100));
        RoundedBorder border = new RoundedBorder();
        border.setShape(this);
        setUI(border);
        setOpaque(false);
    }
    
}
