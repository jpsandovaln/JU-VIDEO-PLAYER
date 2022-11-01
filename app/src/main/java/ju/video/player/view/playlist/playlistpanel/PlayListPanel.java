/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view.playlist.playlistpanel;

import java.awt.Dimension;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import ju.video.player.view.commons.TitleLabel;
import ju.video.player.view.playlist.PlayListFrame;

public class PlayListPanel extends JPanel {
    
    public PlayListPanel(PlayListFrame playListFrame) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBounds(250, 0, 585, 600);
        add(new TitleLabel("My PlayList"));
        VideoListPanel videoListPanel = new VideoListPanel(playListFrame);
        ExaminePanel examinePanel = new ExaminePanel(videoListPanel);
        add(examinePanel);
        add(videoListPanel);
        Component box = Box.createRigidArea(new Dimension(563, 673));
        ((JComponent) box).setAlignmentX(Component.LEFT_ALIGNMENT);
        add(box);
        //setBackground(new Color (40, 49, 73));
        setAlignmentY(Component.TOP_ALIGNMENT);
        setOpaque(false);
    }
}
