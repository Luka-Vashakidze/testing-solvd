package com.solvd.testng;

import com.solvd.gamestore.Checkout;
import com.solvd.gamestore.Game;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class CheckoutTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("checkout suite start");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("checkout suite end");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("new checkout test");
    }

    @Test
    public void testEmptyCheckout() {
        Checkout c = new Checkout();
        assertEquals(c.getTotal(), 0);
    }

    @Test
    public void testAddGame() {
        Checkout c = new Checkout();
        c.addGame(new Game("cs", 10));
        assertEquals(c.getTotal(), 10);
    }

    @Test
    public void testPaymentSuccess() {
        Checkout c = new Checkout();
        c.addGame(new Game("cs", 10));
        assertEquals(c.pay(20), 10);
    }

    @Test
    public void testPaymentFail() {
        Checkout c = new Checkout();
        c.addGame(new Game("cs", 10));
        assertEquals(c.pay(5), -1);
    }

    @Test
    public void testOrderIncrement() {
        Checkout c = new Checkout();
        int first = c.getOrderNumber();
        c.addGame(new Game("cs", 10));
        c.pay(10);
        assertEquals(c.getOrderNumber(), first + 1);
    }
}
