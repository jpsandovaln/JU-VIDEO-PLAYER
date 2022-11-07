/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jala University
 */
package ju.video.player.controller.componentscontrollers;

import java.awt.event.ActionListener;

import javax.swing.JTextField;

import ju.video.player.view.playlist.filterspanel.DateComponentsPanel;
import ju.video.player.view.playlist.filterspanel.DatePicker;

import java.awt.event.ActionEvent;

/**
 * It initializes the DatePicker when user press the CalendarButton
 *
 * @author Adriana Olivera Ordoñez
 * @version 1.0
 */
public class DatePickerController implements ActionListener{
    private DateComponentsPanel panel;
    private JTextField field;
    
    public DatePickerController(DateComponentsPanel panel, JTextField field) {
        this.panel = panel;
        this.field = field;
    }

    public void actionPerformed(ActionEvent ae) {
        field.setText(new DatePicker(panel).setPickedDate());
    }
}
