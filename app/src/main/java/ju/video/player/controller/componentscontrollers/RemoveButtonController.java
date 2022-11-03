package ju.video.player.controller.componentscontrollers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import ju.video.player.model.ListValidVideos;
import ju.video.player.model.MediaList;

public class RemoveButtonController implements ActionListener {
    private File file;

    public RemoveButtonController(File file) {
        this.file = file;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MediaList.removeFile(file);
        ListValidVideos.getInstance().applyFilters();
    }

}
