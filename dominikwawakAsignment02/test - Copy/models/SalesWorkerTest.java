package models;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SalesWorkerTest {

    private SalesWorker sales1, sales2;

    @Before
    public void setUp() throws Exception {
        sales1 = new SalesWorker(50, 20, "Dan", "Jene", "dan@fun.com", "0863563673", 5.9);
        sales2 = new SalesWorker(40, 25, "John", "Joe", "jon@hon.com", "07837484575", 50); //percentage bonus is too big


    }

    @AfterEach
    void tearDown() {
        sales1 = sales2 = null;
    }

    @Test
    public void getPercentageBonus() {
        assertEquals(0.059, sales1.getPercentageBonus(), 0.01);
        assertEquals(0, sales2.getPercentageBonus(), 0.01);

    }

    @Test
    public void setPercentageBonus() {
        sales1.setPercentageBonus(20);  // boundary
        assertEquals(0.2, sales1.getPercentageBonus(), 0.01);
        sales2.setPercentageBonus(10);
        sales2.setPercentageBonus(100);
        assertEquals(0.1, sales2.getPercentageBonus(), 0.01);

    }

    @Test
    public void calculateSalary() {
        assertEquals(1503.78, sales1.calculateSalary(), 0.01);
        assertEquals(1025, sales2.calculateSalary(), 0.01);

    }

    @Test
    public void TestToString() {
        assertTrue(sales1.toString().contains("percentage Bonus="));
        assertTrue(sales1.toString().contains("0.059"));
        assertTrue(sales2.toString().contains("John"));


    }
}