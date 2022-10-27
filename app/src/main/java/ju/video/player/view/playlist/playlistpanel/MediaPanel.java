package ju.video.player.view.playlist.playlistpanel;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ju.video.player.controller.PlayMediaButtonController;
import ju.video.player.view.commons.Button;
import ju.video.player.view.commons.Colors;

public class MediaPanel extends JPanel{

    public MediaPanel(String mediaName, int index) {
        initPanel();
        JLabel name = new JLabel(mediaName);
        name.setForeground(Colors.COMPONETS_COLOR);
        Button playButton = new Button("");
		playButton.setIcon("/play.png", 20, 20);
        playButton.addActionListener(new PlayMediaButtonController(index));
        Button convertButton = new Button("");
        convertButton.setIcon("/convert.png", 20, 20);
		
        add(name);
        add(Box.createRigidArea(new Dimension(400 - name.getText().length()*7, 0)));
        add(playButton);
        add(Box.createRigidArea(new Dimension(5, 0)));
        add(convertButton);
    }

    public void initPanel() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBorder(BorderFactory.createLineBorder(Colors.COMPONETS_COLOR));
        setBackground(Colors.PRIMARY_BACKGROUNG_COLOR);
    }

}
