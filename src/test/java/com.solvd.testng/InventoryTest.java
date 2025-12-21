package com.solvd.testng;

import com.solvd.gamestore.Inventory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class InventoryTest {

    private Inventory inv;

    @BeforeMethod
    public void setup() {
        inv = new Inventory(5);
    }

    @Test
    public void testTakeGame() {
        assertTrue(inv.takeGame());
    }

    @Test
    public void testStockDecrease() {
        inv.takeGame();
        assertEquals(inv.getGamesInStock(), 4);
    }

    @Test
    public void testEmptyStock() {
        inv = new Inventory(0);
        assertFalse(inv.takeGame());
    }

    @Test
    public void testAddGames() {
        inv.addGames(3);
        assertEquals(inv.getGamesInStock(), 8);
    }

    @Test
    public void testStockPositive() {
        assertTrue(inv.getGamesInStock() > 0);
    }
}
