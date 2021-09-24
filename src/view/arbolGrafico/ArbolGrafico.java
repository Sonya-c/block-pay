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
import model.system.Bloque;

public class ArbolGrafico extends javax.swing.JPanel {
    private Arbol arbol;
    private ArrayList<Line> listaLineas;
    private Graphics lineasGraficas;
    
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
        
        listaLineas = new ArrayList<>();
        
        // Raíz de todo el árbol
        this.mainPanel.add(rootPanel);
        rootPanel.setLocation(middle - 25, 25);
        rootPanel.setSize(50, 50);
        
        // Añadir sub arbol (raíz) de personas
        this.mainPanel.add(userRootPanel);
        userRootPanel.setLocation(middle - 130 - 75 - 50/2 - 150/2, 150);
        userRootPanel.setSize(150, 50);
        listaLineas.add(new Line(middle - 25, 25 + 50, middle - 130 - 50/2 - 150/2, 150));
        
        // Añadir sub árbol (raíz) de bloques
        this.mainPanel.add(blockRootPanel);
        blockRootPanel.setLocation(middle + 130 + 50/2 + 150/2, 150);
        blockRootPanel.setSize(150, 50);
        listaLineas.add(new Line(middle + 25, 25 + 50, middle + 130 + 50/2 + 150, 150));
        
        // Dibujar arbol de usuarios
        listaLineas.add(new Line(middle - 130 - 75 - 50/2, 200, middle - 75 - 130 + 190 / 2, 230));
        listaLineas.add(new Line(middle - 130 - 75 - 50/2, 200, middle - 75 - 130 - 50 - 190/2, 230));
        drawUsers(arbol.getRoot().getChildren().search(0), middle - 75 - 130, 230);
        

