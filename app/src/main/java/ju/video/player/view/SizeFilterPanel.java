package ju.video.player.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class SizeFilterPanel extends JPanel {

    public SizeFilterPanel() {
        initPanel();
        add(Box.createRigidArea(new Dimension(10, 0)));
        TextField minSizeField = new TextField("Min Size (Mb)");
        minSizeField.addKeyListener(new KeyAdapter() {
           public void keyTyped(KeyEvent e)
           {
              char caracter = e.getKeyChar();
              if(((caracter < '0') ||
                 (caracter > '9')) &&
                 (caracter != '\b'))
              {
                 e.consume();  // ignore the key event
              }
           }
        });
        add(minSizeField);
        TextField maxSizeField = new TextField("Max Size (Mb)");
        maxSizeField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e)
            {
               char caracter = e.getKeyChar();
               if(((caracter < '0') ||
                  (caracter > '9')) &&
                  (caracter != '\b'))
               {
                  e.consume();  // ignore the key event
               }
            }
         });
        add(maxSizeField);
        add(Box.createRigidArea(new Dimension(10, 0)));
    }
    

    private void initPanel() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBounds(0, 0, 200, 500);
        setBackground(new Color (64, 75, 105));
    }
    
}
