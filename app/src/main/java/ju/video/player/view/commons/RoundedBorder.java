package ju.video.player.view.commons;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.AbstractButton;

class RoundedBorder extends BasicButtonUI {      
      
    public RoundedBorder() {
        super();
    }
      
    public void roundButton(JButton button){
        button.setBorderPainted(false);
    }
      
    @Override
    public void paint(Graphics g, JComponent c) {
        Graphics2D g2d = (Graphics2D) g;
        Shape buttonShape = null;
        buttonShape = new RoundRectangle2D.Double(0, 0, c.getWidth() , c.getHeight(), 10, 10);
        g2d.setPaint(Colors.PRIMARY_COLOR);
        g2d.fill(buttonShape);
        super.paint(g2d, c);
    }
    
    @Override
    protected void paintButtonPressed(Graphics g, AbstractButton b) {
        Graphics2D g2d = (Graphics2D) g;
        Shape buttonShape = null;
        buttonShape = new RoundRectangle2D.Double(0, 0, b.getWidth(), b.getHeight(), 10, 10);
        g2d.setPaint(Colors.SECONDARY_COLOR);
        g2d.fill(buttonShape);
    }
}
