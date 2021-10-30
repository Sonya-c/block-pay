package controller;

import model.list.List;
import model.list.ListNode;
import model.system.Block;
import model.system.Transaction;
import model.system.Wallet;

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

    // GETTERS---    
    public List<Block> getBlockList() {
        return blockList;
    }

    /**
     * Retorna todas las transacciones en las que ha estado involucrada una
     * wallet, sea como remitente o destinataria.
     *
     * @param wallet
     * @return
     */
    public List<Transaction> getHistorial(Wallet wallet) {
        List<Transaction> foundTransactions = new List();

        for (Block block : blockList) {
            for (Transaction transaction : block.getTransactions()) {
                if (transaction.getRemitent().getID().equals(wallet.getID())
                        || transaction.getDestinatary().getID().equals(wallet.getID())) {
                    foundTransactions.add(transaction);
                }
            }
        }

        return foundTransactions;
    }

    //---
    /**
     * Verifica la transacción
     *
     * @param transaction
     * @return
     */
    public boolean verifyTransaction(Transaction transaction) {

        System.out.println(TransactionController.class.toString() + " verifyTransaction(Transaction) is eva? " + transaction.getRemitent().getID().equals("eva0"));

        if (transaction.getRemitent().getID().equals("eva0")) {
            // Si es eva no debemos verificar
            if (transaction.getRemitent().getMoney() - transaction.getMoney() <= 0) {
                transaction.getRemitent().setMoney(Double.MAX_VALUE); // Recargarle a eva
            }
            return true;

        } else {

            double money = 0;

            /*
             * Verify that the money of the remitent makes sense
             * move from all block and all transacctions
             * seach the transacction that has as remitent or as destinatary the trasaction remitent wallet
             * add or rest money
             * if the calculateed money is the same, do the transaction. Else, kill the wallet [insert evil laugh]
             */
            
            for (Block block : blockList) {

                for (Transaction t : block.getTransactions()) {

                    if (t.getRemitent().getID().equals(transaction.getRemitent().getID())) {
                        money -= t.getMoney();

                    } else if (t.getDestinatary().getID().equals(transaction.getRemitent().getID())) {
                        money += t.getMoney();
                    }
                }
            }

            System.out.println(TransactionController.class.toString() + " verifyTransaction(Transaction) MENSAJE Dinero calculado : " + money);
            System.out.println(TransactionController.class.toString() + " verifyTransaction(Transaction) MENSAJE Dinero actual en billetera de remitente : " + transaction.getRemitent().getMoney());

            return (money == transaction.getRemitent().getMoney() && money >= transaction.getMoney());
        }
    }

    /**
     * Add a new trasaction
     *
     * @param transaction
     * @return 0: everything fine 1: we have an impostor amung us
     */
    public boolean addNewTransaction(Transaction transaction) {
        ListNode tail = blockList.getTail();

        if (verifyTransaction(transaction)) {
            // Verify this trasaction is correct 
            // Not corruption!
            if (tail == null) {
                // No se ha creado ningun bloque

                Block block = new Block();
                block.getTransactions().add(transaction);
                blockList.add(block);

                return true;
            } else {
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

                    return true;
                } else {
                    System.out.println(TransactionController.class.toString() + " addNewTransaction(Transaction) ERROR: Estructura de datos incorrecta");
                }
            }

        } else {
            System.out.println(TransactionController.class.toString() + "addNewTransaction(Transaction) ERROR: Verificación fallida");
        }

        return false;
    }

    /**
     * Agrega las transacciones que ya existían, es decir, las que vienen del archivo guardadas previamente.
     * @param transaction 
     */
    public void addTransaction(Transaction transaction) {
        ListNode tail = blockList.getTail();
        if (tail == null) {

            Block block = new Block();
            block.getTransactions().add(transaction);
            blockList.add(block);

        } else {

            if (tail.getInfo() instanceof Block) {
                Block block = (Block) tail.getInfo();
                if (block.getTransactions().getSize() < 3) {
                    block.getTransactions().add(transaction);
                } else {
                    block = new Block();
                    block.getTransactions().add(transaction);
                    blockList.add(block);
                }
            }
        }
        System.out.println(TransactionController.class.toString() + " addTransaction(Transaction transaction) MENSAJE Transacción ingresada exitosamente");
    }

    public void writeTransactionInFile() {
        for (Block block : blockList) {
            for (Transaction transaction : block.getTransactions()) {
                if (!FileController.isTransactionInFile(transaction)) {
                    FileController.writeFile(FileController.findCreateFile("transaction.txt"),
                            transaction.getRemitent().getID() + "#"
                            + transaction.getDestinatary().getID() + "#" + transaction.getMoney() + "#" + transaction.getDate()
                            + "#" + transaction.getMessange());
                }
            }
        }
    }

}
