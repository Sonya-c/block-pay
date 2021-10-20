/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.system;

import controller.AccountController;
import controller.FileController;
import model.list.List;

/**
 * An account can have multiples wallets
 */
public class Account {
    private final int ID;
    private String userName;
    private String password;
    private List<Wallet> wallets;
    
    /**
     * Create a new account 
     * 
     * @param ID
     * @param userName
     * @param password 
     */
    public Account(int ID, String userName, String password) {
        this.ID = ID;
        this.userName = userName;
        this.password = password;
        wallets = new List<>();
    }

    public void addWallet(Wallet wallet){
        this.wallets.add(wallet);
    }
    
    /**
     * 
     * @param idWallet
     * @return 
     */
    public Wallet getWallet(String idWallet){
        for (Wallet wallet : wallets) {
            if (wallet.getID().equals(idWallet)){
                return wallet;
            }
        }
        return null;
    }
    
    /* ======= GETTERS AND SETTERS =======*/
    
    public int getID() {
        return ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Wallet> getWallets() {
        return wallets;
    }
    
}
