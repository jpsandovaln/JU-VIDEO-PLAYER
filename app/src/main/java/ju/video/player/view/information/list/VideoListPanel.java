package ju.video.player.view.information.list;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Font;

public class VideoListPanel extends JPanel {

    private static final String TITLE = " Video List";
    private static final String NAME = "Serif";
    private static final int SIZE = 12;

    public VideoListPanel() {

        JLabel videoNameLabel = new VideoLabel("ThisIsAMp4Video.mp4");
        JLabel videoNameLabel1 = new VideoLabel("ThisIsAMp3Video.mp3");
        JLabel videoNameLabel2 = new VideoLabel("ThisIsAMkvVideo.mkv");
        JLabel videoNameLabel3 = new VideoLabel("ThisIsAMovVideo.mov");

        initialize();
        var list = new DefaultListModel<String>();

        list.addElement(videoNameLabel.getText());
        list.addElement(videoNameLabel1.getText());
        list.addElement(videoNameLabel2.getText());
        list.addElement(videoNameLabel3.getText());
        list.addElement(videoNameLabel.getText());
        list.addElement(videoNameLabel.getText());
        list.addElement(videoNameLabel1.getText());
        list.addElement(videoNameLabel2.getText());
        list.addElement(videoNameLabel3.getText());

        add(new JScrollPane(new JList<>(list)));
        setBackground(Color.CYAN);
    }

    private void initialize() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Font font = new Font(NAME, Font.BOLD, SIZE);
        setBorder(BorderFactory.createTitledBorder(null, TITLE, TitledBorder.LEFT, 0, font));
    }
}
