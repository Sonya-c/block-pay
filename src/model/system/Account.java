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
        
//        firstMoney();
        
    }

    /**
     * Método para poder agregarle los primero 50k al usuario y descontarselos al usuario principal,
     * pero se hace desde la clase AccountController.
     */
    public final void firstMoney(){
        if (!userName.equals("user0")){
            AccountController ac = new AccountController(FileController.loadAccount());
            ac.moneyFirstWallet(wallets, ID, userName, password);
        }
    }
    
    public void addWallet(Wallet wallet){
        this.wallets.add(wallet);
    }
    
    public Wallet getWallet(int idWallet){
        for (Wallet wallet : wallets) {
            if (wallet.getID() == idWallet){
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
