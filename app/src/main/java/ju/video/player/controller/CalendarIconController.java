package ju.video.player.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import ju.video.player.view.materialDesing.callback.CallbackT;
import ju.video.player.view.materialDesing.components.date.picker.DarkDatePicker;

public class CalendarIconController implements MouseListener {
    JTextField textField;
    private MaskFormatter maskData;
    DarkDatePicker datePicker;
    Date date;

    public CalendarIconController(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyY");
        date = null;
        try {
            date = dateFormat.parse(textField.getText());
        } catch (ParseException e1) {
            date = new Date();
        }
        datePicker = new DarkDatePicker(null, new CallbackT() {
            @Override
            public void done(Object s) {
                textField.setText(dateFormat.format(datePicker.getValue()));
                // maskData.install(textField);
            }
        });
        System.out.println(e.getSource());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
