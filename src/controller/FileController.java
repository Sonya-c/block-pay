/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
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

    public static boolean searchAccount(Account account) {
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

    public static void loadWallets(Account account) {
        File walletFile = findCreateFile("wallet.txt");

        if (walletFile != null) {

            try {
                Scanner read = new Scanner(walletFile);
                while (read.hasNextLine()) {
                    String line = read.nextLine();
                    String data[] = line.split("#");
                    if (Integer.parseInt(data[3]) == account.getID() && account.getWallet(data[0]) != null) {
                        Wallet wallet = account.getWallet(data[0]);
                        wallet.setMoney(Double.parseDouble(data[1]));
                        System.out.println(FileController.class.getName() + "MENSAJE dinero de wallet actualizado : " + wallet.getMoney());
                    } else if (Integer.parseInt(data[3]) == account.getID()) {
                        Wallet wallet = new Wallet(data[0], Double.parseDouble(data[1]), data[2]);
                        account.addWallet(wallet);
                        System.out.println(FileController.class.getName() + " MENSAJE nueva wallet " + Arrays.toString(data) + " + " + account.getID());
                    }
                }

                System.out.println(FileController.class.getName() + " MENSAJE " + "Se ha terminado de leer");

            } catch (FileNotFoundException e) {
                System.out.println(FileController.class.getName() + " ERROR " + e.toString());
            }

        }

    }

    public static void updateWallet(File walletFile, Wallet wallet) {
        File newFile = new File(walletFile.getAbsolutePath() + ".tmp");
        try (BufferedReader br = new BufferedReader(new FileReader(walletFile))) {

            String line;
            while ((line = br.readLine()) != null) {
                String data[] = line.split("#");
                String walletIdTxt = data[0];
                if (walletIdTxt.equals(wallet.getID())) {
                    String newLine = wallet.getID() + "#" + String.valueOf(wallet.getMoney()) + "#" + wallet.getNickname() + data[3];
                    FileController.writeFile(newFile, newLine);
                }
            }
            br.close();
            if (!walletFile.delete()) {
                System.out.println("No se pudo borrar el archivo antiguo");
            }
            if (!newFile.renameTo(walletFile)) {
                System.out.println("No se pudo renombrar el archivo");
            }

        } catch (IOException e) {
            System.out.println(FileController.class.getName() + " ERROR " + e.toString());
        }
    }

    public static int searchWallet(Wallet wallet) {
        File accountFile = findCreateFile("wallet.txt");
        if (accountFile != null) {
            try {
                Scanner read = new Scanner(accountFile);
                while (read.hasNextLine()) {
                    String line = read.nextLine();
                    String data[] = line.split("#");
                    String walletId = data[0];
                    if (walletId.equals(wallet.getID()) && wallet.getMoney() != Double.parseDouble(data[1])) {
                        return -1;
                    } else if (walletId.equals(wallet.getID())) {
                        return 1;
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println(FileController.class.getName() + " ERROR " + e.toString());
            }
        }
        return 0;
    }

    public static boolean findTransaction(Transaction transaction) {
        File transactionFile = findCreateFile("transaction.txt");
        if (transactionFile != null) {
            try {
                Scanner read = new Scanner(transactionFile);
                while (read.hasNextLine()) {
                    String line = read.nextLine();
                    String data[] = line.split("#");
                    String walletRemitentId = data[0];
                    String walletDestinataryId = data[1];
                    String money = data[2];
                    if (walletRemitentId.equals(transaction.getRemitent().getID())
                            && walletDestinataryId.equals(transaction.getDestinatary().getID())
                            && Double.parseDouble(money) == transaction.getMoney() 
                            && transaction.getDate().toString().equals(data[3])
                            && transaction.getMessange().equals(data[4])) {
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
        File blockFile = findCreateFile("transaction.txt");

        if (blockFile != null) {

            try {
                Scanner read = new Scanner(blockFile);

                while (read.hasNextLine()) {
                    String line = read.nextLine();
                    String data[] = line.split("#");
                    // bloque, remitent, destinatary, money, date, messange

                    // BUSCAR WALLETS (Ni puta idea como)
                    Wallet walletRemitent = accountController.getWallet(data[0]);
                    Wallet walletDestinatary = accountController.getWallet(data[1]);
                    // IDEA DE BUSCAR WALLETS ||

                    double money = Double.parseDouble(data[2]);

                    String dateString[] = data[3].split("-");
                    LocalDate date = LocalDate.of(Integer.parseInt(dateString[0]),
                            Integer.parseInt(dateString[1]), Integer.parseInt(dateString[2]));

                    Transaction transaction = new Transaction(walletRemitent, walletDestinatary, money, date, data[4]);
                    transactionController.uploadTransaction(transaction);
                    System.out.println(
                            FileController.class.getName()
                            + " MENSAJE transacción " + " #"
                            + transactionController.getBlockList().getSize()
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
