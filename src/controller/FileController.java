/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import model.list.List;
import model.system.Account;
import model.system.Transaction;
import model.system.Wallet;

/**
 *
 * @author 57301
 */
public class FileController {

    private static final String DIR = "C:\\Block-Pay\\";

    /**
     *
     * @param fileName
     * @return
     */
    public static File findCreateFile(String fileName) {
        File file = new File(DIR + fileName);

        if (!file.exists()) {
            file.getParentFile().mkdirs();

            try {
                file.createNewFile();
                System.out.println(FileController.class.getName() + " MENSAJE  acceso a " + fileName);

            } catch (IOException e) {
                System.out.println(FileController.class.getName() + " ERROR " + e.toString());
            }
        }

        return file;
    }

    /**
     * @param file
     * @param line 
     */
    
    public static void writeFile(File file, String line) {
        try (FileWriter fw = new FileWriter(file.getAbsoluteFile(), true)) {
            //casting
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                //casting
                bw.write(line);
                bw.newLine();

                bw.flush();
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al cargar archivo");
        }
    }

    /**
     *
     * @return 
     */
    public static List<Account> loadAccount() {
        List<Account> accountList = new List<>();

        File accountFile = findCreateFile("account.txt");

        if (accountFile != null) {

            try {
                Scanner read = new Scanner(accountFile);

                while (read.hasNextLine()) {
                    String line = read.nextLine();
                    String data[] = line.split("#");

                    Account account = new Account(Integer.parseInt(data[0]), data[1], data[2]);
                    
                    accountList.add(account);

                    System.out.println(
                            FileController.class.getName()
                            + " #"
                            + accountList.getSize()
                            + " MENSAJE nueva account "
                            + Arrays.toString(data));
                }

                System.out.println(FileController.class.getName() + " MENSAJE " + "Se ha terminado de leer");

            } catch (FileNotFoundException e) {
                System.out.println(FileController.class.getName() + " ERROR " + e.toString());
            }
        } else {
            System.out.println(FileController.class.getName() + " ERROR account file null");
        }

        return accountList;
    }

    /**
     * 
     * @param account
     * @return 
     */
     public static boolean isAccountInFile(Account account) {
        File accountFile = findCreateFile("account.txt");
        if (accountFile != null) {
            try {
                Scanner read = new Scanner(accountFile);
                while (read.hasNextLine()) {
                    String line = read.nextLine();
                    String data[] = line.split("#");
                    String user = data[1];
                    if (user.equals(account.getUserName())) {
                        return true;
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println(FileController.class.getName() + " ERROR " + e.toString());
            }
        }
        return false;
    }
    
    /**
     * @param account
    */
    public static void loadWallets(Account account) {
        File walletFile = findCreateFile("wallet.txt");

        if (walletFile != null) {

            try {
                Scanner read = new Scanner(walletFile);
                while (read.hasNextLine()) {
                    String line = read.nextLine();
                    String data[] = line.split("#");
                    if (Integer.parseInt(data[3]) == account.getID()) {
                        Wallet wallet = new Wallet(data[0], Double.parseDouble(data[1]), data[2]);
                        if (account.getWallet(data[0]) == null) {
                            account.addWallet(wallet);
                        } else if (account.getWallet(data[0]) != null && 
                                account.getWallet(data[0]).getMoney() != wallet.getMoney()){
                            account.getWallet(data[0]).setMoney(wallet.getMoney());
                            System.out.println(FileController.class.toString() + " MENSAJE actualizado el dinero de "
                                    + wallet.getID() + " -- ahora : " + account.getWallet(data[0]).getMoney());
                        }
                    }
                }

                System.out.println(FileController.class.getName() + " MENSAJE " + "Se ha terminado de leer");

            } catch (FileNotFoundException e) {
                System.out.println(FileController.class.getName() + " ERROR " + e.toString());
            }

        }

    }
  /**
     *
     * @param transaction
     * @return 
     */
    public static boolean isTransactionInFile(Transaction transaction) {
        File accountFile = findCreateFile("transaction.txt");
        if (accountFile != null) {
            try {
                Scanner read = new Scanner(accountFile);
                while (read.hasNextLine()) {
                    String line = read.nextLine();
                    String data[] = line.split("#");
                    String walletRemitentId = data[0];
                    String walletDestinataryId = data[1];
                    String money = data[2];
                    if (walletRemitentId.equals(transaction.getRemitent().getID())
                            && walletDestinataryId.equals(transaction.getDestinatary().getID())
                            && Double.parseDouble(money) == transaction.getMoney()) {
                        return true;
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println(FileController.class.getName() + " ERROR " + e.toString());
            }
        }
        return false;
    }

    /**
     *
     * @param accountController
     * @param transactionController
     */
    public static void loadBlock(AccountController accountController, TransactionController transactionController) {
        File transactionFile = findCreateFile("transaction.txt");

        if (transactionFile != null) {

            try {
                Scanner read = new Scanner(transactionFile);

                while (read.hasNextLine()) {
                    String line = read.nextLine();
                    String data[] = line.split("#");

                    //Busqueda de wallets
                    Wallet walletRemitent = accountController.getWalletById(data[0]);
                    Wallet walletDestinatary = accountController.getWalletById(data[1]);

                    double money = Double.parseDouble(data[2]);

                    String dateString[] = data[3].split("-");
                    LocalDate date = LocalDate.of(Integer.parseInt(dateString[0]),
                            Integer.parseInt(dateString[1]), Integer.parseInt(dateString[2]));
                    Transaction transaction = new Transaction(walletRemitent, walletDestinatary, money, date, data[4]);
                    transactionController.addTransaction(transaction);
                }

                System.out.println(FileController.class.getName() + " MENSAJE " + "Se ha terminado de leer");

            } catch (FileNotFoundException e) {
                System.out.println(FileController.class.getName() + " ERROR " + e.toString());
            }
        } else {
            System.out.println(FileController.class.getName() + " ERROR transactionFile null");
        }
    }

}
