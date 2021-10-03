/*
 * A wallet has an amount of money
 * A wallet can send money to another
 */
package model.system;

public class Wallet {
    private final int ID;
    private double money;
    
    public Wallet(int ID, double money) {
        this.ID = ID;
        this.money = money;
    }
    
    /* ======= GETTERS AND SETTERS =======*/
    
    public int getID() {
        return this.ID;
    }
    
    public double getMoney() {
        return this.money;
    }
    
    public void setMoney(double money) {
        this.money = money;
    }
}
