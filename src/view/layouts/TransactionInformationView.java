/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.layouts;

import controller.AccountController;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import model.list.List;
import model.system.Account;
import model.system.Transaction;
import model.system.Wallet;
import view.includes.Modal;
import view.includes.TransactionCard;
import view.includes.WrapLayout;


/**
 *
 * @author sonya
 */
public class TransactionInformationView extends javax.swing.JPanel {

    private final Account account;
    private final JFrame parent;
    private final AccountController accountController;

    /**
     * Creates new form TransactionInformationView
     *
     * @param account
     * @param accountController
     * @param parent
     */
    public TransactionInformationView(Account account, AccountController accountController, JFrame parent) {
        this.account = account;
        this.accountController = accountController;
        this.parent = parent;
        initComponents();
        
        transactionsPanel.setLayout(new WrapLayout(FlowLayout.CENTER, 30, 30));
        updateWalletsUser();
    }

    /**
     *
     * @param transactions
     */
    private void loadTransactions(List<Transaction> transactions) {
        transactionsPanel.removeAll();
        
        for (Transaction transaction : transactions) {
            transactionsPanel.add(new TransactionCard(transaction));
        }

        transactionScroll.validate();
        transactionScroll.repaint();
        transactionsPanel.validate();
        transactionsPanel.repaint();
    }

    public void updateWalletsUser() {
        for (Wallet wallet : account.getWallets()) {
            if (!existOnCombox(wallet)) {
                walletsUserCombox.addItem(wallet.getID());
            }
        }
    }

    /**
     * Método para que no se estén agregando las carteras después de que ya
     * están en el Combox
     *
     * @param wallet
     * @return
     */
    private boolean existOnCombox(Wallet wallet) {
        for (int i = 0; i < walletsUserCombox.getItemCount(); i++) {
            if (wallet.getID().equals(walletsUserCombox.getItemAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        transactionWalletNotFoundPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        headerPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        activityPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        walletsUserCombox = new javax.swing.JComboBox<>();
        transactionByIdBtn = new javax.swing.JButton();
        bodyPanel = new javax.swing.JPanel();
        transactionScroll = new javax.swing.JScrollPane();
        transactionsPanel = new javax.swing.JPanel();

        transactionWalletNotFoundPanel.setBackground(new java.awt.Color(255, 255, 255));
        transactionWalletNotFoundPanel.setMaximumSize(new java.awt.Dimension(305, 95));
        transactionWalletNotFoundPanel.setMinimumSize(new java.awt.Dimension(305, 95));
        transactionWalletNotFoundPanel.setPreferredSize(new java.awt.Dimension(305, 95));

        jLabel4.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sad-icon.png"))); // NOI18N
        jLabel4.setText("<html>¡No se encontraron transacctiones en las que  participe esta billetera!</html>");

        javax.swing.GroupLayout transactionWalletNotFoundPanelLayout = new javax.swing.GroupLayout(transactionWalletNotFoundPanel);
        transactionWalletNotFoundPanel.setLayout(transactionWalletNotFoundPanelLayout);
        transactionWalletNotFoundPanelLayout.setHorizontalGroup(
            transactionWalletNotFoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionWalletNotFoundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        transactionWalletNotFoundPanelLayout.setVerticalGroup(
            transactionWalletNotFoundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionWalletNotFoundPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        setLayout(new java.awt.BorderLayout());

        headerPanel.setBackground(new java.awt.Color(101, 30, 149));
        headerPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        headerPanel.setLayout(new java.awt.BorderLayout());

        titleLabel.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 209, 102));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        titleLabel.setText("Mis Transacciones");
        headerPanel.add(titleLabel, java.awt.BorderLayout.CENTER);

        activityPanel.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Id de la billetera");
        activityPanel.add(jLabel2);

        walletsUserCombox.setBackground(new java.awt.Color(151, 58, 168));
        walletsUserCombox.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        walletsUserCombox.setForeground(new java.awt.Color(255, 255, 255));
        walletsUserCombox.setToolTipText("Mis billeteras");
        walletsUserCombox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        walletsUserCombox.setPreferredSize(new java.awt.Dimension(150, 31));
        walletsUserCombox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                walletsUserComboxActionPerformed(evt);
            }
        });
        activityPanel.add(walletsUserCombox);

        transactionByIdBtn.setBackground(new java.awt.Color(216, 49, 91));
        transactionByIdBtn.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        transactionByIdBtn.setForeground(new java.awt.Color(255, 255, 255));
        transactionByIdBtn.setText("Buscar");
        transactionByIdBtn.setToolTipText("Buscar");
        transactionByIdBtn.setBorderPainted(false);
        transactionByIdBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        transactionByIdBtn.setFocusPainted(false);
        transactionByIdBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transactionByIdBtnMouseClicked(evt);
            }
        });
        transactionByIdBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionByIdBtnActionPerformed(evt);
            }
        });
        activityPanel.add(transactionByIdBtn);

        headerPanel.add(activityPanel, java.awt.BorderLayout.LINE_END);

        add(headerPanel, java.awt.BorderLayout.NORTH);

        bodyPanel.setBackground(new java.awt.Color(255, 255, 255));
        bodyPanel.setLayout(new java.awt.BorderLayout());

        transactionsPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout transactionsPanelLayout = new javax.swing.GroupLayout(transactionsPanel);
        transactionsPanel.setLayout(transactionsPanelLayout);
        transactionsPanelLayout.setHorizontalGroup(
            transactionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 698, Short.MAX_VALUE)
        );
        transactionsPanelLayout.setVerticalGroup(
            transactionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );

        transactionScroll.setViewportView(transactionsPanel);

        bodyPanel.add(transactionScroll, java.awt.BorderLayout.CENTER);

        add(bodyPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void transactionByIdBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionByIdBtnMouseClicked

        Wallet wallet = accountController.getWalletById((String) walletsUserCombox.getSelectedItem());
        List<Transaction> transactionByWallet = accountController.getHistorial(wallet);
        if (transactionByWallet.getSize() != 0) {
            loadTransactions(transactionByWallet);
        } else {
            Modal modal = new Modal(parent, "Sin transacciones", true, transactionWalletNotFoundPanel);
        }

    }//GEN-LAST:event_transactionByIdBtnMouseClicked

    private void transactionByIdBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionByIdBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_transactionByIdBtnActionPerformed

    private void walletsUserComboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_walletsUserComboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_walletsUserComboxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel activityPanel;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton transactionByIdBtn;
    private javax.swing.JScrollPane transactionScroll;
    private javax.swing.JPanel transactionWalletNotFoundPanel;
    private javax.swing.JPanel transactionsPanel;
    private javax.swing.JComboBox<String> walletsUserCombox;
    // End of variables declaration//GEN-END:variables
}
