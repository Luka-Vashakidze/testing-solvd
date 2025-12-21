package com.solvd.gamestore;

public class Checkout {

    private double total;
    private int orderNumber;

    public Checkout() {
        total = 0;
        orderNumber = 1;
    }

    public void addGame(Game g) {
        total += g.getPrice();
    }

    public double pay(double amount) {
        if (amount >= total) {
            double change = amount - total;
            total = 0;
            orderNumber++;
            return change;
        }
        return -1;
    }

    public double getTotal() {
        return total;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
}
