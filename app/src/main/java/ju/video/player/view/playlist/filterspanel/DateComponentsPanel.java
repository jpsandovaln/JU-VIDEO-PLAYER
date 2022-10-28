/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view.playlist.filterspanel;

import java.awt.Dimension;
import java.awt.Component;
import java.awt.Image;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentListener;

import ju.video.player.controller.DatePickerController;
import ju.video.player.view.materialDesing.constants.Constants;

/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
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
        add(Box.createRigidArea(new Dimension(10, 0)));
        text.getDocument().addDocumentListener(dateListener);
        JButton b = new JButton("popup");
        add(text);
        add(b);

        b.addActionListener(new DatePickerController(this, text));
        add(Box.createRigidArea(new Dimension(10, 0)));
        JLabel calendarIcon = new JLabel();
        ImageIcon image = new ImageIcon(Constants.RESOURCES_DIRECTORY + "/components/icons/calendar-icon.png");
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
        calendarIcon.setIcon(icon);
        add(calendarIcon);
        add(Box.createRigidArea(new Dimension(10, 0)));
    }

    private void initPanel() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBounds(0, 0, 200, 500);
        setOpaque(false);
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}
