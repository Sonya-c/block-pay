/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.system;

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

    /* ======= GETTERS AND SETTERS =======*/
    public int getID() {
        return ID;
    }

    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public List<Wallet> getWallets() {
        return wallets;
    }

    /**
     *
     * @param idWallet
     * @return
     */
    public Wallet getWallet(String idWallet) {
        for (Wallet wallet : wallets) {
            if (wallet.getID().equals(idWallet)) {
                return wallet;
            }
        }
        return null;
    }

    /**
     *
     * @param nickname
     * @return
     */
    public Wallet getWalletByNickname(String nickname) {
        if (nickname != null) {
            for (Wallet wallet : this.wallets) {
                if (nickname.equals(wallet.getNickname())) {
                    return wallet;
                }
            }
        } else {
            System.out.println(Account.class.toString() + " getWalletByNickname(nickname) ERROR null nickname");
        }
        return null;
    }

    //---
    /**
     *
     * @param wallet
     */
    public void addWallet(Wallet wallet) {
        if (!walletExists(wallet)) {
            this.wallets.add(wallet);
            System.out.println(Account.class.toString() + " addWallet(wallet) MENSAJE se agregó " + wallet.getID() + " a la cuenta " + this.userName);
        }
    }

    /**
     *
     * @param wallet
     * @return
     */
    public boolean walletExists(Wallet wallet) {
        for (Wallet w : wallets) {
            if (w.getID().equals(wallet.getID())) {
                return true;
            }
        }
        return false;
    }

}
