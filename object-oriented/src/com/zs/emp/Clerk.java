package com.zs.emp;

public class Clerk extends Employee {
    private double incentive;

    public Clerk(double salary, double incentive) {
        super(salary);
        this.incentive = incentive;
    }

    @Override
    public void payslip() {
        super.payslip();
        System.out.println("Incentive: " + incentive);
    }

    @Override
    public double getSalary() {
        return super.getSalary() + incentive;
    }
}
