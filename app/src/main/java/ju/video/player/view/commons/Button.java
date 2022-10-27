package ju.video.player.view.commons;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Image;

import ju.video.player.view.materialDesing.constants.Constants;


public class Button extends JButton {

    public Button(String text) {
        super(text);
        RoundedBorder border = new RoundedBorder();
        border.setShape(this);
        setUI(border);
        setOpaque(false);
    }

    public void setIcon(String path, int width, int height) {
        ImageIcon convertImage = new ImageIcon(Constants.RESOURCES_IMAGES + path);
        Icon convertIcon = new ImageIcon(convertImage.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        setIcon(convertIcon);
    }
    
}
