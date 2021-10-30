package view;

import controller.AccountController;
import java.awt.Color;
import java.awt.Frame;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import view.layouts.IndexView;
import view.layouts.ProfileView;
import view.layouts.WalletsView;
import view.layouts.TransactionInformationView;
import model.system.Account;
import model.list.List;

/**
 *
 * @author sonya
 */
public class MainView extends javax.swing.JFrame {

    private final Account account;
    private final AccountController accountController;

    private final List<javax.swing.JButton> buttons;
    // VIEW
    private final IndexView indexView;
    private final ProfileView profileView;
    private final WalletsView walletsView;
    private final TransactionInformationView transactionInformationView;

    private int xx;
    private int xy;
    
    public MainView(Account account, AccountController accountController) {
        this.indexView = new IndexView(this, account, accountController);
        this.profileView = new ProfileView(account);
        this.transactionInformationView = new TransactionInformationView(account, accountController, this);
        this.walletsView = new WalletsView(this, account, accountController, transactionInformationView);
        this.account = account;
        this.accountController  = accountController;
        
        initComponents();

        bodyPanel.add(indexView);

        buttons = new List<>();

        buttons.add(profileBtn);
        buttons.add(indexBtn);
        buttons.add(walletsBtn);
        buttons.add(transactionsBtn);
        setUndecorated(true);
        setIconImage((new ImageIcon(getClass().getResource("/images/logo.png"))).getImage());
    }