        // Dibujar arbol de bloques
        drawBlocks(arbol.getRoot().getChildren().search(1), middle + 130 + 50/2 + 150,230);
        // this.validate();
        // this.repaint();
        drawLines();
    }
    
    /**
     * Dibuja las personas
     * @param rootUser 
     * @param x 
     * @param y 
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
                while (rootUser.getChildren().search(i) != null) {
                    userNodo = rootUser.getChildren().search(i);
                    user = (Persona) userNodo.getInfo(); 
                    
                    System.out.println("view.arbol.ArbolGrafico.drawUser i =  " + i);

                    PersonaNodo personaNodo = new PersonaNodo(user);
                    this.mainPanel.add(personaNodo);
                    
                    int x2 = x - i * (with + padding);
                    
                    personaNodo.setLocation(x2, y);
                    personaNodo.setSize(with, height);
                    
                    if (rootUser.getChildren().search(i) != null) {
                        listaLineas.add(new Line(x + with/2, y + height, x2 + with/2, y + 2*height));
                    }
                    System.out.println("view.arbol.ArbolGrafico.drawUser bound: x = " + (x - i * (with + padding)) + " y = " + y + padding);
                    System.out.println("view.arbol.ArbolGrafico.drawUser location: " + personaNodo.getLocation().toString());
                   
                    i++;
                }
                
                System.out.println("view.arbol.ArbolGrafico.drawUser main panel height: " + this.mainPanel.getHeight());
                
                drawUsers(rootUser.getChildren().search(0), x, y +  2* height);
                
            } else {
                PersonaNodo personaNodo = new PersonaNodo(user);
                this.mainPanel.add(personaNodo);
                personaNodo.setLocation(x, y + 2*height);
            }
        }
    }
    
    /**
     * 
     * @param rootBlock
     * @param x
     * @param y 
     */
    public void drawBlocks(NodoArbol rootBlock, int x, int y) {
        int with = 2 * 190;
        int height = 130;
        int padding = 50;
        NodoArbol p = rootBlock;
        
        x = x - 190;
        
        if (rootBlock != null) {
            System.out.println("view.arbolGrafico.ArbolGrafico.drawBlocks No es nulo");
            
            while (p != null) {
                BloqueNodo bloqueNodo = new BloqueNodo((Bloque) p.getInfo());
                this.mainPanel.add(bloqueNodo);
                
                bloqueNodo.setLocation(x, y);
                bloqueNodo.setSize(with, height);
                
                y += 2 * height;
                p = p.getNext();
            }
        }
        
    }
    public void drawLines() {
        Graphics canvas = this.mainPanel.getGraphics();
        
        if (canvas != null) {
            canvas.setColor(new java.awt.Color(236,0,140));

            listaLineas.forEach((line) -> {
                canvas.drawLine(line.x1, line.y1, line.x2, line.y2);
            });
        }
    }
    
    /*
    
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

    */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        rootPanelLabel = new javax.swing.JLabel();
        userRootPanel = new javax.swing.JPanel();
        userRootPanelLabel = new javax.swing.JLabel();
        blockRootPanel = new javax.swing.JPanel();
        userRootPanelLabel1 = new javax.swing.JLabel();
        headerPanel = new javax.swing.JPanel();
        updateBtn = new javax.swing.JButton();
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
        userRootPanelLabel.setForeground(new java.awt.Color(27, 20, 100));
        userRootPanelLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userRootPanelLabel.setText("Usuarios");
        userRootPanel.add(userRootPanelLabel, java.awt.BorderLayout.CENTER);

        blockRootPanel.setBackground(new java.awt.Color(0, 255, 197));
        blockRootPanel.setLayout(new java.awt.BorderLayout());

        userRootPanelLabel1.setBackground(new java.awt.Color(0, 255, 197));
        userRootPanelLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        userRootPanelLabel1.setForeground(new java.awt.Color(27, 20, 100));
        userRootPanelLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userRootPanelLabel1.setText("Transacciones");
        blockRootPanel.add(userRootPanelLabel1, java.awt.BorderLayout.CENTER);

        setBackground(new java.awt.Color(27, 20, 100));
        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                formAncestorResized(evt);
            }
        });
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        headerPanel.setBackground(new java.awt.Color(27, 20, 100));
        headerPanel.setPreferredSize(new java.awt.Dimension(1255, 50));

        updateBtn.setBackground(new java.awt.Color(236, 0, 140));
        updateBtn.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setText("Actualizar");
        updateBtn.setBorderPainted(false);
        updateBtn.setFocusable(false);
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(updateBtn)
                .addContainerGap(685, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerPanelLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(updateBtn)
                .addContainerGap())
        );

        add(headerPanel, java.awt.BorderLayout.PAGE_START);

        scrollPanel.setBackground(new java.awt.Color(27, 20, 100));
        scrollPanel.setBorder(null);
        scrollPanel.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());
        scrollPanel.setAutoscrolls(true);
        scrollPanel.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                scrollPanelMouseWheelMoved(evt);
            }
        });
        scrollPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scrollPanelMouseClicked(evt);
            }
        });

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

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        draw();
        if (listaLineas != null)drawLines();
    }//GEN-LAST:event_updateBtnActionPerformed

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        draw();
        if (listaLineas != null)drawLines();
    }//GEN-LAST:event_formPropertyChange

    private void formAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorResized
        draw();
        if (listaLineas != null)drawLines();
    }//GEN-LAST:event_formAncestorResized

    private void scrollPanelMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_scrollPanelMouseWheelMoved
        draw();
        // if (listaLineas != null)drawLines();
    }//GEN-LAST:event_scrollPanelMouseWheelMoved

    private void scrollPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scrollPanelMouseClicked
        draw();
        if (listaLineas != null)drawLines();
    }//GEN-LAST:event_scrollPanelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel blockRootPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JLabel rootPanelLabel;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JButton updateBtn;
    private javax.swing.JPanel userRootPanel;
    private javax.swing.JLabel userRootPanelLabel;
    private javax.swing.JLabel userRootPanelLabel1;
    // End of variables declaration//GEN-END:variables
}
