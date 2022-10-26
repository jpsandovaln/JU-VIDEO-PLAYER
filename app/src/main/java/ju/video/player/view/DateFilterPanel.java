package ju.video.player.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class DateFilterPanel extends JPanel {

    public DateFilterPanel() throws ParseException {
        initPanel();
        
        DateComponentsPanel initDatePanel = new DateComponentsPanel("Initial date");
        add(initDatePanel);
        Component box = Box.createRigidArea(new Dimension(0, 5));
        ((JComponent) box).setAlignmentX(Component.LEFT_ALIGNMENT);
        add(box);
        DateComponentsPanel finalDatePanel = new DateComponentsPanel("Final date");
        add(finalDatePanel);
    }
    

    private void initPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBounds(0, 0, 200, 500);
        setBackground(new Color (64, 75, 105));
        setAlignmentX(Component.LEFT_ALIGNMENT);
    }
}
