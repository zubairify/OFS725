package com.zs.emp;

public abstract class Employee {
    private int empNo;
    private double salary;
    private static int counter = 101;

    public Employee(double salary) {
        this.empNo = counter ++;
        this.salary = salary;
    }
    public Employee() {}

    public void payslip() {
        System.out.println("Emp No: " + empNo + ", Salary: " + salary);
    }

    public double getSalary() {
        return salary;
    }
}
