package ju.video.player.view.playlist.playlistpanel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import ju.video.player.controller.ButtonController;
import ju.video.player.view.commons.Button;
import ju.video.player.view.commons.TextField;

public class ExaminePanel extends JPanel {

    public ExaminePanel(VideoListPanel videoListPanel) {
        initPanel();
        TextField pathField = new TextField("Path");
        add(pathField);
        Button examineButton = new Button("Examine");
        examineButton.addActionListener(new ButtonController(videoListPanel));
        add(examineButton);
    }
    private void initPanel() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        //setBounds(0, 0, 0, 600);
        setOpaque(false);
        setAlignmentY(Component.TOP_ALIGNMENT);
    }
}
