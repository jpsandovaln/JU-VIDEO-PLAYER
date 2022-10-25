package ju.video.player.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import javax.swing.JComponent;

public class FiltersPanel extends JPanel {

    public FiltersPanel() {
		initPanel();
        add(new TitleLabel("Filters"));
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new SubtitleLabel("File Size"));
        SizeFilterPanel sizeFilterPanel = new SizeFilterPanel();
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(sizeFilterPanel);
        /*DateField date = new DateField("Date");
        add(date.setRequired(false).getComponent());
        FolderChooserButton button = new FolderChooserButton(new VideoListPanel(), textArea, date);
        add(button);*/
        Component box = Box.createRigidArea(new Dimension(250, 600));
        ((JComponent) box).setAlignmentX(Component.LEFT_ALIGNMENT);
        add(box);
       
    }

    private void initPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBounds(0, 0, 200, 500);
        setBackground(new Color (64, 75, 105));
    }

}
