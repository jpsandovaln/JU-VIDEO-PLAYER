/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view.playlist.playlistpanel;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;

import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.border.TitledBorder;

import ju.video.player.model.ListValidVideos;
import ju.video.player.view.commons.UIColor;
import ju.video.player.view.playlist.PlayListFrame;

import java.awt.Dimension;
import java.awt.Component;
import java.awt.Font;

public class VideoListPanel extends JPanel {

    private static final String TITLE = " Video List";
    private static final String NAME = "Arial";
    private static final int SIZE = 12;

    private PlayListFrame playListFrame;

    public VideoListPanel(PlayListFrame playListFrame) {
        this.playListFrame = playListFrame;
        initialize();
        add(Box.createRigidArea(new Dimension(700, 470))); 
    }

    private void initialize() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        Font font = new Font(NAME, Font.BOLD, SIZE);
        setBackground(UIColor.PRIMARY_BACKGROUNG_COLOR);
        setForeground(UIColor.COMPONETS_COLOR);
        setBorder(BorderFactory.createTitledBorder(null, TITLE, TitledBorder.LEFT, 0, font, UIColor.COMPONETS_COLOR));
    }

    public void setPlayerLabel() {
        removeAll();
        for (int index = 0; index < ListValidVideos.getInstance().getVideoList().size(); index++) {
            MediaPanel mediaPanel = new MediaPanel(ListValidVideos.getInstance().getVideoList().get(index), index, playListFrame);
            mediaPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            add(mediaPanel);
        }
        Component box = Box.createRigidArea(new Dimension(700, 0));
        ((JComponent) box).setAlignmentX(Component.LEFT_ALIGNMENT);
        add(box);
        updateUI();
    }
}
