package ju.video.player.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ju.video.player.view.playlist.filterspanel.FiltersPanel;

public class ApplyFilterController implements ActionListener {
    FiltersPanel panel;
    

    public ApplyFilterController(FiltersPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
