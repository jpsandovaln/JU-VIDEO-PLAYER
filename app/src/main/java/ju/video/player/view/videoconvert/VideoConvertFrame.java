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
import ju.video.player.controller.componentscontrollers.BackButtonController;

import ju.video.player.view.commons.Button;
import ju.video.player.view.commons.UIColor;
import ju.video.player.view.commons.UIFont;
import ju.video.player.view.commons.constants.Constant;
import ju.video.player.view.commons.display.FrameUtility;
import ju.video.player.view.playlist.PlayListFrame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.awt.Component;
import java.awt.Dimension;
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

    private ConvertController controller;
    private FormatConvertController formatController;
    private String path;

    private JComboBox<String> comboType;
    private JComboBox<String> comboFormat;
    private PlayListFrame playListFrame;
    JFrame frame;

    public VideoConvertFrame(String path, PlayListFrame playListFrame) {
        formatController = new FormatConvertController(this);
        controller = new ConvertController(this, playListFrame);
        this.path = path;
        this.playListFrame = playListFrame;
        initFrame();
    }

    public void initFrame() {
        frame = FrameUtility.build("ATT Player", 0, 0, WIDTH_FRAME, HEIGHT_FRAME, true);
        frame.add(returnButon());
        frame.add(IcoLabel());
        frame.add(TxtLabel("Input : " + new File(path).getName(), 240, 150));
        frame.add(TxtLabel("Select an Output Format :", 240, 200));
        frame.add(panelFormat());
        frame.add(panelType());
        frame.add(buttonConv());
        frame.getContentPane().setBackground(UIColor.PRIMARY_BACKGROUNG_COLOR);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        Image icon = new ImageIcon(Constant.RESOURCES_IMAGES+"\\icon.png").getImage();
        frame.setIconImage(icon);

    }
    private Button returnButon() {
        Button returnButton = new Button("");
        returnButton.setIcon("back.png", 30, 30);
        returnButton.setBounds(10, 10, 45, 35);
        returnButton.addActionListener(new BackButtonController(frame, playListFrame));
        returnButton.setVisible(true);
        return returnButton;
    }

    private JLabel IcoLabel() {
        ImageIcon iconf = new ImageIcon(this.getClass().getResource("/att1.png"));
        JLabel label = new JLabel();
        label.setBounds(310, 30, 250, 150);
        label.setIcon(iconf);
        label.setVisible(true);
        return label;
    }

    private JLabel TxtLabel(String text, int posX, int posY) {
        JLabel labelT = new JLabel();
        labelT.setBounds(posX, posY, 450, 200);
        labelT.setText(text);
        labelT.setFont(UIFont.COMMON_BIGGEST);
        labelT.setForeground(UIColor.COMPONETS_COLOR);
        labelT.setVisible(true);
        return labelT;
    }

    public JButton buttonConv() {
        Button button = new Button("Convert");
        button.setBounds(POSX_BUTTON, POSY_BUTTON, WIDTH_BUTTON, HEIGHT_BUTTON);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setFont(new Font("Serif", Font.PLAIN, 25));
        button.addActionListener(controller);
        button.setVisible(true);
        return button;
    }

    public JPanel panelType() {
        comboFormat = new JComboBox();
        fillFormat((String) comboType.getSelectedItem());
        comboFormat.setFont(UIFont.COMMON_BIGGEST);
        comboFormat.setEditable(false);
        comboFormat.setBackground(UIColor.PRIMARY_BACKGROUNG_COLOR);
        comboFormat.setForeground(UIColor.COMPONETS_COLOR);
        comboFormat.setPreferredSize(new Dimension(150, 40));
        JPanel panelCombo = new JPanel();
        panelCombo.setBounds(380, 330, WIDTH_PANEL, HEIGHT_PANEL);
        panelCombo.add(comboFormat);
        panelCombo.setLayout(new FlowLayout());
        panelCombo.setOpaque(false);
        panelCombo.setVisible(true);
        return panelCombo;
    }

    public JPanel panelFormat() {
        comboType = new JComboBox();
        fillType();
        comboType.setFont(UIFont.COMMON_BIGGEST);
        comboType.setEditable(false);
        comboType.setBackground(UIColor.PRIMARY_BACKGROUNG_COLOR);
        comboType.setForeground(UIColor.COMPONETS_COLOR);
        comboType.addActionListener(formatController);
        comboType.setPreferredSize(new Dimension(150, 40));

        JPanel panelCombo = new JPanel();
        panelCombo.setBounds(190, 330, WIDTH_PANEL, HEIGHT_PANEL);
        panelCombo.add(comboType);
        panelCombo.setLayout(new FlowLayout());
        panelCombo.setOpaque(false);
        panelCombo.setVisible(true);
        return panelCombo;
    }

    public JComboBox<String> getFormat() {
        return this.comboFormat;
    }

    private void fillType() {
        comboType.addItem("Video");
        comboType.addItem("Audio");
    }

    public void fillFormat(String select) {
        comboFormat.removeAllItems();
        if (select.equals("Video")) {
            comboFormat.addItem("flv");
            comboFormat.addItem("mkv");
            comboFormat.addItem("avi");
            comboFormat.addItem("mov");
            comboFormat.addItem("mp4");
        } else if (select.equals("Audio")) {
            comboFormat.addItem("mp3");
            comboFormat.addItem("aac");
            comboFormat.addItem("ogg");
            comboFormat.addItem("flac");
            comboFormat.addItem("wma");
            comboFormat.addItem("wav");
        }
    }

    public JComboBox<String> getTypeFormat() {
        return comboType;
    }

    public String getPath() {
        return path;
    }

    public JFrame getFrame() {
        return frame;
    }
}
