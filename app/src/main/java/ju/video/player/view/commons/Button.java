/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view.commons;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import ju.video.player.view.commons.constants.Constant;

import java.awt.Image;

/**
 * It creates a JButton with its respectives features.
 *
 * @author Adriana Olivera Ordoñez
 * @version 1.0
 */
public class Button extends JButton {

    public Button(String text) {
        super(text);
        RoundedBorder border = new RoundedBorder();
        border.roundButton(this);
        setUI(border);
        setOpaque(false);
    }

    /**
     * Set the icon of the button
     * 
     * @param path location of the image
     * @param width 
     * @param height
     */
    public void setIcon(String path, int width, int height) {
        ImageIcon convertImage = new ImageIcon(Constant.RESOURCES_IMAGES + path);
        Icon convertIcon = new ImageIcon(convertImage.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        setIcon(convertIcon);
    }
    
}
