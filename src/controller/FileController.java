/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import model.list.List;
import model.system.Account;
import model.system.Block;
import model.system.Transaction;

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
                    
                    Account account = new Account(data[0], data[1], data[2]);
                    accountList.add(account);
                    
                    System.out.println(
                            FileController.class.getName() +
                            " #" +
                            accountList.getSize() +
                            " MENSAJE nueva account "
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
    
    
    private static void loadWallets(Account account) {
        File walletFile = findCreateFile("wallet.txt");
        
        // BUSCAR LAS WALLETS DE ESTE USUARIO
    }
    
    /**
     * 
     * @param transactionController
     * @return 
     */
    public static List<Block> loadBlock(TransactionController transactionController) {
        List<Block> blockList = new List<>();
        
        File blockFile = findCreateFile("transaction.txt");
        
        if (blockFile != null) {
            
            try {
                Scanner read = new Scanner(blockFile);
            
                while (read.hasNextLine()) {
                    String line = read.nextLine();
                    String data[] = line.split("#");
                    // remitent, destinatary, money, date, messange
                    
                    // BUSCAR WALLETS (Ni puta idea como)
                    
                    double money = Double.parseDouble(data[2]);
                    
                    String dateString[] = data[3].split("/");
                    Date date = new Date(Integer.parseInt(dateString[0]),
                            Integer.parseInt(dateString[1]),
                            Integer.parseInt(dateString[2]),
                            Integer.parseInt(dateString[3]),
                            Integer.parseInt(dateString[4]));
                    
                    Transaction transaction = new Transaction(null, null, money, date, data[4]);
                    
                    transactionController.add(transaction);
                    
                    System.out.println(
                            FileController.class.getName() +
                            " #" +
                            blockList.getSize() +
                            " MENSAJE nueva account "
                            + Arrays.toString(data));
                }
                
                System.out.println(FileController.class.getName() + " MENSAJE " + "Se ha terminado de leer");
                
            } catch (FileNotFoundException e) {
                System.out.println(FileController.class.getName() + " ERROR " + e.toString());
            }
        } else {
            System.out.println(FileController.class.getName() + " ERROR account file null");
        }
        
        return blockList;
    }
}
