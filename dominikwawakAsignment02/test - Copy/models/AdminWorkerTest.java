/*
package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AdminWorkerTest {
    private AdminWorker admin1, admin2;

    @Before
    public void setUp() throws Exception {
        admin1 = new AdminWorker(39.5, 10, "Larry", "Walsh", "larry@hotmail.com", "0896564655", 20);
        admin2 = new AdminWorker(20, 10, "Barry", "lee", "barry@hotmail.com", "08966767887", -10); // negative
    }

    @After
    public void tearDown() throws Exception {
        admin1 = admin2 = null;
    }

    @Test
    public void getFixedBounus() {
        assertEquals(20, admin1.getFixedBounus(), 0.01);
        assertEquals(0, admin2.getFixedBounus(), 0.01);
    }

    @Test
    public void setFixedBounus() {
        admin1.setFixedBounus(-100);
        admin2.setFixedBounus(50);
        assertEquals(20, admin1.getFixedBounus(), 0.01);
        assertEquals(50, admin2.getFixedBounus(), 0.01);
    }

    @Test
    public void calculateSalary() {
        assertEquals(418.95, admin1.calculateSalary(), 0.01);
        assertEquals(202, admin2.calculateSalary(), 0.01);
    }

    @Test
    public void testToString() {
        assertTrue(admin1.toString().contains("fixed Bonus="));
        assertTrue(admin1.toString().contains("20"));
        assertTrue(admin2.toString().contains("Barry"));
    }


}

 */