
package view.arbolGrafico;

import model.system.Persona;

public class PersonaNodo extends javax.swing.JPanel {
    private Persona persona;
    
    public PersonaNodo(Persona persona) {
        this.persona = persona;
        initComponents();       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setMaximumSize(new java.awt.Dimension(290, 180));
        setMinimumSize(new java.awt.Dimension(290, 180));
        setPreferredSize(new java.awt.Dimension(290, 180));
        setLayout(new java.awt.GridLayout(4, 2, 5, 10));

        jLabel1.setText("Usuario");
        add(jLabel1);

        jTextField1.setText(this.persona.getUserName());
        add(jTextField1);

        jLabel2.setText("Nombre");
        add(jLabel2);

        jTextField3.setText(this.persona.getNames());
        add(jTextField3);

        jLabel3.setText("Apellido");
        add(jLabel3);

        jTextField2.setText(this.persona.getLastNames());
        add(jTextField2);

        jLabel4.setText("Dinero");
        add(jLabel4);

        jTextField4.setText("" + this.persona.getDinero());
        add(jTextField4);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
