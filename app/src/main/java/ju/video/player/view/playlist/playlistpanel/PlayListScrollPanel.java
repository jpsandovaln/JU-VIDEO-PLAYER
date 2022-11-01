package ju.video.player.view.playlist.playlistpanel;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import ju.video.player.view.commons.UIColor;
import ju.video.player.view.commons.UIFont;

public class PlayListScrollPanel extends JScrollPane {

    public PlayListScrollPanel(Component panel) {
        super(panel);
        initialize();
    }

    private void initialize() {
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        setBounds(50, 30, 300, 400);
        setBackground(UIColor.PRIMARY_BACKGROUNG_COLOR);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setBorder(BorderFactory.createTitledBorder(null, "PlayList",
                    TitledBorder.LEFT, 0, UIFont.COMMON_FONT, UIColor.COMPONETS_COLOR));
    }

    
}
