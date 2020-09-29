package models;

import java.util.ArrayList;

public class SalesWorker extends Employee {

    private double percentageBonus;


    public SalesWorker(double hoursWorked, double hourlyRate, String firstName, String lastName, String email, String phoneNumber, double percentageBonus, ArrayList<Qualification> qualifications) {
        super(hoursWorked, hourlyRate, firstName, lastName, email, phoneNumber,qualifications);

        if (percentageBonus > 0 && percentageBonus <= 20) {
            this.percentageBonus = percentageBonus / 100;
        }


    }

    public double getPercentageBonus() {
        return percentageBonus;
    }

    public void setPercentageBonus(double percentageBonus) {
        if (percentageBonus > 0 && percentageBonus <= 20) {
            this.percentageBonus = percentageBonus / 100;
        }

    }

    private double salesWorkersBonus() {
        return getSalary() * getPercentageBonus();
    }

    @Override
    public double calculateSalary() {
        return getSalary() + salesWorkersBonus();
    }

    @Override
    public String toString() {
        return "SalesWorker{" + super.toString() +
                "percentage Bonus=" + percentageBonus +
                '}';
    }
}
