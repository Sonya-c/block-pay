/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.system;

/**
 *
 * @author sonya
 */
public class Eva extends Account {
    
    public Eva() {
        super(0, "eva", "eva_mitocondrial#100");
    
        Wallet wallet = new Wallet("eva0", 5000, "Eva's wallet");
        addWallet(wallet);
    }
    
}
