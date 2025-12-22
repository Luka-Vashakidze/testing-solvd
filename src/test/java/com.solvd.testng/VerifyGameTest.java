package com.solvd.testng;

import com.solvd.gamestore.Game;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class VerifyGameTest {

    @Test
    public void testGameTitleLowercase() {
        Game g = new Game("CSGO", 10);
        assertEquals(g.getTitle(), "csgo");
    }

    @Test
    public void testGamePrice() {
        Game g = new Game("doom", 20);
        assertEquals(g.getPrice(), 20);
    }

    @Test
    public void testDifferentGame() {
        Game g = new Game("gta", 30);
        assertTrue(g.getPrice() > 0);
    }

    @Test
    public void testZeroPrice() {
        Game g = new Game("free", 0);
        assertEquals(g.getPrice(), 0);
    }

    @Test
    public void testGameNotNull() {
        Game g = new Game("test", 5);
        assertNotNull(g);
    }
}
