/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view.commons;

import javax.swing.BorderFactory;
import javax.swing.JFormattedTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Font;

public class TextField extends JFormattedTextField  {
    private static final String NAME = "Arial";
    private static final int SIZE = 12;

    public TextField(String name) {
        initPanel(name);
    }
    public TextField(String name, MaskFormatter mask) {
        super(mask);
        initPanel(name);
    }

    public void initPanel(String name) {
        Font font = new Font(NAME, Font.BOLD, SIZE); 
        setForeground(Colors.COMPONETS_COLOR);
        setSize(100, 14);
        setFont(font);
        setBorder(BorderFactory.createTitledBorder(null, name, TitledBorder.LEFT, 0, font, Colors.COMPONETS_COLOR));
        setBackground(Colors.PRIMARY_BACKGROUNG_COLOR);
    }
}
