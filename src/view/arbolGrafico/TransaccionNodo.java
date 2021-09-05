
package view.arbolGrafico;

import model.system.Transaccion;

public class TransaccionNodo extends javax.swing.JPanel {
    private Transaccion transaccion;
    
    public TransaccionNodo(Transaccion transaccion) {
        this.transaccion = transaccion;
        initComponents();       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setMaximumSize(new java.awt.Dimension(290, 180));
        setMinimumSize(new java.awt.Dimension(290, 180));
        setPreferredSize(new java.awt.Dimension(290, 180));
        setLayout(new java.awt.GridLayout(6, 2, 5, 10));

        jLabel1.setText("Id");
        add(jLabel1);

        jTextField1.setText(this.transaccion.getId() + "");
        add(jTextField1);

        jLabel4.setText("Dinero");
        add(jLabel4);

        jTextField2.setText(this.transaccion.getMonto() + "");
        add(jTextField2);

        jLabel2.setText("Remitente antes");
        add(jLabel2);

        jTextField3.setText(this.transaccion.getRemitenteAntes() + "");
        add(jTextField3);

        jLabel3.setText("Remitente despues");
        add(jLabel3);

        jTextField4.setText(this.transaccion.getRemitenteDespues() + "");
        add(jTextField4);

        jLabel5.setText("Destinatario antes");
        add(jLabel5);

        jTextField4.setText("" + this.transaccion.getDestinatarioAntes());
        add(jTextField5);

        jLabel6.setText("Destinatario despues");
        add(jLabel6);

        jTextField4.setText("" + this.transaccion.getDestinatarioDespues());
        add(jTextField6);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
