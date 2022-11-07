/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view.footer;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

/**
 * It creates the panel with the footer text
 *
 * @author Roberto Fernandez
 * @version 1.0
 */
public class FooterPanel extends JPanel {
    public FooterPanel() {
        add(new FooterLabel(), BorderLayout.EAST);
        setBackground(Color.GRAY);
    }
}
