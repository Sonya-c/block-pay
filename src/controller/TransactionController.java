package controller;

import model.dynamic.list.List;
import model.dynamic.list.ListNode;
import model.system.Block;
import model.system.Transaction;

/**
 * It manages the logical process of doing a transaction
 * 
 * @author sonya
 */
public class TransactionController {
    List<Block> blockList;
    
    public TransactionController() {
        this.blockList = new List<Block>();
    }
    
    /**
     * 
     * @param blockList 
     */
    public TransactionController(List<Block> blockList) {
        this.blockList = blockList;
    }
    
    /**
     * Verifica la transacción
     * 
     * @param transaction
     * @return 
     */
    public boolean verifyTransaction(Transaction transaction) {
        double money = 0; // IMPORTANT: ¿Qué dinero inicial vamos a dar?
        
        /*
         * Verify that the money of the remitent makes sense
         * move fromm all block and all transacctions
         * seach the transacction that has as remitent or as destinatary the trasaction remitent wallet
         * add or rest money
         * if the calculateed money is the same, do the transaction. Else, kill the wallet [insert evil laugh]
         */
        for (Block block : blockList) {
            for (Transaction t : block.getTransactions()) {
                
                if (t.getRemitent() == transaction.getRemitent()) {
                    money -= t.getMoney();
                
                } else if (t.getDestinatary() == transaction.getRemitent()) {
                    money += t.getMoney();
                }
            }
        }
        
        return (money == transaction.getRemitent().getMoney() && money >= transaction.getMoney());
    }
   
    /**
     * Add a new trasaction
     * 
     * @param transaction 
     * @return 
     *  0: everything fine
     *  1: we have an impostor amung us
     */
    public int add(Transaction transaction) {
        ListNode tail = blockList.getTail();
        
        if (verifyTransaction(transaction)) {
            // Verify this trasaction is correct 
            // Not corruption!
            
            if (tail.getInfo() instanceof Block) {
                // Confirm that the info is a listNode
                Block block = (Block) tail.getInfo();

                if (block.getTransactions().getSize() < 3) {
                    // As this block is not full size, we can add the new transaction here
                    block.getTransactions().add(transaction);
                } else {
                    // As this block is full size, we must create a new block
                    block = new Block();
                    block.getTransactions().add(transaction);
                    blockList.add(block);   
                }
                
                return 0;
            } else {
                System.out.println("controller.TransactionController.add(Transaction) ERROR: Estructura de datos incorrecta");
            }
        }  
        
        // Q: ¿Qué le hacemos a las transacciones que resulten malas?
        
        return 1;
    }
    
}
