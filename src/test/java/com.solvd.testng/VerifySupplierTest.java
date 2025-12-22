package com.solvd.testng;

import com.solvd.gamestore.Supplier;
import org.testng.annotations.*;
import static org.testng.Assert.*;

public class VerifySupplierTest {

    @BeforeClass
    public void beforeClass() {
        System.out.println("supplier class start");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("supplier class end");
    }

    @Test
    public void testSupplySuccess() {
        Supplier s = new Supplier(10);
        assertTrue(s.supply(5));
    }

    @Test
    public void testSupplyFail() {
        Supplier s = new Supplier(3);
        assertFalse(s.supply(5));
    }

    @Test
    public void testStockDecrease() {
        Supplier s = new Supplier(10);
        s.supply(4);
        assertEquals(s.getStock(), 6);
    }

    @Test
    public void testRestock() {
        Supplier s = new Supplier(5);
        s.restock(5);
        assertEquals(s.getStock(), 10);
    }

    @Test
    public void testStockPositive() {
        Supplier s = new Supplier(1);
        assertTrue(s.getStock() > 0);
    }
}
