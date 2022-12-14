/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view.playlist;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

import ju.video.player.view.commons.UIColor;
import ju.video.player.view.commons.constants.Constant;
import ju.video.player.view.commons.display.FrameUtility;
import ju.video.player.view.playlist.filterspanel.FiltersPanel;
import ju.video.player.view.playlist.playlistpanel.PlayListPanel;

import java.awt.Image;
import java.awt.Component;

/**
 * It is the Frame where initialize all components of the PlayList UI
 *
 * @author Adriana Olivera
 * @version 1.0
 */

public class PlayListFrame {
    private JFrame frame;

    public PlayListFrame() {
        frame = FrameUtility.build("ATT Player", 0, 0, 850, 600, true);
        frame.setLayout(null);
        FiltersPanel filtersPanel = new FiltersPanel();
        filtersPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        frame.add(filtersPanel);
        PlayListPanel playListPanel = new PlayListPanel(this);
        playListPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        frame.add(playListPanel);

        Image icon = new ImageIcon(Constant.RESOURCES_IMAGES + "\\icon.png").getImage();
        frame.setIconImage(icon);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(UIColor.PRIMARY_BACKGROUNG_COLOR);
        frame.setResizable(false);
    }

    /**
     * @param isVisible new value for isVisible feature
     */
    public void setVisible(Boolean isVisible) {
        frame.setVisible(isVisible);
    }

    /**
     * @return current frame
     */
    public JFrame getFrame() {
        return frame;
    }

}
