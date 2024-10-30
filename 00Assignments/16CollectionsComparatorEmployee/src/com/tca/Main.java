package com.tca;

import com.tca.comparators.*;
import com.tca.entities.Employee;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
    Company Approach :  Anonymous Inner class

        Collections.sort(names, new Comparator<String>()
            {
                public int compare(String s1, String s2){
                    return s1.compareTo(s2);
                }
            });
*/


public class Main {
    public static void main(String[] args) {



        //Creating Array list for storing employee information
        //Note : Use TreeSet for Avoid Duplicates
        List<Employee> employees = new ArrayList<>();
        display(employees);

        employees.add(new Employee(101,"omkar", 100000.00, "Pimpri Chinchwad"));
        employees.add(new Employee(102,"vaibhav", 70000.00, "Pune"));
        employees.add(new Employee(103,"rohan", 10000.00, "Hyderabad"));
        employees.add(new Employee(104,"rahul", 12000.00, "Bangalore"));
        employees.add(new Employee(105,"rushi", 150000.00, "Mumbai"));

        //Displaying Original Order Of added Data
        System.out.println("Original Order of Employee Data : ");
        display(employees);


        System.out.println("\n\n");


        //Sort Data as per User's choice
        try{
            sortBy(employees);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void display(List<Employee> employees){
        for(Employee employee : employees){
            System.out.println(employee.displayEmployeeInformation());
        }
    }


    public static void sortBy(List<Employee> employees) throws Exception{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Sort Data By -->");
                System.out.println("1.EmployeeId\n2.EmployeeName\n3.EmployeeSalary\n4.EmployeeCity");
                System.out.print("Enter Option [1/2/3/4] : ");
                String option = br.readLine();

                switch (option) {
                    case "1":
                        Collections.sort(employees, new SortByEmployeeIdAsc());
                        break;

                    case "2":
                        Collections.sort(employees, new SortByEmployeeNameAsc());
                        break;
                    case "3":
                        Collections.sort(employees, new SortByEmployeeSalaryAsc());
                        break;
                    case "4":
                        Collections.sort(employees, new SortByEmployeeCityAsc());
                        break;
                    default:
                        throw new Exception("\nWrong Option!!\nExiting Application");
                }

                System.out.println("\nData After Sorted : ");
                display(employees);
                System.out.println("--------------------------------\n");
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


}