package ju.video.player.view.playlist;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ExaminePanel extends JPanel {

    public ExaminePanel() {
        initPanel();
        TextField pathField = new TextField("Path");
        add(pathField);
        Button examineButton = new Button("Examine");
        add(examineButton);
    }
    private void initPanel() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        //setBounds(0, 0, 0, 600);
        setOpaque(false);
        setAlignmentY(Component.TOP_ALIGNMENT);
    }
}
