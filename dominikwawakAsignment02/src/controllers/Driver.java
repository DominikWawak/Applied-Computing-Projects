package controllers;

import models.Manager;
import models.Qualification;
import utils.ScannerInput;

import java.util.ArrayList;

public class Driver {

    private EmployeeAPI empAPI;


    public Driver() {
        //input = new Scanner(System.in);
        empAPI = new EmployeeAPI();

    }

    public static void main(String[] args) {


        Driver app = new Driver();
        app.run();
    }

    private int mainMenu() {
        System.out.println("Menu");
        System.out.println("---------");
        System.out.println("  1) Add an employee (Manager)");
        System.out.println("  2) Add an employee (Sales worker)");
        System.out.println("  3) Add an employee (Admin worker)");
        System.out.println("  4) Add an existing employee to a department");
        System.out.println("  5) Update an employee");
        System.out.println("  6) Delete an employee");
        System.out.println("  7) Delete employee form a department");
        System.out.println("  8) list all employees");
        System.out.println("  9) list all departments");
        System.out.println("  10) list all employees in department");
        System.out.println("  -------------------");
        System.out.println("  11) Find the total of the salaries owed to all the employees");
        System.out.println("  12) Find the average of the salaries owed to all the employees");
        System.out.println("  13) print the employee with the highest pay");
        System.out.println("  --------------------");
        System.out.println("  14) List all employees in the company in ascending alphabetical order (first name)");
        System.out.println("  15) List all employees in the company in descending alphabetical order (second name)");
        System.out.println("  16) List all employees in the company in ascending order (hourly rate)");
        System.out.println("  --------------------");
        System.out.println("  17) Search the system for an employee by second name");
        System.out.println("  18) Search the system for an employee within a given manager's department");
        System.out.println("  --------------------");
        System.out.println("  20)  Save to XML");
        System.out.println("  21) Load from XML");
        System.out.println("  --------------------");
        System.out.println("  0) Exit");

        return ScannerInput.readNextInt("==>> ");
    }

    private void run() {
        int option = mainMenu();
        while (option != 0) {

            switch (option) {
                case 1:
                    addManager();

                    break;
                /*
                case 2:
                    addSalesWorker();

                    break;
                case 3:
                    addAdminWorker();

                    break;
                case 4:
                    addEmpToManager();

                    break;
                case 5:
                    updateEmployee();

                    break;
                case 6:
                    deleteEmployeeByIndex();

                    break;
                case 7:
                    deleteEmployeeFromDepartment();


                    break;
                    */

                case 8:
                    System.out.println(empAPI.listOfEmployees());

                    break;
                case 9:
                    System.out.println(empAPI.listManagerEmployees());

                    break;
                    /*
                case 10:
                    listManagersEmployees();


                    break;
                case 11:
                    System.out.println(empAPI.totalSalariesOwed());

                    break;
                case 12:
                    System.out.println(empAPI.avgSalariesOwed());

                    break;
                case 13:
                    employeeWithHighestPay();

                    break;
                case 14:
                    sortEmployeesByFirstNameInAscendingOrder();

                    break;
                case 15:
                    sortEmployeesByFirstNameDescendingOrder();

                    break;
                case 16:
                    sortEmployeesByHourlyRate();

                    break;
                case 17:
                    searchByLastName();

                    break;
                case 18:
                    searchByLastNameInDep();

                    break;

                case 20:
                    try {
                        empAPI.save();
                    } catch (Exception e) {
                        System.err.println("Error writing to file: " + e);
                    }
                    break;
                case 21:
                    try {
                        empAPI.load();
                    } catch (Exception e) {
                        System.err.println("Error reading from file: " + e);
                    }
                    break;

                 */
                default:
                    System.out.println("Invalid option entered: " + option);
                    break;


            }


            String empty = ScannerInput.readNextString("\nPress any key to continue...");


            option = mainMenu();
        }


        System.out.println("Exiting... bye");
        System.exit(0);
    }


