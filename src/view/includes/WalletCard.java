package view.includes;

import model.system.Wallet;

public class WalletCard extends javax.swing.JPanel {

    private final Wallet wallet;
    
    public WalletCard(Wallet wallet) {
        this.wallet = wallet;
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        nicknameTxt = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        moneyLabel = new javax.swing.JLabel();
        nicknameLabel = new javax.swing.JLabel();
        moneyTxt = new javax.swing.JLabel();
        idTxt = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        sendMoneyBtn = new javax.swing.JButton();
        archiveWalletBtn = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(27, 20, 100));
        setLayout(new java.awt.GridBagLayout());

        nicknameTxt.setBackground(new java.awt.Color(53, 42, 157));
        nicknameTxt.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        nicknameTxt.setForeground(new java.awt.Color(255, 255, 255));
        nicknameTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(27, 20, 100), 1, true));
        nicknameTxt.setMinimumSize(new java.awt.Dimension(60, 32));
        nicknameTxt.setPreferredSize(new java.awt.Dimension(60, 32));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        add(nicknameTxt, gridBagConstraints);

        idLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        idLabel.setForeground(new java.awt.Color(102, 204, 255));
        idLabel.setText("#ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(idLabel, gridBagConstraints);

        moneyLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        moneyLabel.setForeground(new java.awt.Color(102, 204, 255));
        moneyLabel.setText("Dinero");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(moneyLabel, gridBagConstraints);

        nicknameLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        nicknameLabel.setForeground(new java.awt.Color(102, 204, 255));
        nicknameLabel.setText("Apodo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(nicknameLabel, gridBagConstraints);

        moneyTxt.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        moneyTxt.setForeground(new java.awt.Color(255, 255, 255));
        moneyTxt.setText("00,0");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        add(moneyTxt, gridBagConstraints);

        idTxt.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        idTxt.setForeground(new java.awt.Color(255, 255, 255));
        idTxt.setText("id");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        add(idTxt, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 49;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jSeparator2, gridBagConstraints);

        sendMoneyBtn.setBackground(new java.awt.Color(236, 0, 140));
        sendMoneyBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        sendMoneyBtn.setForeground(new java.awt.Color(255, 255, 255));
        sendMoneyBtn.setText("Enviar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        add(sendMoneyBtn, gridBagConstraints);

        archiveWalletBtn.setBackground(new java.awt.Color(236, 0, 140));
        archiveWalletBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        archiveWalletBtn.setForeground(new java.awt.Color(255, 255, 255));
        archiveWalletBtn.setText("archivar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        add(archiveWalletBtn, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        add(jSeparator3, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton archiveWalletBtn;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel idTxt;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel moneyLabel;
    private javax.swing.JLabel moneyTxt;
    private javax.swing.JLabel nicknameLabel;
    private javax.swing.JTextField nicknameTxt;
    private javax.swing.JButton sendMoneyBtn;
    // End of variables declaration//GEN-END:variables
}