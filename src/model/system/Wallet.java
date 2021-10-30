/*
 * A wallet has an amount of money
 * A wallet can send money to another
 */
package model.system;

public class Wallet {
    private final String ID;
    private double money;
    private String nickname;
    
    public Wallet(String ID, double money, String nickname) {
        this.ID = ID;
        this.money = money;
        this.nickname = nickname;
    }
    
    /* ======= GETTERS AND SETTERS =======*/
    
    public String getID() {
        return this.ID;
    }
    
    public double getMoney() {
        return this.money;
    }
    
    /**
     * 
     * @param money 
     */
    public void setMoney(double money) {
        this.money = money;
    }

    public String getNickname() {
        return nickname;
    }

    /**
     * 
     * @param nickname 
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    //---
}
