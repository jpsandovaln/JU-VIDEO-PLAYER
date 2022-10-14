package ju.video.player.view.information.list;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import ju.video.player.model.ListValidVideos;
import ju.video.player.view.videoplayer.VideoPlayerComponents.VideoFrame;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.component.MediaPlayerComponent;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

public class VideoListPanel extends JPanel {

    private static final String TITLE = " Video List";
    private static final String NAME = "Serif";
    private static final int SIZE = 12;
    private DefaultListModel<String> list;

    public VideoListPanel() {
        initialize();
        list = new DefaultListModel<String>();
        add(new JScrollPane(new JList<>(list)));
        setBackground(Color.CYAN);
    }

    private void initialize() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Font font = new Font(NAME, Font.BOLD, SIZE);
        setBorder(BorderFactory.createTitledBorder(null, TITLE, TitledBorder.LEFT, 0, font));
    }

    public void setPlayerLabel() {

        list.removeAllElements();
        for (int index = 0; index < ListValidVideos.getInstance().getVideoList().size(); index++) {
            JLabel playerNameLabel = new JLabel(ListValidVideos.getInstance().getVideoList().get(index).substring(3));
            list.addElement(playerNameLabel.getText());
        }

    }

    public void setPlayerLabel(ArrayList<String> listaArchivosmp4) {
        list.removeAllElements();
        for (int index = 0; index < listaArchivosmp4.size(); index++) {
            JLabel playerNameLabel = new JLabel(listaArchivosmp4.get(index).substring(3));
            list.addElement(playerNameLabel.getText());
        }
    }

}