     /*
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        parentPanel = new javax.swing.JPanel();
        titleBar = new javax.swing.JPanel();
        gapPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        actionPanel = new javax.swing.JPanel();
        minimizateBtn = new javax.swing.JButton();
        maximixateBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();
        menuBarPanel = new javax.swing.JPanel();
        mainMenuOptionsPanel = new javax.swing.JPanel();
        profileBtn = new javax.swing.JButton();
        indexBtn = new javax.swing.JButton();
        walletsBtn = new javax.swing.JButton();
        transactionsBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();
        bodyPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Block Pay | Home");
        setExtendedState(6);
        setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        setMinimumSize(new java.awt.Dimension(800, 500));
        setName("Block Pay main Panel"); // NOI18N

        parentPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 10, 84)));
        parentPanel.setLayout(new java.awt.BorderLayout());

        titleBar.setBackground(new java.awt.Color(54, 10, 84));
        titleBar.setPreferredSize(new java.awt.Dimension(30, 30));
        titleBar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                titleBarMouseDragged(evt);
            }
        });
        titleBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                titleBarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                titleBarMousePressed(evt);
            }
        });
        titleBar.setLayout(new java.awt.BorderLayout());

        gapPanel.setMinimumSize(new java.awt.Dimension(80, 30));
        gapPanel.setOpaque(false);
        gapPanel.setPreferredSize(new java.awt.Dimension(80, 30));
        titleBar.add(gapPanel, java.awt.BorderLayout.LINE_START);

        titleLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Block Pay | Home");
        titleBar.add(titleLabel, java.awt.BorderLayout.CENTER);

        actionPanel.setOpaque(false);

        minimizateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/minimizate-icon.png"))); // NOI18N
        minimizateBtn.setBorder(null);
        minimizateBtn.setBorderPainted(false);
        minimizateBtn.setContentAreaFilled(false);
        minimizateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizateBtn.setOpaque(false);
        minimizateBtn.setPreferredSize(new java.awt.Dimension(20, 20));
        minimizateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizateBtnActionPerformed(evt);
            }
        });
        actionPanel.add(minimizateBtn);

        maximixateBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/maximizate-icon.png"))); // NOI18N
        maximixateBtn.setBorder(null);
        maximixateBtn.setBorderPainted(false);
        maximixateBtn.setContentAreaFilled(false);
        maximixateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        maximixateBtn.setOpaque(false);
        maximixateBtn.setPreferredSize(new java.awt.Dimension(20, 20));
        maximixateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maximixateBtnActionPerformed(evt);
            }
        });
        actionPanel.add(maximixateBtn);

        closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close-icon.png"))); // NOI18N
        closeBtn.setAlignmentY(0.0F);
        closeBtn.setBorder(null);
        closeBtn.setBorderPainted(false);
        closeBtn.setContentAreaFilled(false);
        closeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        closeBtn.setOpaque(false);
        closeBtn.setPreferredSize(new java.awt.Dimension(20, 20));
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });
        actionPanel.add(closeBtn);

        titleBar.add(actionPanel, java.awt.BorderLayout.LINE_END);

        parentPanel.add(titleBar, java.awt.BorderLayout.PAGE_START);

        menuBarPanel.setBackground(new java.awt.Color(255, 255, 255));
        menuBarPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(229, 226, 244), 1, true));
        menuBarPanel.setMinimumSize(new java.awt.Dimension(60, 302));
        menuBarPanel.setPreferredSize(new java.awt.Dimension(60, 500));
        menuBarPanel.setLayout(new java.awt.BorderLayout());

        mainMenuOptionsPanel.setBackground(new java.awt.Color(151, 58, 168));
        mainMenuOptionsPanel.setOpaque(false);
        mainMenuOptionsPanel.setLayout(new javax.swing.BoxLayout(mainMenuOptionsPanel, javax.swing.BoxLayout.Y_AXIS));

        profileBtn.setBackground(new java.awt.Color(255, 255, 255));
        profileBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        profileBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user-icon.png"))); // NOI18N
        profileBtn.setToolTipText("Perfil");
        profileBtn.setAlignmentY(0.0F);
        profileBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        profileBtn.setContentAreaFilled(false);
        profileBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profileBtn.setFocusPainted(false);
        profileBtn.setFocusable(false);
        profileBtn.setIconTextGap(0);
        profileBtn.setMargin(new java.awt.Insets(0, 0, 0, 0));
        profileBtn.setMaximumSize(new java.awt.Dimension(60, 60));
        profileBtn.setMinimumSize(new java.awt.Dimension(60, 60));
        profileBtn.setOpaque(true);
        profileBtn.setPreferredSize(new java.awt.Dimension(60, 60));
        profileBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileBtnActionPerformed(evt);
            }
        });
        mainMenuOptionsPanel.add(profileBtn);

        indexBtn.setBackground(new java.awt.Color(255, 209, 102));
        indexBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        indexBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home-icon.png"))); // NOI18N
        indexBtn.setToolTipText("Inicio");
        indexBtn.setAlignmentY(0.0F);
        indexBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 209, 102), 2));
        indexBtn.setContentAreaFilled(false);
        indexBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        indexBtn.setFocusPainted(false);
        indexBtn.setFocusable(false);
        indexBtn.setMaximumSize(new java.awt.Dimension(60, 60));
        indexBtn.setMinimumSize(new java.awt.Dimension(60, 60));
        indexBtn.setOpaque(true);
        indexBtn.setPreferredSize(new java.awt.Dimension(60, 60));
        indexBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indexBtnActionPerformed(evt);
            }
        });
        mainMenuOptionsPanel.add(indexBtn);

        walletsBtn.setBackground(new java.awt.Color(255, 255, 255));
        walletsBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        walletsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/wallet-icon.png"))); // NOI18N
        walletsBtn.setToolTipText("Billeteras");
        walletsBtn.setAlignmentY(0.0F);
        walletsBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        walletsBtn.setContentAreaFilled(false);
        walletsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        walletsBtn.setFocusPainted(false);
        walletsBtn.setFocusable(false);
        walletsBtn.setMaximumSize(new java.awt.Dimension(60, 60));
        walletsBtn.setMinimumSize(new java.awt.Dimension(60, 60));
        walletsBtn.setOpaque(true);
        walletsBtn.setPreferredSize(new java.awt.Dimension(60, 60));
        walletsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                walletsBtnActionPerformed(evt);
            }
        });
        mainMenuOptionsPanel.add(walletsBtn);

        transactionsBtn.setBackground(new java.awt.Color(255, 255, 255));
        transactionsBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        transactionsBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/graph-icon.png"))); // NOI18N
        transactionsBtn.setToolTipText("Transacciones");
        transactionsBtn.setAlignmentY(0.0F);
        transactionsBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        transactionsBtn.setContentAreaFilled(false);
        transactionsBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        transactionsBtn.setFocusPainted(false);
        transactionsBtn.setFocusable(false);
        transactionsBtn.setMaximumSize(new java.awt.Dimension(60, 60));
        transactionsBtn.setMinimumSize(new java.awt.Dimension(60, 60));
        transactionsBtn.setOpaque(true);
        transactionsBtn.setPreferredSize(new java.awt.Dimension(60, 60));
        transactionsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                transactionsBtnActionPerformed(evt);
            }
        });
        mainMenuOptionsPanel.add(transactionsBtn);

        menuBarPanel.add(mainMenuOptionsPanel, java.awt.BorderLayout.CENTER);

        exitBtn.setBackground(new java.awt.Color(255, 255, 255));
        exitBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        exitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close-icon.png"))); // NOI18N
        exitBtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        exitBtn.setContentAreaFilled(false);
        exitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitBtn.setFocusPainted(false);
        exitBtn.setMaximumSize(new java.awt.Dimension(60, 60));
        exitBtn.setMinimumSize(new java.awt.Dimension(55, 60));
        exitBtn.setOpaque(true);
        exitBtn.setPreferredSize(new java.awt.Dimension(55, 60));
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        menuBarPanel.add(exitBtn, java.awt.BorderLayout.PAGE_END);

        parentPanel.add(menuBarPanel, java.awt.BorderLayout.WEST);

        bodyPanel.setBackground(new java.awt.Color(245, 244, 251));
        bodyPanel.setMinimumSize(new java.awt.Dimension(740, 500));
        bodyPanel.setPreferredSize(new java.awt.Dimension(740, 500));
        bodyPanel.setLayout(new java.awt.BorderLayout());
        parentPanel.add(bodyPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(parentPanel, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(826, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void defaultButtonBorder() {
        for (javax.swing.JButton button : buttons) {
            button.setBorder(defaultBorder);
            button.setBackground(Color.white);
        }
    }
    
    private void profileBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileBtnActionPerformed
        bodyPanel.removeAll();
        defaultButtonBorder();

        bodyPanel.add(profileView);
        setTitle("Block Pay | Perfil");
        titleLabel.setText("Block Pay | Perfil");

        profileBtn.setBorder(hightlightborder);
        profileBtn.setBackground(hightlightcolor);

        bodyPanel.validate();
        bodyPanel.repaint();


    }//GEN-LAST:event_profileBtnActionPerformed

    private void indexBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indexBtnActionPerformed
        bodyPanel.removeAll();
        defaultButtonBorder();

        bodyPanel.add(indexView);
        setTitle("Block Pay | Home");
        titleLabel.setText("Block Pay | Home");
        
        indexBtn.setBorder(hightlightborder);
        indexBtn.setBackground(hightlightcolor);

        bodyPanel.validate();
        bodyPanel.repaint();
    }//GEN-LAST:event_indexBtnActionPerformed

    private void walletsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_walletsBtnActionPerformed
        bodyPanel.removeAll();
        defaultButtonBorder();

        bodyPanel.add(walletsView);
        setTitle("Block Pay | Billeteras");
        titleLabel.setText("Block Pay | Home");
        
        walletsBtn.setBorder(hightlightborder);
        walletsBtn.setBackground(hightlightcolor);

        bodyPanel.validate();
        bodyPanel.repaint();
    }//GEN-LAST:event_walletsBtnActionPerformed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        accountController.writeAccountInFile();
        System.out.println("El usuario va a salir");
        System.exit(0);
    }//GEN-LAST:event_exitBtnActionPerformed

    private void transactionsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_transactionsBtnActionPerformed
        bodyPanel.removeAll();
        defaultButtonBorder();

        bodyPanel.add(transactionInformationView);
        setTitle("Block Pay | Transacciones");
        titleLabel.setText("Block Pay | Transacciones");
        
        transactionsBtn.setBorder(hightlightborder);
        transactionsBtn.setBackground(hightlightcolor);

        bodyPanel.validate();
        bodyPanel.repaint();

    }//GEN-LAST:event_transactionsBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        accountController.writeAccountInFile();
        System.out.println("El usuario va a salir");
        System.exit(0);
    }//GEN-LAST:event_closeBtnActionPerformed

    private void maximixateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maximixateBtnActionPerformed
        if (this.getExtendedState() == MAXIMIZED_BOTH) {
            this.setExtendedState(JFrame.NORMAL);
        } else {
            this.setExtendedState(MAXIMIZED_BOTH);
        }
    }//GEN-LAST:event_maximixateBtnActionPerformed

    private void minimizateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimizateBtnActionPerformed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_minimizateBtnActionPerformed

    private void titleBarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleBarMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_titleBarMousePressed

    private void titleBarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleBarMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_titleBarMouseDragged

    private void titleBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titleBarMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            if (this.getExtendedState() == MAXIMIZED_BOTH) {
                this.setExtendedState(JFrame.NORMAL);
            } else {
                this.setExtendedState(MAXIMIZED_BOTH);
            }
        }
    }//GEN-LAST:event_titleBarMouseClicked

    private final java.awt.Color hightlightcolor = new java.awt.Color(255,209,102);
    private final javax.swing.border.LineBorder defaultBorder = new javax.swing.border.LineBorder(Color.white, 2, true);
    private final javax.swing.border.LineBorder hightlightborder = new javax.swing.border.LineBorder(hightlightcolor, 2, true);
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actionPanel;
    private javax.swing.JPanel bodyPanel;
    private javax.swing.JButton closeBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JPanel gapPanel;
    private javax.swing.JButton indexBtn;
    private javax.swing.JPanel mainMenuOptionsPanel;
    private javax.swing.JButton maximixateBtn;
    private javax.swing.JPanel menuBarPanel;
    private javax.swing.JButton minimizateBtn;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JButton profileBtn;
    private javax.swing.JPanel titleBar;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton transactionsBtn;
    private javax.swing.JButton walletsBtn;
    // End of variables declaration//GEN-END:variables
}
