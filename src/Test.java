
import controller.AccountController;
import controller.TransactionController;
import java.util.Scanner;
import model.system.Account;

public class Test {
    
    public static void main(String args[]) {
        Scanner read = new Scanner(System.in);
        TransactionController transactionCtrl = new TransactionController();
        AccountController accountCtrl = new AccountController();
        
        for (Account account : accountCtrl.getAccountList()) {
            System.out.println(account.getUserName() + " " + account.getPassword());
        }
        
        String usuario, password;
        do {
            System.out.print("Usuario: ");
            usuario = read.next();

            System.out.print("Contraseña: ");
            password = read.next();
        } while(!accountCtrl.verifyPassword(usuario, password));
        
        System.out.println("Login Exitoso");
    }
}
