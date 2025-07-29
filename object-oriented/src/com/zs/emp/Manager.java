package com.zs.emp;

public class Manager extends Employee {
    private double commission;

    public Manager(double salary, double commission) {
        super(salary);
        this.commission = commission;
    }

    @Override
    public void payslip() {
        super.payslip();
        System.out.println("Commission: " + commission);
    }

    @Override
    public double getSalary() {
        return super.getSalary() + commission;
    }
}
