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
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import model.list.List;
import model.system.Account;
import model.system.Block;
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

    public static void updateAccount(Account account) {
        File accountFile = findCreateFile("account.txt");

        if (accountFile != null) {

            File newFile = new File(accountFile.getAbsolutePath() + ".tmp");

            try {
                Scanner read = new Scanner(accountFile);
                while (read.hasNextLine()) {
                    String line = read.nextLine();
                    String data[] = line.split("#");
                    String user = data[1];
                    if (user.equals(account.getUserName())) {
                        String updateAccount = account.getID() + "#" + account.getUserName() + "#" + account.getPassword();
                        writeFile(newFile, updateAccount);
                    } else {
                        writeFile(newFile, line);
                    }
                }
                if (!accountFile.delete()) {
                    System.out.println(FileController.class.getName() + " MENSAJE " + "No se pudo borrar el archivo antiguo");
                }
                if (!newFile.renameTo(accountFile)) {
                    System.out.println(FileController.class.getName() + " MENSAJE " + "No se pudo renombrar el archivo");
                }
            } catch (FileNotFoundException e) {
                System.out.println(FileController.class.getName() + " ERROR " + e.toString());
            }

        }

    }

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
                        account.addWallet(wallet);
                    }
                }

                System.out.println(FileController.class.getName() + " MENSAJE " + "Se ha terminado de leer");

            } catch (FileNotFoundException e) {
                System.out.println(FileController.class.getName() + " ERROR " + e.toString());
            }

        }

    }

    public static void updateWallet(Wallet wallet) {
        File walletFile = findCreateFile("wallet.txt");

        if (walletFile != null) {

            File newFile = new File(walletFile.getAbsolutePath() + ".tmp");

            try {
                Scanner read = new Scanner(walletFile);
                while (read.hasNextLine()) {
                    String line = read.nextLine();
                    String data[] = line.split("#");
                    String idWallet = data[0];
                    
                    if (idWallet == wallet.getID()) {
                        String updateWallet = wallet.getID() + "#" + wallet.getMoney() + "#" + wallet.getNickname() + data[3];
                        writeFile(newFile, updateWallet);
                    } else {
                        writeFile(newFile, line);
                    }
                }
                if (!walletFile.delete()) {
                    System.out.println(FileController.class.getName() + " MENSAJE " + "No se pudo borrar el archivo antiguo");
                }
                if (!newFile.renameTo(walletFile)) {
                    System.out.println(FileController.class.getName() + " MENSAJE " + "No se pudo renombrar el archivo");
                }
            } catch (FileNotFoundException e) {
                System.out.println(FileController.class.getName() + " ERROR " + e.toString());
            }

        }
    }

    /**
     *
     * @param accountController
     * @param transactionController
     */
    public static void loadBlock(AccountController accountController, TransactionController transactionController) {
        File blockFile = findCreateFile("transaction.txt");

        if (blockFile != null) {

            try {
                Scanner read = new Scanner(blockFile);

                while (read.hasNextLine()) {
                    String line = read.nextLine();
                    String data[] = line.split("#");
                    // remitent, destinatary, money, date, messange

                    // BUSCAR WALLETS (Ni puta idea como)
                    Wallet walletRemitent = accountController.getWallet(data[1]);
                    Wallet walletDestinatary = accountController.getWallet(data[2]);
                    // IDEA DE BUSCAR WALLETS ||

                   double money = Double.parseDouble(data[3]);

                    String dateString[] = data[4].split(" ");
                    Date date = new Date(Integer.parseInt(dateString[0]),
                            Integer.parseInt(dateString[1]),
                            Integer.parseInt(dateString[2]),
                            Integer.parseInt(dateString[3]),
                            Integer.parseInt(dateString[4]));

                    Transaction transaction = new Transaction(walletRemitent, walletDestinatary, money, date, data[4]);
                    transactionController.add(transaction);

                    System.out.println(
                            FileController.class.getName()
                            + " #"
                            + transactionController.getBlockList().getSize()
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

    }

}
