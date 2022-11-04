/**
 * Copyright (c) 2022 Jala University.
 *
 * This software is the confidential and proprieraty information of Jalasoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * Licence agreement you entered into with Jalasoft
 */
package ju.video.player.view.commons;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.AbstractButton;
/**
 * It builds the UI border for the buttons.
 *
 * @author Adriana Olivera Ordoñez
 * @version 1.0
 */
class RoundedBorder extends BasicButtonUI {      
      
    public RoundedBorder() {
        super();
    }
      
    /**
     * Set the border of the button
     * @param button
     */
    public void roundButton(JButton button){
        button.setBorderPainted(false);
    }
      
    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        Shape buttonShape = null;
        buttonShape = new RoundRectangle2D.Double(0, 0, c.getWidth() , c.getHeight(), 10, 10);
        g2d.setPaint(UIColor.PRIMARY_COLOR);
        g2d.fill(buttonShape);
        super.paint(g2d, c);
    }
    
    @Override
    protected void paintButtonPressed(Graphics g, AbstractButton b) {
        Graphics2D g2d = (Graphics2D) g;
        Shape buttonShape = null;
        buttonShape = new RoundRectangle2D.Double(0, 0, b.getWidth(), b.getHeight(), 10, 10);
        g2d.setPaint(UIColor.SECONDARY_COLOR);
        g2d.fill(buttonShape);
    }
}