/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view.commons;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * It creates a JLabel with the caracteristics of a Subtitle.
 *
 * @author Adriana Olivera Ordoñez
 * @version 1.0
 */

public class SubtitleLabel extends JLabel {
    private static final int FONT_STYLE = 1;
    private static final int FONT_SIZE = 18;

    public SubtitleLabel(String title) {
        super(title, SwingConstants.LEFT);
        setFont(new Font("Arial", FONT_STYLE, FONT_SIZE));
        setForeground(new Color(219, 237, 243));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setVisible(true);
    }
    

}
