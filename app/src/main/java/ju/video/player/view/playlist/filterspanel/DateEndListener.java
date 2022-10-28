/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */

package ju.video.player.view.playlist.filterspanel;

import ju.video.player.model.ListValidVideos;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateEndListener implements DocumentListener {
    private JTextField text;

    public void setText(JTextField text) {
        this.text = text;
    }

    public void changedUpdate(DocumentEvent e) {
        setEndDateValue(e);
    }

    public void removeUpdate(DocumentEvent e) {
        setEndDateValue(e);
    }

    public void insertUpdate(DocumentEvent e) {
        setEndDateValue(e);
    }

    /**
     * Get the date of the TextField to set to the ListValidVideos Singleton class.
     *
     * @param e
     */
    public void setEndDateValue(DocumentEvent e) {
        String date = text.getText();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            // convert String to LocalDate
            LocalDate localDate = LocalDate.parse(date, formatter);
            ListValidVideos.getInstance().setEndDate(localDate);
        } catch (Exception ex) {
            ListValidVideos.getInstance().setEndDate(null);
        }
    }
}
