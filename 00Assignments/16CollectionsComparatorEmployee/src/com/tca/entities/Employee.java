package com.tca.entities;

import java.util.Objects;

public class Employee {
    private Integer employeeId;
    private String employeeName;
    private Double employeeSalary;
    private String employeeCity;


    public Employee(Integer employeeId, String employeeName, Double employeeSalary, String employeeCity) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeCity = employeeCity;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeCity() {
        return employeeCity;
    }

    public void setEmployeeCity(String employeeCity) {
        this.employeeCity = employeeCity;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", employeeCity='" + employeeCity + '\'' +
                '}';
    }

    public String displayEmployeeInformation(){
        return employeeId + " " + employeeName + " " + employeeSalary + " " + employeeCity ;
    }


}