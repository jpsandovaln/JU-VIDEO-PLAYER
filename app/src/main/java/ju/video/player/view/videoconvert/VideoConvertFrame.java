package ju.video.player.view.videoconvert;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

import ju.video.player.controller.ConvertController;
import ju.video.player.view.MainFrame;
import ju.video.player.view.commons.Colors;
import ju.video.player.view.information.search.FolderChooserButton;
import ju.video.player.view.materialDesing.ResponsiveSwingMaterialDesign;
import ju.video.player.view.materialDesing.components.date.fields.DateField;
import ju.video.player.view.materialDesing.components.image.ImageLabel;
import ju.video.player.view.materialDesing.components.utils.ImageRoundedBorder;
import ju.video.player.view.materialDesing.components.utils.RoundedBorder;
import ju.video.player.view.materialDesing.display.FrameUtility;
import ju.video.player.view.materialDesing.layouts.ResponsiveLayout;
import java.awt.event.ActionListener;
import java.awt.Dimension;

import javax.swing.JButton;

import javax.swing.*;
import java.awt.*;

import ju.video.player.view.materialDesing.components.input.TextArea;
import ju.video.player.view.materialDesing.constants.Constants;
import ju.video.player.view.playlist.playlistpanel.VideoListPanel;

import java.awt.Dimension;

import javax.swing.JButton;

public class VideoConvertFrame extends JFrame{
    // frame
    static JFrame f;

    // label
    static JLabel l, l1, l3, l4;

    
    // combobox
    static JComboBox c1, c2;
    private ConvertController controller;

    public VideoConvertFrame() {
        controller = new ConvertController(this);
        initFrame();
    }

    public void initFrame() {
        JFrame frame = FrameUtility.build("ATT Player", 0, 0, 850, 600, true);

        frame.add(panelSelect());
        frame.add(buttonConv(controller));
        frame.getContentPane().setBackground(Colors.PRIMARY_BACKGROUNG_COLOR);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    public JButton buttonConv(ActionListener listener) {
        JButton Button = new JButton();
        RoundedBorder border = new RoundedBorder(20);

        Button.setBorder(border);
        Button.setBounds(300, 300, 260, 50);
        Button.setAlignmentX(Component.CENTER_ALIGNMENT);
        Button.setText("Convert");
        // Button.setForeground(Color.WHITE);
        Button.setBackground(Colors.PRIMARY_COLOR);
        Button.addActionListener(listener);
        Button.setVisible(true);
        return Button;

    }

    public JPanel panelSelect() {

        String s1[] = { "AVI", "MKV", "FLV" };
        c1 = new JComboBox(s1);
        c1.setEditable(false);

        l = new JLabel("Select One Format ");
        l.setForeground(Color.WHITE);

        JPanel p = new JPanel();
        p.setBounds(0, 0, 260, 50);
        p.add(l);
        p.add(c1);
        p.setLayout(new FlowLayout());
        p.setOpaque(false);
        p.setVisible(true);
        return p;
    }

}
