package ju.video.player.view;
import ju.video.player.controller.ButtonControler;
import ju.video.player.view.information.list.VideoListPanel;
import ju.video.player.view.information.search.FolderChooserButton;
import ju.video.player.view.information.search.SearchPanel;
import ju.video.player.view.materialDesing.ResponsiveSwingMaterialDesign;
import ju.video.player.view.materialDesing.callback.CallbackT;
import ju.video.player.view.materialDesing.components.buttons.MaterialButton;
import ju.video.player.view.materialDesing.components.date.fields.DateField;
import ju.video.player.view.materialDesing.components.image.ImageLabel;
import ju.video.player.view.materialDesing.components.input.TextArea;
import ju.video.player.view.materialDesing.components.utils.ImageRoundedBorder;
import ju.video.player.view.materialDesing.display.FrameUtility;
import ju.video.player.view.materialDesing.layouts.ResponsiveLayout;
import javax.swing.JFrame;
public class MetaDataFrame {
    public static void main(String[] args) {

        JFrame frame = FrameUtility.build("Video player", 0, 0, 500, 500, true);

        ResponsiveLayout rl = new ResponsiveLayout(10, 4, frame);
        ImageLabel imageLabel = new ImageLabel("\\image.png", rl, 120, 120, 120);

        ImageRoundedBorder roundedBorder = new ImageRoundedBorder(120, ResponsiveSwingMaterialDesign.PRIMARY_COLOR);
        roundedBorder.setStroke(2);

        imageLabel.setBorder(roundedBorder);

        rl.add(imageLabel.getComponent(), 4, 1, ResponsiveLayout.ResponsiveConstants.CENTER);
        TextArea textArea = new TextArea("File size", rl);
        rl.add(textArea.getComponent(), 4, 1);
        DateField date = new DateField("Date", rl);
        rl.add(date.setRequired(false).getComponent(), 4, 1);
        FolderChooserButton button = new FolderChooserButton(new VideoListPanel(), frame, textArea, date);
        rl.add(button, 2, 0.5, ResponsiveLayout.ResponsiveConstants.CENTER);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
