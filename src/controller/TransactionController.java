package controller;

import model.list.List;
import model.list.ListNode;
import model.system.Account;
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

    /**
     * Verifica la transacción
     *
     * @param transaction
     * @return
     */
    public boolean verifyTransaction(Transaction transaction) {
        System.out.println("TransactionController.verifyTransaction(Transaction) is eva? " + transaction.getRemitent().getID().equals("eva0"));

        if (transaction.getRemitent().getID().equals("eva0")) {
            // Si es eva no debemos verificar
            if (transaction.getRemitent().getMoney() - transaction.getMoney() <= 0) {
                transaction.getRemitent().setMoney(Double.MAX_VALUE); // Recargarle a eva
            }
            return true;

        } else {

//            double money = this.existsMoneyAtFirst(transaction);
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

            System.out.println("controller.TransactionController.verifyTransaction(Transaction) MENSAJE: valor money = " + money);
            System.out.println(TransactionController.class.toString() + " MENSAJE: " + transaction.getRemitent().getMoney());

            return (money == transaction.getRemitent().getMoney() && money >= transaction.getMoney());
        }
    }

    private double existsMoneyAtFirst(Transaction transaction) {
        Wallet remitent = transaction.getRemitent();
        Wallet destinatary = transaction.getDestinatary();
        for (Block block : blockList) {
            for (Transaction transaction1 : block.getTransactions()) {
                if (remitent.getID().equals(transaction1.getDestinatary().getID())
                        && transaction.getRemitent().getID().equals("eva0")
                        || destinatary.getID().equals(transaction1.getDestinatary().getID())
                        && transaction.getRemitent().getID().equals("eva0")) {
                    return 50000d;
                }
            }
        }
        return 0d;
    }

    /**
     * Add a new trasaction
     *
     * @param transaction
     * @return 0: everything fine 1: we have an impostor amung us
     */
    public int add(Transaction transaction) {
        ListNode tail = blockList.getTail();

        if (verifyTransaction(transaction)) {
            // Verify this trasaction is correct 
            // Not corruption!
            if (tail == null) {
                // No se ha creado ningun bloque

                Block block = new Block();
                block.getTransactions().add(transaction);
                blockList.add(block);

                return -1;
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

                    return 0;
                } else {
                    System.out.println("controller.TransactionController.add(Transaction) ERROR: Estructura de datos incorrecta");
                }
            }

        } else {
            System.out.println("controller.TransactionController.add(Transaction) ERROR: Verificación fallida");
        }

        return 1;
    }

    public void soutTransaction() {
        for (Block block : blockList) {
            for (Transaction transaction : block.getTransactions()) {
                System.out.println(transaction.getMoney() + transaction.getRemitent().getID() + transaction.getDestinatary().getID());
            }
        }
    }


    public List<Transaction> getHistorial(Wallet wallet) {
        List<Transaction> transactions = new List();

        for (Block block : blockList) {
            for (Transaction transaction : block.getTransactions()) {
                if (transaction.getRemitent().getID().equals(wallet.getID()) || transaction.getDestinatary().getID().equals(wallet.getID())) {
                    transactions.add(transaction);
                }
            }
        }

        return transactions;
    }

    public void writeTransactionInFile() {
        for (Block block : blockList) {
            for (Transaction transaction : block.getTransactions()) {
                if (!FileController.findTransaction(transaction)) {
                    FileController.writeFile(FileController.findCreateFile("transaction.txt"),
                            transaction.getRemitent().getID() + "#"
                            + transaction.getDestinatary().getID() + "#" + transaction.getMoney() + "#" + transaction.getDate()
                            + "#" + transaction.getMessange());
                }
            }
        }
    }

    public void addTransaction(Transaction t) {
        ListNode tail = blockList.getTail();
        if (tail == null) {

            Block block = new Block();
            block.getTransactions().add(t);
            blockList.add(block);

        } else {

            if (tail.getInfo() instanceof Block) {
                // Confirm that the info is a listNode
                Block block = (Block) tail.getInfo();

                if (block.getTransactions().getSize() < 3) {
                    // As this block is not full size, we can add the new transaction here
                    block.getTransactions().add(t);
                } else {
                    // As this block is full size, we must create a new block
                    block = new Block();
                    block.getTransactions().add(t);
                    blockList.add(block);
                }
            }
        }
        System.out.println(TransactionController.class.toString() + " MENSAJE Transaccipon por lista ingresada");
    }

    public List<Block> getBlockList() {
        return blockList;
    }

}
