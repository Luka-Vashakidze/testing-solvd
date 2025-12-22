package com.solvd.testng;

import com.solvd.gamestore.Inventory;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class VerifyInventoryTest {

    @Test
    public void verifyTakeGameTest() {
        Inventory inv = new Inventory(5);
        assertTrue(inv.takeGame());
    }

    @Test
    public void verifyStockDecreaseTest() {
        Inventory inv = new Inventory(5);
        inv.takeGame();
        assertEquals(inv.getGamesInStock(), 4);
    }

    @Test
    public void verifyEmptyStockTest() {
        Inventory inv = new Inventory(0);
        assertFalse(inv.takeGame());
    }

    @Test
    public void verifyAddGamesTest() {
        Inventory inv = new Inventory(5);
        inv.addGames(3);
        assertEquals(inv.getGamesInStock(), 8);
    }

    @Test
    public void verifyStockPositiveTest() {
        Inventory inv = new Inventory(1);
        assertTrue(inv.getGamesInStock() > 0);
    }
}
