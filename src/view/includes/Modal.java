/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.includes;

import java.awt.Component;
import javax.swing.JFrame;

/**
 *
 * @author sonya
 */
public class Modal extends javax.swing.JDialog {

    public Modal(JFrame frame, String title, boolean bool, Component contentPane) {
        super(frame, title, bool);
        
        // Añadir el panel
        getContentPane().add(contentPane);
        
        // Eliminar los botones
        // setUndecorated(true);
        
        // No se que hace esot
        pack();
        
        setLocationRelativeTo(null);
        setVisible(true);
        setMaximumSize(contentPane.getSize());
        setSize(contentPane.getSize());
        setResizable(false);
        
    }
    
}