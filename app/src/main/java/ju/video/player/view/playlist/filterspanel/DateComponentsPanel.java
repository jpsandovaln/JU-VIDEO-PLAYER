/**
 * Copyright (c) 2022 Jala University.
 * 
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */

package ju.video.player.view.playlist.filterspanel;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.DocumentListener;

import ju.video.player.controller.componentscontrollers.DatePickerController;
import ju.video.player.view.commons.Button;
import ju.video.player.view.commons.TextField;
import ju.video.player.view.commons.UIColor;
import ju.video.player.view.commons.UIFont;

/**
 * It is the Panel of the Date Picker for filter the files
 *
 * @author Adriana Olivera
 * @version 1.0
 */

public class DateComponentsPanel extends JPanel {
    final TextField text = new TextField("");

    public DateComponentsPanel(String title, DateInitListener dateInitListener) throws ParseException {
        text.setTitle(title);
        dateInitListener.setText(text);
        initDateComponentsPanel(title, dateInitListener);
    }

    public DateComponentsPanel(String title, DateEndListener dateEndListener) throws ParseException {
        text.setTitle(title);
        dateEndListener.setText(text);
        initDateComponentsPanel(title, dateEndListener);
    }

    public void initDateComponentsPanel(String title, DocumentListener dateListener) throws ParseException {
        initPanel();
        JLabel label = new JLabel(title);
        label.setFont(UIFont.COMMON_FONT);
        label.setForeground(UIColor.COMPONETS_COLOR);
        text.setEditable(false);
        //text.setForeground(UIColor.COMPONETS_COLOR);
        text.setBackground(UIColor.SECONDARY_BACKGROUNG_COLOR);
        text.getDocument().addDocumentListener(dateListener);
        JPanel buttonPanel = new JPanel();
		Button buttonIcon = new Button("");
        buttonIcon.setIcon("/calendar-icon.png", 20, 20);
		buttonIcon.addActionListener(new DatePickerController(this, text));
        buttonPanel.setOpaque(false);
        buttonPanel.setSize(0, 20);
        //buttonPanel.add(Box.createRigidArea(new Dimension(2, 0)));
        buttonPanel.add(buttonIcon);
        buttonPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        //add(label);
		add(text, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.EAST);
    }

    /**
     * Initialize the Panel
     */
    private void initPanel() {
        setLayout(new BorderLayout());
        setSize(180, 100);
        setOpaque(false);
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}
