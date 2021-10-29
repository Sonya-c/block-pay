
import controller.AccountController;
import controller.FileController;
import controller.TransactionController;
import model.system.Account;
import view.LoginView;

/**
 *
 * @author sonya
 */
public class App {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        TransactionController transactionController = new TransactionController();
        
        AccountController accountController = new AccountController(FileController.loadAccount(), transactionController);
        
         for (Account account : accountController.getAccountList()) {
            FileController.loadWallets(account);
        }
        
        FileController.loadBlock(accountController, transactionController);

        // Mostra la vista principal
        LoginView loginView = new LoginView(accountController);
        loginView.setVisible(true);
    }
}
