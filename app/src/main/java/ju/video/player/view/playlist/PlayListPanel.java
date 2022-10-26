package ju.video.player.view.playlist;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

public class PlayListPanel extends JPanel {
    
    public PlayListPanel() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBounds(250, 0, 585, 600);
        //setBounds(0, 0, 200, 500);
        add(new TitleLabel("My PlayList"));
        ExaminePanel examinePanel = new ExaminePanel();
        add(examinePanel);
        Component box = Box.createRigidArea(new Dimension(563, 673));
        ((JComponent) box).setAlignmentX(Component.LEFT_ALIGNMENT);
        add(box);
        //setBackground(new Color (40, 49, 73));
        setAlignmentY(Component.TOP_ALIGNMENT);
        setOpaque(false);
    }
}
