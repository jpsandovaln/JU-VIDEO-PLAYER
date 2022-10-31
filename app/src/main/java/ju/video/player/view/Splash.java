/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view;

import ju.video.player.view.commons.UIColor;
import ju.video.player.view.commons.constants.Constant;
import ju.video.player.view.commons.display.FrameUtility;
import ju.video.player.view.playlist.PlayListFrame;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Image;

/**
 * This class is responsible for running the loading screen.
 *
 * @author Jose Antonio Romay Ayarachi
 * @version 1.0
 */

public class Splash extends JFrame {
    private static final int WIDTH_FRAME = 850;
    private static final int HEIGHT_FRAME = 600;
    private static JProgressBar progressBar;
    private static JFrame frame;

    public Splash() {
        initFrame();
        try {
            for (int index = 0; index <= 100; index++) {
                progressBar.setValue(index);
                Thread.sleep(18);
            }
            frame.setVisible(false);
            new PlayListFrame();
        } catch (Exception e) {
        }

    }

    public void initFrame() {
        frame = FrameUtility.build("ATT Player", 0, 0, WIDTH_FRAME, HEIGHT_FRAME, true);
        ImageIcon icon = new ImageIcon(this.getClass().getResource("/splash5r1.gif"));
        ImageIcon iconLog = new ImageIcon(this.getClass().getResource("/att2.png"));
        progress();

        frame.add(image(icon, 220, 5, 380, 380));
        frame.add(image(iconLog, 100, 225, 600, 400));
        frame.add(progressBar);
        frame.getContentPane().setBackground(UIColor.PRIMARY_BACKGROUNG_COLOR);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        Image iconApp = new ImageIcon(Constant.RESOURCES_IMAGES + "\\icon.png").getImage();
        frame.setIconImage(iconApp);
    }

    private JLabel image(ImageIcon icono, int posX, int posY, int Width, int Height) {
        JLabel label1 = new JLabel();
        label1.setBounds(posX, posY, Width, Height);
        label1.setIcon(icono);
        label1.setVisible(true);
        return label1;
    }

    private void progress() {
        progressBar = new JProgressBar();
        progressBar.setForeground(new Color(0, 128, 128));
        progressBar.setBounds(80, 500, 700, 20);
    }

    public JFrame getFrame() {
        return frame;
    }
}
