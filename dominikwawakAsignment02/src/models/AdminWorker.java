package models;

import utils.Utilities;

import java.util.ArrayList;

public class AdminWorker extends Employee {

    private double fixedBonus;

    public AdminWorker(double hoursWorked, double hourlyRate, String firstName, String lastName, String email, String phoneNumber, double fixedBonus, ArrayList<Qualification> qualifications) {
        super(hoursWorked, hourlyRate, firstName, lastName, email, phoneNumber,qualifications);
        if (Utilities.validDoubleNonNegative(fixedBonus)) {
            this.fixedBonus = fixedBonus;

        }

    }

    public double getFixedBounus() {
        return fixedBonus;
    }

    public void setFixedBounus(double fixedBounus) {
        if (Utilities.validDoubleNonNegative(fixedBounus)) {
            this.fixedBonus = fixedBounus;

        }
    }

    @Override
    public double calculateSalary() {
        return getSalary() + fixedBonus;
    }

    @Override
    public String toString() {
        return "AdminWorker{" + super.toString() +
                "fixed Bonus=" + fixedBonus +
                '}';
    }
}
