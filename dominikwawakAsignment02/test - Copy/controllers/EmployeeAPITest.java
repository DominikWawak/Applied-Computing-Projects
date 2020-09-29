/*package controllers;

import models.AdminWorker;
import models.Manager;
import models.SalesWorker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeAPITest {
    private EmployeeAPI employeesPopulated, employeesEmpty;



    private Manager manager1, manager2;
    private AdminWorker adminWorker1, adminWorker2;
    private SalesWorker salesWorker1, salesWorker2;


    @Before
    public void setUp() throws Exception {
        manager1 = new Manager(30, 20, "Harry", "Duggan", "harry@hotmail.com", "089624536345");
        manager2 = new Manager(20, 100, "Jerry", "Sand", "jerry@hotmail.com", "0896246665");
        adminWorker1 = new AdminWorker(39.5, 10, "Larry", "Walsh", "larry@hotmail.com", "0896564655", 20);
        adminWorker2 = new AdminWorker(20, 10, "Barry", "lee", "barry@hotmail.com", "08966767887", -10);
        salesWorker1 = new SalesWorker(50, 20, "Dan", "Jene", "dan@fun.com", "0863563673", 5.9);
        salesWorker2 = new SalesWorker(40, 25, "John", "Joe", "jon@hon.com", "07837484575", 50);

        manager1.addDeptEmployee(adminWorker1);
        manager1.addDeptEmployee(salesWorker2);


        employeesPopulated = new EmployeeAPI();
        employeesPopulated.addEmployee(manager1);
        employeesPopulated.addEmployee(adminWorker1);
        employeesPopulated.addEmployee(salesWorker1);

        employeesEmpty = new EmployeeAPI();


    }

    @After
    public void tearDown() throws Exception {
        manager1 = manager2 = null;
        adminWorker1 = adminWorker2 = null;
        salesWorker1 = salesWorker2 = null;

    }

    @Test
    public void getEmployees() {
        assertEquals(3, employeesPopulated.getEmployees().size());
        assertEquals(0, employeesEmpty.getEmployees().size());
    }

    @Test
    public void setEmployees() {
        EmployeeAPI newEmployees = new EmployeeAPI();
        assertEquals(0, newEmployees.getEmployees().size());
        newEmployees.setEmployees(employeesPopulated.getEmployees());
        assertEquals(3, newEmployees.getEmployees().size());
        assertEquals("Harry", newEmployees.getEmployees().get(0).getFirstName());

    }

    @Test
    public void addEmployee() {

        assertEquals(0, employeesEmpty.getEmployees().size());
        AdminWorker adminAddTest = new AdminWorker(60, 15, "Ger", "Jones", "ger@mail.com", "0873647845", 99);
        employeesEmpty.addEmployee(adminAddTest);
        assertEquals(1, employeesEmpty.getEmployees().size());
        assertEquals("Ger", employeesEmpty.getEmployees().get(0).getFirstName());


    }

    @Test
    public void addEmployeeToDepartment() {
        employeesEmpty.addEmployee(adminWorker2);
        employeesEmpty.addEmployee(salesWorker2);
        //employeesEmpty.addEmployeeToDepartment(0,1); This is right to throw an error
        employeesEmpty.addEmployee(manager2);
        employeesEmpty.addEmployee(manager1);
        //
        //
        //employeesEmpty.addEmployeeToDepartment(2,3); This is corrected in the driver
        //
        //
        employeesEmpty.addEmployeeToDepartment(2, 0);
        assertTrue(employeesEmpty.listOfEmployees().contains("John"));
        assertTrue(employeesEmpty.listOfEmployees().contains("Barry"));

        // If wrong index
        assertFalse(employeesEmpty.addEmployeeToDepartment(10, 20));

    }

    @Test
    public void getEmployee() {
        assertTrue(employeesPopulated.getEmployee(0).getFirstName().contains("Harry"));
        assertTrue(employeesPopulated.getEmployee(1).getEmail().contains("larry@hotmail.com"));


    }

    @Test
    public void removeEmployee() {
        assertEquals(3, employeesPopulated.getEmployees().size());
        employeesPopulated.removeEmployeeByIndex(0);
        assertEquals(2, employeesPopulated.getEmployees().size());

        //Invalid Index
        assertNull(employeesPopulated.removeEmployeeByIndex(10));


    }

    @Test
    public void testRemoveEmployee() {
        assertEquals(3, employeesPopulated.getEmployees().size());
        employeesPopulated.removeEmployeeByLastName("duggan");
        assertEquals(2, employeesPopulated.getEmployees().size());

        //Invalid Name
        assertNull(employeesPopulated.removeEmployeeByLastName("Lucky"));


    }

    @Test
    public void testRemoveEmployeeFromDep() {
        assertEquals(2, manager1.noEmployeesInDepartment());
        employeesPopulated.removeEmployeeFromDepartment(0, 1);
        assertEquals(1, manager1.noEmployeesInDepartment());
        assertEquals("Larry", manager1.getEmployeesInDep().get(0).getFirstName());

        assertNull(employeesEmpty.removeEmployeeFromDepartment(0, 1));
    }

    @Test
    public void numberOfEmployees() {
        assertEquals(3, employeesPopulated.getEmployees().size());
        assertEquals(employeesPopulated.getEmployees().size(), employeesPopulated.numberOfEmployees());
    }

    @Test
    public void listOfEmployees() {
        //check if empty
        assertTrue(employeesEmpty.listOfEmployees().contains("No employees stored"));
        //check if populated
        assertTrue(employeesPopulated.listOfEmployees().contains("Harry"));
        assertTrue(employeesPopulated.listOfEmployees().contains("Larry"));
        assertTrue(employeesPopulated.listOfEmployees().contains("Dan"));
    }

    @Test
    public void listManagerEmployees() {
        // if empty
        assertTrue(employeesEmpty.listManagerEmployees().contains("no managers in the system"));

        assertTrue(employeesPopulated.listManagerEmployees().contains("Harry"));

    }

    @Test
    public void noOfManagers() {
        assertEquals(1, employeesPopulated.noOfManagers());
        assertEquals(0, employeesEmpty.noOfManagers());

    }

    @Test
    public void getManagers() {
        assertEquals(1, employeesPopulated.getManagers().size());
        assertEquals(0, employeesEmpty.getManagers().size());
        assertTrue(employeesPopulated.getManagers().get(0).getEmail().contains("harry@hotmail.com"));
    }

    @Test
    public void testListManagerEmployees() {
        assertTrue(employeesPopulated.listManagerEmployees(manager1).contains("Larry"));
        assertTrue(employeesPopulated.listManagerEmployees(manager1).contains("John"));

        employeesEmpty.addEmployee(manager2);
        assertTrue(employeesEmpty.listManagerEmployees(manager2).contains("This manager has no employees in his/her department"));
    }

    @Test
    public void totalSalariesOwed() {
        assertEquals(0, employeesEmpty.totalSalariesOwed(), 0.01);
        // calculateSalary and getSalary work because of the other tests
        assertEquals(2537.1695, employeesPopulated.totalSalariesOwed(), 0.01);
        employeesPopulated.addEmployee(salesWorker2);
        assertEquals(3562.1695, employeesPopulated.totalSalariesOwed(), 0.01);
    }

    @Test
    public void avgSalariesOwed() {
        assertEquals(845.7231, employeesPopulated.avgSalariesOwed(), 0.01);
        employeesPopulated.addEmployee(salesWorker2);
        assertEquals(890.542375, employeesPopulated.avgSalariesOwed(), 0.01);

    }

    @Test
    public void employeeWithHighestPay() {
        assertNull(employeesEmpty.employeeWithHighestPay());

        assertTrue(employeesPopulated.employeeWithHighestPay().getFirstName().contains("Dan"));

    }


    @Test
    public void testSearchEmployeesLastName() {
        assertTrue(employeesPopulated.searchEmployees("Jene").contains(salesWorker1));
        assertTrue(employeesPopulated.searchEmployees("WALs").contains(adminWorker1));
        assertTrue(employeesPopulated.searchEmployees("gGan").contains(manager1));
        assertTrue(employeesPopulated.searchEmployees("W").contains(adminWorker1));
        // IF THE NAME DOESN'T EXIST
        assertEquals(0, employeesPopulated.searchEmployees("Lyons").size());

        AdminWorker adminWorker3 = new AdminWorker(20, 10, "Sophie", "Welsh", "soph@hotmail.com", "08966767887", 89);
        employeesPopulated.addEmployee(adminWorker3);
        assertTrue(employeesPopulated.searchEmployees("W").contains(adminWorker3));


    }

    @Test
    public void testSortEmployeesByFirstName() {
        employeesPopulated.sortEmployeesByFirstName();
        assertTrue(employeesPopulated.getEmployees().get(0).getFirstName().contains("Dan"));
        assertTrue(employeesPopulated.getEmployees().get(1).getFirstName().contains("Harry"));
        assertTrue(employeesPopulated.getEmployees().get(2).getFirstName().contains("Larry"));
    }

    @Test
    public void testSortEmployeesByLastName() {
        employeesPopulated.sortEmployeesByLastName();
        assertTrue(employeesPopulated.getEmployees().get(0).getLastName().contains("Walsh"));
        assertTrue(employeesPopulated.getEmployees().get(1).getLastName().contains("Jene"));
        assertTrue(employeesPopulated.getEmployees().get(2).getLastName().contains("Duggan"));

    }

    @Test
    public void testSortEmployeesByHourlyRate() {
        employeesPopulated.sortEmployeesByHourlyRate();
        assertEquals(10.1, employeesPopulated.getEmployees().get(0).getHourlyRate(), 0.01);
        assertEquals(20, employeesPopulated.getEmployees().get(1).getHourlyRate(), 0.01);
        assertEquals(20, employeesPopulated.getEmployees().get(2).getHourlyRate(), 0.01);

    }

    @Test
    public void loadAndSave() throws Exception {
        //TESTING WHEN EMPTY
        assertEquals(0, employeesEmpty.getEmployees().size());
        employeesEmpty.save();
        EmployeeAPI employeesEmptyLoadAndSave = new EmployeeAPI();
        employeesEmptyLoadAndSave.load();
        assertEquals(0, employeesEmptyLoadAndSave.getEmployees().size());

        //TESTING WHEN ADDING
        employeesEmpty.addEmployee(manager2);
        employeesEmpty.addEmployee(salesWorker2);
        employeesEmpty.save();
        employeesEmptyLoadAndSave.load();
        assertEquals(2, employeesEmptyLoadAndSave.getEmployees().size());


    }

}

 */