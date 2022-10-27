package ju.video.player.view.commons;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.AbstractButton;

class RoundedBorder extends BasicButtonUI {      
       
    public enum ButtonShape {
        ROUND,
        SQUARE,
        POLYGON
    }
      
    private ButtonShape shape;
      
    public RoundedBorder() {
        super();
    }
      
    public void setShape(JButton button){
        button.setBorderPainted(false);
        this.shape = ButtonShape.ROUND;
    }
      
    @Override
    public void paint(Graphics g, JComponent c) {
    
        Graphics2D g2d = (Graphics2D) g;
    
        // definamos las formas de nuestros botones
        Shape buttonShape = null;
        switch (shape) {
        case ROUND:
        buttonShape = new RoundRectangle2D.Double(0, 0, c.getWidth() , c.getHeight(), 10, 10);
        break;
        case SQUARE:
        buttonShape = new Rectangle(0, 0, c.getWidth(), c.getHeight());
        break;
        case POLYGON:
        int[] xPoints = {0, 0 + c.getWidth() / 3, 0 + 2 * (c.getWidth() / 3), c.getWidth(), 0 + 2 * (c.getWidth() / 3), 0 + c.getWidth() / 3};
        int[] yPoints = {c.getHeight() / 2, 0, 0, c.getHeight() / 2, c.getHeight(), c.getHeight()};
        buttonShape = new Polygon(xPoints, yPoints, 6);
        break;
        }
        g2d.setPaint(Colors.PRIMARY_COLOR);
        g2d.fill(buttonShape);
    
        super.paint(g2d, c);
    
    }
    
    @Override
    protected void paintButtonPressed(Graphics g, AbstractButton b) {
        Graphics2D g2d = (Graphics2D) g;
    
        // definamos las formas de nuestros botones
        Shape buttonShape = null;
        switch (shape) {
        case ROUND:
        buttonShape = new RoundRectangle2D.Double(0, 0, b.getWidth(), b.getHeight(), 10, 10);
        break;
        case SQUARE:
        buttonShape = new Rectangle(0, 0, b.getWidth(), b.getHeight());
        break;
        case POLYGON:
        int[] xPoints = {0, 0 + b.getWidth() / 3, 0 + 2 * (b.getWidth() / 3), b.getWidth(), 0 + 2 * (b.getWidth() / 3), 0 + b.getWidth() / 3};
        int[] yPoints = {b.getHeight() / 2, 0, 0, b.getHeight() / 2, b.getHeight(), b.getHeight()};
        buttonShape = new Polygon(xPoints, yPoints, 6);
        break;
        }
        g2d.setPaint(Colors.SECONDARY_COLOR);
        g2d.fill(buttonShape);
    }
}
