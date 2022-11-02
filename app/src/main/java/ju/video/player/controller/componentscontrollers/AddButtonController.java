package ju.video.player.controller.componentscontrollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ju.video.player.model.ListValidVideos;
import ju.video.player.view.commons.TextField;
import ju.video.player.view.playlist.playlistpanel.VideoListPanel;

public class AddButtonController implements ActionListener {
    private TextField textField;
    private VideoListPanel playListPanel;

    public AddButtonController(VideoListPanel playListPanel, TextField textField) {
        this.playListPanel = playListPanel;
        this.textField = textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedPath = textField.getText();
        ListValidVideos.getInstance().setPathOfTheSelectedFolder(selectedPath);
        ListValidVideos.getInstance().setPlayListPanel(playListPanel);
        ListValidVideos.getInstance().applyFilters();
    }

}
