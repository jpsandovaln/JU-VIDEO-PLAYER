/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view.playlist.playlistpanel;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JComponent;

import ju.video.player.model.ListValidVideos;
import ju.video.player.view.commons.UIColor;
import ju.video.player.view.playlist.PlayListFrame;

import java.awt.Dimension;
import java.awt.Component;

public class VideoListPanel extends JPanel {

    private PlayListFrame playListFrame;

    public VideoListPanel(PlayListFrame playListFrame) {
        this.playListFrame = playListFrame;
        initialize();
        Component box = Box.createRigidArea(new Dimension(700, 430));
        ((JComponent) box).setAlignmentX(Component.LEFT_ALIGNMENT);
        add(box);
    }

    private void initialize() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setSize(700, 430);
        setBounds(50, 30, 300, 430);
        setBackground(UIColor.PRIMARY_BACKGROUNG_COLOR);
        setForeground(UIColor.COMPONETS_COLOR);
    }

    public void setPlayerLabel() {
        removeAll();
        for (int index = 0; index < ListValidVideos.getInstance().getVideoList().size(); index++) {
            MediaPanel mediaPanel = new MediaPanel(ListValidVideos.getInstance().getVideoList().get(index), index, playListFrame);
            mediaPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            add(mediaPanel);
        }
        setSize(700, 600);
        updateUI();
    }
}
