/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view.playlist.filterspanel;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import ju.video.player.model.ListValidVideos;
import ju.video.player.view.commons.Colors;
import ju.video.player.view.commons.TextField;

public class SizeFilterPanel extends JPanel {

    public SizeFilterPanel() {
        initPanel();
        add(Box.createRigidArea(new Dimension(10, 0)));
        TextField minSizeField = new TextField("Min Size (Mb)");
        minSizeField.setBackground(Colors.SECONDARY_BACKGROUNG_COLOR);
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
        minSizeField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                setFileSizeValue();
            }
            public void removeUpdate(DocumentEvent e) {
                setFileSizeValue();
            }
            public void insertUpdate(DocumentEvent e) {
                setFileSizeValue();
            }

            public void setFileSizeValue() {
                String text = minSizeField.getText();
                double value = Double.parseDouble(text);
                ListValidVideos.getInstance().setMinFileSize(value);
            }
        });
        add(minSizeField);
        TextField maxSizeField = new TextField("Max Size (Mb)");
        maxSizeField.setBackground(Colors.SECONDARY_BACKGROUNG_COLOR);
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

        maxSizeField.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                setFileSizeValue();
            }
            public void removeUpdate(DocumentEvent e) {
                setFileSizeValue();
            }
            public void insertUpdate(DocumentEvent e) {
                setFileSizeValue();
            }

            public void setFileSizeValue() {
                String text = maxSizeField.getText();
                double value = Double.parseDouble(text);
                ListValidVideos.getInstance().setMaxFileSize(value);
            }
        });

        add(maxSizeField);
        add(Box.createRigidArea(new Dimension(10, 0)));
    }
    

    private void initPanel() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setBounds(0, 0, 200, 500);
        setOpaque(false);
    }
    
}
