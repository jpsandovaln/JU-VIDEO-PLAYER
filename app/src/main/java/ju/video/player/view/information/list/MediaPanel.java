package ju.video.player.view.information.list;

import java.awt.Dimension;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ju.video.player.view.playlist.Button;
import ju.video.player.view.playlist.Colors;
import uk.co.caprica.vlcj.waiter.mediaplayer.PlayingWaiter;
import ju.video.player.view.materialDesing.constants.Constants;

public class MediaPanel extends JPanel{

    public MediaPanel(String mediaName) {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBorder(BorderFactory.createLineBorder(Colors.COMPONETS_COLOR));
        setBackground(Colors.PRIMARY_BACKGROUNG_COLOR);
        JLabel name = new JLabel(mediaName);
        name.setForeground(Colors.COMPONETS_COLOR);
        Button playButton = new Button("");
		ImageIcon playImage = new ImageIcon(Constants.RESOURCES_IMAGES + "/play.png");
        Icon icon = new ImageIcon(playImage.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        playButton.setIcon(icon);
        add(name);
        System.out.println(400 - name.getText().length()*6.55);
        add(Box.createRigidArea(new Dimension(400 - name.getText().length()*7, 0)));
        add(playButton);
    }

}
