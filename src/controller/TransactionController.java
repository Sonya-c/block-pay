package controller;

import model.list.List;
import model.list.ListNode;
import model.system.Block;
import model.system.Eva;
import model.system.Transaction;

/**
 * It manages the logical process of doing a transaction
 * 
 * @author sonya
 */
public class TransactionController {
    private final List<Block> blockList;
    
    public TransactionController() {
        this.blockList = new List<>();
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
        if (transaction.getRemitent().getID() == "eva0") {
            if (transaction.getRemitent().getMoney() - transaction.getMoney() <= 0) {
                transaction.getRemitent().setMoney(Double.MAX_VALUE); // Recargarle a eva
            }
            return true;
        } else {
            double money = 50000; // IMPORTANT: ¿Qué dinero inicial vamos a dar? - 50k, para mantener la idea del pasado.

            /*
             * Verify that the money of the remitent makes sense
             * move from all block and all transacctions
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
                
                FileController.writeFile(FileController.findCreateFile("transaction.txt"), 
                        (block.toString() + "#" + transaction.getRemitent().getID() + "#" + transaction.getDestinatary().getID()
                                + "#" + transaction.getMoney() + "#" + transaction.getDate() + "#" + transaction.getMessange()) );
                
                return 0;
            } else {
                System.out.println("controller.TransactionController.add(Transaction) ERROR: Estructura de datos incorrecta");
            }
        }  
        
        // Q: ¿Qué le hacemos a las transacciones que resulten malas?
        
        return 1;
    }

    public List<Block> getBlockList() {
        return blockList;
    }
    
    
    
}
