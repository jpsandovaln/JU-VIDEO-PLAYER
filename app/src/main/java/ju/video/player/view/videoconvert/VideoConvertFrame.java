/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view.videoconvert;

import javax.swing.JPanel;
import ju.video.player.controller.ConvertController;
import ju.video.player.controller.FormatConvertController;
import ju.video.player.view.commons.UIColor;
import ju.video.player.view.materialDesing.components.utils.RoundedBorder;
import ju.video.player.view.materialDesing.display.FrameUtility;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

/**
 * This class is responsible for running the view to convert.
 *
 * @author Jose Antonio Romay Ayarachi 
 * @version 1.0
 */

public class VideoConvertFrame extends JFrame {

    private static final int WIDTH_FRAME = 850;
    private static final int HEIGHT_FRAME = 600;
    private static final int WIDTH_PANEL = 260;
    private static final int HEIGHT_PANEL = 150;

    private static final int POSX_BUTTON = 280;
    private static final int POSY_BUTTON = 460;
    private static final int WIDTH_BUTTON = 260;
    private static final int HEIGHT_BUTTON = 50;
    private static final int RADIUS_BUTTON = 20;

    private ConvertController controller;
    private FormatConvertController formatController;
    private String path;

    private JComboBox<String> combotype;
    private JComboBox<String> comboformat;

    public VideoConvertFrame(String path) {
        formatController = new FormatConvertController(this);
        controller = new ConvertController(this);
        this.path = path;
        initFrame();

    }

    public void initFrame() {
        JFrame frame = FrameUtility.build("ATT Player", 0, 0, WIDTH_FRAME, HEIGHT_FRAME, true);
        frame.add(IcoLabel());
        frame.add(TxtLabel());
        frame.add(panelFormat());
        frame.add(panelType());
        frame.add(buttonConv());
        frame.getContentPane().setBackground(UIColor.PRIMARY_BACKGROUNG_COLOR);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    private JLabel IcoLabel() {
        ImageIcon iconf = new ImageIcon(this.getClass().getResource("/att1.png"));
        JLabel label = new JLabel();
        label.setBounds(310, 30, 250, 150);
        label.setIcon(iconf);
        label.setVisible(true);
        return label;
    }

    private JLabel TxtLabel() {
        JLabel labelT = new JLabel();
        labelT.setBounds(230, 150, 450, 150);
        labelT.setText("Select an Output Format");
        labelT.setFont(new Font("Serif", Font.PLAIN, 40));
        labelT.setForeground(Color.WHITE);
        labelT.setVisible(true);
        return labelT;
    }

    public JButton buttonConv() {
        JButton button = new JButton();
        RoundedBorder border = new RoundedBorder(RADIUS_BUTTON);

        button.setBorder(border);
        button.setBounds(POSX_BUTTON, POSY_BUTTON, WIDTH_BUTTON, HEIGHT_BUTTON);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setText("Convert");
        button.setFont(new Font("Serif", Font.PLAIN, 25));
        button.setBackground(UIColor.PRIMARY_COLOR);
        button.addActionListener(controller);
        button.setVisible(true);
        return button;
    }

    public JPanel panelType() {

        comboformat = new JComboBox();
        fillFormat((String) combotype.getSelectedItem());
        comboformat.setFont(new Font("Serif", Font.PLAIN, 30));
        comboformat.setEditable(false);

        JPanel panelCombo = new JPanel();
        panelCombo.setBounds(380, 290, WIDTH_PANEL, HEIGHT_PANEL);
        panelCombo.add(comboformat);
        panelCombo.setLayout(new FlowLayout());
        panelCombo.setOpaque(false);
        panelCombo.setVisible(true);
        return panelCombo;
    }

    public JPanel panelFormat() {

        combotype = new JComboBox();
        fillType();
        combotype.addActionListener(formatController);
        combotype.setFont(new Font("Serif", Font.PLAIN, 30));
        combotype.setEditable(false);

        JPanel panelCombo = new JPanel();
        panelCombo.setBounds(190, 290, WIDTH_PANEL, HEIGHT_PANEL);
        panelCombo.add(combotype);
        panelCombo.setLayout(new FlowLayout());
        panelCombo.setOpaque(false);
        panelCombo.setVisible(true);
        return panelCombo;
    }

    public JComboBox<String> getFormat() {
        return this.comboformat;
    }

    private void fillType() {
        combotype.addItem("Video");
        combotype.addItem("Audio");
    }

    public void fillFormat(String select) {
        comboformat.removeAllItems();
        if (select.equals("Video")) {
            comboformat.addItem("flv");
            comboformat.addItem("mkv");
            comboformat.addItem("avi");
        } else if (select.equals("Audio")) {
            comboformat.addItem("mp3");
            comboformat.addItem("aac");
            comboformat.addItem("ogg");
            comboformat.addItem("flac");
            comboformat.addItem("wma");
            comboformat.addItem("wav");
        }
    }

    public JComboBox<String> getTypeFormat() {
        return combotype;
    }

    public String getPath() {
        return path;
    }

}
