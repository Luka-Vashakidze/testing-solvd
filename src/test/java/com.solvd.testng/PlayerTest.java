package com.solvd.testng;

import com.solvd.gamestore.Player;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class PlayerTest {

    @Test
    public void testBuySuccess() {
        Player p = new Player("luka", 20);
        assertTrue(p.buy(10));
    }

    @Test
    public void testBuyFail() {
        Player p = new Player("luka", 5);
        assertFalse(p.buy(10));
    }

    @Test
    public void testBalanceDecrease() {
        Player p = new Player("luka", 20);
        p.buy(5);
        assertEquals(p.getBalance(), 15);
    }

    @Test
    public void testAddMoney() {
        Player p = new Player("luka", 10);
        p.addMoney(10);
        assertEquals(p.getBalance(), 20);
    }

    @Test
    public void testPurchaseCount() {
        Player p = new Player("luka", 50);
        p.buy(10);
        p.buy(10);
        assertEquals(p.getPurchases(), 2);
    }
}
