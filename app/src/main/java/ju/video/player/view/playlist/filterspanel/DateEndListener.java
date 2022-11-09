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

import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * It gets the value f the Text field to apply the date filter
 *
 * @author Maria Hurtado
 * @version 1.0
 */
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
        Runnable doAssist = new Runnable() {
            @Override
            public void run() {
                // init
                String date = text.getText();
                if (date == null || date.isEmpty() || date.length() < 10) {
                    ListValidVideos.getInstance().setInitDate(null);
                    return;
                }
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                try {
                    // convert String to LocalDate
                    LocalDate localDate = LocalDate.parse(date, formatter);
                    ListValidVideos.getInstance().setEndDate(localDate);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Final date is invalid");
                    ListValidVideos.getInstance().setEndDate(null);
                }
                // end
            }
        };
        SwingUtilities.invokeLater(doAssist);
    }
}
