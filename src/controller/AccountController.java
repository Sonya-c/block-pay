
package controller;

import model.list.List;
import model.system.Account;

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
        if (accountList.getSize() == 0) {
            accountList.add(new Account("0", "user0", "password0"));
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

    public List<Account> getAccountList() {
        return accountList;
    }
}
