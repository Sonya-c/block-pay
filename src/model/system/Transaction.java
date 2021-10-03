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
public class Transaction {
    private final Wallet remitent;
    private final Wallet destinatary;
    
    public Transaction(Wallet remitent, Wallet destinatary) {
        this.remitent = remitent;
        this.destinatary = destinatary;
    }
}
