package models;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Test Class for the (concrete) Manager class
 *
 * @author Siobhan Drohan & Mairead Meagher
 * @version 03/20
 */


public class ManagerTest {

    private Manager manNormal1, manNormal2;
    private AdminWorker admin1;
    private SalesWorker sales1, sales2;

    /**
     * Method to set up data for testing.
     *
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {

        manNormal1 = new Manager(30, 20, "Harry", "Duggan", "harry@hotmail.com", "089624536345");
        admin1 = new AdminWorker(20, 10, "Larry", "Walsh", "larry@hotmail.com", "0896564655", 20);
        sales1 = new SalesWorker(20, 10, "Barry", "lee", "barry@hotmail.com", "08966767887", 10);
        sales2 = new SalesWorker(20, 10, "Mary", "red", "mary@hotmail.com", "083457775", 5);

        manNormal2 = new Manager(20, 100, "Jerry", "Sand", "jerry@hotmail.com", "0896246665");
        manNormal2.addDeptEmployee(admin1);
        manNormal2.addDeptEmployee(sales1);
    }

    @AfterEach
    void tearDown() {
        manNormal1 = manNormal2 = null;
        admin1 = null;
        sales1 = sales2 = null;
    }

    /**
     * Test method for Manager constructor
     */
    @Test
    public void testManager() {

        assertEquals("Harry", manNormal1.getFirstName());
        assertEquals("harry@hotmail.com", manNormal1.getEmail());
        assertEquals("089624536345", manNormal1.getPhoneNumber());
        assertEquals(30, manNormal1.getHoursWorked(), 0.01);
        assertEquals(20, manNormal1.getHourlyRate(), 0.01);

        assertEquals(0, manNormal1.noEmployeesInDepartment());

        assertEquals(20, manNormal2.getHoursWorked(), 0.01);
        assertEquals(100, manNormal2.getHourlyRate(), 0.01);
        assertEquals(2, manNormal2.noEmployeesInDepartment());
    }

    /**
     * Test method for getDept and setDept. (No validation on this field)
     */
    @Test
    public void testConstructorsGetSetDept() {
        assertEquals(2,manNormal2.getEmployeesInDep().size());
        ArrayList<Employee> newEmployees = new ArrayList<>();


        newEmployees.add(sales2);
        manNormal2.setEmployeesInDep(newEmployees);
        assertEquals(1,manNormal2.getEmployeesInDep().size());

    }

    @Test
    public void testCalculateSalary() {
        // manager with no employees
        assertEquals(600, manNormal1.calculateSalary(), 0.01);
        assertEquals(222, admin1.calculateSalary(), 0.01);
        assertEquals(222.2, sales1.calculateSalary(), 0.01);
        assertEquals(2004.442, manNormal2.calculateSalary(), 0.01);
        manNormal2.addDeptEmployee(sales2);
        assertEquals(2006.563, manNormal2.calculateSalary(), 0.01);
    }

    /**
     * Test method for addDeptEmployee(Employee).
     */
    @Test
    public void testAddDeptEmployee() {
        assertEquals(0, manNormal1.noEmployeesInDepartment());
        manNormal1.addDeptEmployee(sales1);
        assertEquals(1, manNormal1.noEmployeesInDepartment());
        Employee testEmpInDep = manNormal1.getEmployeesInDep().get(0);
        assertEquals("Barry", testEmpInDep.getFirstName());

    }

    @Test
    public void removeEmployee() {
        assertEquals(2, manNormal2.noEmployeesInDepartment());
        manNormal2.removeEmployeeFromDepartment(0);
        assertEquals(1, manNormal2.noEmployeesInDepartment());
        assertEquals("Barry", manNormal2.getEmployeesInDep().get(0).getFirstName());
    }

    @Test
    public void setDept() {
        ArrayList<Employee> newDept = new ArrayList<Employee>();
        newDept.add(new AdminWorker(20, 10, "Jim", "Jimmy", "jim@gmail.com", "0877654343", 22));
        newDept.add(new SalesWorker(20, 10, "Daniel", "Walsh", "dan@lan.com", "0564343", 11));
        newDept.add(new AdminWorker(20, 10, "Lee", "San", "lee@wee.com", "076514122", 200));
        manNormal2.setEmployeesInDep(newDept);
        assertEquals(3, manNormal2.noEmployeesInDepartment());
        assertEquals("Jim", manNormal2.getEmployeesInDep().get(0).getFirstName());

    }

    @Test
    public void testToString() {
        assertTrue(manNormal2.getEmployeesInDep().get(0).toString().contains("Larry"));
        assertTrue(manNormal2.getEmployeesInDep().get(1).toString().contains("Barry"));
        assertTrue(manNormal2.getEmployeesInDep().get(0).toString().contains("20"));

    }


}

