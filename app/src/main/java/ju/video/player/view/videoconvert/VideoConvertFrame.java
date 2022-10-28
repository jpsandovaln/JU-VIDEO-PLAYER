package ju.video.player.view.videoconvert;

import javax.swing.JPanel;

import ju.video.player.controller.ConvertController;
import ju.video.player.view.commons.Colors;
import ju.video.player.view.materialDesing.components.utils.RoundedBorder;
import ju.video.player.view.materialDesing.display.FrameUtility;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;

public class VideoConvertFrame extends JFrame {

    private static final int WIDTH_FRAME = 850;
    private static final int HEIGHT_FRAME = 600;
    private static final int WIDTH_PANEL = 260;
    private static final int HEIGHT_PANEL = 50;

    private static final int POSX_BUTTON = 300;
    private static final int POSY_BUTTON = 300;
    private static final int WIDTH_BUTTON = 260;
    private static final int HEIGHT_BUTTON = 50;
    private static final int RADIUS_BUTTON = 20;

    private JLabel comboLabel;
    private JComboBox<String> comboFormat;
    private ConvertController controller;
    private String path;

    public String getPath() {
        return path;
    }

    public VideoConvertFrame(String path) {
        controller = new ConvertController(this);
        this.path = path;
        initFrame();
    }

    public void initFrame() {
        JFrame frame = FrameUtility.build("ATT Player", 0, 0, WIDTH_FRAME, HEIGHT_FRAME, true);
        JButton btnV = buttonConv();

        frame.add(btnV);
        frame.add(panelSelect());
        frame.getContentPane().setBackground(Colors.PRIMARY_BACKGROUNG_COLOR);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        btnV.addActionListener(controller);

    }

    public JButton buttonConv() {
        JButton button = new JButton();
        RoundedBorder border = new RoundedBorder(RADIUS_BUTTON);

        button.setBorder(border);
        button.setBounds(POSX_BUTTON, POSY_BUTTON, WIDTH_BUTTON, HEIGHT_BUTTON);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setText("Convert");
        button.setBackground(Colors.PRIMARY_COLOR);

        button.setVisible(true);
        return button;

    }

    public JPanel panelSelect() {

        String[] formats = {"avi", "mkv", "flv" };

        comboFormat = new JComboBox<String>(formats);
        comboFormat.setEditable(false);
        comboFormat.addItemListener(null);

        comboLabel = new JLabel("Select One Format ");
        comboLabel.setForeground(Color.WHITE);

        JPanel panelCombo = new JPanel();
        panelCombo.setBounds(0, 0, WIDTH_PANEL, HEIGHT_PANEL);
        panelCombo.add(comboLabel);
        panelCombo.add(comboFormat);
        panelCombo.setLayout(new FlowLayout());
        panelCombo.setOpaque(false);
        panelCombo.setVisible(true);
        return panelCombo;
    }

    public JComboBox<String> getFormat() {
        return this.comboFormat;
    }

}
