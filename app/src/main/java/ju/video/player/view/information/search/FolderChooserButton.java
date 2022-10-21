package ju.video.player.view.information.search;

import ju.video.player.controller.ButtonControler;
import ju.video.player.view.information.list.VideoListPanel;
import ju.video.player.view.materialDesing.components.date.fields.DateField;
import ju.video.player.view.materialDesing.components.input.TextArea;

import javax.swing.*;
import java.awt.*;

public class FolderChooserButton extends JButton {
    public FolderChooserButton(VideoListPanel panelSouth, JFrame frame, TextArea area, DateField date) {
        super("Choose file");
        setSize(new Dimension(200, 200));
        addActionListener(new ButtonControler(panelSouth, frame, area, date));
    }
}
