/*
 * 
 */
package view;

import model.structure.Arbol;

public class ArbolGrafico extends javax.swing.JPanel {
    private Arbol arbol;
    
    public ArbolGrafico(Arbol arbol) {
        this.arbol = arbol;
        
        initComponents();
    }
    
    public void draw() {
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        outputTxt = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setLayout(new java.awt.BorderLayout());

        outputTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        outputTxt.setViewportView(jTextArea1);

        add(outputTxt, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JScrollPane outputTxt;
    // End of variables declaration//GEN-END:variables
}
