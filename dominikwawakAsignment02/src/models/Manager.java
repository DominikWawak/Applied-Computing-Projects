package models;

import utils.Utilities;

import java.util.ArrayList;


public class Manager extends Employee {
    private ArrayList<Employee> employeesInDep;
    //The employees should already be in the employees list (see EmployeeAPI).????



    public Manager(double hoursWorked, double hourlyRate, String firstName, String lastName, String email, String phoneNumber,ArrayList<Qualification> qualifications) {
        super(hoursWorked, hourlyRate, firstName, lastName, email, phoneNumber, qualifications);
        employeesInDep = new ArrayList<Employee>();
    }


    public int noEmployeesInDepartment() {
        return employeesInDep.size();
    }


    public void addDeptEmployee(Employee employee) {
        employeesInDep.add(employee);

    }

    public boolean removeEmployeeFromDepartment(int index) {
        if (Utilities.validIndex(index, employeesInDep)) {
            employeesInDep.remove(index);
            return true;
        } else {
            return false;
        }

    }


    @Override
    public double calculateSalary() {
        double managersBonus = 0;
        for (Employee employee : employeesInDep) {
            managersBonus += employee.calculateSalary() * 0.01;
        }
        return getSalary() + managersBonus;
    }

    public ArrayList<Employee> getEmployeesInDep() {
        return employeesInDep;
    }

    public void setEmployeesInDep(ArrayList<Employee> employees) {
        this.employeesInDep = employees;
    }

    @Override
    public String toString() {
        return "Manager{" + super.toString() +
                "employeesInDep=" + employeesInDep +
                '}';
    }
}
