package ju.video.player.view.information.list;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import ju.video.player.model.ListValidVideos;
import ju.video.player.view.playlist.Colors;
import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.component.MediaPlayerComponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;

public class VideoListPanel extends JPanel {

    private static final String TITLE = " Video List";
    private static final String NAME = "Serif";
    private static final int SIZE = 12;
    //private DefaultListModel<String> list;

    public VideoListPanel() {
        initialize();
        add(Box.createRigidArea(new Dimension(700, 470)));
        //list = new DefaultListModel<String>();
        //add(new JScrollPane(new JList<>(list)));
       
    }

    private void initialize() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        Font font = new Font(NAME, Font.BOLD, SIZE);
        setBackground(Colors.PRIMARY_BACKGROUNG_COLOR);
        setForeground(Colors.COMPONETS_COLOR);
        setBorder(BorderFactory.createTitledBorder(null, TITLE, TitledBorder.LEFT, 0, font));
    }

    public void setPlayerLabel() {
        removeAll();
        for (int index = 0; index < ListValidVideos.getInstance().getVideoList().size(); index++) {
            MediaPanel mediaPanel = new MediaPanel(ListValidVideos.getInstance().getVideoList().get(index).substring(3));
            //mediaPanel.setLabel();
            mediaPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            add(mediaPanel);
        }
        Component box = Box.createRigidArea(new Dimension(700, 0));
        ((JComponent) box).setAlignmentX(Component.LEFT_ALIGNMENT);
        add(box);
    }

    public void setPlayerLabel(ArrayList<String> listaArchivosmp4) {
        removeAll();
        for (int index = 0; index < listaArchivosmp4.size(); index++) {
            MediaPanel MediaPanel = new MediaPanel(listaArchivosmp4.get(index).substring(3));
            add(MediaPanel);
        }
    }

}
