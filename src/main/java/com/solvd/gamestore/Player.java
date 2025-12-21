package com.solvd.gamestore;

public class Player {

    private String name;
    private double balance;
    private int purchases;

    public Player(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.purchases = 0;
    }

    public boolean buy(double price) {
        if (balance >= price) {
            balance -= price;
            purchases++;
            return true;
        }
        return false;
    }

    public void addMoney(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public int getPurchases() {
        return purchases;
    }
}
