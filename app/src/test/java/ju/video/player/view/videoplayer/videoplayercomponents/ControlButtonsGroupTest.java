/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprietary information of Jala University
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Jala University
 */
package ju.video.player.view.videoplayer.videoplayercomponents;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ju.video.player.view.videoplayer.MediaPlayerFrame;
import ju.video.player.view.videoplayer.VideoPlayerPanel;
import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtonsGroup;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaListPlayerComponent;

/**
 * This test is responsible for test ControlButtonsGroup class
 *
 * @author Sergio A. Lema Estevez
 * @version 1.0
 */

public class ControlButtonsGroupTest {

    @Test
    public void shouldInitControlButtonsGroup() {
        EmbeddedMediaListPlayerComponent embeddedMediaListPlayerComponent = new EmbeddedMediaListPlayerComponent();
        MediaPlayerFrame mediaPlayerFrame = new MediaPlayerFrame(null, embeddedMediaListPlayerComponent);
        VideoPlayerPanel videoPlayerPanel = new VideoPlayerPanel(mediaPlayerFrame);
        ControlButtonsGroup controlButtonsGroup = new ControlButtonsGroup(videoPlayerPanel);
        assertEquals(6, controlButtonsGroup.getComponentCount());
    }

}
