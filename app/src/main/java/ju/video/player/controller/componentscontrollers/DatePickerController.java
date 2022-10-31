package ju.video.player.controller.componentscontrollers;

import java.awt.event.ActionListener;

import javax.swing.JTextField;

import ju.video.player.view.playlist.filterspanel.DateComponentsPanel;
import ju.video.player.view.playlist.filterspanel.DatePicker;

import java.awt.event.ActionEvent;

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
