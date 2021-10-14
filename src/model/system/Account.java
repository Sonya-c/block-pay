/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.system;

/**
 * A account can have multiples wallets
 */
public class Account {
    private final String ID;
    private String userName;
    private String password;
    
    /**
     * Create a new account 
     * 
     * @param ID
     * @param userName
     * @param password 
     */
    public Account(String ID, String userName, String password) {
        this.ID = ID;
        this.userName = userName;
        this.password = password;
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
    
}