    public void addManager() {
        String firstName = ScannerInput.readNextString("Please enter the first name ==> ");
        String lastName = ScannerInput.readNextString("please enter the last name ==> ");
        String email = ScannerInput.readNextString("Please enter the email ==> ");
        String phoneNumber = ScannerInput.readNextString("Please enter the phone number ==> ");
        double hoursWorked = ScannerInput.readNextDouble("Please enter the hours worked ==>");
        double hourlyRate = ScannerInput.readNextDouble("Please enter the hourly rate ==>");
        int year = ScannerInput.readNextInt("jhsgbdfkjhdbkfgbdf");
        String college = ScannerInput.readNextString("fasdfdfs");
        String qualification = ScannerInput.readNextString("dsfsfsdfsdfd");
        String degree = ScannerInput.readNextString("zdfhjkgvkjszdhfvs");
        ArrayList<Qualification> qualifications=new ArrayList<Qualification>();
        Manager man = new Manager(hoursWorked, hourlyRate, firstName, lastName, email, phoneNumber, qualifications);
        Qualification qual = new Qualification(year,qualification,college,degree);
        man.addQualifications(qual);
        empAPI.addEmployee(man);

    }

/*
    public void addSalesWorker() {
        String firstName = ScannerInput.readNextString("Please enter the first name ==> ");
        String lastName = ScannerInput.readNextString("please enter the last name ==> ");
        String email = ScannerInput.readNextString("Please enter the email ==> ");
        String phoneNumber = ScannerInput.readNextString("Please enter the phone number ==> ");
        double hoursWorked = ScannerInput.readNextDouble("Please enter the hours worked ==>");
        double hourlyRate = ScannerInput.readNextDouble("Please enter the hourly rate ==>");
        double percentageBonus = ScannerInput.readNextDouble("Please enter the percentage bonus ==> ");
        empAPI.addEmployee(new SalesWorker(hoursWorked, hourlyRate, firstName, lastName, email, phoneNumber, percentageBonus));

    }

    public void addAdminWorker() {
        String firstName = ScannerInput.readNextString("Please enter the first name ==> ");
        String lastName = ScannerInput.readNextString("please enter the last name ==> ");
        String email = ScannerInput.readNextString("Please enter the email ==> ");
        String phoneNumber = ScannerInput.readNextString("Please enter the phone number ==> ");
        double hoursWorked = ScannerInput.readNextDouble("Please enter the hours worked ==>");
        double hourlyRate = ScannerInput.readNextDouble("Please enter the hourly rate ==>");
        double fixedBonus = ScannerInput.readNextDouble("Please enter the fixed bonus ==> ");
        empAPI.addEmployee(new AdminWorker(hoursWorked, hourlyRate, firstName, lastName, email, phoneNumber, fixedBonus));
    }

    public void addEmpToManager() {
        System.out.println(empAPI.listOfEmployees());
        int depIndex = ScannerInput.readNextInt("Enter the index of Manager employee ==> ");
        if (Utilities.validIndex(depIndex, empAPI.getEmployees())) {
            if (empAPI.getEmployees().get(depIndex) instanceof Manager) {
                int empIndex = ScannerInput.readNextInt("Enter the index of employee ==> ");
                if (Utilities.validIndex(empIndex, empAPI.getEmployees()) && !(empAPI.getEmployees().get(empIndex) instanceof Manager)) {
                    empAPI.addEmployeeToDepartment(depIndex, empIndex);
                    System.out.println("Employee added");
                } else {
                    System.out.println("The index entered is not valid");
                }
            } else {
                System.out.println("The index entered is not a manager employee");
            }
        } else {
            System.out.println("The index entered is not valid");
        }

    }

    public void deleteEmployeeByIndex() {
        System.out.println(empAPI.listOfEmployees());
        if (empAPI.getEmployees().size() > 0) {
            int index = ScannerInput.readNextInt("Please enter the index of the employee to delete ==>");
            if (Utilities.validIndex(index, empAPI.getEmployees())) {

                System.out.println("Deleted employee " + " " + empAPI.removeEmployeeByIndex(index).getLastName());

            } else {
                System.out.println("The index entered was not valid");
            }
        }

    }


    public void updateEmployee() {

        if (empAPI.getEmployees().size() > 0) {
            System.out.println(empAPI.listOfEmployees());
            int index = ScannerInput.readNextInt("Enter the index of the employee to Update ==> ");
            Employee employee = empAPI.getEmployee(index);
            if (Utilities.validIndex(index, empAPI.getEmployees())) {
                String firstName = ScannerInput.readNextString("Please enter the first name ==> ");
                employee.setFirstName(firstName);
                String lastName = ScannerInput.readNextString("please enter the last name ==> ");
                employee.setLastName(lastName);
                String email = ScannerInput.readNextString("Please enter the email ==> ");
                employee.setEmail(email);
                String phoneNumber = ScannerInput.readNextString("Please enter the phone number ==> ");
                employee.setPhoneNumber(phoneNumber);
                double hoursWorked = ScannerInput.readNextDouble("Please enter the hours worked ==>");
                employee.setHoursWorked(hoursWorked);
                double hourlyRate = ScannerInput.readNextDouble("Please enter the hourly rate ==>");
                employee.setHourlyRate(hourlyRate);

                if (employee instanceof SalesWorker) {
                    double percentageBonus = ScannerInput.readNextDouble("Please enter the percentage bonus ==> ");
                    ((SalesWorker) employee).setPercentageBonus(percentageBonus);

                } else if (employee instanceof AdminWorker) {
                    double fixedBonus = ScannerInput.readNextDouble("Please enter the fixed bonus ==> ");
                    ((AdminWorker) employee).setFixedBounus(fixedBonus);
                }
            } else {
                System.out.println("No employee matches your index ");
            }
        } else {
            System.out.println("There are no employees");
        }
    }

    public void listManagersEmployees() {

        if (empAPI.noOfManagers() > 0) {
            System.out.println(empAPI.listManagerEmployees());
            int index = ScannerInput.readNextInt("Please enter the index of the manager ==> ");
            if (empAPI.getEmployee(index) instanceof Manager) {
                System.out.println(empAPI.listManagerEmployees((Manager) empAPI.getEmployee(index)));
            } else {
                System.out.println("this manager does not exist");
            }
        } else {
            System.out.println("No Managers in the system");
        }


    }

    public void deleteEmployeeByLastName() {

        if (empAPI.getEmployees().size() > 0) {
            System.out.println(empAPI.listOfEmployees());
            String lastName = ScannerInput.readNextString("Please enter the last name of the employee you want to delete ==> ");
            empAPI.removeEmployeeByLastName(lastName);
            System.out.println("employee deleted");
        } else {
            System.out.println("There are no employees");
        }
    }

    public void deleteEmployeeFromDepartment() {
        if (empAPI.noOfManagers() > 0 && empAPI.numberOfEmployees() > 0) {
            System.out.println(empAPI.listOfEmployees());
            int index = ScannerInput.readNextInt("Please enter the index of the manager ==> ");

            if (empAPI.getEmployee(index) instanceof Manager && Utilities.validIndex(index, empAPI.getEmployees())) {
                System.out.println(empAPI.listManagerEmployees((Manager) empAPI.getEmployee(index)));
                int empIndex = ScannerInput.readNextInt("Enter the index of employee ==> ");
                if (Utilities.validIndex(empIndex, ((Manager) empAPI.getEmployee(index)).getEmployeesInDep())) {
                    Employee deletedEmployee = ((Manager) empAPI.getEmployee(index)).getEmployeesInDep().get(empIndex);
                    empAPI.removeEmployeeFromDepartment(index, empIndex);
                    System.out.println("deleted" + "" + deletedEmployee.getFirstName() + " " + deletedEmployee.getLastName());
                } else {
                    System.out.println("this employee does not exist");
                }

            } else {
                System.out.println("this manager does not exist");
            }


        } else {
            System.out.println("There are no employees or managers");

        }
    }


    public void employeeWithHighestPay() {
        if (empAPI.getEmployees().size() > 0) {
            System.out.println(empAPI.employeeWithHighestPay().getFirstName() + " " + empAPI.employeeWithHighestPay().getLastName());
        } else {
            System.out.println("There are no employees");
        }

    }

    public void searchByLastName() {
        if (empAPI.getEmployees().size() > 0) {

            String lastName = ScannerInput.readNextString("Please enter the last name of an employee ==> ");
            if (empAPI.searchEmployees(lastName).size() > 0) {

                System.out.println(empAPI.searchEmployees(lastName).toString());
            } else {
                System.out.println("No employees match your search");
            }
        } else {
            System.out.println("no employees stored");
        }
    }

    public void searchByLastNameInDep() {
        if (empAPI.getManagers().size() > 0) {
            System.out.println(empAPI.listManagerEmployees());
            int manIndex = ScannerInput.readNextInt("Please enter the index of the manager ==> ");
            String lastName = ScannerInput.readNextString("Please enter the last name of an employee ==> ");
            if (empAPI.searchEmployeesInDep(manIndex, lastName).size() > 0) {
                String str = "";
                for (Employee searchedEmployee : empAPI.searchEmployeesInDep(manIndex, lastName)) {
                    str = str + searchedEmployee + "\n";
                }
                System.out.println(str);

            } else {
                System.out.println("No employees match your search");
            }
        } else {
            System.out.println("no employees stored");
        }


    }


    public void sortEmployeesByFirstNameInAscendingOrder() {
        if (empAPI.getEmployees().size() > 0) {
            empAPI.sortEmployeesByFirstName();
            System.out.println(empAPI.listOfEmployees());
        } else {
            System.out.println("no employees stored");
        }
    }

    public void sortEmployeesByFirstNameDescendingOrder() {
        if (empAPI.getEmployees().size() > 0) {
            empAPI.sortEmployeesByLastName();
            System.out.println(empAPI.listOfEmployees());
        } else {
            System.out.println("no employees stored");
        }
    }

    public void sortEmployeesByHourlyRate() {
        if (empAPI.getEmployees().size() > 0) {
            empAPI.sortEmployeesByHourlyRate();
            System.out.println(empAPI.listOfEmployees());
        } else {
            System.out.println("no employees stored");
        }
    }

*/
}
