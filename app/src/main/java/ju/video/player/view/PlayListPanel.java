package ju.video.player.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlayListPanel extends JPanel {
    
    public PlayListPanel() {
        JLabel title = new JLabel("List");
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setSize(500, 600);
        //setBounds(0, 0, 200, 500);
        add(new JLabel("List"));
        add(Box.createRigidArea(new Dimension(584, 600)));
        setBackground(new Color(0,255,100));
    }
}
