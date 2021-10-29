/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.includes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;
import model.list.List;
import model.system.Account;
import model.system.Block;
import model.system.Wallet;

/**
 *
 * @author sonya
 */
public class GraphView extends JPanel implements MouseWheelListener, MouseListener, MouseMotionListener {
    private final List<Account> accounts;
    private final List<Block> blocks;
    
    
    /* BEGIN Zoom and transate stuff */
    private double zoomFactor = 1;
    private double prevZoomFactor = 1;
    private boolean zoomer;
    private boolean dragger;
    private boolean released;
    private double xOffset = 0;
    private double yOffset = 0;
    private int xDiff;
    private int yDiff;
    private Point startPoint;
    /* END Zoom and transate stuff */
    
    public GraphView(List<Account> accounts, List<Block> blocks) {
        this.accounts = accounts;
        this.blocks = blocks;
        initComponent();
    }
    
    private void initComponent() {
        setCursor(new Cursor(Cursor.MOVE_CURSOR));
        addMouseWheelListener((MouseWheelListener) this);
        addMouseMotionListener((MouseMotionListener) this);
        addMouseListener((MouseListener) this);
    }
    
        
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("Calibri", Font.PLAIN, 20);
        
        g2.setFont(font);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setBackground(Color.white);
        
        /* BEGIN ZOOM AND TRANSLATE STUFF */
        if (zoomer) {
            AffineTransform at = new AffineTransform();

            double xRel = MouseInfo.getPointerInfo().getLocation().getX() - getLocationOnScreen().getX();
            double yRel = MouseInfo.getPointerInfo().getLocation().getY() - getLocationOnScreen().getY();

            double zoomDiv = zoomFactor / prevZoomFactor;

            xOffset = (zoomDiv) * (xOffset) + (1 - zoomDiv) * xRel;
            yOffset = (zoomDiv) * (yOffset) + (1 - zoomDiv) * yRel;

            at.translate(xOffset, yOffset);
            at.scale(zoomFactor, zoomFactor);
            prevZoomFactor = zoomFactor;
            g2.transform(at);
            zoomer = false;
        }

        if (dragger) {
            AffineTransform at = new AffineTransform();
            at.translate(xOffset + xDiff, yOffset + yDiff);
            at.scale(zoomFactor, zoomFactor);
            g2.transform(at);

            if (released) {
                xOffset += xDiff;
                yOffset += yDiff;
                dragger = false;
            }

        }

        /* END ZOOM AND TRANSALATE STRUFF*/
        
        paintAccount(g2);
    }
    
    public void paintAccount(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("Calibri", Font.PLAIN, 20);
        
        g2.setFont(font);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        int accountsHeight = 50;
        int accountSpacing = 100;
        int accountSize = 100;
        int accountX = 30;
        int accountY = 0;
        
        int walletX = accountSize + 90;
        int walletSize = 100;
        int walletSpacing = 100;
        int walletHeight = 0;
        
        System.out.println("view.includes.GraphView.paint account size = " + accounts.getSize());
        for (Account account : accounts) {
            
            walletHeight = accountsHeight;

            if (account.getWallets().getSize() < 1) {
                if (accountY != 0) g2.drawLine(accountX + accountSize / 2, accountY + accountSize, accountX + accountSize / 2, accountsHeight);
                
                accountY = accountsHeight;
                accountsHeight += accountSize + accountSpacing;
                
            } else {
                if (accountY != 0) g2.drawLine(accountX + accountSize / 2, accountY + accountSize, accountX + accountSize / 2,
                        accountsHeight + (int) (walletSize + walletSpacing) * account.getWallets().getSize() / 2 - accountSize / 2);
                
                accountY = accountsHeight + (int) (walletSize + walletSpacing) * account.getWallets().getSize() / 2 - accountSize / 2;
                accountsHeight += (walletSize + walletSpacing) * account.getWallets().getSize();
            }
            
            for (Wallet wallet : account.getWallets()) {
                g2.drawString("" + wallet.getID(), walletX, walletHeight);
                g2.draw(new RoundRectangle2D.Double(walletX, walletHeight, walletSize, walletSize, 50, 50));
                g2.drawLine(accountX + accountSize, accountY + accountSize / 2, walletX, walletHeight + walletSize / 2);
                
                walletHeight += walletSize + walletSpacing;
            }
            
            System.out.println("view.includes.GraphView.paint wallet size = " + account.getWallets().getSize());
            System.out.println("view.includes.GraphView.paint account y  = " + accountY);
            
            g2.draw(new RoundRectangle2D.Double(accountX, accountY, accountSize, accountSize, 50, 50));
            g2.drawString("" + account.getID(), accountX, accountY);
        }
        
    }
    
    
    /* Zoom and drag stuff */
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

        zoomer = true;

        //Zoom in
        if (e.getWheelRotation() < 0) {
            zoomFactor *= 1.1;
            repaint();
        }
        //Zoom out
        if (e.getWheelRotation() > 0) {
            zoomFactor /= 1.1;
            repaint();
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point curPoint = e.getLocationOnScreen();
        xDiff = curPoint.x - startPoint.x;
        yDiff = curPoint.y - startPoint.y;

        dragger = true;
        repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        released = false;
        startPoint = MouseInfo.getPointerInfo().getLocation();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        released = true;
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
