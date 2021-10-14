/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.system;

import controller.TransactionController;
import model.dynamic.list.List;
import model.dynamic.list.ListNode;

/**
 *
 * @author 57301
 */
public class Graph {

    private List mainNode;
    private ListNode<Account> listUsers;
    private ListNode<Block> listBlocks;
    private TransactionController tc;

    public Graph() {

        mainNode = new List(2);

        mainNode.add("Usuarios");
        mainNode.add("Transacciones");

        this.tc = new TransactionController();
    }

    public void addNodeUser(Account account) {
        listUsers = mainNode.getNode("Usuarios");

        while (listUsers != null) {
            listUsers = listUsers.getNext();
        }

        if (listUsers == null) {
            listUsers = new ListNode(account);
            listUsers.setPrev(listUsers.getPrev());
            listUsers.setNext(null);
            System.out.println("model.system.Graph.addNodoUser(Account) MENSAJE: inserción realizada");
        } else {
            System.out.println("model.system.Graph.addNodoUser(Account) ERROR: no hubo inserción");
        }

        mainNode.getNode("Usuarios").add(listUsers);
    }

    public void addNodeTrans(Transaction transaction) {
        listBlocks = mainNode.getNode("Transacciones");
        ListNode temp = listBlocks;
        int sw = 3;
        
        while (temp != null && sw < 3) {
            if (temp.getInfo() instanceof Block) {
                Block b = (Block) temp.getInfo();
                sw = b.getTransactions().getSize();
            }
            temp = temp.getNext();
        }

        
        
        tc.add(transaction);
        
        
    }

    public List getMainNode() {
        return mainNode;
    }

    public ListNode<Account> getListUsers() {
        return listUsers;
    }

    public ListNode<Block> getListBlocks() {
        return listBlocks;
    }

    
    
}
