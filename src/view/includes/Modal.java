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
        getContentPane().add(contentPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);   
    }
    
}