
import controller.AccountController;
import controller.FileController;
import controller.TransactionController;
import java.util.Scanner;
import model.system.Account;

public class Test {

    public static void main(String args[]) {
        Scanner read = new Scanner(System.in);
        TransactionController transactionCtrl = new TransactionController();
        AccountController accountCtrl = new AccountController();

        accountCtrl.addAccount(new Account(1, "Natalia", "Mendoza"));

        for (Account account : accountCtrl.getAccountList()) {
            System.out.println(account.getUserName() + " " + account.getPassword());
            System.out.println(account.getWallets());
        }

        String usuario = null, password = null;
        int i = 0;
        do {
            if (usuario != null & password != null && !accountCtrl.verifyUsername(usuario)) {
                accountCtrl.addAccount(new Account(i++,usuario,password));
            }

            System.out.print("Usuario: ");
            usuario = read.next();

            System.out.print("Contraseña: ");
            password = read.next();
            
            i++;
        } while (!accountCtrl.verifyPassword(usuario, password));

        System.out.println("Login Exitoso");
    }
}
