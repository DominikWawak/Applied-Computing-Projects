package models;


import utils.Utilities;

import java.util.ArrayList;

public abstract class Employee {
    private ArrayList<Qualification> qualifications ;
    private double hoursWorked;
    private double hourlyRate;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    final static double NORMAL_WORKWEEK = 39.5;
    final static double MIN_WAGE = 10.10;


    public Employee(double hoursWorked, double hourlyRate, String firstName, String lastName, String email, String phoneNumber,ArrayList<Qualification> qual) {
        qualifications = new ArrayList<Qualification>();
        if (Utilities.validDoubleNonNegative(hoursWorked))
            this.hoursWorked = hoursWorked;

        if (hourlyRate >= MIN_WAGE)
            this.hourlyRate = hourlyRate;
        else {
            this.hourlyRate = MIN_WAGE;
        }
        this.firstName = Utilities.max20Chars(firstName);

        this.lastName = Utilities.max20Chars(lastName);
        if (Utilities.validEmail(email))
            this.email = email;
        if (Utilities.onlyContainsNumbers(phoneNumber))
            this.phoneNumber = phoneNumber;

        this.qualifications = qual;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if (Utilities.validDoubleNonNegative(hoursWorked))
            this.hoursWorked = hoursWorked;

    }

    public double getHourlyRate() {

        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate >= MIN_WAGE)
            this.hourlyRate = hourlyRate;
        else {
            this.hourlyRate = MIN_WAGE;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = Utilities.max20Chars(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = Utilities.max20Chars(lastName);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (Utilities.validEmail(email))
            this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (Utilities.onlyContainsNumbers(phoneNumber))
            this.phoneNumber = phoneNumber;
    }


    //Methods


    public double getOverTime() {
        double overTime = hoursWorked - NORMAL_WORKWEEK;
        if (Utilities.validDoubleNonNegative(overTime))
            return overTime * hourlyRate * 2;
        else {
            return 0;
        }
    }

    public double getSalary() {
        if (hoursWorked <= NORMAL_WORKWEEK)
            return hourlyRate * hoursWorked;
        else {
            return hourlyRate * hoursWorked + getOverTime();
        }
    }

    public void addQualifications(Qualification details) {
        qualifications.add(details);
    }

    public abstract double calculateSalary();


    @Override
    public String toString() {
        return "Employee{" +
                "Hours Worked=" + hoursWorked +
                ", " + hourlyRate + " per hour" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
