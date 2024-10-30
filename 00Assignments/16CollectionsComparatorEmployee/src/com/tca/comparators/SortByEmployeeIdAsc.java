package com.tca.comparators;

import com.tca.entities.Employee;

import java.util.Comparator;

public class SortByEmployeeIdAsc implements Comparator<Employee> {
    @Override
    public int compare(Employee ob1, Employee ob2 ){
        return ob1.getEmployeeId().compareTo(ob2.getEmployeeId());
    }
}
