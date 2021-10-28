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
    }
    
    /**
     * 
     * @param account
     * @return 
     */
    public double getSaldo(Account account){
        return transactionController.getSaldo(account);
    }
    
    public void writeAccountInFile() {
        for (Account a : accountList) {
            if (!FileController.searchAccount(a)) {
                FileController.writeFile(FileController.findCreateFile("account.txt"),
                        a.getID() + "#" + a.getUserName() + "#" + a.getPassword());
            }

            for (Wallet wallet : a.getWallets()) {
                if (FileController.searchWallet(wallet) == 0) {
                    FileController.writeFile(FileController.findCreateFile("wallet.txt"),
                            wallet.getID() + "#" + wallet.getMoney() + "#" + wallet.getNickname() + "#" + a.getID());
                } else if (FileController.searchWallet(wallet) == -1) {
                    FileController.updateWallet(wallet);
                }
            }
        }
        transactionController.writeTransactionInFile();
    }

    /**
     * 
     * @param wallet
     * @return 
     */
    public String getHistorial(Wallet wallet) {
        return transactionController.getHistorial(wallet);
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
        Transaction transaction = new Transaction(this.getWallet("eva0"), wallet, 50000, LocalDate.now(), "Hola, bienvenido a block-pay");
        if (transactionController.add(transaction) <= 0) {
            transaction.getRemitent().setMoney(transaction.getRemitent().getMoney() - transaction.getMoney());
            transaction.getDestinatary().setMoney(transaction.getDestinatary().getMoney() + transaction.getMoney());
      
        }
        account.addWallet(wallet);
    }

    /**
     *
     * @param id
     * @return
     */
    public Wallet getWallet(String id) {

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
     * @param nickname
     * @return 
     */
    public Wallet getWalletByNickname(String nickname) {
        if (nickname != null) {
            for (Account account : accountList) {
               for (Wallet wallet : account.getWallets()) {
                   if (nickname.equals(wallet.getNickname())) {
                       return wallet;
                   }
               }
           }
        } else {
            System.out.println("controller.AccountController.getWalletByNickname(nickname) ERROR null nickname");
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

    /**
     * 
     * @return 
     */
    public TransactionController getTransactionController() {
        return transactionController;
    }

}
