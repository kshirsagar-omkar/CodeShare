package com.tca.comparators;

import com.tca.entities.Employee;

import java.util.Comparator;

public class SortByEmployeeNameDesc implements Comparator<Employee> {
    @Override
    public int compare(Employee ob1, Employee ob2 ){
        return -ob1.getEmployeeName().compareTo(ob2.getEmployeeName());
    }
}