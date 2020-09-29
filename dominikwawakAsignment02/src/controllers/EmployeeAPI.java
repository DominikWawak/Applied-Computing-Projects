package controllers;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import models.Employee;
import models.Manager;
import utils.Utilities;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * EmployeeAPI class
 * This controller class is responsible for storing and managing all the employees.
 * The employees are entered by the user via the console in the Driver class.
 *
 * @author Dominik Wawak
 * @version 1.0.0 (20.Apr.2020)
 */
public class EmployeeAPI {
    private ArrayList<Employee> employees;

    /**
     * EmployeeAPI Constructor
     * Instantiates the employees ArrayList.
     */
    public EmployeeAPI() {
        employees = new ArrayList<Employee>();


    }

    /**
     * Mutators and Accessors for the ArrayList of employees.
     */

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    /**
     * addParty
     * Method that adds an employee object to the arrayList
     *
     * @param employee of type Employee.
     */

    //
    //
    // ADDING
    //
    //
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * addEmployeeToDepartment
     * A method that takes in an index of a manager employee and a non manager employee and adds that employee to the employeesInDep ArrayList in Manager class.
     * Validation is done here and also done in the Driver class as thats where the user inputs the indices.
     *
     * @param manIndex must be a index of a Manager from the employees Arraylist.
     * @param empIndex must be a index of an Employee but not a Manager ( validation in driver ).
     * @return a boolean if the employee has been added it returns true
     */
    public boolean addEmployeeToDepartment(int manIndex, int empIndex) {

        if (Utilities.validIndex(manIndex, employees) && Utilities.validIndex(empIndex, employees)) {
            ((Manager) employees.get(manIndex)).addDeptEmployee(employees.get(empIndex));
            return true;
        } else {
            return false;
        }
    }


    /**
     * getParty.
     * Method that returns an Employee object at the specified index.
     *
     * @param index Its the index of an Employee from the Arraylist, validated with the Utilities class.
     * @return An object of type Employee is returned if the index is valid otherwise it returns null.
     */
    public Employee getEmployee(int index) {
        if (Utilities.validIndex(index, employees)) {
            return employees.get(index);
        } else {
            return null;
        }
    }

    //
    //
    // DELETING
    //
    //

    /**
     * removeEmployeeByIndex
     * A method that deletes an Employee from the arraylist and returns it.
     *
     * @param index is passed into the method that specifies the index off an employee to remove.
     * @return An object of type Employee is returned if the employee has been deleted and the index is valid otherwise it returns null.
     */
    public Employee removeEmployeeByIndex(int index) {
        if (Utilities.validIndex(index, employees)) {

            return employees.remove(index);
        } else {
            return null;
        }
    }

