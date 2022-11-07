/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view.playlist.playlistpanel;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import ju.video.player.view.commons.UIColor;
import ju.video.player.view.commons.UIFont;

/**
 * It is the Scroll panel for add the elements of the playlist
 *
 * @author Adriana Olivera
 * @version 1.0
 */

public class PlayListScrollPanel extends JScrollPane {

    public PlayListScrollPanel(Component panel) {
        super(panel);
        initialize();
    }

    /**
     * Initialize the panel
     */
    private void initialize() {
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setBounds(50, 30, 300, 430);
        setBackground(UIColor.PRIMARY_BACKGROUNG_COLOR);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setBorder(BorderFactory.createTitledBorder(null, "PlayList",
                    TitledBorder.LEFT, 0, UIFont.COMMON_FONT, UIColor.COMPONETS_COLOR));
    }

    
}
