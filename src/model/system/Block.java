
package model.system;

import model.list.List;

public class Block {
    private List<Transaction> transactions;
    
    public Block() {
        transactions = new List(3);
    }    

    //GETTERS AND SETTERS ---
    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List transactions) {
        this.transactions = transactions;
    }
    //---
}
