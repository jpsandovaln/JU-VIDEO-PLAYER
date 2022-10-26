package ju.video.player.view;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

import ju.video.player.view.materialDesing.constants.Constants;
import ju.video.player.view.materialDesing.display.FrameUtility;

import java.awt.Image;
import java.text.ParseException;
import java.awt.FlowLayout;

public class PlayListFrame {

    public PlayListFrame() throws ParseException {
        JFrame frame = FrameUtility.build("ATT Player", 0, 0, 850, 600, true);
        //ResponsiveLayout layout = new ResponsiveLayout(1, 3, frame);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        FiltersPanel filtersPanel = new FiltersPanel();
        frame.add(filtersPanel);
        PlayListPanel playListPanel = new PlayListPanel();
        frame.add(playListPanel);
        Image icon = new ImageIcon(Constants.RESOURCES_IMAGES + "\\icon.png").getImage();
        frame.setIconImage(icon);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setBackground(null);
    }
    
}
