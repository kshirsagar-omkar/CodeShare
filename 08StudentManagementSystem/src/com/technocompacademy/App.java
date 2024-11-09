package com.technocompacademy;

import com.technocompacademy.entities.students.Student;
import com.technocompacademy.util.student.StudentOperation;
import com.technocompacademy.view.AddStudentScreen;
import com.technocompacademy.view.DeleteStudentScreen;
import com.technocompacademy.view.DisplayStudentScreen;
import com.technocompacademy.view.UpdateStudentScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TechnoComAcademy Student Management System main application module.
 *
 * <p>This class serves as the entry point for initializing and launching the
 * application.</p>
 *
 * @author Omkar kshirsagar
 * @version 1.0, 06/11/2024
 * @since 1.0
 */

public class App {
    public static void main(String[] args) {










        //Test Code for Screens

//        new AddStudentScreen();
//        new DisplayStudentScreen();

//        new DeleteStudentScreen();

//        new UpdateStudentScreen();
















/*
//      TEST CODES :


//      1. Adding a single Student record into student database file

        try{
            Student ob = new Student(101, "AAA", 90.00);
            if (StudentOperation.save(ob)) {
                System.out.println("Data Added Successfully for Roll Number : " + ob.getStudentRollNo());
            } else {
                System.out.println("Error While Adding Data For Roll Number : " + ob.getStudentRollNo());
            }
        }
        catch (NullPointerException e){
            System.out.println("Error While Writing Student Data To File : " + e.getMessage());
            e.printStackTrace();
        }




//      2. Adding Multiple records into student database file

        List<Student> listOfStudents = new ArrayList<>();
        listOfStudents.add(new Student(101,"AAA",90.01));
        listOfStudents.add(new Student(102,"BBB",70.00));
        listOfStudents.add(new Student(103,"CCC",65.88));

        try {
            StudentOperation.saveAll(listOfStudents);
        }
        catch (NullPointerException e){
            System.out.println("Error While Writing Student's Data To File : " + e.getMessage());
            e.printStackTrace();
        }



//      3. retrieve all students records in List
        List<Student> students = StudentOperation.getAllStudents();
        for (Student student : students){
            System.out.println(student);
        }




//      3. search student in database
        Integer trno = 109;
        Student s = StudentOperation.searchStudent(trno);
        if(s == null){
            System.out.println("No Record found for roll number : " + trno);
        }else{
            System.out.println("Record found for roll number : " + trno);
            System.out.println(s);
        }



//      4. delete student from student database
        Integer trno = 101;
        boolean status = StudentOperation.deleteStudent(trno);
        if(status){
            System.out.println("Delete success : " + trno);
        }
        else {
            System.out.println("Unable to delete : " + trno);
        }



//      5.Update student record from student database
        Student student = new Student(101,"ZZZ", 90.0);
        boolean status = StudentOperation.updateStudent(student);
        if(status){
            System.out.println("Update success : " + student.getStudentRollNo());
        }
        else {
            System.out.println("Unable to update : " + student.getStudentRollNo());
        }



*/
    }


}