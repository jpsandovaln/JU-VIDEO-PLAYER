package ju.video.player.view.information.search;

import ju.video.player.controller.ButtonController;
import ju.video.player.view.materialDesing.components.date.fields.DateField;
import ju.video.player.view.materialDesing.components.input.TextArea;
import ju.video.player.view.materialDesing.components.utils.RoundedBorder;
import ju.video.player.view.materialDesing.constants.Constant;
import ju.video.player.view.playlist.playlistpanel.VideoListPanel;

import javax.swing.*;
import java.awt.*;


public class FolderChooserButton extends JButton {
    public FolderChooserButton(VideoListPanel panelSouth, JFrame frame, TextArea area, DateField date) {
        super("Choose file");
        initComponents();
        //addActionListener(new ButtonController(panelSouth, frame, area, date));
    }

    private void initComponents() {
        setSize(new Dimension(200, 200));
    }
}
