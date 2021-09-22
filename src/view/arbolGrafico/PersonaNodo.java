
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
        java.awt.GridBagConstraints gridBagConstraints;

        usuarioLabel = new javax.swing.JLabel();
        usuarioTxt = new javax.swing.JTextField();
        nombreLabel = new javax.swing.JLabel();
        nombreUsuarioTxt = new javax.swing.JTextField();
        apellidoLabel = new javax.swing.JLabel();
        apellidoTxt = new javax.swing.JTextField();
        dineroLabel = new javax.swing.JLabel();
        dineroTxt = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setMaximumSize(new java.awt.Dimension(190, 130));
        setMinimumSize(new java.awt.Dimension(190, 130));
        setPreferredSize(new java.awt.Dimension(190, 130));
        setLayout(new java.awt.GridBagLayout());

        usuarioLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        usuarioLabel.setForeground(new java.awt.Color(236, 0, 140));
        usuarioLabel.setText("Usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        add(usuarioLabel, gridBagConstraints);

        usuarioTxt.setText(this.persona.getUserName());
        usuarioTxt.setEditable(false);
        usuarioTxt.setForeground(new java.awt.Color(27, 20, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 3.0;
        add(usuarioTxt, gridBagConstraints);

        nombreLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        nombreLabel.setForeground(new java.awt.Color(236, 0, 140));
        nombreLabel.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        add(nombreLabel, gridBagConstraints);

        nombreUsuarioTxt.setText(this.persona.getNames());
        nombreUsuarioTxt.setEditable(false);
        nombreUsuarioTxt.setForeground(new java.awt.Color(27, 20, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 3.0;
        add(nombreUsuarioTxt, gridBagConstraints);

        apellidoLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        apellidoLabel.setForeground(new java.awt.Color(236, 0, 140));
        apellidoLabel.setText("Apellido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        add(apellidoLabel, gridBagConstraints);

        apellidoTxt.setText(this.persona.getLastNames());
        apellidoTxt.setEditable(false);
        apellidoTxt.setForeground(new java.awt.Color(27, 20, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 3.0;
        add(apellidoTxt, gridBagConstraints);

        dineroLabel.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        dineroLabel.setForeground(new java.awt.Color(236, 0, 140));
        dineroLabel.setText("Dinero");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 10);
        add(dineroLabel, gridBagConstraints);

        dineroTxt.setText("" + this.persona.getDinero());
        dineroTxt.setEditable(false);
        dineroTxt.setForeground(new java.awt.Color(27, 20, 100));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 3.0;
        add(dineroTxt, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel apellidoLabel;
    private javax.swing.JTextField apellidoTxt;
    private javax.swing.JLabel dineroLabel;
    private javax.swing.JTextField dineroTxt;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreUsuarioTxt;
    private javax.swing.JLabel usuarioLabel;
    private javax.swing.JTextField usuarioTxt;
    // End of variables declaration//GEN-END:variables
}
