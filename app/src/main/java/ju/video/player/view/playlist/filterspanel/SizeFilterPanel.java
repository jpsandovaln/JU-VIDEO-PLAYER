/**
 * Copyright (c) 2022 Jala University.
 * <p>
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */

package ju.video.player.view.playlist.filterspanel;

import ju.video.player.model.ListValidVideos;
import ju.video.player.view.commons.UIColor;
import ju.video.player.view.commons.TextField;

import javax.swing.JPanel;
import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.BoxLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * It is the panel where the size filters textfields are
 *
 * @author Adriana Olivera Ordoñez
 * @version 1.0
 */
public class SizeFilterPanel extends JPanel {

    public SizeFilterPanel() {
        initPanel();
        add(Box.createRigidArea(new Dimension(20, 0)));
        TextField minSizeField = new TextField("Min Size (Mb)");
        minSizeField.setBackground(UIColor.SECONDARY_BACKGROUNG_COLOR);
        minSizeField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') ||
                        (caracter > '9')) &&
                        (caracter != '\b')) {
                    e.consume();
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
                Runnable doAssist = new Runnable() {
                    @Override
                    public void run() {
                        String text = minSizeField.getText();
                        if (text == null || text.isEmpty()) {
                            ListValidVideos.getInstance().setMaxFileSize(0);
                            return;
                        }
                        try {
                            double value = Double.parseDouble(text);
                            ListValidVideos.getInstance().setMinFileSize(value);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Minimum Size is invalid");
                            ListValidVideos.getInstance().setMinFileSize(0);
                            minSizeField.setText("");
                        }
                    }
                };
                SwingUtilities.invokeLater(doAssist);
            }
        });

        add(minSizeField);

        TextField maxSizeField = new TextField("Max Size (Mb)");
        maxSizeField.setBackground(UIColor.SECONDARY_BACKGROUNG_COLOR);
        maxSizeField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char caracter = e.getKeyChar();
                if (((caracter < '0') ||
                        (caracter > '9')) &&
                        (caracter != '\b')) {
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
                Runnable doAssist = new Runnable() {
                    @Override
                    public void run() {
                        String text = maxSizeField.getText();
                        if (text == null || text.isEmpty()) {
                            ListValidVideos.getInstance().setMaxFileSize(0);
                            return;
                        }
                        try {
                            double value = Double.parseDouble(text);
                            ListValidVideos.getInstance().setMaxFileSize(value);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Maximum Size is invalid");
                            ListValidVideos.getInstance().setMaxFileSize(0);
                            maxSizeField.setText("");
                        }
                    }
                };
                SwingUtilities.invokeLater(doAssist);
            }
        });
        add(maxSizeField);
        add(Box.createRigidArea(new Dimension(10, 0)));
    }

    /**
     * Initialize the panel
     */
    private void initPanel() {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setSize(200, 500);
        setOpaque(false);
    }

}
