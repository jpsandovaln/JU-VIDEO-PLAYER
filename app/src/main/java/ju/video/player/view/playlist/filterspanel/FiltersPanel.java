package ju.video.player.view.playlist.filterspanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

<<<<<<< HEAD
import ju.video.player.model.ListValidVideos;
=======
import ju.video.player.controller.ApplyFilterController;
>>>>>>> ui/JU-VideoPlayer/jose/integration_UI
import ju.video.player.view.commons.Button;
import ju.video.player.view.commons.SubtitleLabel;
import ju.video.player.view.commons.TitleLabel;

import javax.swing.JComponent;

public class FiltersPanel extends JPanel {

    public FiltersPanel() throws ParseException {
		initPanel();
        SizeFilterPanel sizeFilterPanel = new SizeFilterPanel();
        DateFilterPanel dateFilterPanel = new DateFilterPanel();
        Button applyFiltersButton = new Button("Apply Filters");
        Component box = Box.createRigidArea(new Dimension(250, 600));
        ((JComponent) box).setAlignmentX(Component.LEFT_ALIGNMENT);
        applyFiltersButton.addActionListener(new ApplyFilterController(this));
        
        add(new TitleLabel("Filters"));
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new SubtitleLabel("File Size"));
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(sizeFilterPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(new SubtitleLabel("Creation Date"));
        add(Box.createRigidArea(new Dimension(0, 5)));
        add(dateFilterPanel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        Button applyFiltersButton = new Button("Apply Filters");
        applyFiltersButton.addActionListener(e -> ListValidVideos.getInstance().applyFilters());
        add(applyFiltersButton);
        add(box);
    }

    private void initPanel() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBounds(0, 0, 250, 600);
        setBackground(new Color (64, 75, 105));
        setAlignmentY(Component.TOP_ALIGNMENT);
    }

}
