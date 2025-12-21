package com.solvd.gamestore;

public class Game {

    private String title;
    private double price;

    public Game(String title, double price) {
        this.title = title.toLowerCase();
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
}
