/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view.videoplayer;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.BorderLayout;

import ju.video.player.view.commons.UIColor;
import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtonsGroup;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.fullscreen.adaptive.AdaptiveFullScreenStrategy;

public class VideoPlayerPanel extends JPanel {
    private EmbeddedMediaListPlayerComponent mediaPlayerComponent;

    public VideoPlayerPanel(MediaPlayerFrame mainFrame) {
        this.mediaPlayerComponent = mainFrame.getMediaComponent();
        initialize();
        mediaPlayerComponent.mediaPlayer().fullScreen().strategy(new AdaptiveFullScreenStrategy(mainFrame));
        ControlButtonsGroup controlButtonsGroup = new ControlButtonsGroup(this);
        add(mediaPlayerComponent, BorderLayout.CENTER);
        add(controlButtonsGroup, BorderLayout.PAGE_END);
    }
    public void initialize() {
        BorderLayout borderLayout = new BorderLayout(3, 3);
        Border border = BorderFactory.createLineBorder(Color.black, 1);
        setBorder(border);
        setVisible(true);
        setLayout(borderLayout);
        setVisible(true);
        setBackground(UIColor.PRIMARY_BACKGROUNG_COLOR);
    }

    public EmbeddedMediaListPlayerComponent getMediaPlayer() {
        return mediaPlayerComponent;
    }
}
