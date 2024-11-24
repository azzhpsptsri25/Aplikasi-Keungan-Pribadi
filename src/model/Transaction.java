/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.Date;

public class Transaction {
    private String title;
    private double amount;
    private Date date;
    
    public Transaction(String title, double amount, Date date) {
        this.title = title;
        this.amount = amount;
        this.date = date;
    }
    
    public String getTitle() {
        return title;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return title + " - " + amount + " - " + date;
    }

    
}

