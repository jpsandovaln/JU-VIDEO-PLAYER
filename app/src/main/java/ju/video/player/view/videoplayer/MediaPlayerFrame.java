/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view.videoplayer;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Image;

import ju.video.player.view.materialDesing.constants.Constant;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;


public class MediaPlayerFrame extends JFrame {
    EmbeddedMediaListPlayerComponent mediaComponent;

    public MediaPlayerFrame(EmbeddedMediaListPlayerComponent mediaComponent) {
        this.mediaComponent = mediaComponent;
        
        initialize();
        VideoPlayerPanel videoPlayerPanel = new VideoPlayerPanel(this);
        add(videoPlayerPanel, BorderLayout.CENTER);
    }
    private void initialize() {
        Image icon = new ImageIcon(Constant.RESOURCES_IMAGES+"\\icon.png").getImage();
        setIconImage(icon);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(new BorderLayout());
        setTitle("Media Player");
        setVisible(true);
    }

    public EmbeddedMediaListPlayerComponent getMediaComponent() {
        return mediaComponent;
    }
}
