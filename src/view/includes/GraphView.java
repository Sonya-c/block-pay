/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.includes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
public class GraphView extends JPanel {
    private final List<Account> accounts;
    private final List<Block> blocks;

    public GraphView(List<Account> accounts, List<Block> blocks) {
        this.accounts = accounts;
        this.blocks = blocks;
    }
   
    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
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
    
}
