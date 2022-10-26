package ju.video.player.view.information.list;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ju.video.player.view.playlist.Colors;

public class MediaPanel extends JPanel{

    public MediaPanel(String mediaName) {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBorder(BorderFactory.createLineBorder(Colors.COMPONETS_COLOR));
        JLabel name = new JLabel(mediaName);
        add(name);
    }

}
