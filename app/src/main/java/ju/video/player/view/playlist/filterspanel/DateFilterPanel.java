/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view.playlist.filterspanel;

import java.awt.Dimension;
import java.awt.Component;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class DateFilterPanel extends JPanel {

    public DateFilterPanel() throws ParseException {
        initPanel();
        
        DateComponentsPanel initDatePanel = new DateComponentsPanel("Initial date");
        add(initDatePanel);
        Component box = Box.createRigidArea(new Dimension(0, 5));
        ((JComponent) box).setAlignmentX(Component.LEFT_ALIGNMENT);
        add(box);
        DateComponentsPanel finalDatePanel = new DateComponentsPanel("Final date");
        add(finalDatePanel);
    }
    
    private void initPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBounds(0, 0, 200, 500);
        setOpaque(false);
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}
