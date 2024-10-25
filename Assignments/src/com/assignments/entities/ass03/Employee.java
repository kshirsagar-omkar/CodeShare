package com.assignments.entities.ass03;

public class Employee {
    protected int employeeId;
    protected String employeeName;
    protected double employeeSalary;
    protected String employeeCity;
    private static int employeeCount;

    static{
        employeeCount = 0;
    }

    public Employee() {
        this.employeeId = 0;
        this.employeeName = null;
        this.employeeSalary = 0.00;
        this.employeeCity = null;
        ++employeeCount;
    }

    public Employee(int employeeId, String employeeName, double employeeSalary, String employeeCity) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeCity = employeeCity;
        ++employeeCount;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeCity() {
        return employeeCity;
    }

    public void setEmployeeCity(String employeeCity) {
        this.employeeCity = employeeCity;
    }

    public static int getEmployeeCount() {
        return employeeCount;
    }

}
