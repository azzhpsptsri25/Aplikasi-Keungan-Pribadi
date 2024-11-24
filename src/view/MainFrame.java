/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.Transaction;
import service.TransactionService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

public class MainFrame extends JFrame {

    private TransactionService transactionService;
    private DefaultListModel<String> transactionListModel;

    public MainFrame() {
        transactionService = new TransactionService();
        transactionListModel = new DefaultListModel<>();

        setTitle("Aplikasi Keuangan Pribadi");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header
        JLabel label = new JLabel("Selamat Datang di Aplikasi Keuangan!");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label, BorderLayout.CENTER);

        // List
        JList<String> transactionList = new JList<>(transactionListModel);
        add(new JScrollPane(transactionList), BorderLayout.CENTER);

        // Footer
        JButton addButton = new JButton("Tambah Transaksi");
        add(addButton, BorderLayout.SOUTH);

        // Event Listener
        addButton.addActionListener((ActionEvent e) -> {
            showAddTransactionDialog();
        });
    }

    private void showAddTransactionDialog() {
        JTextField titleField = new JTextField();
        JTextField amountField = new JTextField();
        Object[] fields = {
            "Judul:", titleField,
            "Jumlah:", amountField
        };

        int option = JOptionPane.showConfirmDialog(this, fields, "Tambah Transaksi", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String title = titleField.getText();
            double amount = Double.parseDouble(amountField.getText());
            Transaction transaction = new Transaction(title, amount, new Date());
            transactionService.addTransaction(transaction);
            transactionListModel.addElement(transaction.toString());
        }
    }
}

