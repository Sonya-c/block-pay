package view;

import java.awt.Image;
import javax.swing.ImageIcon;
/**
 *
 * @author sonya
 */
public class WelcomeView extends javax.swing.JFrame {

    /**
     * Creates new form Welcome
     */
    public WelcomeView() {
        initComponents();
        
        // (new ImageIcon(getClass().getResource("/resources/img/logo.png"))).getImage()
        Image image = (new ImageIcon(getClass().getResource("/resources/img/logo.png"))).getImage();
        Image newImage = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH); 
        iconLabel.setIcon(new ImageIcon(newImage));
        System.out.println(iconLabel.getIcon());
    }

    public void setMaxValue(int max) {
        this.progressBar.setMaximum(max);
    }
    
    public void progress() {
        this.progressBar.setValue(this.progressBar.getValue() + 1);
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPael = new javax.swing.JPanel();
        iconLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        footerPanel = new javax.swing.JPanel();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rohi Coins | Werlcome");
        setAlwaysOnTop(true);
        setIconImage((new ImageIcon(getClass().getResource("/resources/img/logo.png"))).getImage());
        setUndecorated(true);
        setResizable(false);

        mainPael.setBackground(new java.awt.Color(27, 20, 100));

        iconLabel.setBackground(new java.awt.Color(255, 51, 102));
        iconLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconLabel.setMaximumSize(new java.awt.Dimension(200, 200));
        iconLabel.setMinimumSize(new java.awt.Dimension(200, 200));

        titleLabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("BLOCK PAY");

        javax.swing.GroupLayout mainPaelLayout = new javax.swing.GroupLayout(mainPael);
        mainPael.setLayout(mainPaelLayout);
        mainPaelLayout.setHorizontalGroup(
            mainPaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPaelLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addGroup(mainPaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(iconLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addGap(109, 109, 109))
        );
        mainPaelLayout.setVerticalGroup(
            mainPaelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPaelLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(iconLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleLabel)
                .addGap(24, 24, 24))
        );

        getContentPane().add(mainPael, java.awt.BorderLayout.CENTER);

        footerPanel.setBackground(new java.awt.Color(27, 20, 100));

        progressBar.setBackground(new java.awt.Color(0, 255, 197));
        progressBar.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        progressBar.setForeground(new java.awt.Color(236, 0, 140));
        progressBar.setValue(50);
        progressBar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        progressBar.setBorderPainted(false);
        progressBar.setOpaque(true);
        progressBar.setPreferredSize(new java.awt.Dimension(300, 15));
        progressBar.setStringPainted(true);
        progressBar.setVerifyInputWhenFocusTarget(false);
        footerPanel.add(progressBar);

        getContentPane().add(footerPanel, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel footerPanel;
    private javax.swing.JLabel iconLabel;
    private javax.swing.JPanel mainPael;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}