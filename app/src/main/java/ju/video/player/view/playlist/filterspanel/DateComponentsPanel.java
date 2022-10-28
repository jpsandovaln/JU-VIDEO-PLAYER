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
import java.awt.Image;
import java.awt.BorderLayout;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.BoxLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ju.video.player.controller.DatePickerController;
import ju.video.player.view.commons.Button;
import ju.video.player.view.commons.Colors;
import ju.video.player.view.commons.Fonts;
import ju.video.player.view.materialDesing.constants.Constants;

public class DateComponentsPanel extends JPanel {

    public DateComponentsPanel(String title) throws ParseException {
        initPanel();
        JLabel label = new JLabel(title);
        label.setFont(Fonts.COMMON_FONT);
        label.setForeground(Colors.COMPONETS_COLOR);
		JTextField text = new JTextField(20);
		Button buttonIcon = new Button("");
        buttonIcon.setIcon("calendar-icon.png", 20, 20);
		buttonIcon.addActionListener(new DatePickerController(this, text));
		
        //add(Box.createRigidArea(new Dimension(5, 0)));
        add(label, BorderLayout.WEST);
        //add(Box.createRigidArea(new Dimension(10, 0)));
		add(text, BorderLayout.CENTER);
		add(buttonIcon, BorderLayout.EAST);
        //add(Box.createRigidArea(new Dimension(10, 0)));
        
    }
    private void initPanel() {
        setLayout(new BorderLayout());
        setBounds(0, 0, 200, 500);
        setOpaque(false);
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }

}
