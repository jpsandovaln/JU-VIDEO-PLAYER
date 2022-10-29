/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view.playlist.filterspanel;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;

public class DateFilterPanel extends JPanel {
    public DateFilterPanel() throws ParseException {
        initPanel();
        DateInitListener dateInitListener = new DateInitListener();
        DateEndListener dateEndListener = new DateEndListener();
        DateComponentsPanel initDatePanel = new DateComponentsPanel("Initial date", dateInitListener);
        add(initDatePanel);
        Component box = Box.createRigidArea(new Dimension(0, 5));
        ((JComponent) box).setAlignmentX(Component.LEFT_ALIGNMENT);
        add(box);
        DateComponentsPanel finalDatePanel = new DateComponentsPanel("Final date", dateEndListener);
        add(finalDatePanel);
    }

    private void initPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBounds(0, 0, 200, 500);
        setOpaque(false);
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}
