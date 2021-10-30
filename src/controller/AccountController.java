package controller;

import java.time.LocalDate;
import model.list.List;
import model.system.Account;
import model.system.Eva;
import model.system.Transaction;
import model.system.Wallet;

public class AccountController {

    private final List<Account> accountList;
    private final TransactionController transactionController;
    private Eva eva;

    /**
     *
     * @param accountList
     * @param transactionController
     */
    public AccountController(List<Account> accountList, TransactionController transactionController) {
        this.accountList = accountList;
        this.transactionController = transactionController;
        createEva();
    }

// GETTERS ---
    
     public List<Account> getAccountList() {
        return accountList;
    }
 
    public TransactionController getTransactionController() {
        return transactionController;
    }
    
    /**
     *
     * @param id
     * @return
     */
    public Wallet getWalletById(String id) {

        for (Account account : accountList) {
            for (Wallet wallet : account.getWallets()) {
                if (id.equals(wallet.getID())) {
                    return wallet;
                }
            }
        }
        return null;

    }

    /**
     *
     * @param idAccount
     * @return
     */
    public Account getAccount(int idAccount) {
        for (Account account : accountList) {
            if (idAccount == account.getID()) {
                return account;
            }
        }
        return null;
    }

    /**
     *
     * @param username
     * @return
     */
    public Account getAccount(String username) {
        for (Account account : accountList) {
            if (username.equals(account.getUserName())) {
                return account;
            }
        }
        return null;
    }
    
     /**
     *
     * @param wallet
     * @return
     */
    public List<Transaction> getHistorial(Wallet wallet) {
        return transactionController.getHistorial(wallet);
    }
  
// ---
    
    private void createEva() {
        if (accountList.getSize() == 0) {
            eva = new Eva();
            accountList.add(eva);
        } else {
            for (Account account : accountList) {
                if (account.getID() == 0 && account instanceof Eva) {
                    eva = (Eva) account;
                    break;
                }
            }
        }
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public boolean verifyPassword(String username, String password) {
        for (Account account : accountList) {
            if ((account.getUserName().trim()).equals(username.trim())) {
                
                if ((account.getPassword()).equals(password)) {
                    
                    return true;
                    
                } else {
                    
                    System.out.println(AccountController.class.toString()  + " verifyPassword(String username, String password) : ERROR contraseña incorrecta");
                    
                    return false;
                    
                }

            }
        }

        System.out.println(AccountController.class.toString() + " verifyPassword(username, password) ERROR Usuario no encontrado");
        return false;
    }
    
   /**
     *
     * @param username
     * @return
     */
    public boolean verifyUsername(String username) {
        for (Account account : accountList) {
            if (account.getUserName().trim() == null ? username.trim() == null : account.getUserName().trim().equals(username.trim())) {
                return false;
            }
        }

        return true;
    }

    /**
     * Agrega las cuentas que ya han sido creadas y sólo se loguean.
     * @param account
     */
    public void addAccount(Account account) {
        this.accountList.add(account);
    }

    /**
     * Agrega una cuenta que no existía previamente y es su primer login.
     * @param account 
     */
    public void addNewAccount(Account account){
        moneyFistWallet(account);
        this.accountList.add(account);
    }

    /**
     * Agrega a la primera billetera de un usuario nuevo, 50k provenientes del usuario Génesis (Eva)
     * @param account
     */
    public void moneyFistWallet(Account account) {

        Wallet wallet = new Wallet(
                account.getUserName() + account.getWallets().getSize(),
                0,
                "Wallet de " + account.getUserName()
        );
        
        Wallet evaWallet = this.getWalletById("eva0");
        
        Transaction transaction = new Transaction(evaWallet, wallet, 50000, LocalDate.now(), "Hola, bienvenido a block-pay!");
        if (transactionController.addNewTransaction(transaction)) {
            transaction.getRemitent().setMoney(transaction.getRemitent().getMoney() - transaction.getMoney());
            transaction.getDestinatary().setMoney(transaction.getDestinatary().getMoney() + transaction.getMoney());
        }
        account.addWallet(wallet);
    }
    
    /**
     * Guardar la información en los archivos al cerrar el programa.
     */
    public void writeAccountInFile() {
        for (Account a : accountList) {
            if (!FileController.isAccountInFile(a)) {
                FileController.writeFile(FileController.findCreateFile("account.txt"),
                        a.getID() + "#" + a.getUserName() + "#" + a.getPassword());
            }

            for (Wallet wallet : a.getWallets()) {
                FileController.writeFile(FileController.findCreateFile("wallet.txt"),
                        wallet.getID() + "#" + wallet.getMoney() + "#" + wallet.getNickname() + "#" + a.getID());
            }
        }
        transactionController.writeTransactionInFile();
    }

}
