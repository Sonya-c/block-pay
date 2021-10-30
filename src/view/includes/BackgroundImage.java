package view.includes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundImage extends JPanel {

    private Image image;
    
    public BackgroundImage(String path) {
        image = (new ImageIcon(getClass().getResource(path))).getImage();
    }

@Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);

        if (imageWidth <= 0 || imageHeight <= 0) {
            return;
        }
        
        double widthScale = (double)getWidth() / (double)imageWidth;
        double heightScale = (double)getHeight() / (double)imageHeight;
        
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setBackground(Color.white);
        g2.drawImage(image, AffineTransform.getScaleInstance(widthScale, heightScale), this);
        g2.dispose();
    }

}