/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.includes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 *
 * @author sonya
 */
public class BeautifulScrollBar extends BasicScrollBarUI {

    private final Dimension d = new Dimension();

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return new JButton() {

            private static final long serialVersionUID = -3592643796245558676L;

            @Override
            public Dimension getPreferredSize() {
                return d;
            }
        };
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return new JButton() {

            private static final long serialVersionUID = 1L;

            @Override
            public Dimension getPreferredSize() {
                return d;
            }
        };
    }

    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
    
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
        super.paintThumb(g, c, r);
        Graphics2D g2 = (Graphics2D) g;
        JScrollBar sb = (JScrollBar) c;
        
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        Color color;
        
        if (!sb.isEnabled() || r.width > r.height) {
            return;
        } else if (isDragging) {
            color = new Color(54,10,84);
        } else if (isThumbRollover()) {
            color = new Color(101,30,149);
        } else {
            color = new Color(71,18,107);
        }
        
        g2.setPaint(color);
        g2.fillRoundRect(r.x, r.y, r.width, r.height, 10, 10);
        g2.setPaint(color);
        g2.drawRoundRect(r.x, r.y, r.width, r.height, 10, 10);
        g2.dispose();
    }

    @Override
    protected void setThumbBounds(int x, int y, int width, int height) {
        super.setThumbBounds(x, y, width, height);
        scrollbar.repaint();
    }
}