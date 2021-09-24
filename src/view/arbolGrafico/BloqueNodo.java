
package view.arbolGrafico;

import model.system.Bloque;
import model.system.Transaccion;

public class BloqueNodo extends javax.swing.JPanel {

    /**
     * Creates new form BloqueNodo
     */
    public BloqueNodo(Bloque bloque) {
        initComponents();
        
        int i = 0;
        while (bloque != null & i < 3 && bloque.getChildren().search(i) != null) {
            TransaccionNodo transaccionNodo = new TransaccionNodo((Transaccion) bloque.getChildren().search(i).getInfo());
            this.add(transaccionNodo);
            System.out.println("view.arbolGrafico.BloqueNodo pos = " + transaccionNodo.getLocation().toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(236, 0, 140));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}