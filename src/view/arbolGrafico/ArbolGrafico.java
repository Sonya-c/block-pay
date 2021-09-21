/*
 * 
 */
package view.arbolGrafico;

import model.structure.Arbol;
import model.structure.nodo.*;
import model.system.Persona;

public class ArbolGrafico extends javax.swing.JPanel {
    private Arbol arbol;
    
    public ArbolGrafico(Arbol arbol) {
        this.arbol = arbol;
        initComponents();
    }
    
    public void draw() {
        drawUser(arbol.getRoot().getChildren().search(0), 0);
        
    }
    
    public void drawUser(NodoArbol rootUser, int i) {
        Persona user = null;
        
        if (rootUser != null && rootUser.getInfo() != null) {
            System.out.println("view.arbol.arbolGrafico.drawUser info no vacia");
            
            user = (Persona) rootUser.getInfo();
            testTxt.setText(testTxt.getText() + user.getNames());
            
            if (rootUser.getChildren() != null) {
                NodoArbol userNodo = rootUser.getChildren().search(0);
                
                while (i < 3 && userNodo != null) {
                    user = (Persona) userNodo.getInfo(); 
                    testTxt.setText(testTxt.getText() + user.getNames() +  "\n");
                    
                    System.out.println("mode.structure.Arbol.searchUser(NodoArbol, int, int) bucle i = " + i);
                    userNodo = rootUser.getChildren().search(i++);
                    
                }
                
                drawUser(rootUser.getChildren().search(0), 0);
            }
            
        }
    }
    /*
    if (info instanceof Persona) {
            NodoArbol p = root.getChildren().search(0);
            System.out.println("model.struture.Arbol.insert > insertando persona p " + p);
            if (p.getChildren().search(0) == null) {
                
                p.addChild(p, info);
                System.out.println("model.strucure.Arbol.insert > insertando persona, no hay hijo");
                
            } else {
                
                if (p.getChildren().getSize() == p.getChildren().getMAX_SIZE()) {
                    System.out.println("model.strucure.Arbol.insert > insertando persona insertar nuevo nodo");
                    insert(p, info);
                    
                } else {
                    System.out.println("model.strucure.Arbol.insert > insertando persona añadir hijo");
                    p.addChild(p, info);
                }
            }        
        } else if (info instanceof Transaccion) {
            NodoArbol p = root.getChildren().search(1);
            if (p.getChildren().search(0) == null) {
                p.addChild(p, info);
                System.out.println("completado");
            } else {
                if (p.getChildren().getSize() == p.getChildren().getMAX_SIZE() && p.getNext() == null) {
                    System.out.println("en el if");
                    Bloque b = (Bloque) p.getInfo();
                    int j = (Integer) b.getInfo();
                    p.setNext(new NodoArbol(p, 3, new Bloque(j++)));
                    p = p.getNext();
                    insert(root, info);
                    System.out.println(j);
                } else if (p.getChildren().getSize() == p.getChildren().getMAX_SIZE() && p.getNext() != null) {
                    System.out.println("if 2");
                    insert(p, info);
                } else {
                    System.out.println("va por el else");
                    p.addChild(p, info);
                }
            }

        }
    */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        testTxt = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        testTxt.setColumns(20);
        testTxt.setRows(5);
        jScrollPane1.setViewportView(testTxt);

        add(jScrollPane1);

        jButton1.setText("Test");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        draw();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea testTxt;
    // End of variables declaration//GEN-END:variables
}
