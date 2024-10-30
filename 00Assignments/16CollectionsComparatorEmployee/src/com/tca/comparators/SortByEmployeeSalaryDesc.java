package com.tca.comparators;

import com.tca.entities.Employee;

import java.util.Comparator;

public class SortByEmployeeSalaryDesc  implements Comparator<Employee> {
    @Override
    public int compare(Employee ob1, Employee ob2 ){
        return -ob1.getEmployeeSalary().compareTo(ob2.getEmployeeSalary());
    }
}