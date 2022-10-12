package ju.video.player.view.videoplayer.VideoPlayerComponents;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.*;

import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtons.FullScreenButton;
import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtons.NextButton;
import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtons.PauseButton;
import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtons.PlayButton;
import ju.video.player.view.videoplayer.VideoPlayerComponents.ControlButtons.PreviousButton;

import javax.swing.BorderFactory;


public class ControlButtonsGroup extends JPanel{
    public ControlButtonsGroup(){
        FlowLayout layout = new FlowLayout();
        setLayout(layout);

        add(new PlayButton());
        add(new PauseButton());
        add(new PreviousButton());
        add(new NextButton());
        add(new FullScreenButton());
        Border border = BorderFactory.createLineBorder(Color.BLUE,2);
        this.setBorder(border);
    }
}
