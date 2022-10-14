package ju.video.player.view.information.search;

import javax.swing.JButton;

import ju.video.player.controller.ButtonControler;
import ju.video.player.view.information.list.VideoListPanel;

import java.awt.Dimension;

public class FolderChooserButton extends JButton {

    public FolderChooserButton(VideoListPanel panelSouth) {
        super("Choose file");
        
        setSize(new Dimension(200,200));
        addActionListener(new ButtonControler(panelSouth));
    }
}
