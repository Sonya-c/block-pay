/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.system;

/**
 * An account can have multiples wallets
 */
public class Account {
    private final String ID;
    private String userName;
    private String password;
    private final String ID_WALLET;
    /**
     * Create a new account 
     * 
     * @param ID
     * @param userName
     * @param password 
     * @param ID_WALLET 
     */
    public Account(String ID, String userName, String password, String ID_WALLET) {
        this.ID = ID;
        this.userName = userName;
        this.password = password;
        this.ID_WALLET = ID_WALLET;
    }

    /* ======= GETTERS AND SETTERS =======*/
    
    public String getID() {
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

    public String getID_WALLET() {
        return ID_WALLET;
    }
    
}
