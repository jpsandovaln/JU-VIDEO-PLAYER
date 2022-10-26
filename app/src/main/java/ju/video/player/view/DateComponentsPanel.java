package ju.video.player.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Image;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import ju.video.player.view.materialDesing.constants.Constants;

public class DateComponentsPanel extends JPanel {

    public DateComponentsPanel(String title) throws ParseException {
        initPanel();
        add(Box.createRigidArea(new Dimension(10, 0)));
        MaskFormatter mask = new MaskFormatter("##-##-####");
        TextField field = new TextField(title, mask);
        add(field);
        add(Box.createRigidArea(new Dimension(10, 0)));
        JLabel calendarIcon = new JLabel();
		ImageIcon image = new ImageIcon(Constants.RESOURCES_DIRECTORY + "/components/icons/calendar-icon.png");
        Icon icon = new ImageIcon(image.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT));
        calendarIcon.setIcon(icon);
        add(calendarIcon);
        add(Box.createRigidArea(new Dimension(10, 0)));
        
    }
    private void initPanel() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBounds(0, 0, 200, 500);
        setBackground(new Color (64, 75, 105));
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }

}
