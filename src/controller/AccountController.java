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

    /** 
     * CHECK THIS!!!!!
     */
    private void createEva() {
        
        if (accountList.getSize() == 0) {
            eva = new Eva();
            accountList.add(eva);
            
            // CHECK THIS!!!
            FileController.writeFile(FileController.findCreateFile("account.txt"), 0 + "#" + eva.getUserName() + "#" + eva.getPassword());
            FileController.writeFile(FileController.findCreateFile("wallet.txt"), 1 + "#" + String.valueOf(Double.MAX_VALUE) + "#" + "Eva's wallet" + "#" + String.valueOf(eva.getID()));
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

                if ((account.getPassword().trim()).equals(password.trim())) {
                    return true;
                } else {
                    System.out.println("controller.AccountController.verifyPassword(username, password) ERROR contraseña incorrecta");
                    return false;
                }

            }
        }

        System.out.println("controller.AccountController.verifyPassword(username, password) ERROR Usuario no encontrado");
        return false;
    }

    /**
     *
     * @param username
     * @return
     */
    public boolean verifyUsername(String username) {
        for (Account account : accountList) {
            if (account.getUserName() == null ? username == null : account.getUserName().equals(username)) {
                return false;
            }
        }

        return true;
    }

    /**
     *
     * @param account
     */
    public void addAccount(Account account) {
        this.accountList.add(account);
        FileController.writeFile(FileController.findCreateFile("account.txt"), (account.getID() + "#" + account.getUserName() + "#" + account.getPassword()));
    }

    /**
     * 
     * @param account 
     */
    public void moneyFistWallet(Account account) {
              
        Wallet wallet = new Wallet(
                account.getUserName() + account.getWallets().getSize(),
                0,
                "Wallet de " + account.getUserName()
        );
        
        Transaction transaction = new Transaction(eva.getWallet("eva0"), wallet, 50000, LocalDate.now() , "Hola, bienvenido a block-pay");
        transactionController.add(transaction);
        account.addWallet(wallet);
    }
    
    /**
     * 
     * @param idWallet
     * @return 
     */
    public Wallet getWallet(String idWallet) {
        for (Account account : accountList) {
            for (Wallet wallet : account.getWallets()) {
                if (idWallet == null ? wallet.getID() == null : idWallet.equals(wallet.getID())) {
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
     * @return 
     */
    public List<Account> getAccountList() {
        return accountList;
    }
}
