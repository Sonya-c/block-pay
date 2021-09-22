/*
 * 
 */
package view.arbolGrafico;

import java.awt.Graphics;
import model.structure.Arbol;
import model.structure.nodo.*;
import model.system.Persona;
import model.structure.Lista;
import java.util.ArrayList;

public class ArbolGrafico extends javax.swing.JPanel {
    private Arbol arbol;
    private ArrayList<Line> listaLineas;
    
    private class Line {
        int x1, y1, x2, y2;
        
        Line (int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
    }
    
    public ArbolGrafico(Arbol arbol) {
        this.arbol = arbol;
        initComponents();
    }
    
    public void draw() {
        this.mainPanel.removeAll();
        int middle = (int) this.mainPanel.getWidth() / 2;
        
        this.mainPanel.add(rootPanel);
        rootPanel.setLocation(middle - 25, 25);
        rootPanel.setSize(50, 50);
        
        this.mainPanel.add(userRootPanel);
        userRootPanel.setLocation(middle - 130 - 75 - 50/2 - 150/2, 150);
        userRootPanel.setSize(150, 50);
        
        listaLineas = new ArrayList<>();
        listaLineas.add(new Line(middle - 25, 25 + 50, middle - 130 - 50/2 - 150/2, 150));
        
        /*this.mainPanel.add(blockRootPanel);
        blockRootPanel.setLocation(middle + 25, 100);
        blockRootPanel.setSize(50, 50);
        */
        
        drawUsers(arbol.getRoot().getChildren().search(0), middle - 75 - 130, 230);
        
        /*
        Graphics drawingArea = this.mainPanel.getGraphics();
        drawingArea.setColor(new java.awt.Color(236,0,140));
        drawingArea.drawLine(middle - 25, 25 + 50, middle - 130 - 50/2 - 150/2, 150);
        */
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
                
                this.mainPanel.setSize(this.mainPanel.getWidth(), this.mainPanel.getHeight() + height + padding);
                System.out.println("view.arbol.ArbolGrafico.drawUser main panel height: " + this.mainPanel.getHeight());
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
    
    public void drawLines(Graphics canvas) {
        
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

        rootPanel = new javax.swing.JPanel();
        rootPanelLabel = new javax.swing.JLabel();
        userRootPanel = new javax.swing.JPanel();
        userRootPanelLabel = new javax.swing.JLabel();
        blockRootPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        scrollPanel = new javax.swing.JScrollPane();
        parentPanel = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();

        rootPanel.setBackground(new java.awt.Color(0, 0, 0));
        rootPanel.setLayout(new java.awt.BorderLayout());

        rootPanelLabel.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        rootPanelLabel.setForeground(new java.awt.Color(255, 255, 255));
        rootPanelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rootPanelLabel.setText("Root");
        rootPanel.add(rootPanelLabel, java.awt.BorderLayout.CENTER);

        userRootPanel.setBackground(new java.awt.Color(0, 255, 197));
        userRootPanel.setLayout(new java.awt.BorderLayout());

        userRootPanelLabel.setBackground(new java.awt.Color(0, 255, 197));
        userRootPanelLabel.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        userRootPanelLabel.setForeground(new java.awt.Color(236, 0, 140));
        userRootPanelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userRootPanelLabel.setText("Usuarios");
        userRootPanel.add(userRootPanelLabel, java.awt.BorderLayout.CENTER);

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
        scrollPanel.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());
        scrollPanel.setAutoscrolls(true);

        parentPanel.setLayout(new java.awt.BorderLayout());

        mainPanel.setBackground(new java.awt.Color(27, 20, 100));
        mainPanel.setAutoscrolls(true);
        mainPanel.setMinimumSize(new java.awt.Dimension(1255, 32767));
        mainPanel.setName(""); // NOI18N
        mainPanel.setRequestFocusEnabled(false);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1255, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, Short.MAX_VALUE, Short.MAX_VALUE)
        );

        parentPanel.add(mainPanel, java.awt.BorderLayout.CENTER);

        scrollPanel.setViewportView(parentPanel);

        add(scrollPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        draw();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel blockRootPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JLabel rootPanelLabel;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JPanel userRootPanel;
    private javax.swing.JLabel userRootPanelLabel;
    // End of variables declaration//GEN-END:variables
}
