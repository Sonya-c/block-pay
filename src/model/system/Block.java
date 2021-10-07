
package model.system;

import model.dynamic.list.List;

public class Block {
    private List<Transaction> transactions;
    
    public Block() {
        transactions = new List(3);
    }    

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List transactions) {
        this.transactions = transactions;
    }
    
}