    /**
     * removeEmployeeByLastName
     * A method that will delete an employee having the employees last name passed in as a parameter.
     *
     * @param lastname of type String specifies the last name of the employee that needs to be deleted.
     * @return An object of type Employee is returned if the employee has been deleted and the lastName has matched an employee.
     */
    public Employee removeEmployeeByLastName(String lastname) {
        int indexToRemove = 0;
        Employee toDeleteemp = null;
        if (employees.size() > 0) {
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getLastName().toUpperCase().contains(lastname.toUpperCase())) {

                    indexToRemove = i;
                    toDeleteemp = employees.remove(indexToRemove);

                }
            }


        }
        return toDeleteemp;
    }

    /**
     * removeEmployeeFromDepartment
     * A method that will remove a employee form the department ie. the ArrayList stored in Manager class.
     *
     * @param manIndex must be a index of a Manager from the employees Arraylist.
     * @param empIndex must be a index of an Employee that is already in the department (some validation done in driver).
     * @return
     */
    public Employee removeEmployeeFromDepartment(int manIndex, int empIndex) {

        if (noOfManagers() > 0 && numberOfEmployees() > 0) {
            if (employees.get(manIndex) instanceof Manager) {
                ((Manager) employees.get(manIndex)).removeEmployeeFromDepartment(empIndex);

            }
            return employees.get(empIndex);
        } else {
            return null;
        }

    }


    //
    //
    // LISTING
    //
    //


    /**
     * numberOfEmployees
     * A method that returns the size of the employees arraylist,
     *
     * @return number of employees in the arraylist,
     */
    public int numberOfEmployees() {
        return employees.size();
    }

    /**
     * listOfEmployees
     * This method makes a list of all the employees and returns each on a new line.
     *
     * @return the method returns a string which is the list of all the employees, if no employees are stored a message is returned.
     */
    public String listOfEmployees() {
        if (employees.size() > 0) {

            String listOfEmployees = "";
            for (int i = 0; i < employees.size(); i++) {
                listOfEmployees = listOfEmployees + i + ": " + employees.get(i) + "\n";
            }
            return listOfEmployees;

        } else {
            return "No employees stored";
        }
    }

    /**
     * getManagers
     * A method that checks all employees if they are of type Manager and makes and instantiates a new arraylist which holds all the managers.
     *
     * @return The method returns the ArrayList it has created containing all Manager employees.
     */
    public ArrayList<Employee> getManagers() {
        ArrayList<Employee> managers = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee instanceof Manager) {
                managers.add(employee);
            }
        }
        return managers;
    }

    /**
     * listManagerEmployees
     * A method that creates a list of all the employees that are stored under Manager, which is passed in as a parameter.
     *
     * @param manager an object of type Manager is passed in to the method.
     * @return is a String which is the list of all the employees in a department (Manager) and each is printed on a new line.
     */
    public String listManagerEmployees(Manager manager) {
        if (manager.getEmployeesInDep().size() > 0) {
            String listOfManEmployees = "";
            for (int i = 0; i < manager.getEmployeesInDep().size(); i++) {
                listOfManEmployees = listOfManEmployees + i + ": " + manager.getEmployeesInDep().get(i) + "\n";
            }
            return listOfManEmployees;

        } else {
            return "This manager has no employees in his/her department";
        }
    }

    /**
     * noOfManagers
     * A method that calculates the number of Employees which are Managers and returns a int.
     *
     * @return is a int that holds the number of manager employees stored in the ArrayList employees.
     */
    public int noOfManagers() {
        int numOfManagers = 0;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) instanceof Manager)
                numOfManagers++;
        }
        return numOfManagers;
    }

    /**
     * listManagerEmployees
     * This Method lists the Employees which are Managers (Inheritance) from the employees ArrayList.
     *
     * @return is a String that is the list of all the employees who are a instance of Manager and print each one out on a new line.
     */
    public String listManagerEmployees() {

        if (noOfManagers() > 0) {


            String listOfManEmployees = "";
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i) instanceof Manager)
                    listOfManEmployees = listOfManEmployees + i + ": " + (employees.get(i)) + "\n";

            }
            return listOfManEmployees;
        } else {
            return "no managers in the system";
        }


    }

    //
    //
    // CALCULATING
    //
    //

    /**
     * totalSalariesOwed
     * A method that takes every employees calculated and adds it to a total and returns it.
     *
     * @return of type double which is the totalSalaries of all employees stored, if none are stored the return is 0.0.
     */
    public double totalSalariesOwed() {
        if (employees.size() > 0) {
            double totalSalaries = 0;
            for (Employee employee : employees) {
                totalSalaries = totalSalaries + employee.calculateSalary();
            }
            return totalSalaries;
        } else {
            return 0.0;
        }
    }

    /**
     * avgSalariesOwed
     * A method uses the totalSalaries method and divides that by the number of employees to calculate the average Salaries that are owed.
     *
     * @return return of type double which is and average of all salaries.
     */
    public double avgSalariesOwed() {
        if (employees.size() > 0) {
            return totalSalariesOwed() / employees.size();
        } else {
            return 0;
        }
    }

    /**
     * employeeWithHighestPay
     * A method that finds a employee who has the highest pay and returns the Employee,
     * this is done by going through each employee and calculating their salary.
     *
     * @return is an Employee object.
     */
    public Employee employeeWithHighestPay() {
        if (employees.size() > 0) {
            Employee employeeWithHighestPay = employees.get(0);
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).calculateSalary() > employeeWithHighestPay.calculateSalary()) {
                    employeeWithHighestPay = employees.get(i);
                }
            }
            return employeeWithHighestPay;
        } else {
            return null;
        }
    }


    //
    //
    // SEARCHING
    //
    //

    /**
     * searchEmployees
     * A method that searches employees by their last name, it creates and instantiates an ArrayList of searchedEmployees.
     * When the passed in lastName matches the last name of an employee then that employee is added to the searchedEmployees ArrayList.
     *
     * @param lastName specifies the desired last name of the emoployee to be found. Passed in through menu in Driver.
     * @return Is a ArrayList of Employee objects with the matching last name.
     */
    public ArrayList<Employee> searchEmployees(String lastName) {
        ArrayList<Employee> searchedEmployees = new ArrayList<Employee>();
        for (Employee employee : employees) {
            if (employee.getLastName().toUpperCase().contains(lastName.toUpperCase())) {
                searchedEmployees.add(employee);

            }

        }
        return searchedEmployees;


    }

    /**
     * searchEmployeesInDep
     * A method that searches the employees stored in a Manager object by their last name, it creates and instantiates an ArrayList of searchedEmployees.
     * When the passed int matches a index of an employee that is a manager and the lastName matches the last name of an employee then that employee is added to the searchedEmployees ArrayList.
     *
     * @param depIndex specifies the index of a manager employee.
     * @param lastName specifies the desired last name of the emoployee to be found. Passed in through menu in Driver.
     * @return Is a ArrayList of Employee objects with the matching last name in a Manager object.
     */
    public ArrayList<Employee> searchEmployeesInDep(int depIndex, String lastName) {
        ArrayList<Employee> searchedEmployees = new ArrayList<Employee>();
        if (employees.get(depIndex) instanceof Manager) {
            for (Employee employee : ((Manager) employees.get(depIndex)).getEmployeesInDep()) {
                if (employee.getLastName().toUpperCase().contains(lastName.toUpperCase())) {
                    searchedEmployees.add(employee);
                }

            }
        }
        return searchedEmployees;

    }

    //
    //
    // SORTING
    //
    //

    /**
     * sortEmployeesByFirstName
     * <p>
     * This method uses a selection sorting algorithm that loops through the employees ArrayList starting at the end and leaving one out because last one will be sorted.
     * It uses the .compareTo method with the > 0 to sort the array list in ascending alphabetical order.
     * This algorithm keeps on looking for the highest element and puts it at the end by using the swapEmployees method, then it reduces the size of the array by one.
     */

    public void sortEmployeesByFirstName() {

        for (int i = employees.size() - 1; i >= 0; i--) {
            int highestIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (employees.get(j).getFirstName().compareTo(employees.get(highestIndex).getFirstName()) > 0) {
                    highestIndex = j;
                }
            }
            swapEmployees(employees, i, highestIndex);
        }
    }

    /**
     * sortEmployeesByLastName
     * This method is just like the previous one except it sorts the array in descending alphabetical order,
     * The compareTo method with < 0 allows to sort the array in descending alphabetical order
     */
    public void sortEmployeesByLastName() {
        for (int i = employees.size() - 1; i >= 0; i--) {
            int highestIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (employees.get(j).getLastName().compareTo(employees.get(highestIndex).getLastName()) < 0) {
                    highestIndex = j;
                }
            }
            swapEmployees(employees, i, highestIndex);
        }
    }

    /**
     * sortEmployeesByHourlyRate
     * This method is used to sort employees based on a double value which is their hourlyRate.
     * Just like the other sorting methods this one compares an Employee with the highest Hourly rate and takes the highest ap places it at the end.
     * The swapEmployees method is used to place the highest found at the end of the ArrayList.
     */
    public void sortEmployeesByHourlyRate() {
        for (int i = employees.size() - 1; i >= 0; i--) {
            int highestIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (employees.get(j).getHourlyRate() > (employees.get(highestIndex).getHourlyRate())) {
                    highestIndex = j;
                }
            }
            swapEmployees(employees, i, highestIndex);
        }
    }

    /**
     * swapEmployees
     * This method is used to change the location of two objects that are stored in an ArrayList passed in as a parameter.
     * The objects are assigned temporarily and are then swapped by setting their indices with the .set method.
     *
     * @param employees is an ArrayList from where the two objects need to be swapped.
     * @param i         is an int that specifies the index of the location of one object.
     * @param j         is an int that specifies the index of one location for another object.
     */
    private void swapEmployees(ArrayList<Employee> employees, int i, int j) {
        Employee smaller = employees.get(i);
        Employee bigger = employees.get(j);

        employees.set(i, bigger);
        employees.set(j, smaller);
    }


    //
    //
    // SAVING AND LOADING
    //
    //

    /**
     * load and save
     * <p>
     * These methods add persistence they use the xstream library to store the employees in a .xml file and also load from the xml file.
     *
     * @throws Exception
     */

    public void load() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("employees.xml"));
        employees = (ArrayList<Employee>) is.readObject();
        is.close();
    }

    public void save() throws Exception {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("employees.xml"));
        out.writeObject(employees);
        out.close();
    }


}

