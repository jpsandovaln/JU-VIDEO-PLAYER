package ju.video.player.view.playlist;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

import ju.video.player.view.commons.Colors;
import ju.video.player.view.materialDesing.constants.Constants;
import ju.video.player.view.materialDesing.display.FrameUtility;
import ju.video.player.view.playlist.filterspanel.FiltersPanel;
import ju.video.player.view.playlist.playlistpanel.PlayListPanel;

import java.awt.Image;
import java.awt.Component;
import java.text.ParseException;

public class PlayListFrame {

    public PlayListFrame() throws ParseException {
        JFrame frame = FrameUtility.build("ATT Player", 0, 0, 850, 600, true);
        //frame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        frame.setLayout(null);
        FiltersPanel filtersPanel = new FiltersPanel();
        filtersPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        frame.add(filtersPanel);
        PlayListPanel playListPanel = new PlayListPanel();
        playListPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        frame.add(playListPanel);

        Image icon = new ImageIcon(Constants.RESOURCES_IMAGES + "\\icon.png").getImage();
        frame.setIconImage(icon);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Colors.PRIMARY_BACKGROUNG_COLOR);
    }
    
}
