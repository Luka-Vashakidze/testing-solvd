package com.solvd.gamestore;

public class Supplier {

    private int stock;

    public Supplier(int stock) {
        this.stock = stock;
    }

    public boolean supply(int amount) {
        if (stock >= amount) {
            stock -= amount;
            return true;
        }
        return false;
    }

    public void restock(int amount) {
        stock += amount;
    }

    public int getStock() {
        return stock;
    }
}
