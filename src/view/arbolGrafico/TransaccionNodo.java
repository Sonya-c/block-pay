
package view.arbolGrafico;

import model.system.Transaccion;

public class TransaccionNodo extends javax.swing.JPanel {
    private Transaccion transaccion;
    
    public TransaccionNodo(Transaccion transaccion) {
        this.transaccion = transaccion;
        
        initComponents();
        if (transaccion != null) dineroTxt.setText(transaccion.getMonto() + "");
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dineroLabel = new javax.swing.JLabel();
        dineroTxt = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setMaximumSize(new java.awt.Dimension(200, 60));
        setMinimumSize(new java.awt.Dimension(200, 60));
        setPreferredSize(new java.awt.Dimension(290, 180));
        setLayout(new java.awt.GridLayout(1, 2, 5, 10));

        dineroLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        dineroLabel.setForeground(new java.awt.Color(236, 0, 140));
        dineroLabel.setText("Dinero");
        add(dineroLabel);

        dineroTxt.setText(this.transaccion.getMonto() + "");
        dineroTxt.setEditable(false);
        dineroTxt.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        dineroTxt.setForeground(new java.awt.Color(27, 20, 100));
        add(dineroTxt);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dineroLabel;
    private javax.swing.JTextField dineroTxt;
    // End of variables declaration//GEN-END:variables
}
