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
import java.awt.BorderLayout;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

import ju.video.player.controller.componentscontrollers.DatePickerController;
import ju.video.player.view.commons.Button;
import ju.video.player.view.commons.UIColor;
import ju.video.player.view.commons.UIFont;

/**
 * It is the Panel of the Date Picker for filter the files
 *
 * @author Adriana Olivera
 * @version 1.0
 */

public class DateComponentsPanel extends JPanel {
    final JTextField text = new JTextField(20);

    public DateComponentsPanel(String title, DateInitListener dateInitListener) throws ParseException {
        dateInitListener.setText(text);
        initDateComponentsPanel(title, dateInitListener);
    }

    public DateComponentsPanel(String title, DateEndListener dateEndListener) throws ParseException {
        dateEndListener.setText(text);
        initDateComponentsPanel(title, dateEndListener);
    }

    public void initDateComponentsPanel(String title, DocumentListener dateListener) throws ParseException {
        initPanel();
        JLabel label = new JLabel(title);
        label.setFont(UIFont.COMMON_FONT);
        label.setForeground(UIColor.COMPONETS_COLOR);
        text.getDocument().addDocumentListener(dateListener);
		Button buttonIcon = new Button("");
        buttonIcon.setIcon("calendar-icon.png", 20, 20);
		buttonIcon.addActionListener(new DatePickerController(this, text));
        add(label, BorderLayout.WEST);
		add(text, BorderLayout.CENTER);
		add(buttonIcon, BorderLayout.EAST);
    }

    /**
     * Initialize the Panel
     */
    private void initPanel() {
        setLayout(new BorderLayout());
        setBounds(0, 0, 200, 500);
        setOpaque(false);
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}
