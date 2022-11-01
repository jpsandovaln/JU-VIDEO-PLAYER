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

public class DateInitListener implements DocumentListener {
    private JTextField text;

    public void changedUpdate(DocumentEvent e) {
        setInitDateValue(e);
    }

    public void removeUpdate(DocumentEvent e) {
        setInitDateValue(e);
    }

    public void insertUpdate(DocumentEvent e) {
        setInitDateValue(e);
    }

    /**
     * Get the date of the TextField to set to the ListValidVideos Singleton class.
     *
     * @param e
     */

    public void setInitDateValue(DocumentEvent e) {
        Runnable doAssist = new Runnable() {
            @Override
            public void run() {
                String date = text.getText();

                if (date == null || date.isEmpty() || date.length() < 10) {
                    ListValidVideos.getInstance().setInitDate(null);
                    return;
                }
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                try {
                    // convert String to LocalDate
                    LocalDate localDate = LocalDate.parse(date, formatter);
                    ListValidVideos.getInstance().setInitDate(localDate);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Initial date is invalid");
                    text.setText("");
                    ListValidVideos.getInstance().setInitDate(null);
                }
            }
        };
        SwingUtilities.invokeLater(doAssist);
    }

    public void setText(JTextField text) {
        this.text = text;
    }
}
