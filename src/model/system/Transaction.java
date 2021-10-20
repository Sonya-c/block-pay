package model.system;

import java.time.LocalDate;
import java.util.logging.Logger;

/**
 * This class store the information of a transaction
 * @author sonya
 */
public class Transaction {
    private final Wallet remitent;
    private final Wallet destinatary;
    private final double money;
    private final LocalDate date;
    private final String messange;
    
    /**
     * 
     * @param remitent
     * @param destinatary
     * @param money 
     */
    public Transaction(Wallet remitent, Wallet destinatary, double money) {
        this.remitent = remitent;
        this.destinatary = destinatary;
        this.money = money;
        this.date = LocalDate.now();
        this.messange = "";
    }

    /**
     * 
     * @param remitent
     * @param destinatary
     * @param money
     * @param date 
     */
    public Transaction(Wallet remitent, Wallet destinatary, double money, LocalDate date) {
        this.remitent = remitent;
        this.destinatary = destinatary;
        this.money = money;
        this.date = date;
        this.messange = "";
    }
    
    /***
     * 
     * @param remitent
     * @param destinatary
     * @param money
     * @param messange 
     */
    public Transaction(Wallet remitent, Wallet destinatary, double money, String messange) {
        this.remitent = remitent;
        this.destinatary = destinatary;
        this.money = money;
        this.date = LocalDate.now();
        this.messange = messange;
    }
    
    /**
     * 
     * @param remitent
     * @param destinatary
     * @param money
     * @param date
     * @param messange 
     */
    public Transaction(Wallet remitent, Wallet destinatary, double money, LocalDate date, String messange) {
        this.remitent = remitent;
        this.destinatary = destinatary;
        this.money = money;
        this.date = date;
        this.messange = messange;
    }
    
    private static final Logger LOG = Logger.getLogger(Transaction.class.getName());
    
    @Override
    public String toString() {
        return "Transaction{" + 
                "remitent=" + remitent.getNickname() + 
                ", destinatary=" + destinatary.getNickname() +
                ", money=" + money +
                ", date=" + date.toString() +
                ", messange=" + messange + '}';
    }
    
    /* ======= GETTERS AND SETTERS =======*/
    public Wallet getRemitent() {
        return remitent;
    }

    public Wallet getDestinatary() {
        return destinatary;
    }

    public double getMoney() {
        return money;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getMessange() {
        return messange;
    }
    
    
}
