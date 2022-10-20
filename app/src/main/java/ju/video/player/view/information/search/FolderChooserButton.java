package ju.video.player.view.information.search;

import javax.swing.JButton;

import ju.video.player.controller.ButtonControler;
import ju.video.player.view.information.list.VideoListPanel;
import ju.video.player.view.materialDesing.callback.CallbackT;
import ju.video.player.view.materialDesing.components.buttons.MaterialButton;
import ju.video.player.view.materialDesing.layouts.ResponsiveLayout;

import java.awt.Dimension;

public class FolderChooserButton extends MaterialButton {

    public FolderChooserButton(VideoListPanel panelSouth, String text, ResponsiveLayout responsiveLayout, CallbackT eventCallback) {
        super(text, responsiveLayout, eventCallback);
        //setSize(new Dimension(200,200));
        //addActionListener(new ButtonControler(panelSouth));
    }
}
