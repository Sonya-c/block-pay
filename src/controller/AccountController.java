package controller;

import model.list.List;
import model.list.ListNode;
import model.system.Account;
import model.system.Wallet;

public class AccountController {

    private final List<Account> accountList;

    public AccountController() {
        this.accountList = FileController.loadAccount();
        createEva();
    }

    public AccountController(List<Account> accountList) {
        this.accountList = accountList;
        createEva();
    }

    private void createEva() {
        Account eva = new Account(0, "user", "password0");
        if (accountList.getSize() == 0) {
            accountList.add(new Account(0, "user0", "password0"));
            eva.addWallet(new Wallet(1, Double.MAX_VALUE, "user0"));
            FileController.writeFile(FileController.findCreateFile("account.txt"), 0 + "#" + "user0" + "#" + "password0");
            FileController.writeFile(FileController.findCreateFile("wallet.txt"), 1 + "#" + String.valueOf(Double.MAX_VALUE) + "#" + "user0" + "#" + 0);
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

    public void moneyFirstWallet(List<Wallet> wallets, int ID, String userName, String password) {
        wallets.add(new Wallet(ID - 10 + 282,
                50000,
                (userName.substring(0, 3).concat(password.substring(0, 3))).toLowerCase()));
        ListNode<Account> eva = accountList.getHead();
        double moneyTemp = eva.getInfo().getWallets().getHead().getInfo().getMoney();
        eva.getInfo().getWallets().getHead().getInfo().setMoney(moneyTemp - 50000);
    }

    public Wallet getWallet(int idWallet) {
        for (Account account : accountList) {
            for (Wallet wallet : account.getWallets()) {
                if (idWallet == wallet.getID()) {
                    return wallet;
                }
            }
        }
        return null;
    }

    public Account getAccount(int idAccount) {
        for (Account account : accountList) {
            if (idAccount == account.getID()) {
                return account;
            }
        }
        return null;
    }

    public List<Account> getAccountList() {
        return accountList;
    }
}
