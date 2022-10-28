package ju.video.player.view.videoconvert;

import javax.swing.JPanel;

import ju.video.player.controller.ConvertController;
import ju.video.player.view.commons.Colors;
import ju.video.player.view.materialDesing.components.utils.RoundedBorder;
import ju.video.player.view.materialDesing.display.FrameUtility;

import javax.swing.JButton;
import javax.swing.*;
import java.awt.*;

public class VideoConvertFrame extends JFrame{
    // frame
    static JFrame f;

    // label
    static JLabel l, l1, l3, l4;
    //

    
    // combobox
    private JComboBox c1;
    private ConvertController controller;
    private String path;
    private String format;

    public String getPath() {
        return path;
    }


    public VideoConvertFrame(String path) {
        controller = new ConvertController(this);
        this.path = path;
        initFrame();
    }

    public void initFrame() {
        JFrame frame = FrameUtility.build("ATT Player", 0, 0, 850, 600, true);
        
        JButton btnV= buttonConv();
        // btnV.addActionListener(ActionListener listener);
        
        frame.add(btnV);
        frame.add(panelSelect());
        frame.getContentPane().setBackground(Colors.PRIMARY_BACKGROUNG_COLOR);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        btnV.addActionListener(controller);

    }

    public JButton buttonConv() {
        JButton Button = new JButton();
        RoundedBorder border = new RoundedBorder(20);

        Button.setBorder(border);
        Button.setBounds(300, 300, 260, 50);
        Button.setAlignmentX(Component.CENTER_ALIGNMENT);
        Button.setText("Convert");
        Button.setBackground(Colors.PRIMARY_COLOR);
       
        Button.setVisible(true);
        return Button;

    }

    public JPanel panelSelect() {

        String s1[] = { "avi", "mkv", "flv" };;
        c1 = new JComboBox(s1);
        c1.setEditable(false);
        this.format=c1.getSelectedItem()+"";
        c1.addItemListener(null);
        // System.out.println(c1.getSelectedItem()+"");

        l = new JLabel("Select One Format ");
        l.setForeground(Color.WHITE);

        JPanel p = new JPanel();
        p.setBounds(0, 0, 260, 50);
        p.add(l);
        p.add(c1);
        p.setLayout(new FlowLayout());
        p.setOpaque(false);
        p.setVisible(true);
        return p;
    }

    public JComboBox getFormat()
    {
            return this.c1;
    }

}
