package com.solvd.gamestore;

public class Inventory {

    private int gamesInStock;

    public Inventory(int count) {
        this.gamesInStock = count;
    }

    public boolean takeGame() {
        if (gamesInStock > 0) {
            gamesInStock--;
            return true;
        }
        return false;
    }

    public void addGames(int count) {
        gamesInStock += count;
    }

    public int getGamesInStock() {
        return gamesInStock;
    }
}
