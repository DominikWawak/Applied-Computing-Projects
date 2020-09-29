


package models;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test Class for the abstract class utils.Utilities.Employee
 * <p>
 * Note that we are testing via the AdminWorker class, but we are
 * only testing methods that reside in the utils.Utilities.Employee class
 *
 * @author Siobhan Drohan & Mairead Meagher
 * @version 03/20
 **/

public class EmployeeTest {

    private AdminWorker empNormal1, empWrongDetail, empOnEdge, empNormalWorkWeek, empBelowNormalWorkWeek;


    /**
     * Method to set up data for testing.
     *
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        empNormal1 = new AdminWorker(42, 13, "Sean", "McSean", "sean@gmail.com", "089981718", 20); // all correct ignoring specific feild
        empWrongDetail = new AdminWorker(-20, -10, "Sean56789123456789123", "McSean789012345678901", "seanatgmaildotcom", "double089981718", 20); // all incorrect, names >20, invalid email, number contains letters
        empOnEdge = new AdminWorker(0, 0, "Sean5678912345678912", "McSean78901234567890", "seanat@gmail.mail.dotcom", "089981718", 20); // names have 20 chars, and the hoursWorked and hourlyWage is 0,
        empNormalWorkWeek = new AdminWorker(39.5, 10, "Sean", "McSean", "sean@gmail.com", "089981718", 20);
        empBelowNormalWorkWeek = new AdminWorker(20, 10, "Sean", "McSean", "sean@gmail.com", "089981718", 20);
    }

    @AfterEach
    void tearDown() {
        empNormalWorkWeek = empBelowNormalWorkWeek = empNormal1 = empOnEdge = empWrongDetail = null;

    }

    /**
     * Test method for utils.Utilities.Employee constructor
     */
    @Test
    public void testConstructor() {
        //test on valid data

        assertEquals("Sean", empNormal1.getFirstName()); // not testing the second name because its the same validation
        assertEquals("sean@gmail.com", empNormal1.getEmail());
        assertEquals("089981718", empNormal1.getPhoneNumber());

        assertEquals(42, empNormal1.getHoursWorked(), 0.01);
        assertEquals(13, empNormal1.getHourlyRate(), 0.01);
        assertEquals(0, empOnEdge.getHoursWorked(), 0.01);
        assertEquals(10.1, empOnEdge.getHourlyRate(), 0.01);

        assertEquals("Sean5678912345678912", empOnEdge.getFirstName());
        assertEquals("seanat@gmail.mail.dotcom", empOnEdge.getEmail());
        assertEquals("089981718", empOnEdge.getPhoneNumber());


        //test on invalid data

        assertEquals("Sean5678912345678912", empWrongDetail.getFirstName());

        assertEquals(null, empWrongDetail.getEmail());
        assertEquals(null, empWrongDetail.getPhoneNumber());

        assertEquals(0, empWrongDetail.getHoursWorked(), 0.01);
        assertEquals(10.10, empWrongDetail.getHourlyRate(), 0.01);
        assertEquals(0, empOnEdge.getHoursWorked(), 0.01);
        assertEquals(10.10, empOnEdge.getHourlyRate(), 0.01);
    }

    /**
     * Test method for getSalary(), testing for employees with and without overtime.
     */
    @Test
    public void testgetSalary() {
        //employee under NORMAL_WORKING_WEEKS hours
        assertEquals(398.95, empNormalWorkWeek.getSalary(), 0.01);
        assertEquals(202, empBelowNormalWorkWeek.getSalary(), 0.01);
        //employee with overtime + fixed bonus
        assertEquals(611, empNormal1.getSalary(), 0.01);
        empNormal1.setHourlyRate(0);
        assertEquals(474.7, empNormal1.getSalary(), 0.01);
        empNormal1.setHourlyRate(20);
        assertEquals(940.0, empNormal1.getSalary(), 0.01);
        empNormal1.setHoursWorked(40.5);
        empNormal1.setHourlyRate(20);
        assertEquals(850, empNormal1.getSalary(), 0.01);
    }

    /**
     * Test method for getters and setters.
     */
    @Test
    public void testSettersGetters() {

        assertEquals(42, empNormal1.getHoursWorked(), 0.01);
        empNormal1.setHoursWorked(40);
        assertEquals(40, empNormal1.getHoursWorked(), 0.01);
        empNormal1.setHoursWorked(-1);
        assertEquals(40, empNormal1.getHoursWorked(), 0.01);
        empNormal1.setHourlyRate(40);
        assertEquals(40, empNormal1.getHourlyRate(), 0.01);
        empNormal1.setHourlyRate(9.79);
        //ensure no change when invalid data used
        assertEquals(10.1, empNormal1.getHourlyRate(), 0.01);
    }

    /**
     * Test method for getOverTime (= hourly-rate*2 * (the number of hours overtime))
     */
    @Test
    public void getOverTime() {
        assertEquals(65, empNormal1.getOverTime(), 0.01);
        assertEquals(0, empNormalWorkWeek.getOverTime(), 0.01);
        empNormal1.setHourlyRate(20);
        assertEquals(100, empNormal1.getOverTime(), 0.01);
    }

    /**
     * Test method for toString - checks that all data fields are present.
     */
    @Test
    public void testToString() {
        assertTrue(empNormal1.toString().contains("Hours Worked"));
        assertTrue(empNormal1.toString().contains("42"));
        assertTrue(empNormal1.toString().contains("per hour"));
        assertTrue(empNormal1.toString().contains("13"));
    }
}
