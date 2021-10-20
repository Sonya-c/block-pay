
import controller.AccountController;
import controller.FileController;
import controller.TransactionController;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import model.system.Account;
import model.system.Block;
import model.system.Transaction;
import model.system.Wallet;

public class Test {

    public static void main(String args[]) {
        Scanner read = new Scanner(System.in);
        
        TransactionController transactionController = new TransactionController();
        AccountController accountController = new AccountController(FileController.loadAccount(), transactionController);
        FileController.loadBlock(accountController, transactionController);
        Account a1 = new Account(1, "Natalia", "DolexFortee");
        accountController.addAccount(a1);
        accountController.moneyFistWallet(a1);
        Account a2 = new Account(2, "Sonya", "HelloDarknessMyOldFriend");
        accountController.addAccount(a2);
        accountController.moneyFistWallet(a2);
        Account a3 = new Account(3, "Yuli", "holamundo:v");
        accountController.addAccount(a3);
        accountController.moneyFistWallet(a3);

        for (Account account : accountController.getAccountList()) {
            System.out.println(account.getUserName() + " " + account.getPassword());
            for (Wallet wallet : account.getWallets()) {
                System.out.println(wallet.getNickname() + " " + wallet.getMoney());
            }
        }

        Transaction t1 = new Transaction(a3.getWallet("Yuli0"),
                a2.getWallet("Sonya0"), 25000, LocalDate.now(), "De a3 para a2"); //EXITOSA
        transactionController.add(t1);
        Transaction t2 = new Transaction(a1.getWallet("Natalia0"),
                a2.getWallet("Sonya0"), 50000, LocalDate.now(), "De a1 para a2"); //EXITOSA
        transactionController.add(t2);
        Transaction t3 = new Transaction(a1.getWallet("Natalia0"),
                a3.getWallet("Yuli0"), 25000, LocalDate.now(), "De a1 para a3"); //PROBLEMA
        transactionController.add(t3);
        Transaction t4 = new Transaction(a3.getWallet("Yuli0"),
                a1.getWallet("Natalia0"), 5000, LocalDate.now(), "De a3 para a1"); //EXITOSA
        transactionController.add(t4);

        for (Block block : transactionController.getBlockList()) {
            for (Transaction transaction : block.getTransactions()) {
                System.out.println(block.toString() + " - " + transaction.toString());
            }
        }

    }
//  String usuario = null, password = null;
//        int i = 0;
//        do {
//            if (usuario != null & password != null && !accountController.verifyUsername(usuario)) {
//                accountController.addAccount(new Account(i++,usuario,password));
//            }
//
//            System.out.print("Usuario: ");
//            usuario = read.next();
//
//            System.out.print("Contraseña: ");
//            password = read.next();
//            
//            i++;
//        } while (!accountController.verifyPassword(usuario, password));
//
//        System.out.println("Login Exitoso");
}
