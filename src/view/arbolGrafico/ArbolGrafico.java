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
        this.mainPanel.removeAll();
        int middleX = (int) this.mainPanel.getWidth() / 2;
        drawUsers(arbol.getRoot().getChildren().search(0), middleX, 0);
    }
    
    /**
     * Dibuja las personas
     * @param rootUser 
     */
    public void drawUsers(NodoArbol rootUser, int x, int y) {
        Persona user;
        int with = 190;
        int height = 130;
        int padding = 50;
        
        if (rootUser != null && rootUser.getInfo() != null) {
            System.out.println("view.arbol.arbolGrafico.drawUser info no vacia");
            
            user = (Persona) rootUser.getInfo();
            
            if (rootUser.getChildren() != null) {
                NodoArbol userNodo = rootUser.getChildren().search(0);
                System.out.println("view.arbol.arbolGrafico.drawUser user:" + user.getNames() +"tiene hijos");
                
                int i = 0;
                while (rootUser.getChildren() != null && i < rootUser.getChildren().getSize()) {
                    userNodo = rootUser.getChildren().search(i);
                    user = (Persona) userNodo.getInfo(); 
                    
                    // testTxt.setText(testTxt.getText() + user.getNames() +  "\n");
                    PersonaNodo personaNodo = new PersonaNodo(user);
                    this.mainPanel.add(personaNodo);
                    // personaNodo.setBounds(x - i * (with + padding), y + padding, with, height);
                    personaNodo.setLocation(x - i * (with + padding), y + padding);
                    personaNodo.setSize(with, height);
                    System.out.println("view.arbol.ArbolGrafico.drawUser bound: x = " + (x - i * (with + padding)) + " y = " + y + padding);
                    System.out.println("view.arbol.ArbolGrafico.drawUser location: " + personaNodo.getLocation().toString());
                   
                    i++;
                }
                /*
                System.out.println("view.arbol.ArbolGrafico.drawUser altura antes: " +  this.mainPanel.getHeight());
                this.mainPanel.setSize(this.mainPanel.getWidth(), this.mainPanel.getHeight() + height + padding);
                System.out.println("view.arbol.ArbolGrafico.drawUser altura despues: " +  this.mainPanel.getHeight());
                */
                drawUsers(rootUser.getChildren().search(0), x, y +  height + padding);
                
            } else {
                // testTxt.setText(testTxt.getText() + user.getNames() + "\n");
                PersonaNodo personaNodo = new PersonaNodo(user);
                this.mainPanel.add(personaNodo);
                // personaNodo.setBounds(x, y + height + padding, with, height);
                personaNodo.setLocation(x, y + height + padding);
            }
        }
        this.validate();
        this.repaint();
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

        jButton1 = new javax.swing.JButton();
        scrollPanel = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(27, 20, 100));
        setLayout(new java.awt.BorderLayout());

        jButton1.setText("Test");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, java.awt.BorderLayout.PAGE_START);

        scrollPanel.setBackground(new java.awt.Color(27, 20, 100));
        scrollPanel.setBorder(null);
        scrollPanel.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPanel.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());
        scrollPanel.setAutoscrolls(true);

        mainPanel.setBackground(new java.awt.Color(204, 204, 204));
        mainPanel.setMaximumSize(new java.awt.Dimension(1245, 320));
        mainPanel.setMinimumSize(new java.awt.Dimension(1245, 320));
        mainPanel.setName(""); // NOI18N
        mainPanel.setPreferredSize(new java.awt.Dimension(1245, 320));
        mainPanel.setLayout(null);
        scrollPanel.setViewportView(mainPanel);

        add(scrollPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        draw();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane scrollPanel;
    // End of variables declaration//GEN-END:variables
}
