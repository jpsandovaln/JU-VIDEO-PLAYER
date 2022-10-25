package ju.video.player.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FiltersPanel extends JPanel {

    public FiltersPanel() {
        JLabel title = new JLabel("Filters");
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBounds(0, 0, 200, 500);
        add(new JLabel("Filters"));
        add(Box.createRigidArea(new Dimension(250, 600)));
        setBackground(new Color(0,255,204));
    }

}
